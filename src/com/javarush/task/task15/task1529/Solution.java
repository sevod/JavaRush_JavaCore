package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String par = reader.readLine();
            if (par.equals("helicopter"))
                result = new Helicopter();
            else if (par.equals("plane")) {
                int i = Integer.parseInt(reader.readLine());
                result = new Plane(i);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
