package com.bookmanager.dao;

import com.bookmanager.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用户Dao层
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/18 23:55
 */
public class UserDao {

    /**
     * 登录验证
     * @param connection    数据库链接
     * @param user  用户
     * @return
     * @throws Exception
     */
    public User login(Connection connection, User user) throws Exception{
        User resultUser = null;
        String sql = "SELECT * FROM t_user where userName = ? and password = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
        ResultSet resultSet = pstmt.executeQuery();

        if (resultSet.next()){
            resultUser = new User();
            resultUser.setId(resultSet.getInt("id"));
            resultUser.setUserName(resultSet.getString("userName"));
            resultUser.setPassword(resultSet.getString("password"));
        }
        return resultUser;
    }
}
