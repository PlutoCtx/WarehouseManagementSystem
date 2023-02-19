package com.chentx.tables.module01;

import java.util.Random;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/18 0:47
 * @since JDK17
 */

public class GetRandomNumber {

    public static int[] getRandomNumber(int max, int amount){
        // 1至max之间的amount个不同随机增速（包括1和max）
        int[] randomNumber = new int[amount];
        int index = 0;
        randomNumber[0] = -1;
        Random random = new Random();
        while (index < amount){
            int number = random.nextInt(max) + 1;
            boolean isInArrays = false;
            for (int m : randomNumber) {
                if (m == number){
                    isInArrays = true;
                }
            }
            if (isInArrays == false){
                // 如果number不在数组randomNumber中
                randomNumber[index] = number;
                index++;
            }
        }
        return randomNumber;

    }


}
