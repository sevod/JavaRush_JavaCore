package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        while (fileInputStream.available() > 0){
            int byteFile = fileInputStream.read();
            if (! list.contains(byteFile)) {
                list.add(byteFile);
            }
        }
        fileInputStream.close();

        Collections.sort(list);

        for (Integer i: list) {
            System.out.print(i + " ");
        }
    }
}
