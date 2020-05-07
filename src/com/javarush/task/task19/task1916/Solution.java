package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> stringArray1 = new ArrayList<>();
        ArrayList<String> stringArray2 = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

//        String fileName1 = "C:/test/1";
//        String fileName2 = "C:/test/2";

        FileReader fileReader1 = new FileReader(fileName1);
        FileReader fileReader2 = new FileReader(fileName2);

        BufferedReader file1 = new BufferedReader(fileReader1);
        BufferedReader file2 = new BufferedReader(fileReader2);

        while (file1.ready()){
            stringArray1.add(file1.readLine());
        }

        while (file2.ready()){
            stringArray2.add(file2.readLine());
        }

        file1.close();
        file2.close();

        int j = 0;
        int length2 = stringArray2.size() - 1;
        for (int i = 0; i < stringArray1.size(); i++){
            if (length2 >= j) {
                if (stringArray1.get(i).equals(stringArray2.get(j))) {
                    lines.add(new LineItem(Type.SAME, stringArray1.get(i)));
                    j++;
                }else if (length2 > j && stringArray1.get(i).equals(stringArray2.get(j + 1))){
                    lines.add(new LineItem(Type.ADDED, stringArray2.get(j)));
                    j++;
                    i--;
                }else {
                    lines.add(new LineItem(Type.REMOVED, stringArray1.get(i)));
                }
            } else {
                lines.add(new LineItem(Type.REMOVED, stringArray1.get(i)));
            }
        }
        if (length2 == j){
            lines.add(new LineItem(Type.ADDED, stringArray2.get(j)));
        }

        for (LineItem li: lines) {
            System.out.println(li.type + " " + li.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
