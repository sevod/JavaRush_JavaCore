package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, Double> map = new HashMap<>();
        String nameFile = args[0];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile));

        while (bufferedReader.ready()){
            String[] str = bufferedReader.readLine().split(" ");
            if(map.containsKey(str[0]))
                map.put(str[0], map.get(str[0]) + Double.parseDouble(str[1]));
            else
                map.put(str[0], Double.parseDouble(str[1]));
        }

        bufferedReader.close();

        for (Map.Entry<String, Double> sortMap: map.entrySet()) {
            arrayList.add(sortMap.getKey());
        }

        Collections.sort(arrayList);

        for (String i: arrayList) {
            for (Map.Entry<String, Double> sortMap: map.entrySet()) {
                if (i.equals(sortMap.getKey())){
                    System.out.println(sortMap.getKey() + " " + sortMap.getValue());
                    continue;
                }
            }
        }
    }
}
