package com.javarush.task.task18.task1813;

import java.io.FileOutputStream;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        AmigoOutputStream amigoOutputStream = new AmigoOutputStream(new FileOutputStream("C:/test/result3.txt"));
        amigoOutputStream.write("123".getBytes());
        amigoOutputStream.close();
    }
}
