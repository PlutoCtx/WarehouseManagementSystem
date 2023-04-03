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
        String sql = "UPDATE test SET cargoNumber = cargoNumber + ? WHERE cargoId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, cargo.getNumberOfInventoryCargo());
        preparedStatement.setString(2, cargo.getModel());
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
        String sql = "Insert INTO test(cargoId, cargoName,cargoNumber, cargoAvePrice) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, cargo.getModel());
        preparedStatement.setString(2, cargo.getCargoName());
        preparedStatement.setInt(3, cargo.getNumberOfInventoryCargo());
        preparedStatement.setDouble(4, cargo.getCargoAvePrice());
        return preparedStatement.executeUpdate();

    }


    /**
     * 经理确认货物出库
     * @param connection    数据库连接
     * @param string    确认状态
     * @return  修改的条数，只要不是1， 就说明修改成功
     * @throws SQLException how do I know
     */
    public int checkOut(Connection connection, String string) throws SQLException {
        String sql = "INSERT INTO test(outCheck) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, string);
        return preparedStatement.executeUpdate();

    }


    /**
     * 经理确认货物出库
     * @param connection    数据库连接
     * @param string    确认状态
     * @return  修改的条数，只要不是1， 就说明修改成功
     * @throws SQLException how do I know
     */
    public int checkIn(Connection connection, String string) throws SQLException {
        String sql = "INSERT INTO test(inCheck) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, string);
        return preparedStatement.executeUpdate();

    }
}
