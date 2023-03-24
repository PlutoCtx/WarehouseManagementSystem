package com.chentx.attempts.attempt03_suc;

import lombok.Data;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 20:51
 * @since JDK17
 */

@Data
public class Node {
    /**
     * 货物名称
     */
    String name;
    /**
     * 型号
     */
    String model;
    /**
     * 货号
     */
    String itemNumber;
    /**
     * 货物单位
     */
    String unit;
    /**
     * 库存总数
     */
    String inventoryNumber;
    /**
     * 平均价
     */
    String averagePrice;
    /**
     * 库存总价
     */
    String totalInventoryPrice;

    Node(String[] s) {
        setName(s[0]);
        setModel(s[1]);
        setItemNumber(s[2]);
        setUnit(s[3]);
        setInventoryNumber(s[4]);
        setAveragePrice(s[5]);
        setTotalInventoryPrice(s[6]);
    }

    @Override
    public String toString() {
        String str = name + "," + model;
        if (model == null || str.endsWith(",")){
            return name;
        }
        return str;
    }

}

