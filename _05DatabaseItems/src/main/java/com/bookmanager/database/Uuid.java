package com.bookmanager.database;

import com.fasterxml.uuid.Generators;

import java.util.UUID;
import java.util.logging.Logger;

/**
 * uuid
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/4/1 19:45
 * @since JDK17
 */

public class Uuid {

//    public static void main(String[] args) {
//        String uuid01 = UUID.randomUUID().toString();
//        Logger.getGlobal().info(uuid01);
//        String uuid02 = UUID.randomUUID().toString();
//        Logger.getGlobal().info(uuid02);
//        UUID uuid03 = UUID.fromString("533a4559-e55c-18b3-2456-555563322002");
//        Logger.getGlobal().info(uuid03.toString());
//        Logger.getGlobal().info(String.valueOf(uuid01.compareTo(uuid02)));
//    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            UUID uuid = Generators.timeBasedGenerator().generate();
            Logger.getGlobal().info(uuid.toString());
        }




    }







}
