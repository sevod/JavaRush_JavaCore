package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out; //как бы архив, что бы потом вернуть все назад

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); //сюда мы положем данные перехваченные из стандартного потока
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream); // подменили, теперь все уходит в steam

        testString.printSomething();    //пробаем печатать, но все уходит в созданый steam

        String str = byteArrayOutputStream.toString();  //достаем все что только что пытались печатать из steam

        System.setOut(printStream);  //возвращаем поток на место, что бы можно было выводить в консоль

//        PrintStream printStream1 = System.out;
//        System.setOut(printStream1); //а вот так не работает

        System.out.println(str.replace("te", "??"));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
