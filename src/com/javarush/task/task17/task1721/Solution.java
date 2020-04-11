package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        //String file1 = "C:/test/1";
        //String file2 = "C:/test/1";

        BufferedReader readerFile1 = new BufferedReader(new FileReader(file1));
        while (readerFile1.ready())
            allLines.add(readerFile1.readLine());
        readerFile1.close();

        BufferedReader readerFile2 = new BufferedReader(new FileReader(file2));
        while (readerFile2.ready())
            forRemoveLines.add(readerFile2.readLine());

        readerFile2.close();

        new Solution().joinData();
    }

    public void joinData() throws CorruptedDataException {
        Iterator<String> iterator = allLines.iterator();

        for (String str: forRemoveLines) {
            if (allLines.contains(str))
                allLines.remove(str);
            else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
        //System.out.println(allLines);
    }
}
