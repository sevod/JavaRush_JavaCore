package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countAll = 0;
        int countSpace = 0;

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        //FileInputStream fileInputStream = new FileInputStream("c:/test/1");

        while (fileInputStream.available() > 0){
            countAll++;
            int ch = fileInputStream.read();
            if (ch == ' ')
                countSpace++;
        }

        fileInputStream.close();

        float count = (float)countSpace / (float)countAll * 100;
        System.out.printf("%.02f", count);

    }
}
