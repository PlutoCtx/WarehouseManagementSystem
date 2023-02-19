package com.bookmanager.dao;

import com.bookmanager.model.Book;
import com.bookmanager.utils.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/21 11:28
 */
public class BookDao {


    /**
     * 添加图书
     * @param connection    连接数据库
     * @param book  书籍
     * @return  the number of being effected rows
     * @throws Exception how do I know
     */
    public int add(Connection connection, Book book)throws Exception{
        String sql = "INSERT INTO t_book VALUES (null, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, book.getBookName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setString(3, book.getSex());
        preparedStatement.setFloat(4, book.getPrice());
        preparedStatement.setInt(5, book.getBookTypeId());
        preparedStatement.setString(6, book.getBookDesc());
        return preparedStatement.executeUpdate();
    }

    /**
     * 查找书籍
     * @param connection    连接数据库
     * @param book  书籍
     * @return  the number of being effected rows
     * @throws Exception    how do I know
     */
    public ResultSet list(Connection connection, Book book)throws Exception{
        StringBuilder stringBuffer = new StringBuilder("SELECT * FROM t_book b,t_bookType bt WHERE b.bookTypeId = bt.id");
        if(StringUtil.isNotEmpty(book.getBookName())){
            stringBuffer.append(" and b.bookName like '%").append(book.getBookName()).append("%'");
        }
        if(StringUtil.isNotEmpty(book.getAuthor())){
            stringBuffer.append(" and b.author like '%").append(book.getAuthor()).append("%'");
        }
        if(book.getBookTypeId() != null && book.getBookTypeId()!=-1){
            stringBuffer.append(" and b.bookTypeId=").append(book.getBookTypeId());
        }
        PreparedStatement preparedStatement = connection.prepareStatement(stringBuffer.toString());
        return preparedStatement.executeQuery();
    }


    /**
     * 删除书籍
     * @param connection    连接数据库
     * @param id 书籍id号
     * @return
     * @throws Exception
     */
    public int delete(Connection connection,String id)throws Exception{
        String sql="DELETE FROM t_book WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        return preparedStatement.executeUpdate();
    }

    /**
     *  更新书籍
     * @param connection    连接数据库
     * @param book  书籍
     * @return
     * @throws Exception
     */
    public int update(Connection connection,Book book) throws Exception{
        String sql="UPDATE t_book SET bookName = ?, author = ?, sex = ?, price = ?, bookDesc = ?, bookTypeId = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, book.getBookName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setString(3, book.getSex());
        preparedStatement.setFloat(4, book.getPrice());
        preparedStatement.setString(5, book.getBookDesc());
        preparedStatement.setInt(6, book.getBookTypeId());
        preparedStatement.setInt(7, book.getId());
        return preparedStatement.executeUpdate();
    }


    /**
     * 查看书籍分类下的书籍数
     * @param connection    连接数据库
     * @param bookTypeId    书籍分类
     * @return  是否存在书籍对应分类下的书籍
     * @throws Exception    how do I know
     */
    public boolean existBookByBookTypeId(Connection connection,String bookTypeId)throws Exception{
        String sql="SELECT * FROM t_book WHERE bookTypeId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, bookTypeId);
        ResultSet rs = preparedStatement.executeQuery();
        return rs.next();
    }

}
