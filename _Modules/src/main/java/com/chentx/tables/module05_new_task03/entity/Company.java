package com.chentx.tables.module05_new_task03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 公司名
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/15 23:52
 * @since JDK17
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    /**
     * 公司编号
     */
    String companyName;
    /**
     * 公司名
     */
    String companyNumber;
    /**
     * 描述
     */
    String description;
    /**
     * 最近合作日期
     */
    Date latestCooperationDay;
    /**
     * 主营业务
     */
    String major;
    /**
     * 地址
     */
    String address;
    /**
     * 负责人
     */
    String responsiblePersonalDay;
    /**
     * 负责人员工号
     */
    String warehouseManagerNumber;



}
