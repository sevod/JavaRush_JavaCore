package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");

//        words.add("А");
//        words.add("Б");
//        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        //String fileName = "c:/test/1";

        FileReader fileReader = new FileReader(fileName);
        BufferedReader file = new BufferedReader(fileReader);

        while (file.ready()){
            String str = file.readLine();
            String[] arrayStr = str.split(" ");
            int count = 0;
            for (String word: arrayStr) {
                if (words.contains(word))
                    count++;
            }
            if (count == 2)
                System.out.println(str);
        }

        file.close();
        fileReader.close();
    }
}
