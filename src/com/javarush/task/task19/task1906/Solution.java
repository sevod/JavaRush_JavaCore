package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
//        String file1 = "c:/test/1";
//        String file2 = "c:/test/2";
        reader.close();

        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        int i = 1;
        while (fileReader.ready()) {
            int ch = fileReader.read();
            if (i % 2 == 0)
                fileWriter.write(ch);
            i++;
        }
        fileReader.close();
        fileWriter.close();
    }
}
