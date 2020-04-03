package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> dataFile = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();

        while (true){
            String str = reader.readLine();
            dataFile.add(str + "\n");
            if (str.equals("exit"))
                break;
        }


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFile));

        try {
            for (String str : dataFile) {
                bufferedWriter.write(str);
            }
        } catch (Exception e){}
        bufferedWriter.close();
    }
}
