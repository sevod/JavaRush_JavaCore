package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        String fileName = args[0];
        //String fileName = "c:/test/1";

        FileInputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() > 0){
            int key = fileInputStream.read();
            if (!arrayList.contains(key))
                arrayList.add(key);
        }

        Collections.sort(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            map.put(arrayList.get(i), 0);
        }

        fileInputStream.close();

        fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() > 0){
            int key = fileInputStream.read();
            if (!map.containsKey(key))
                map.put(key, 1);
            else
                map.put(key, map.get(key) + 1);
        }

        for (int i: arrayList) {
            System.out.println((char) i + " " + map.get(i));
        }

        fileInputStream.close();
    }
}
