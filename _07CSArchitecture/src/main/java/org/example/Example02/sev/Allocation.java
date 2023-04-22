
package org.example.Example02.sev;


import org.example.Example02.biao.Depository;
import org.example.Example02.biao.Out_Record;
import org.example.Example02.biao.Standing_Book;
import org.example.Example02.operator.Op_Depository;
import org.example.Example02.operator.Op_Standing_Book;
import org.example.Example02.operator.Op_out_Record;
import org.example.Example02.tool.Get_Connect;

import java.sql.SQLException;

public class Allocation {

    public static void Allocation(int id1,int id2) {

        //Get_Connect.getConnection();

        Out_Record out1= Op_out_Record.findOut_RecordById(id1);
        Out_Record out2=Op_out_Record.findOut_RecordById(id2);
        //若无记录，则返回
        if(out1==null||out2==null) {
            return;
        }

        if(out1.getBj()!=4||out2.getBj()!=5) {
            System.out.println("不是调拨记录，无法处理");
            return;
        }
        if(out1.getChecked()==0||out2.getChecked()==0) {
            System.out.println("该调拨记录尚未通过审核，无法处理");
            return;
        }
        if(out1.getVs()==1||out2.getVs()==1) {
            System.out.println("该调拨记录已处理过，无需再处理");
            return;
        }

        Depository dRecord1=new Op_Depository().findDepositoryRecord(out1.getCname(), out1.getPno());
        Depository dRecord2=new Op_Depository().findDepositoryRecord(out2.getCname(), out2.getPno());
        if(dRecord1==null||dRecord2==null) {
            System.out.println("仓库为空，无法调拨");
            return;
        }
        dRecord1.setNum(dRecord1.getNum()-out1.getNum());
        dRecord1.setSum_price(dRecord1.getSum_price()-out1.getSum_price());
        dRecord2.setNum(dRecord2.getNum()-out2.getNum());
        dRecord2.setSum_price(dRecord2.getSum_price()-out2.getSum_price());

        try {
            dRecord1.setPrice(dRecord1.getSum_price()/dRecord1.getNum());
            dRecord2.setPrice(dRecord2.getSum_price()/dRecord2.getNum());
        } catch (Exception e) {
            System.out.println("PurchaseService.purchase().本仓除0错误");
            e.printStackTrace();
        }

        try {
            Get_Connect.conn.setAutoCommit(false);
            //更新vis
            int res11=Op_out_Record.updateVis(out1.getId(), 1);
            int res12=Op_out_Record.updateVis(out2.getId(), 1);
            if(res11==0||res12==0) {
                Get_Connect.conn.rollback();		//更新vis失败回滚
                return;
            }

            //更新本仓
            int res21=Op_Depository.update(dRecord1.getCname(), dRecord1.getPno(), dRecord1.getNum()
                    , dRecord1.getPrice(), dRecord1.getSum_price());
            int res22=Op_Depository.update(dRecord2.getCname(), dRecord2.getPno(), dRecord2.getNum()
                    , dRecord2.getPrice(), dRecord2.getSum_price());
            if(res21==0||res22==0) {
                System.out.println("res2为0");
                Get_Connect.conn.rollback();
                return;
            }

            //插入台账
            int res31= Op_Standing_Book.insert(new Standing_Book(0, out1.getCname(), out1.getPno(), out1.getBj(),
                    out1.getNum(), out1.getPrice(), out1.getSum_price(), dRecord1.getNum(), dRecord1.getPrice(),
                    dRecord1.getSum_price()));
            int res32=Op_Standing_Book.insert(new Standing_Book(0, out2.getCname(), out2.getPno(), out2.getBj(),
                    out2.getNum(), out2.getPrice(), out2.getSum_price(), dRecord2.getNum(), dRecord2.getPrice(),
                    dRecord2.getSum_price()));
            if(res31==0||res32==0) {
                Get_Connect.conn.rollback();
                return;
            }

            Get_Connect.conn.commit();
            Get_Connect.conn.close();
        } catch (SQLException e) {
            System.out.println("WarehousingService.Warehousing()事务处理异常");
            try {
                Get_Connect.conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
