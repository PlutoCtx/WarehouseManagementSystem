package com.bookmanager.utils;

/**
 * 字符串工具类
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/20 22:41
 */
public class StringUtil {

    /**
     * 判读字符串是否为空
     * @param str 待判断字符串
     * @return 结果值
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str.trim());
    }

    /**
     * 判读字符串是否不为空
     * @param str 待判断字符串
     * @return 结果值
     */
    public static boolean isNotEmpty(String str){
        return str != null && !"".equals(str.trim());
    }

}
