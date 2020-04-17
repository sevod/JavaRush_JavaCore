package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        //String nameFile = "c:/test/1";
        reader.close();

        PrintStream printStream = new PrintStream(System.out);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);

        testString.printSomething();
        String str = byteArrayOutputStream.toString();
        System.setOut(printStream);

        System.out.println(str);

        FileOutputStream fileOutputStream = new FileOutputStream(nameFile);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

