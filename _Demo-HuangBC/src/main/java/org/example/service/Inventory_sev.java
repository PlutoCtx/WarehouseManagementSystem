package org.example.service;

import org.example.tables.*;
import org.example.operator.*;
import org.example.tool.DBConnect;

import java.sql.SQLException;

/**
 * @author chent
 */
public class Inventory_sev {
    public static void Inventory(int id) {

        DBConnect.getConnection();

        Inventory inv= Op_Inventory.findInventoryRecord(id);
        //如果无该记录，则返回
        if(inv==null) {
            return;
        }

        Depository dRecord= Op_Depository.findDepositoryRecord(inv.getCname(), inv.getPno());
        Out_Record out=new Out_Record(0, inv.getCname(), inv.getPno(),dRecord.getNum(), dRecord.getPrice(),
                dRecord.getSum_price(), 6, 1, 1);
        out.setNum(out.getNum()-dRecord.getNum());
        out.setSum_price(out.getNum()*out.getPrice());
        dRecord.setNum(inv.getNum());
        dRecord.setSum_price(inv.getNum()*dRecord.getPrice());

        Total_Depository tRecord= Op_Total_Depository.findTotalDepositoryRecord(inv.getPno());
        tRecord.setNum(tRecord.getNum()-out.getNum());
        tRecord.setSum_price(tRecord.getSum_price()-out.getSum_price());

        //开始事务处理
        try {
            DBConnect.conn.setAutoCommit(false);
            int res1= Op_out_Record.insert(out);
            if(res1==0) {
                DBConnect.conn.rollback();
                return;
            }

            //更新本仓
            int res2=Op_Depository.update(dRecord.getCname(), dRecord.getPno(),
                    dRecord.getNum(), dRecord.getPrice(), dRecord.getSum_price());
            if(res2==0) {
                DBConnect.conn.rollback();
                return;
            }

            //更新总仓
            int res3=Op_Total_Depository.update(tRecord.getPno(), tRecord.getNum(),
                    tRecord.getSum_price(), tRecord.getSum_price());
            if(res3==0) {
                DBConnect.conn.rollback();
                return;
            }

            //插入台账
            int res4= Op_Standing_Book.insert(new Standing_Book(0, out.getCname(), out.getPno(), out.getBj(),
                    out.getNum(), out.getPrice(), out.getSum_price(), dRecord.getNum(), dRecord.getPrice(),
                    dRecord.getSum_price()));
            if(res4==0) {
                DBConnect.conn.rollback();
                return;
            }

            DBConnect.conn.commit();
            DBConnect.conn.close();
        } catch (SQLException e) {
            System.out.println("InventorySev.Inventory()事务处理失败");
            try {
                DBConnect.conn.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
