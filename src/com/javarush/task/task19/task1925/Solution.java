package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        String result = "";

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()){
            String str = bufferedReader.readLine();
            String[] arrayStr = str.split(" ");

            for (String word: arrayStr) {
                if (word.length() > 6)
                    result += word + ",";
            }
        }
        result = result.substring(0, result.length() - 1);
        fileWriter.write(result);

        fileWriter.close();
        fileReader.close();
        bufferedReader.close();
    }
}
