package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        //String string = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
        reader.close();

        string = string.substring(string.indexOf('?') + 1);
        String Astr[] = string.split("&");
        ArrayList<String> strObj = new ArrayList<>();
        for (String str: Astr) {
            String str2 = "";
            try {
                str2 = str.substring(0, str.indexOf('='));
            }catch (Exception e){
                str2 = str;
            }
            if (str2.equals("obj")) {
                strObj.add(str.substring(str.indexOf("=") + 1));
            }
            System.out.print(str2 + " ");
        }
        if (!strObj.isEmpty())
            System.out.println("");
        for (String str: strObj) {
            try {
                alert(Double.parseDouble(str));
            }catch (Exception e) {
                alert(str);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
