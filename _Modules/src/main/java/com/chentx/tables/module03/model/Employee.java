package com.chentx.tables.module03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * employee class,including warehouse keeper and warehouse manager
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/18 18:02
 * @since JDK17
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    /**
     * id
     */
    private int id;
    /**
     * 职工号
     */
    private String employeeNumber;
    /**
     * 姓名
     */
    private String name;
    /**
     * 职位，仓管员、经理
     */
    private String position;
    /**
     * 是否在职，默认在职
     */
    private Byte inOffice;
    /**
     * 性别
     */
    private Byte sex;
    /**
     * 年龄
     */
    private int age;
    /**
     * 联系方式
     */
    private String contact;
    /**
     * 薪资
     */
    private double salary;
    /**
     * 入职日期，yyyy-MM-dd，无法默认设置当前日期
     */
    private Date dateOfEntry;
    /**
     * 离职日期，yyyy-MM-dd，无法默认设置当前日期
     */
    private Date dateOfDeparture;




















}
