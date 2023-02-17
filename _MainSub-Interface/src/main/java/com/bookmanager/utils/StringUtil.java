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
        if (str == null || "".equals(str.trim())){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判读字符串是否不为空
     * @param str 待判断字符串
     * @return 结果值
     */
    public static boolean isNotEmpty(String str){
        if (str != null && !"".equals(str.trim())){
            return true;
        }else {
            return false;
        }
    }

}



/*package com.bookmanager.utils;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/13 18:11
 * @since JDK17


public class StringUtil {
}
*/