package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();
        reader.close();

//        String nameFile1 = "c:/test/1";
//        String nameFile2 = "c:/test/2";

        BufferedReader fileReader = new BufferedReader(new FileReader(nameFile1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFile2));

        int i = 0;
        while (fileReader.ready()){
            String str = fileReader.readLine();
            for (String s: str.split(" ")) {
                if (!s.isEmpty()) {
                    try {
                        i = Integer.parseInt(s);
                    } catch (Exception e){
                        continue;
                    }
                    bufferedWriter.write(i + " ");
                }
            }
        }
        fileReader.close();
        bufferedWriter.close();
    }
}
