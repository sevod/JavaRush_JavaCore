package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        int id = Integer.parseInt(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();

        //int id = 2;
        //String nameFile = "c:/test/1";

        FileInputStream fileInputStream = new FileInputStream(nameFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        while (bufferedReader.ready()){
            String str = bufferedReader.readLine();
            String[] arrStr = str.split(" ");
            if (Integer.parseInt(arrStr[0]) == id) {
                System.out.println(str);
                break;
            }
        }
        bufferedReader.close();
    }
}
