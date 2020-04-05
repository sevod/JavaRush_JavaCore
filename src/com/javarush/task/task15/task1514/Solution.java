package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(12d,"12ddded");
        labels.put(13d,"12dd");
        labels.put(14d,"1s2sdd");
        labels.put(15d,"a12dd");
        labels.put(16d,"12dbcd");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }


}
