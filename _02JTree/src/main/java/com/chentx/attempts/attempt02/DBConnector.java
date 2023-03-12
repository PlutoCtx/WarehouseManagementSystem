package com.chentx.attempts.attempt02;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * 数据库连接
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 17:14
 * @since JDK17
 */

public class DBConnector {
    private static final String CONNECT_URL = "jdbc:mysql://localhost:3306/warehousemanagementsystem?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String CONNECT_USERNAME = "root";
    private static final String CONNECT_PASSWORD = "Shangxiao111";

    private Connection connection;

    public DBConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(CONNECT_URL, CONNECT_USERNAME, CONNECT_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Material> queryNodeByHH(String hh) {
        String sqlFormat = "select * from clggb where length(hh) = %d and hh like '%s%%'";

        int nodeHHLength = hh.length() + 2;
        List<Material> materialList = new LinkedList<>();
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = String.format(sqlFormat, nodeHHLength, hh);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Material material = new Material();
                material.setMc(resultSet.getString("mc"));
                material.setGgxh(resultSet.getString("ggxh"));
                material.setHh(resultSet.getString("hh"));
                material.setDw(resultSet.getString("dw"));
                materialList.add(material);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materialList;
    }

    public Material queryMaterialByHH(String hh) {
        String sqlFormat = "select * from clggb where hh = '%s'";

        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql  = String.format(sqlFormat, hh);
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                Material material = new Material();
                material.setMc(resultSet.getString("mc"));
                material.setGgxh(resultSet.getString("ggxh"));
                material.setHh(resultSet.getString("hh"));
                material.setDw(resultSet.getString("dw"));
                return material;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Material();
    }
}
