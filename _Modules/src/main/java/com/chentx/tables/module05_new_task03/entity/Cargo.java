package com.chentx.tables.module05_new_task03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 货物实体类
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/11 11:04
 * @since JDK17
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    String cargoId;
    String cargoName;
    Integer cargoNumber;
    Double cargoAvePrice;

}
