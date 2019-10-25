package privateschoolstructure;

import privateschoolstructure.Entities.*;
import java.text.ParseException;
import java.util.*;
import static privateschoolstructure.PrivateSchoolStructure.scanner;

public class Print {

   

    public static void printCoursesofaStudent(ArrayList<Student> arS) {

        System.out.println("Whose student?");
        Student s = (Student) Finder.findaPerson(arS);
        for (int i = 0; i < s.getCourses().size(); i++) {
            System.out.println((i + 1) + ". " + s.getCourses().get(i));
        }
    }

    public static void printCoursesofaTrainer(ArrayList<Trainer> arT, ArrayList<Course> arC) {

        int j = 1;
        System.out.println("Which trainer?");
        Trainer t = (Trainer) Finder.findaPerson(arT);
        System.out.println("\n" + t + "\n");
        for (int i = 0; i < arC.size(); i++) {
            if (arC.get(i).getTrainers().contains(t)) {
                System.out.println(j + ". " + arC.get(i));
                j++;
            }
        }
    }

    public static void printAllStudentsperCourse(ArrayList<Course> arC) {

        for (int i = 0; i < arC.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + arC.get(i).getTitle() + "\n");
            for (int j = 0; j < arC.get(i).getStudents().size(); j++) {
                System.out.println((j + 1) + ". " + arC.get(i).getStudents().get(j));
            }
        }
    }

        public static <X> void printAll(ArrayList<X> arX) {

        for (int i = 0; i < arX.size(); i++) {
            System.out.println((i + 1) + ". " + arX.get(i));
        }
    }

    public static <X> X printAllandPick(ArrayList<X> arX) {

        printAll(arX);
        boolean found = false;
        int index;

        do {
            index = Checker.intCheck();
            if ((index > 0) && (index <= arX.size())) {
                found = true;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        } while (found == false);

        return arX.get((index - 1));
    }


    public static void printStudentsofaCourse(ArrayList<Course> arC) {

        String ask1;
        do {
            System.out.println("\n" + "If you want to see the list of the courses and select by number, type...................'0'"
                    + "\n" + "If you want to enter the course title, type.............................................'1'"
                    + "\n" + "If you want to cancel, type.............................................................'2'");
            ask1 = scanner.nextLine();
            switch (ask1) {
                case "0":
                    Course c1 = printAllandPick(arC);
                    System.out.println("\n" + c1.getTitle() + "\n");
                    printAll(c1.getStudents());
                    break;
                case "1":
                    Course c2 = Finder.findaCourse(arC);
                    System.out.println("\n" + c2.getTitle() + "\n");
                    printAll(c2.getStudents());
                    break;
                case "2":
                    System.out.println("\n" + "Action cancelled" + "\n");
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask1.equals("2"));
    }

    public static void printAllTrainersperCourse(ArrayList<Course> arC) {

        for (int i = 0; i < arC.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + arC.get(i).getTitle() + "\n");
            printAll(arC.get(i).getTrainers());
        }
    }

    public static void printTrainersofaCourse(ArrayList<Course> arC) {

        String ask1;
        do {
            System.out.println("\n" + "If you want to see the list of the courses and select by number, type...................'0'"
                    + "\n" + "If you want to enter the course title, type.............................................'1'"
                    + "\n" + "If you want to cancel, type.............................................................'2'");
            ask1 = scanner.nextLine();
            switch (ask1) {
                case "0":
                    Course c1 = printAllandPick(arC);
                    System.out.println("\n" + c1.getTitle() + "\n");
                    printAll(c1.getTrainers());
                    break;
                case "1":
                    Course c2 = Finder.findaCourse(arC);
                    System.out.println("\n" + c2.getTitle() + "\n");
                    printAll(c2.getTrainers());
                    break;
                case "2":
                    System.out.println("\n" + "Action cancelled" + "\n");
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask1.equals("2"));
    }

    public static void printAllAssignmentsperCourse(ArrayList<Course> arC, ArrayList<Assignment> arA) {

        for (int i = 0; i < arC.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + arC.get(i).getTitle() + "\n");
            for (Assignment a : arA) {
                if (arC.get(i).getTitle().equals(a.getTitle())) {
                    System.out.println(a);
                }
            }
        }
    }

    public static void printAllAssignmentperStudent(ArrayList<Student> arS) {

        for (int i = 0; i < arS.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + arS.get(i).getFirstName() + " " + arS.get(i).getLastName() + "\n");
            for (int j = 0; j < arS.get(i).getAssignments().size(); j++) {
                System.out.println((j + 1) + ". " + arS.get(i).getAssignments().get(j)
                        + "  SubDate: " + arS.get(i).getAssignments().get(j).getSubDateTime()
                        + "  Oral Mark: " + arS.get(i).getAssignments().get(j).getOralMark()
                        + "  Total Mark: " + arS.get(i).getAssignments().get(j).getTotalMark());
            }
        }
    }

    public static void printAssignmentsofaStudent(ArrayList<Student> arS) {

        System.out.println("Who student?");

        String ask1;
        do {
            System.out.println("\n" + "If you want to see the list of the students and select by number, type..................'0'"
                    + "\n" + "If you want to enter the student's name, type...........................................'1'"
                    + "\n" + "If you want to cancel, type.............................................................'2'");
            ask1 = scanner.nextLine();
            switch (ask1) {
                case "0":
                    Student s1 = printAllandPick(arS);
                    System.out.println("\n" + s1 + "\n");
                    for (int j = 0; j < s1.getAssignments().size(); j++) {
                        System.out.println((j + 1) + ". " + s1.getAssignments().get(j)
                                + "  SubDate: " + s1.getAssignments().get(j).getSubDateTime()
                                + "  Oral Mark: " + s1.getAssignments().get(j).getOralMark()
                                + "  Total Mark: " + s1.getAssignments().get(j).getTotalMark());
                    }
                    break;
                case "1":
                    Student s2 = (Student) Finder.findaPerson(arS);
                    System.out.println("\n" + s2 + "\n");
                    for (int j = 0; j < s2.getAssignments().size(); j++) {
                        System.out.println((j + 1) + ". " + s2.getAssignments().get(j)
                                + "  SubDate: " + s2.getAssignments().get(j).getSubDateTime()
                                + "  Oral Mark: " + s2.getAssignments().get(j).getOralMark()
                                + "  Total Mark: " + s2.getAssignments().get(j).getTotalMark());
                    }
                    break;
                case "2":
                    System.out.println("\n" + "Action cancelled" + "\n");
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask1.equals("2"));

    }

    public static void printStsmorethanoneOptCourses(ArrayList<Student> arS, ArrayList<Course> opt_cours) {

        System.out.println("\n" + "******************* Students that belong to more than one optional course *********************" + "\n");
        int courses = 0;
        ArrayList<Student> students = new ArrayList<>();
        for (Student s : arS) {
            for (Course c : opt_cours) {
                if (s.getCourses().contains(c)) {
                    courses++;
                }
            }
            if (courses > 1) {
                students.add(s);
                courses = 0;
            }
        }
        printAll(students);
    }

    public static void printStudenttoSubmit(ArrayList<Student> arS) throws ParseException {

        Date d1 = Checker.dateCheckandgetInput();
        Calendar c = Calendar.getInstance();
        c.setTime(d1);
        int dayOfWeek = (c.get(Calendar.DAY_OF_WEEK));

        Calendar first_Day_this_week = Calendar.getInstance();
        Calendar last_Day_this_week = Calendar.getInstance();
        first_Day_this_week.setTime(d1);
        int week_num = first_Day_this_week.get(Calendar.WEEK_OF_YEAR);
        first_Day_this_week.set(Calendar.WEEK_OF_YEAR, week_num);
        first_Day_this_week.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        last_Day_this_week.setTime(d1);
        last_Day_this_week.set(Calendar.WEEK_OF_YEAR, week_num);
        last_Day_this_week.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

        Calendar first_Day_prev_week = Calendar.getInstance();
        Calendar last_Day_prev_week = Calendar.getInstance();
        first_Day_prev_week.setTime(d1);
        int week_num1 = ((first_Day_this_week.get(Calendar.WEEK_OF_YEAR)) - 1);
        first_Day_prev_week.set(Calendar.WEEK_OF_YEAR, (week_num1));
        first_Day_prev_week.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        last_Day_prev_week.setTime(d1);
        last_Day_prev_week.set(Calendar.WEEK_OF_YEAR, (week_num1));
        last_Day_prev_week.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

        System.out.println("\n" + "************************** Students who have to submit this week ******************************" + "\n");
        boolean found = false;

        if (dayOfWeek < 2) {
            for (Student s : arS) {
                for (Assignment a : s.getAssignments()) {
                    if (Checker.isWithinRange(a.getSubDateTime(), first_Day_prev_week.getTime(), last_Day_prev_week.getTime()) == true) {
                        System.out.println("Assignment: " + a.getTitle() + " " + a.getSubDateTime() + " " + s.firstName + " " + s.lastName);
                        found = true;

                    }
                }
            }
        } else {
            for (Student s : arS) {
                for (Assignment a : s.getAssignments()) {
                    if (Checker.isWithinRange(a.getSubDateTime(), (first_Day_this_week.getTime()), (last_Day_this_week.getTime())) == true) {
                        System.out.println("Assignment: " + a.getTitle() + " " + a.getSubDateTime() + " " + s.firstName + " " + s.lastName);
                        found = true;
                    }
                }
            }
        }

        if (found == false) {
            System.out.println("\n" + "No student has to submit this week." + "\n");
        }
    }

    public static void overviewStudentElements(ArrayList<Student> arS) {

        System.out.println("\n" + "Which student?");
        Student s = new Student();
        
        String ask1;
        boolean found = false;
        do {
            System.out.println("\n" + "If you want to see the list of the students and select by number, type..................'0'"
                    + "\n" + "If you want to enter the student's name, type...........................................'1'"
                    + "\n" + "If you want to cancel, type.............................................................'2'");
            ask1 = scanner.nextLine();
            switch (ask1) {
                case "0":
                    s = printAllandPick(arS);
                    found = true;
                    break;
                case "1":
                    s = (Student) Finder.findaPerson(arS);
                    found = true;
                    break;
                case "2":
                    System.out.println("\n" + "Action cancelled" + "\n");
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask1.equals("2")&&(found==false));

        String ask2;
        do {
            System.out.println("\n" + "To overview student's tuition, type.....................'1'"
                    + "\n" + "To overview student's birth date, type..................'2'"
                    + "\n" + "To overview student's mark, type........................'3'"
                    + "\n" + "To cancel, type.........................................'4'" + "\n");

            ask2 = scanner.nextLine();

            switch (ask2) {
                case "1":
                    System.out.println("\n" + "Student's tuition: " + s.getTuitionFees() + " euros");
                    break;
                case "2":
                    System.out.println("\n" + "Student's birth date: " + s.getDateOfBirth());
                    break;
                case "3":
                    System.out.println("\n" + "Which course?");
                    Assignment a = Finder.findanAssignment(s.getAssignments());

                    String mark = "default";
                    String ask3;
                    do {
                        System.out.println("\n" + "Select mark.");
                        System.out.println("*** '1' for Oral / '2' for Total ***" + "\n");
                        ask3 = scanner.nextLine();
                        switch (ask3) {
                            case "1":
                                mark = "Oral";
                                System.out.println("Student's Oral mark: " + a.getOralMark());
                                break;
                            case "2":
                                mark = "Total";
                                System.out.println("Student's Oral mark: " + a.getTotalMark());
                                break;
                            default:
                                System.out.println("Invalid input. Try again.");
                                break;
                        }
                    } while ((!ask3.equals("1")) && (!ask3.equals("2")));
                    break;
                case "4":
                    System.out.println("\n" + "Action cancelled." + "\n");
                    break;
                case "default":
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }

        } while (!ask2.equals("4"));
    }
}
