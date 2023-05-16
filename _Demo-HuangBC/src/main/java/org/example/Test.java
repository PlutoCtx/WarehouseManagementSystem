package org.example;


import org.example.CS.Main_Frame;
import org.example.tool.DBConnect;

public class Test {
    public static void main(String[] args) {
        DBConnect.getConnection();
        new Main_Frame();

    }
}
