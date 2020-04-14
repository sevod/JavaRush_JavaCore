package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);


        while (fileInputStream2.available() > 0)
            data.add(fileInputStream2.read());

        while (fileInputStream1.available() > 0)
            data.add(fileInputStream1.read());

        fileInputStream1.close();
        fileInputStream2.close();

        FileOutputStream fileOutputStream = new FileOutputStream(file1);

        for (Integer i: data) {
            fileOutputStream.write(i);
        }

        fileOutputStream.close();
    }
}
