package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);

        System.setOut(stream);

        testString.printSomething();

        System.setOut(printStream);

        String s = byteArrayOutputStream.toString();
        //s = s.substring(0, s.length()-2);
        String[] str = s.split(" ");

        int n1 = Integer.parseInt(str[0]);
        int n2 = Integer.parseInt(str[2]);

        if (str[1].equals("+"))
            s = (s + (n1 + n2));
        else if (str[1].equals("-"))
            s = (s + (n1 - n2));
        else if (str[1].equals("*"))
            s = (s + (n1 * n2));

        System.out.print(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

