package com.chentx.attempts.onlineexamples.ex06;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 11:01
 * @since JDK17
 */
@Data
@AllArgsConstructor
public class Menu {
    private String id;
    private String parentId;
    private String text;
    private String url;
    private String yxbz;
    private List<Menu> children;
    public Menu(String id,String parentId,String text,String url,String yxbz) {
        this.id=id;
        this.parentId=parentId;
        this.text=text;
        this.url=url;
        this.yxbz=yxbz;
    }
    /*省略get\set*/
}