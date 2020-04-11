package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = null;
        if (args[0].equals("-c")) {
            Date date = new SimpleDateFormat( "dd/MM/yyyy" ).parse( args[3] );

            if (args[2].equals("м")) {
                person = Person.createMale(args[1], date);
            } else if (args[2].equals("ж")) {
                person = Person.createFemale(args[1], date);
            }
            if (person != null)
                allPeople.add(person);
            System.out.println(allPeople.size() - 1);

        } else if (args[0].equals("-u")) {
            person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            if (args[3].equals("м"))
                person.setSex(Sex.MALE);
            else if (args[3].equals("ж"))
                person.setSex(Sex.FEMALE);
            person.setBirthDate(new SimpleDateFormat( "dd/MM/yyyy" ).parse( args[4] ));
        }
        else if (args[0].equals("-d")) {
            person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
        else if (args[0].equals("-i")) {
            person = allPeople.get(Integer.parseInt(args[1]));

            String sex = "";
            if (person.getSex().equals(Sex.MALE))
                sex = "м";
            else
                sex = "ж";
            System.out.println(person.getName() + " " + sex + " " + df.format(person.getBirthDate()));
        }
    }
}
