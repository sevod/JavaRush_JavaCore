package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> inputString = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        //String fileName = "c:/test/1";

        FileReader fileReader = new FileReader(fileName);
        BufferedReader file = new BufferedReader(fileReader);


        while (file.ready()){
            String  s = file.readLine();
            inputString.add(s);
        }

        for (String str: inputString) {
            char[] charArray = str.toCharArray();
            for (int i = charArray.length - 1; i >= 0; i--)
                System.out.print(charArray[i]);
            System.out.println("");
        }

        fileReader.close();
    }
}
