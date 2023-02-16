package com.chentx.attempts.examples;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 12:58
 * @since JDK17
 */

public class Goods {
    String name;
    double price;

    Goods(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name;
    }


}
