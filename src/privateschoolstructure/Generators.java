package privateschoolstructure;

import privateschoolstructure.Entities.*;
import java.util.*;

public class Generators {

    public static Student setCoursestoStudent(String stream, Student s, int opt_cour, ArrayList<Course> arC) {

        opt_cour = ((int) ((s.getTuitionFees() / 200) - 8));

        if (stream.equals("Java")) {

            ArrayList<Course> courses1 = new ArrayList<>();

            courses1.add(arC.get(0));
            courses1.add(arC.get(1));
            courses1.add(arC.get(2));
            courses1.add(arC.get(3));
            courses1.add(arC.get(6));
            courses1.add(arC.get(8));
            courses1.add(arC.get(9));
            courses1.add(arC.get(11));

            switch (opt_cour) {
                case 1:
                    courses1.add(arC.get(5));
                    break;
                case 2:
                    courses1.add(arC.get(5));
                    courses1.add(arC.get(7));
                    break;
                case 3:
                    courses1.add(arC.get(5));
                    courses1.add(arC.get(7));
                    courses1.add(arC.get(12));
                    break;
                case 4:
                    courses1.add(arC.get(5));
                    courses1.add(arC.get(7));
                    courses1.add(arC.get(12));
                    courses1.add(arC.get(13));

                    break;
                case 0:
                    break;

            }
            s.setCourses(courses1);
        }
        if (stream.equals("C#")) {

            ArrayList<Course> courses1 = new ArrayList<>();

            courses1.add(arC.get(0));
            courses1.add(arC.get(1));
            courses1.add(arC.get(3));
            courses1.add(arC.get(4));
            courses1.add(arC.get(6));
            courses1.add(arC.get(8));
            courses1.add(arC.get(10));
            courses1.add(arC.get(11));

            switch (opt_cour) {
                case 1:
                    courses1.add(arC.get(5));
                    break;
                case 2:
                    courses1.add(arC.get(5));
                    courses1.add(arC.get(7));
                    break;
                case 3:
                    courses1.add(arC.get(5));
                    courses1.add(arC.get(7));
                    courses1.add(arC.get(12));
                    break;
                case 4:
                    courses1.add(arC.get(5));
                    courses1.add(arC.get(7));
                    courses1.add(arC.get(12));
                    courses1.add(arC.get(13));

                    break;
                case 0:
                    break;

            }
            s.setCourses(courses1);
        }
        return s;
    }

    public static void setAssignmentstoStudent(Student s, ArrayList<Course> arC, ArrayList<Assignment> arA) {

        ArrayList<Assignment> assignments = new ArrayList<>();
        ArrayList<Assignment> copies = new ArrayList<>();

        s.getCourses().forEach((c) -> {
            arA.stream().filter((a) -> (c.getTitle().equals(a.getTitle()))).forEachOrdered((a) -> {
                assignments.add((a));
            });
        });

        for (Assignment a : assignments) {
            Assignment c = new Assignment(a);
            copies.add(c);
        }

        s.setAssignments(copies);

    }

    public static void generateStudents(ArrayList<Student> s, String[] fn, String[] sn, ArrayList<Course> arC) {
        for (int i = 0; i < 60; i++) {
            s.add(Random.getRandomStudent(fn, sn, arC));
        }
    }

    public static void setStudentstoDataCourse(Course c, ArrayList<Student> s) {
        s.stream().filter((student) -> ((student.getCourses()).contains(c))).forEachOrdered((student) -> {
            (c.getStudents()).add(student);
        });
    }

    public static void fillAllCourseswithStudents(ArrayList<Course> arC, ArrayList<Student> arS) {
        arC.forEach((course) -> {
            setStudentstoDataCourse(course, arS);
        });
    }

    public static ArrayList<Assignment> generateAssignments(ArrayList<Assignment> arA, ArrayList<Course> arC, Date sd1) {

        for (Course c : arC) {
            Assignment a = new Assignment();
            a.setTitle(c.getTitle());
            a.setDescription("Individual");
            if (c.getStart_date().equals(sd1)) {
                a.setTerm(1);
            } else {
                a.setTerm(2);
            }
            arA.add(a);
        }

        for (Course c : arC) {
            Assignment a = new Assignment();
            a.setTitle(c.getTitle());
            a.setDescription("Group");
            if (c.getStart_date().equals(sd1)) {
                a.setTerm(1);
            } else {
                a.setTerm(2);
            }
            arA.add(a);
        }

        return arA;
    }

    public static void generateSyntheticData(ArrayList<Student> arS, ArrayList<Course> arC, ArrayList<Assignment> arA, String[] fnames, String[] snames, Date sd1, Date sd2) {

        generateStudents(arS, fnames, snames, arC);

        arS.forEach((s) -> {
            setCoursestoStudent(s.getStream(), s, 1, arC);
        });

        fillAllCourseswithStudents(arC, arS);

        generateAssignments(arA, arC, sd1);

        for (Student s : arS) {
            setAssignmentstoStudent(s, arC, arA);
        }
    }

}
