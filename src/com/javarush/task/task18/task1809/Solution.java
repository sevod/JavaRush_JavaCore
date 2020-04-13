package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());

        while (fileInputStream.available() > 0)
            arrayList.add(fileInputStream.read());

        for (int i = arrayList.size() - 1; i >= 0; i--)
            fileOutputStream.write(arrayList.get(i));

        reader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
