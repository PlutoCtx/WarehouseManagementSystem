package com.chentx.attempts.attempt02;

import lombok.Data;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 17:16
 * @since JDK17
 */

@Data
public class Material {
    private String mc;
    private String ggxh;
    private String hh;
    private String dw;

    @Override
    public String toString() {
        return mc + '\'' +  ", " + ggxh + '\'' + hh;
    }
}
