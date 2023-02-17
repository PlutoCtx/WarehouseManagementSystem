package com.bookmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图书类
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 10:41
 */


@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookType {
    /**
     * 编号
     */
    private int id;
    /**
     * 图书类别名称
     */
    private String bookTypeName;
    /**
     * 描述
     */
    private String bookTypeDesc;

    public BookType(String bookTypeName, String bookTypeDesc) {
        super();
        this.bookTypeName = bookTypeName;
        this.bookTypeDesc = bookTypeDesc;
    }


    @Override
    public String toString() {
        return bookTypeName;
    }
}
