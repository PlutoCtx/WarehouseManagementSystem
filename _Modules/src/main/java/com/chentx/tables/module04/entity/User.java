package com.chentx.tables.module04.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/19 0:14
 * @since JDK17
 */

@Data
public class User {
    private int id ;
    private String name ;
    private String password ;
    private Date birthday ;

}

