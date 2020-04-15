package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String fileName = reader.readLine();
            if (fileName.equals("end"))
                break;
            arrayList.add(fileName);
        }
        reader.close();

        Collections.sort(arrayList);

        String fileName = arrayList.get(0);
        fileName = fileName.substring(0, fileName.length()-6);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (String str: arrayList) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), 1000);
            int i = 1; //
            while (bufferedReader.ready()) {
                System.out.println("String " + i++); //
                bufferedWriter.write(bufferedReader.read());
            }
            bufferedReader.close();
        }

        bufferedWriter.close();
    }
}
