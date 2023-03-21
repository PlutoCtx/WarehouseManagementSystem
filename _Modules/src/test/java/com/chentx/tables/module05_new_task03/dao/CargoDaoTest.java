package com.chentx.tables.module05_new_task03.dao;

import com.chentx.tables.module05_new_task03.entity.Cargo;
import com.chentx.tables.module05_new_task03.utils.Database;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

class CargoDaoTest {

    static Database database = new Database();
    static Connection connection = database.getConnection();
    static Cargo cargo = new Cargo();
    static CargoDao cargoDao = new CargoDao();
//    @Before
//    public void initTest(){
//        database = new Database();
//        connection = database.getConnection();
//        cargo = new Cargo();
//        cargoDao = new CargoDao();
//
//        // 初始化货物信息
//        cargo.setModel("B13");
//        cargo.setCargoName("大砍刀");
//        cargo.setNumberOfInventoryCargo(20);
//        cargo.setCargoAvePrice(8.0);
//    }

    /**
     * 用于测试数据更新程序是否能正常使用
     */
    @Test
    void update() throws SQLException {
        database = new Database();
        connection = database.getConnection();
        cargo = new Cargo();
        cargoDao = new CargoDao();

        // 初始化货物信息
        cargo.setNumberOfInventoryCargo(12);
        cargo.setModel("B13");

        cargoDao.update(connection, cargo);
    }

    /**
     * 用于测试数据入库程序是否能够正常的使用
     * @throws SQLException lue
     */
    @Test
    void add() throws SQLException {

        database = new Database();
        connection = database.getConnection();
        cargo = new Cargo();
        cargoDao = new CargoDao();

        // 初始化货物信息
        cargo.setModel("B12");
        cargo.setCargoName("大砍刀2");
        cargo.setNumberOfInventoryCargo(20);
        cargo.setCargoAvePrice(8.0);

        cargoDao.add(connection, cargo);
    }
}