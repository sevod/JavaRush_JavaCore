package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        //start here - начни тут
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = null;
        switch (args[0]) {
            case ("-c"):{
                for (int i = 0; i < args.length - 1; i+=3) {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(args[3 + i]);

                    if (args[2 + i].equals("м")) {
                        person = Person.createMale(args[1 + i], date);
                    } else if (args[2 + i].equals("ж")) {
                        person = Person.createFemale(args[1 + i], date);
                    }
                    if (person != null)
                        allPeople.add(person);
                    System.out.println(allPeople.size() - 1);
                }
                break;
            }
            case ("-u"):{
                for (int i = 0; i < args.length - 1; i+=4) {
                    person = allPeople.get(Integer.parseInt(args[1 + i]));
                    person.setName(args[2 + i]);
                    if (args[3 + i].equals("м"))
                        person.setSex(Sex.MALE);
                    else if (args[3 + i].equals("ж"))
                        person.setSex(Sex.FEMALE);
                    person.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(args[4 + i]));
                }
                break;
            }
            case ("-d"):{
                for (int i = 1; i < args.length; i++) {
                    person = allPeople.get(Integer.parseInt(args[i]));
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDate(null);
                }
                break;
            }
            case ("-i"):{
                for (int i = 1; i < args.length; i++) {
                    person = allPeople.get(Integer.parseInt(args[i]));

                    String sex = "";
                    if (person.getSex().equals(Sex.MALE))
                        sex = "м";
                    else
                        sex = "ж";
                    System.out.println(person.getName() + " " + sex + " " + df.format(person.getBirthDate()));
                }
                break;
            }
        }
    }
}
