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
        PreparedStatement pstmt = connection.prepareStatement(stringBuffer.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }


    /**
     *
     * @param connection 连接数据库
     * @param id    删除图书类别
     * @return
     * @throws Exception
     */
    public int delete(Connection connection,String id)throws Exception{
        String sql = "DELETE FROM t_bookType WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, id);
        return pstmt.executeUpdate();
    }


    /**
     * 更新图书
     * @param connection    连接数据库
     * @param bookType  图书类
     * @return
     * @throws Exception
     */
    public int update(Connection connection,BookType bookType)throws Exception{
        String sql="UPDATE t_bookType SET bookTypeName = ?, bookTypeDesc = ? WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, bookType.getBookTypeName());
        pstmt.setString(2, bookType.getBookTypeDesc());
        pstmt.setInt(3, bookType.getId());
        return pstmt.executeUpdate();
    }

}
