package com.bookmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图书实体
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 11:17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    /**
     * 图书id
     */
    private int id;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 作者
     */
    private String author;
    /**
     * 性别
     */
    private String sex;
    /**
     * 价格
     */
    private Float price;
    /**
     * 图书类别
     */
    private Integer bookTypeId;
    /**
     * 图书类别
     */
    private String bookTypeName;
    /**
     * 描述
     */
    private String bookDesc;


    public Book(String bookName, String author, String sex, Float price, Integer bookTypeId, String bookDesc) {
        super();
        this.bookName = bookName;
        this.author = author;
        this.sex = sex;
        this.price = price;
        this.bookTypeId = bookTypeId;
        this.bookDesc = bookDesc;
    }




    public Book(int id, String bookName, String author, String sex, Float price, Integer bookTypeId, String bookDesc) {
        super();
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.sex = sex;
        this.price = price;
        this.bookTypeId = bookTypeId;
        this.bookDesc = bookDesc;
    }

    public Book(String bookName, String author, Integer bookTypeId) {
        super();
        this.bookName = bookName;
        this.author = author;
        this.bookTypeId = bookTypeId;
    }


}
