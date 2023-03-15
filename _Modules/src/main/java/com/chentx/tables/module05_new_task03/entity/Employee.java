package com.chentx.tables.module05_new_task03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 员工实体类
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/15 23:42
 * @since JDK17
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    String employeeNumber;
    String password;
    String name;
    String position;
    Boolean inOffice;
    Boolean sex;
    Integer age;
    String contact;
    Double salary;
    Date dateOfEntry;
    Date dateOfDeparture;







}
