package com.chentx.tables.module05_new_task03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 仓库实体类
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/15 23:39
 * @since JDK17
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {

    /**
     * 仓库号
     */
    String warehouseNumber;
    /**
     * 仓库管理人员员工号，负责人
     */
    String warehouseManagerNumber;
    /**
     * 仓库名
     */
    String warehouseName;
    /**
     * 地址
     */
    String address;
    /**
     * 描述
     */
    String description;


}
