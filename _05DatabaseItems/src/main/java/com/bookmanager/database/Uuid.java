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
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            UUID uuid = Generators.timeBasedGenerator().generate();
            Logger.getGlobal().info(uuid.toString());
        }

    }
}
