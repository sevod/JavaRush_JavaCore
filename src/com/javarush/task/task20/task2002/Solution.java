package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("c:/test/1");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            //user.setFirstName("Ivanov");
            //user.setLastName("Ivanov");
            user.setMale(false);
            user.setBirthDate(new Date());
            System.out.println(user.getBirthDate());

            javaRush.users.add(user);
            System.out.println(javaRush);

            //javaRush.users.add(new User());
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

            System.out.println(loadedObject.users.get(0).getBirthDate());
            System.out.println(loadedObject);

            System.out.println(user.getBirthDate().equals(loadedObject.users.get(0).getBirthDate()));
            System.out.println("Обьекты равны? " + javaRush.equals(loadedObject));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            boolean first = true;
            for (User user: users) {
                if (!first)
                    outputStream.write("\n".getBytes());
                outputStream.write((user.getFirstName() == null) ? "".getBytes() : user.getFirstName().getBytes());
                outputStream.write("\n".getBytes());
                outputStream.write((user.getLastName() == null) ? "".getBytes() : user.getLastName().getBytes());
                outputStream.write("\n".getBytes());

                if (user.getBirthDate() != null) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                    String dateString = format.format(user.getBirthDate());
                    outputStream.write(dateString.getBytes());
                }
                outputStream.write("\n".getBytes());
                outputStream.write(user.isMale() ? "1".getBytes() : "0".getBytes());
                outputStream.write("\n".getBytes());
                outputStream.write((user.getCountry() == null) ? "".getBytes() : user.getCountry().toString().getBytes());
                first = false;
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (bufferedReader.ready()){
                User user = new User();
                String firstName = bufferedReader.readLine();
                if (!firstName.equals(""))
                    user.setFirstName(firstName);
                String lastName = bufferedReader.readLine();
                if (!lastName.equals(""))
                    user.setLastName(lastName);
                String date = bufferedReader.readLine();
                if (date != null){
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                    user.setBirthDate(format.parse(date));
                }
                user.setMale(bufferedReader.readLine().equals("1") ? true : false);
                String country = bufferedReader.readLine();
                if (country != null && !country.equals(""))
                    user.setCountry(User.Country.valueOf((country)));
                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
