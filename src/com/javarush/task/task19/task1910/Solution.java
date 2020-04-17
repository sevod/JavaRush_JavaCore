package com.javarush.task.task19.task1910;

/* 
Пунктуация
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
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(nameFile2));

        while (fileReader.ready()){
            String s = fileReader.readLine().replaceAll("\\p{Punct}", "");
                //System.out.print(s);
                fileWriter.write(s);
        }
        fileReader.close();
        fileWriter.close();
    }
}
