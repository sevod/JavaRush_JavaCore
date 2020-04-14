package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.BitSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        //String fileName1 = "c:/test/1";
        //String fileName2 = "c:/test/2";
        String fileName2 = reader.readLine();



        FileInputStream fileInputStream = new FileInputStream(fileName1);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream));
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

        String tmp = reader1.readLine();
        String[] str = tmp.split(" ");
        for (String s: str) {
            double i = Double.parseDouble(s);
            Integer res = (int)Math.round(i);
            fileOutputStream.write(res.toString().getBytes());
            fileOutputStream.write(' ');
        }

        fileOutputStream.close();
        fileInputStream.close();
    }
}
