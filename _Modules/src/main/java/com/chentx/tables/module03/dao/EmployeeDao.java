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

    Employee employee = Employee.EmployeeBuilder.create("server").withAge(45).build();
//        System.out.println(employee.getEmployeeNumber() + "  " + employee.getAge());

    Employee employeeOne = Employee.EmployeeBuilder.anEmployee().withAge(46).build();


    /**
     * 登录验证
     * @param connection    数据库链接
     * @param employee  用户
     * @return  返回查找到的用户
     * @throws Exception    这个方法能够实现登录，但是业务逻辑有问题
     * 逻辑问题：
     *      在方法运行的时候，开始时会查找数据库中的数据，如果有用户名和密码对应的记录，则会返回该记录，
     *      如果没有，程序在之后的部分就会出现提示用户名或密码错误（到这一步是正常的）；
     *      如果有，那就返回数据库中查找到的用户，但是，问题来了，查找到的结果是一个结果集，这也就意味着可能会出现用户名与密码相同的记录情况，
     *      典型的数据问题，但是，我们可以在数据库中将两者标记为唯一，以此来解决此问题
     *
     */
    public Employee login(Connection connection, Employee employee) throws Exception{
        Employee resultUser = null;
        String sql = "SELECT * FROM t_user where userName = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            resultUser = new Employee();
            resultUser.setId(resultSet.getInt("id"));
            resultUser.setName(resultSet.getString("userName"));
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

//    /**
//     * 查找书籍
//     * @param connection    连接数据库
//     * @param book  书籍
//     * @return  the number of being effected rows
//     * @throws Exception    how do I know
//     */
//    public ResultSet list(Connection connection, Book book)throws Exception{
//        StringBuilder stringBuffer = new StringBuilder("SELECT * FROM t_book b,t_bookType bt WHERE b.bookTypeId = bt.id");
//        if(StringUtil.isNotEmpty(book.getBookName())){
//            stringBuffer.append(" and b.bookName like '%").append(book.getBookName()).append("%'");
//        }
//        if(StringUtil.isNotEmpty(book.getAuthor())){
//            stringBuffer.append(" and b.author like '%").append(book.getAuthor()).append("%'");
//        }
//        if(book.getBookTypeId() != null && book.getBookTypeId()!=-1){
//            stringBuffer.append(" and b.bookTypeId=").append(book.getBookTypeId());
//        }
//        PreparedStatement preparedStatement = connection.prepareStatement(stringBuffer.toString());
//        return preparedStatement.executeQuery();
//    }


//    /**
//     * 删除书籍
//     * @param connection    连接数据库
//     * @param id 书籍id号
//     * @return  返回删除掉的记录数量
//     * @throws Exception    可能会无法删除
//     */
//    public int delete(Connection connection,String id)throws Exception{
//        String sql="DELETE FROM t_book WHERE id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, id);
//        return preparedStatement.executeUpdate();
//    }

//    /**
//     *  更新书籍
//     * @param connection    连接数据库
//     * @param book  书籍
//     * @return  返回更新的记录数量
//     * @throws Exception    可能无法更新
//     */
//    public int update(Connection connection,Book book) throws Exception{
//        String sql="UPDATE t_book SET bookName = ?, author = ?, sex = ?, price = ?, bookDesc = ?, bookTypeId = ? WHERE id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, book.getBookName());
//        preparedStatement.setString(2, book.getAuthor());
//        preparedStatement.setString(3, book.getSex());
//        preparedStatement.setFloat(4, book.getPrice());
//        preparedStatement.setString(5, book.getBookDesc());
//        preparedStatement.setInt(6, book.getBookTypeId());
//        preparedStatement.setInt(7, book.getId());
//        return preparedStatement.executeUpdate();
//    }


//    /**
//     * 查看书籍分类下的书籍数
//     * @param connection    连接数据库
//     * @param bookTypeId    书籍分类
//     * @return  是否存在书籍对应分类下的书籍
//     * @throws Exception    how do I know
//     */
//    public boolean existBookByBookTypeId(Connection connection,String bookTypeId)throws Exception{
//        String sql="SELECT * FROM t_book WHERE bookTypeId = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, bookTypeId);
//        ResultSet rs = preparedStatement.executeQuery();
//        return rs.next();
//    }
