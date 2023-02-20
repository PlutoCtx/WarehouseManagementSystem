package com.bookmanager.dao;

import com.bookmanager.model.BookType;
import com.bookmanager.utils.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 10:43
 */
public class BookTypeDao {

    /**
     * 添加图书类别
     * @param connection    连接数据库
     * @param bookType      书籍类别
     * @return      结果
     * @throws Exception 连不上
     */
    public int add(Connection connection, BookType bookType) throws Exception{
        String sql = "INSERT INTO t_bookType VALUE(null, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, bookType.getBookTypeName());
        pstmt.setString(2, bookType.getBookTypeDesc());
        return pstmt.executeUpdate();
    }


    /**
     * 查询某类书籍
     * @param connection    连接数据库
     * @param bookType  书籍类别
     * @return 结果集
     * @throws Exception    无结果
     */
    public ResultSet list(Connection connection, BookType bookType)throws Exception{
        StringBuffer stringBuffer = new StringBuffer("SELECT * FROM t_bookType");
        if(StringUtil.isNotEmpty(bookType.getBookTypeName())){
            stringBuffer.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
        }
        PreparedStatement preparedStatement = connection.prepareStatement(stringBuffer.toString().replaceFirst("and", "where"));
        return preparedStatement.executeQuery();
    }


    /**
     * 通过id号来进行删除操作
     * @param connection 连接数据库
     * @param id    删除图书类别
     * @return  删除的条数（一般是1，以此来判断删除操作是否成功）
     * @throws Exception    可能会无法删除
     */
    public int deleteById(Connection connection,String id)throws Exception{
        String sql = "DELETE FROM t_bookType WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        return preparedStatement.executeUpdate();
    }


    /**
     * 更新图书
     * @param connection    连接数据库
     * @param bookType  图书类
     * @return  返回更新的记录数信息
     * @throws Exception    可能会有无法删除的情况
     */
    public int update(Connection connection,BookType bookType)throws Exception{
        String sql="UPDATE t_bookType SET bookTypeName = ?, bookTypeDesc = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, bookType.getBookTypeName());
        preparedStatement.setString(2, bookType.getBookTypeDesc());
        preparedStatement.setInt(3, bookType.getId());
        return preparedStatement.executeUpdate();
    }

}
