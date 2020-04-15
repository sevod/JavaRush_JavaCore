package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        String param = "";
        String argsId = "";
        String argsId1 = "";
        String argsId2 = "";
        String argsId3 = "";

//         param = "-d";
//         argsId = "19847983";
//         argsId1 = "продукНайм  ";
//         argsId2 = "прайс  ";
//         argsId3 = "куолити  ";
         //String fileName = "c:/test/1";

        if (args.length == 0)
            return;

        if (args.length == 2) {
            param = args[0];
            argsId = args[1];
        }

        if (args.length == 5) {
            param = args[0];
            argsId = args[1];
            argsId1 = args[2];
            argsId2 = args[3];
            argsId3 = args[4];
        }

        while ((8 - argsId.length()) > 0)
            argsId += " ";


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        reader.close();

        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        String forAdd ="";


        if (param.equals("-u")) {
            while ((30 - argsId1.length()) > 0)
                argsId1 += " ";
            while ((8 - argsId2.length()) > 0)
                argsId2 += " ";
            while ((4 - argsId3.length()) > 0)
                argsId3 += " ";
            forAdd = argsId + argsId1 + argsId2 + argsId3;

            while (file.ready()) {
                String str = file.readLine();
                if (!(str.substring(0, 8).equals(argsId)))
                    arrayList.add(str);
                else
                    arrayList.add(forAdd);
            }

        } else if(param.equals("-d")) {
            while (file.ready()) {
                String str = file.readLine();
                if (!(str.substring(0, 8).equals(argsId)))
                    arrayList.add(str);
            }
        }
        file.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        for (int i = 0; i < arrayList.size(); i++) {
            if (i != arrayList.size() - 1)
                fileOutputStream.write((arrayList.get(i) + '\n').getBytes());
            else
                fileOutputStream.write((arrayList.get(i)).getBytes());
        }
        fileOutputStream.close();
    }
}
