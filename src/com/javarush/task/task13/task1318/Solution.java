package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();

        reader.close();

        InputStream inputStream = new FileInputStream(nameFile);
        BufferedInputStream buffer = new BufferedInputStream(inputStream);

        while (buffer.available() > 0){
            System.out.print((char)buffer.read());
        }

        inputStream.close();
        buffer.close();

    }
}