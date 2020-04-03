package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();

        InputStream inputStream = new FileInputStream(nameFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        int number = 0;
        String stringNumber = "";
        Character ch;
        while (bufferedInputStream.available() > 0){
            ch = (char)bufferedInputStream.read();
            if (ch == '\n' || ch == '\r') {
                number = Integer.parseInt(stringNumber);
                if (number % 2 == 0)
                    arrayList.add(number);
                stringNumber = "";
            }
            else
                stringNumber = stringNumber + ch;
        }
        number = Integer.parseInt(stringNumber);
        if (number % 2 == 0)
            arrayList.add(number);

        Collections.sort(arrayList);

        for (int i: arrayList) {
            System.out.println(i);
        }

        inputStream.close();
    }
}
