package com.javarush.task.task15.task1525;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(Statics.FILE_NAME);
            String string = "";
            while (fileInputStream.available() > 0){
                char i = (char)fileInputStream.read();
                if (i != '\n')
                    string += i;
                else {
                    lines.add(string);
                    string = "";
                }
            }
            if (!string.isEmpty())
                lines.add(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
