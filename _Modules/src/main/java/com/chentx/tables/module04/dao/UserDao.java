package com.chentx.tables.module04.dao;

import com.chentx.tables.module04.baseDao.BaseDao;
import com.chentx.tables.module04.entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/19 0:20
 * @since JDK17
 */

public class UserDao extends BaseDao<User> {

    /**
     * 向数据库user表中插入记录
     * @param user  实体对象
     * @return  插入操作是否成功
     */
    public boolean add(User user) {
        String sql= "INSERT INTO user(id,name,password,birthday) values(null,?,?,?)" ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setDate(3, user.getBirthday());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false ;
    }

}

