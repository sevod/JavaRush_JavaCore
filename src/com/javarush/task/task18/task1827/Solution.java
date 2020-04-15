package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
//        String argsId0 = "-c";
//        String argsId1 = "продукНайм  ";
//        String argsId2 = "прайс  ";
//        String argsId3 = "куолити  ";
//        String fileName = "c:/test/1";

        if (args.length == 0)
            return;

        String argsId0 = args[0];
        String argsId1 = args[1];
        String argsId2 = args[2];
        String argsId3 = args[3];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        reader.close();

        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        while (file.ready())
            arrayList.add(file.readLine() + '\n');

        file.close();

        int nString = 0;
        Integer maxId = 0;
        String forAdd ="";

        if (argsId0.equals("-c")) {
            for (int i = 0; i < arrayList.size(); i++) {
                String num = arrayList.get(i).substring(0, 8);
                if (num.contains(" ")){
                    num = (num.split(" "))[0];
                }
                int id = Integer.parseInt(num);
                if (id > maxId) {
                    maxId = id;
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
            maxId++;
            String maxIdstr = maxId.toString();
            while ((8 - maxIdstr.length()) > 0)
                maxIdstr += " ";
            while ((30 - argsId1.length()) > 0)
                argsId1 += " ";
            while ((8 - argsId2.length()) > 0)
                argsId2 += " ";
            while ((4 - argsId3.length()) > 0)
                argsId3 += " ";
            forAdd = "\n" + maxIdstr + argsId1 + argsId2 + argsId3;
            fileOutputStream.write(forAdd.getBytes());
            fileOutputStream.close();
            return;
        } else {
            for (int i = 0; i < arrayList.size() - 1; i++) {
                String id = arrayList.get(i).substring(0, 8);
                if (id.equals(argsId0)) {
                    nString = i;
                }
            }
        }


        forAdd = argsId0 + argsId1 + argsId2 + argsId3 + '\n';
        arrayList.add(nString, forAdd);
        //System.out.println(arrayList);

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        for (int i = 0; i < arrayList.size() - 1; i++) {
            fileOutputStream.write(arrayList.get(i).getBytes());
        }
        fileOutputStream.close();
    }
}
