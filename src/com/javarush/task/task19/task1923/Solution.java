package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader file1 = new FileReader(args[0]);
        FileWriter file2 = new FileWriter(args[1]);

        BufferedReader bufferedReader = new BufferedReader(file1);

        while (bufferedReader.ready()){
            String str = bufferedReader.readLine();
            String[] arrayStr = str.split(" ");
            for (String word: arrayStr) {
                if (word.matches("^.*\\d+.*"))
                    file2.write(word + " ");
                    //System.out.print(word + " ");
            }
        }

        bufferedReader.close();
        file1.close();
        file2.close();
    }
}
