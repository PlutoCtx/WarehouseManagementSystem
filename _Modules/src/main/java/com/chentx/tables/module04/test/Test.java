package com.chentx.tables.module04.test;

import com.chentx.tables.module04.dao.UserDao;
import com.chentx.tables.module04.entity.User;

import java.sql.Date;
import java.util.logging.Logger;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/19 0:16
 * @since JDK17
 */

public class Test {

    public static void main(String[] args) {
        User user = new User() ;
        user.setName("wmc");
        user.setPassword("wmc123");
        user.setBirthday(new Date(System.currentTimeMillis()));
        UserDao userDao = new UserDao() ;
        Logger.getGlobal().info("info: " + userDao.add(user));
        userDao.closeConnection();
    }

}

