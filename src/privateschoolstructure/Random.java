package privateschoolstructure;

import privateschoolstructure.Entities.*;
import java.time.LocalDate;
import java.util.*;

public class Random {

    public static Date randomDeadline1term() {

        java.util.Random random = new java.util.Random();
        int minDay = (int) LocalDate.of(2019, 11, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2020, 2, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomDeadline = LocalDate.ofEpochDay(randomDay);
        Date date1 = java.sql.Date.valueOf(randomDeadline);

        return date1;
    }

    public static Date randomDeadline2term() {

        java.util.Random random = new java.util.Random();
        int minDay = (int) LocalDate.of(2020, 3, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2020, 6, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomDeadline = LocalDate.ofEpochDay(randomDay);
        Date date1 = java.sql.Date.valueOf(randomDeadline);

        return date1;
    }

    public static String randomMark() {
        String mark = null;
        int n = (int) (Math.random() * 4);
        switch (n) {
            case 0:
                mark = "A";
                break;
            case 1:
                mark = "B";
                break;
            case 2:
                mark = "C";
                break;
            case 3:
                mark = "D";
                break;
        }

        return mark;
    }

    public static Student getRandomStudent(String[] fn, String[] sn, ArrayList<Course> arC) {

        String f = fn[((int) (Math.random() * fn.length))];
        String s = sn[((int) (Math.random() * sn.length))];
        String j_or_c;
        int mand_courses = 8;
        int number_of_optional_courses = (int) (Math.random() * 5);
        int all_courses = mand_courses + number_of_optional_courses;
        double tuition = all_courses * 200;

        java.util.Random random = new java.util.Random();
        int minDay = (int) LocalDate.of(1980, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        Date date = java.sql.Date.valueOf(randomBirthDate);

        int rand_int = (int) (Math.random() * 2);
        if (rand_int == 0) {
            j_or_c = "C#";
        } else {
            j_or_c = "Java";
        }

        Student st = new Student(f, s, date, j_or_c, tuition, new ArrayList<>(), new ArrayList<>());

        return st;
    }
}
