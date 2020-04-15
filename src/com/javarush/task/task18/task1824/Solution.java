package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = "";
        while (true){
            try {
                fileName = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream(fileName);
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println(fileName);
                reader.close();
                break;
            }
        }
    }
}
