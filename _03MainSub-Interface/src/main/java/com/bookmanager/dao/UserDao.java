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
     * @return  返回查找到的用户
     * @throws Exception    这个方法能够实现登录，但是业务逻辑有问题
     * 逻辑问题：
     *      在方法运行的时候，开始时会查找数据库中的数据，如果有用户名和密码对应的记录，则会返回该记录，
     *      如果没有，程序在之后的部分就会出现提示用户名或密码错误（到这一步是正常的）；
     *      如果有，那就返回数据库中查找到的用户，但是，问题来了，查找到的结果是一个结果集，这也就意味着可能会出现用户名与密码相同的记录情况，
     *      典型的数据问题，但是，我们可以在数据库中将两者标记为唯一，以此来解决此问题
     *
     */
    public User login(Connection connection, User user) throws Exception{
        User resultUser = null;
        String sql = "SELECT * FROM t_user where userName = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            resultUser = new User();
            resultUser.setId(resultSet.getInt("id"));
            resultUser.setUserName(resultSet.getString("userName"));
            resultUser.setPassword(resultSet.getString("password"));
        }
        return resultUser;
    }
}
