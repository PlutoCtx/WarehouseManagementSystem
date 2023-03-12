package com.chentx.attempts.onlineexamples.ex02;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 0:54
 * @since JDK17
 */

public class Book {
    /**
     * 书名
     */
    String name;
    /**
     * 出版社
     */
    String publishingHouse;
    Book(String n,String p){
        name=n;
        publishingHouse = p;
    }
    @Override
    public String toString() { //返回对象的串表示
        return name;
    }
}