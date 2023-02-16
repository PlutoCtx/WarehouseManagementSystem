package com.chentx.attempts.attempt01;

/**
 * 商品实体类
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 14:02
 * @since JDK17
 */

public class Material {
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
    Integer inventoryNumber;
    /**
     * 平均价
     */
    double averagePrice;
    /**
     * 库存总价
     */
    double totalInventoryPrice;

    public Material(String name, String model) {
        this.name = name;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                '}';
    }
}
