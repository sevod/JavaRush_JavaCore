package com.javarush.task.task19.task1921;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        while (bufferedReader.ready()){
            while (bufferedReader.ready()) {
                String[] arrStr = bufferedReader.readLine().split(" ");
                String name = "";
                String birth = "";
                int count = 1;
                for (int i = arrStr.length - 1; i >= 0; i--) {
                    if (count <= 3)
                        birth = arrStr[i] + "-" + birth;
                    else
                        name = arrStr[i] + " " + name;
                    count++;
                }

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-");
                Date birthDay = simpleDateFormat.parse(birth);

                PEOPLE.add(new Person(name.trim(), birthDay));
            }
        }

//        for (Person person: PEOPLE) {
//            System.out.println(person.getName() + person.getBirthDate());
//        }

        bufferedReader.close();
    }
}
