package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class Solution {
    public static void main(String[] args) throws IOException {
        Double max = 0.0;
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, Double> map = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        while (bufferedReader.ready()){
            String[] str = bufferedReader.readLine().split(" ");
            if (map.containsKey(str[0]))
                map.put(str[0], map.get(str[0]) + Double.parseDouble(str[1]));
            else
                map.put(str[0], Double.parseDouble(str[1]));
            if (max < map.get(str[0]))
                max = map.get(str[0]);
        }

        for (Map.Entry<String, Double> mapEntry: map.entrySet()) {
            if (mapEntry.getValue().equals(max))
                arrayList.add(mapEntry.getKey());
        }

        Collections.sort(arrayList);

        //System.out.println(arrayList);

        for (String str: arrayList) {
            System.out.println(str);
        }

        bufferedReader.close();
    }
}
