package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxByte = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        while (fileInputStream.available() > 0){
            int sizeByte = fileInputStream.read();
            if (sizeByte > maxByte)
                maxByte = sizeByte;
        }
        fileInputStream.close();

        System.out.println(maxByte);
    }
}
