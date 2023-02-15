package com.chentx.attempts.onlineexamples.ex01;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 0:48
 * @since JDK17
 */

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class Menu {
    @JSONField(ordinal=1)
    private int id;
    @JSONField(ordinal=2)
    private String menuName;//名称
    @JSONField(ordinal=3)
    private int parId;//上级ID
    @JSONField(ordinal=4)
    private int type;//0：目录；1：菜单
    @JSONField(ordinal=5)
    private String url;
    @JSONField(ordinal=6)
    public ArrayList<Menu> children;

    public Menu() {
        super();
        this.children = new ArrayList<>();
    }

    private Menu(Builder builder) {
        setId(builder.id);
        setMenuName(builder.menuName);
        setParId(builder.parId);
        setType(builder.type);
        setUrl(builder.url);
        setChildren(builder.children);
    }

    public void addChildren(Menu menu) {

        this.children.add(menu);
    }


    public ArrayList<Menu> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Menu> children) {
        if (children==null){
            children=new ArrayList<>();
        }
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


    public int getParId() {
        return parId;
    }

    public void setParId(int parId) {
        this.parId = parId;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", parId=" + parId +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }

    public static final class Builder {
        private int id;
        private String menuName;
        private int parId;
        private int type;
        private String url;
        private ArrayList<Menu> children;

        public Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder menuName(String menuName) {
            this.menuName = menuName;
            return this;
        }

        public Builder parId(int parId) {
            this.parId = parId;
            return this;
        }

        public Builder type(int type) {
            this.type = type;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder children(ArrayList<Menu> children) {
            this.children = children;
            return this;
        }

        public Menu build() {
            return new Menu(this);
        }
    }
}