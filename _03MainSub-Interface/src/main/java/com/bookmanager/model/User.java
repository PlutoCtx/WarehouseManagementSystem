package com.bookmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体
 *
 * @author Max chenmochen1954@163.com
 * since jdk17
 * @version 2022/12/18 23:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String userName;
    private String password;


    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }
}
