package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        //String nameFile = "c:/test/1";
        reader.close();

        FileReader fileReader = new FileReader(nameFile);

        BufferedReader bufferedFile = new BufferedReader(fileReader);

        int count = 0;
        while (bufferedFile.ready()) {
            for (String s : bufferedFile.readLine().split("\\W")) {
                if (s.equals("world")) {
                    count++;
                }
            }
        }
        System.out.println(count);
        fileReader.close();
    }
}
