package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);

        while (fileInputStream.available() > 0){
            int i = fileInputStream.read();
            if (args[0] == "-e")
                i += 21;
            else
                i -= 21;
            fileOutputStream.write(i);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
