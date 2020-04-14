package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        FileInputStream fileInputStream = new TxtInputStream("C:/test/result.txt");
        while (fileInputStream.available() > 0)
            System.out.println(fileInputStream.read());
        fileInputStream.close();
    }
}
