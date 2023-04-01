package com.chentx.tables.module03.dao;


import com.chentx.tables.module03.model.Employee;

import java.sql.*;

/**
 * EmployeeDao class
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/18 18:05
 * @since JDK17
 */

public class EmployeeDao {

//    Employee employee = Employee.EmployeeBuilder.create("server").withAge(45).build();
//        System.out.println(employee.getEmployeeNumber() + "  " + employee.getAge());

//    Employee employeeOne = Employee.EmployeeBuilder.anEmployee().withAge(46).build();


    /**
     * 登录验证
     * @param connection    数据库链接
     * @param employeeBuilder  用户
     * @return  返回查找到的用户
     * @throws Exception    这个方法能够实现登录，但是业务逻辑有问题
     * 逻辑问题：
     *      在方法运行的时候，开始时会查找数据库中的数据，如果有用户名和密码对应的记录，则会返回该记录，
     *      如果没有，程序在之后的部分就会出现提示用户名或密码错误（到这一步是正常的）；
     *      如果有，那就返回数据库中查找到的用户，但是，问题来了，查找到的结果是一个结果集，这也就意味着可能会出现用户名与密码相同的记录情况，
     *      典型的数据问题，但是，我们可以在数据库中将两者标记为唯一，以此来解决此问题
     *
     */
    public Employee login(Connection connection, Employee employeeBuilder) throws Exception{
        Employee resultUser = null;
        String sql = "SELECT * FROM employeeinfosheet WHERE employeeNumber = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employeeBuilder.getEmployeeNumber());
        preparedStatement.setString(2, employeeBuilder.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            resultUser = new Employee();
            resultUser.setName(resultSet.getString("employeeNumber"));
            resultUser.setPassword(resultSet.getString("password"));
        }
        return resultUser;
    }



    /**
     * 添加职工信息
     * @param connection    数据库连接
     * @param employee  职工对象
     * @return  添加的记录条数
     * @throws SQLException 可能会无法插入
     */
    public int addEmployee(Connection connection, Employee employee) throws SQLException {
        String sql = "INSERT INTO employeeinformationsheet VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getEmployeeNumber());
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setString(3, employee.getPassword());
        preparedStatement.setString(4, employee.getPosition());
        preparedStatement.setByte(5, employee.getInOffice());
        preparedStatement.setByte(6, employee.getSex());
        preparedStatement.setInt(7, employee.getAge());
        preparedStatement.setString(8, employee.getContact());
        preparedStatement.setDouble(9, employee.getSalary());
        preparedStatement.setDate(10, (Date) employee.getDateOfEntry());
        preparedStatement.setDate(11, (Date) employee.getDateOfDeparture());

        return preparedStatement.executeUpdate();
    }


}

