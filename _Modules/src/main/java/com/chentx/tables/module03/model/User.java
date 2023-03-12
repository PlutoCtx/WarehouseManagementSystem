package com.chentx.tables.module03.model;

/**
 * builder测试类
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/20 10:06
 * @since JDK17
 */

public class User {

    private final String name;

    private final String password;

    public User(UserBuilder builder) {
        this.name = builder.name;
        this.password = builder.password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public static final class UserBuilder {
        private final String name;
        private String password;

        private UserBuilder(String names) {
            this.name = names;
        }

        //构建参数是必传参数
        public static UserBuilder create(String name) {
            return new UserBuilder(name);
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

//    public static void main(String[] args) {
//        User aaa = UserBuilder.create("aaa").withPassword("123").build();
//        System.out.println(aaa.getName() + aaa.getPassword());
//    }
}

