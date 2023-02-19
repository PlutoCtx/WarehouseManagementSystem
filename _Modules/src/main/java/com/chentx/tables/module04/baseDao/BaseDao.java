package com.chentx.tables.module04.baseDao;

import com.chentx.tables.module04.utils.DBUtil;

import java.sql.Connection;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/19 0:19
 * @since JDK17
 */

public class BaseDao<T> {
    private DBUtil dbUtil = new DBUtil() ;
    public Connection connection = dbUtil.getConnection();
    public void closeConnection() {
        dbUtil.closeConnection();
    }

}

