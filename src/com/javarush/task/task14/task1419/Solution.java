package com.javarush.task.task14.task1419;

import org.omg.CORBA.ExceptionList;

import java.lang.reflect.Array;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.concurrent.ExecutionException;
/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            FileInputStream fis = new FileInputStream("C2:badFileName.txt");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int i[] = new int[10];
            i[11] = 1;
        } catch (Exception e) {
            exceptions.add(e);
        }


        exceptions.add(new RuntimeException("Message: Unknown Exception"));

        exceptions.add(new IndexOutOfBoundsException("Message: Unknown Exception"));
        exceptions.add(new NumberFormatException("Message: Unknown Exception"));
        exceptions.add(new IllegalArgumentException("Message: Unknown Exception"));

        exceptions.add(new IllegalMonitorStateException("Message: Unknown Exception"));
        exceptions.add(new SecurityException("Message: Unknown Exception"));
        exceptions.add(new ExecutionException(new IllegalMonitorStateException("Message: Unknown Exception")));



    }
}
