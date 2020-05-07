package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        //String fileName = "c:/test/2";

        FileReader fileReader = new FileReader(fileName);
        BufferedReader file = new BufferedReader(fileReader);

        String tegName = args[0];
        String text = "";

        while (file.ready()) {
            text += file.readLine();
        }

        Document html = Jsoup.parse(text, " ", Parser.xmlParser());
        Elements teg = html.getElementsByTag(tegName);
        System.out.println(teg);

        fileReader.close();
        file.close();
    }
}
