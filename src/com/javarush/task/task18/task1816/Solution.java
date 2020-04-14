package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        //FileInputStream fileInputStream = new FileInputStream("c:/test/1");

        while (fileInputStream.available() > 0) {
            int ch = fileInputStream.read();
            if ((ch >= 65 && ch <=90) || (ch >= 97 && ch <=  122) )
                count++;
        }

        fileInputStream.close();
        System.out.println(count);

    }
}
