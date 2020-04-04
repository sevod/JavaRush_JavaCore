package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int num1;
        int num2;
        int max;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            num1 = Integer.parseInt(reader.readLine());
            if (num1 < 1 )
                throw new ArithmeticException("lou zero");
            num2 = Integer.parseInt(reader.readLine());
            if ( num2 < 1)
                throw new ArithmeticException("lou zero");

            if (num1 > num2)
                max = num1;
            else
                max = num2;

            while (max > 0){
                if (num1 % max == 0 && num2 % max == 0 ){
                    System.out.println(max);
                    break;
                }
                max--;
            }
    }
}
