package com.chentx.attempts.attempt03;

import java.util.logging.Logger;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/16 20:51
 * @since JDK17
 */

public class Node {
    String name;
    String ggxh;
    String hh;
    String dw;
    String kcs;
    String pjj;
    String kczj;

    Node(String[] s) {
        setname(s[0]);
        setggxh(s[1]);
        sethh(s[2]);
        setdw(s[3]);
        setkcs(s[4]);
        setpjj(s[5]);
        setkczj(s[6]);
    }

    @Override
    public String toString() {

        String str = name + "," + ggxh;

        if (str.endsWith(",")){
            return name;
        }
        return str;


//        if (ggxh == null){
//            return name;
//        }else {
//            Logger.getGlobal().info(ggxh);
//            return name + "," + ggxh;
//        }
    }


    public void setname(String s) {
        name=s;
    }
    public void setggxh(String s) {
        ggxh=s;
    }
    public void sethh(String s) {
        hh=s;
    }
    public void setdw(String s) {
        dw=s;
    }
    public void setkcs(String s) {
        kcs=s;
    }
    public void setpjj(String s) {
        pjj=s;
    }
    public void setkczj(String s) {
        kczj=s;
    }
}

