package com.chentx.tables.module05_new_task03.dao;

import com.chentx.tables.module05_new_task03.entity.Cargo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 操作货物类
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/3/11 11:06
 * @since JDK17
 */

public class CargoDao {

    /**
     * 更新
     * @param connection    数据库连接
     * @param cargo     货物
     * @return  更新的记录条数
     * @throws SQLException how do I know
     */
    public int update(Connection connection, Cargo cargo) throws SQLException {
        String sql = "UPDATE test SET cargoNumber = cargoNumber + ?, WHERE cargoId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, cargo.getCargoNumber());
        preparedStatement.setString(2, cargo.getCargoId());
        return preparedStatement.executeUpdate();

    }


    /**
     * 添加
     * @param connection    数据库连接
     * @param cargo     货物
     * @return  添加的记录条数
     * @throws SQLException how do I know
     */
    public int add(Connection connection, Cargo cargo) throws SQLException {
        String sql = "Insert INTO test VALUES (NULL, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, cargo.getCargoId());
        preparedStatement.setString(2, cargo.getCargoName());
        preparedStatement.setInt(3, cargo.getCargoNumber());
        preparedStatement.setDouble(4, cargo.getCargoAvePrice());
        return preparedStatement.executeUpdate();

    }
}
