package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        FileOutputStream file3 = new FileOutputStream(reader.readLine());

        int length = file1.available()/2;

        while (file1.available() > 0) {
            if (file1.available() <= length)
                file3.write(file1.read());
            else
                file2.write(file1.read());
        }

        file1.close();;
        file2.close();
        file3.close();
        reader.close();
    }
}
