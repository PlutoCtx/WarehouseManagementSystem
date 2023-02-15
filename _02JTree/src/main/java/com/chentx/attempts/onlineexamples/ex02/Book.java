package com.chentx.attempts.onlineexamples.ex02;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 0:54
 * @since JDK17
 */

public class Book {
    String name;
    String chubanshe;
    Book(String n,String p){
        name=n;
        chubanshe = p;
    }
    public String toString() { //返回对象的串表示
        return name;
    }
}