package privateschoolstructure;

import privateschoolstructure.Entities.*;
import java.text.ParseException;
import java.util.*;
import static privateschoolstructure.Print.printAllandPick;
import static privateschoolstructure.PrivateSchoolStructure.scanner;

public class Input {

    public static ArrayList<Trainer> inputTrainers(ArrayList<Trainer> t) {

        System.out.println("\n" + "Enter trainer's first name" + "\n");
        String fname = scanner.nextLine();

        System.out.println("\n" + "Enter trainer's surname" + "\n");
        String sname = scanner.nextLine();

        System.out.println("\n" + "Enter trainer's subject" + "\n");
        String subject = scanner.nextLine();

        Trainer t1 = new Trainer(fname, sname, subject);
        t.set((int) ((Math.random()) * (t.size() - 1)), t1);

        System.out.println("\n" + "You successfully registered a new trainer! What would you like to do next?" + "\n");

        return t;
    }

    public static ArrayList<Assignment> inputAssignments(ArrayList<Assignment> arA) throws ParseException {

        System.out.println("\n" + "Enter assignment's title" + "\n");
        String title = scanner.nextLine();

        String description = "default";
        String ask;
        do {
            System.out.println("\n" + "Enter assignment's description");
            System.out.println("*** '1' for Individual / '2' for Group ***" + "\n");
            ask = scanner.nextLine();
            switch (ask) {
                case "1":
                    description = "Individual";
                    break;
                case "2":
                    description = "Group";
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while ((!ask.equals("1")) && (!ask.equals("2")));

        System.out.println("\n" + "Pease insert assignment's deadline.");
        Date d1 = Checker.dateCheckandgetInput();

        int term = 0;
        String ask1;
        do {
            System.out.println("\n" + "Pease insert assignment's term.");
            System.out.println("*** '1' for first / '2' for second ***" + "\n");
            ask1 = scanner.nextLine();
            switch (ask1) {
                case "1":
                    term = 1;
                    break;
                case "2":
                    term = 2;
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while ((!ask1.equals("1")) && (!ask1.equals("2")));

        Assignment a = new Assignment();
        a.setTitle(title);
        a.setDescription(description);
        a.setSubDateTime(d1);
        a.setTerm(term);

        arA.add(a);

        System.out.println("\n" + "You successfully created a new assignment! What would you like to do next?" + "\n");

        return arA;
    }

    public static ArrayList<Student> inputStudents(ArrayList<Student> arS, ArrayList<Course> arC, ArrayList<Assignment> arA) throws ParseException {

        ArrayList<Course> courses = new ArrayList<>();

        System.out.println("\n" + "Enter student's first name" + "\n");
        String fname = scanner.nextLine();

        System.out.println("\n" + "Enter student's surname" + "\n");
        String sname = scanner.nextLine();

        System.out.println("\n" + "Enter student's birth date");
        Date birth_date = Checker.dateCheckandgetInput();

        String stream = "default";
        String ask;
        do {
            System.out.println("\n" + "Enter students's stream");
            System.out.println("*** '1' for Java / '2' for C# ***" + "\n");
            ask = scanner.nextLine();
            switch (ask) {
                case "1":
                    stream = "Java";
                    break;
                case "2":
                    stream = "C#";
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while ((!ask.equals("1")) && (!ask.equals("2")));

        System.out.println("\n" + "Enter student's optional courses." + "\n" + "Type 1 for: 'Javascript' First Term Course" + "\n" + "Type 2 for: 'Introduction to Artificial Intelligence' First Term Course" + "\n" + "Type 3 for: 'Operating Systems' Second Term Course" + "\n" + "Type 4 for: 'Apples' Second Term Course" + "\n" + "Type 5 for 'Javascript' and 'Apples'" + "\n" + "Type 6 for 'Javascript' and 'Operating Systems'" + "\n" + "Type 7 for 'Introduction to Artificial Intelligence' and 'Apples'" + "\n" + "Type 8 for 'Introduction to Artificial Intelligence' and 'Operating Systems'" + "\n" + "Type 0 for: No optional course.");
        int count_opt = 0;
        String n1 = scanner.nextLine();

        switch (n1) {
            case "0":
                System.out.println("\n" + "No optional courses." + "\n");
                count_opt = 0;
                break;
            case "1":
                courses.add(arC.get(5));
                count_opt = 1;
                break;
            case "2":
                courses.add(arC.get(6));
                count_opt = 1;
                break;
            case "3":
                courses.add(arC.get(12));
                count_opt = 1;
                break;
            case "4":
                courses.add(arC.get(13));
                count_opt = 1;
                break;
            case "5":
                courses.add(arC.get(5));
                courses.add(arC.get(12));
                count_opt = 2;
                break;
            case "6":
                courses.add(arC.get(5));
                courses.add(arC.get(13));
                count_opt = 2;
                break;
            case "7":
                courses.add(arC.get(7));
                courses.add(arC.get(12));
                count_opt = 2;
                break;
            case "8":
                courses.add(arC.get(7));
                courses.add(arC.get(13));
                count_opt = 2;
                break;
        }

        int mand_courses = 8;
        int all_courses = mand_courses + count_opt;
        double tuition = all_courses * 200;

        Student s = new Student(fname, sname, birth_date, stream, tuition, courses, new ArrayList<>());

        InputAutoFill.setCoursestoInputStudent(stream, s, arC, courses);
        Generators.setAssignmentstoStudent(s, courses, arA);
        arS.set((int) ((Math.random()) * (arS.size() - 1)), s);

        System.out.println("\n" + "You successfully registered the new student! What would you like to do next?" + "\n");

        return arS;
    }

    public static ArrayList<Course> inputCourses(Date sd1, Date sd2, Date ed1, Date ed2, ArrayList<Course> arC, ArrayList<Student> arS, ArrayList<Trainer> arT) throws ParseException {

        String term = "default";
        ArrayList<Trainer> inp_tr = new ArrayList<>();
        ArrayList<Student> inp_st = new ArrayList<>();

        System.out.println("\n" + "Enter course's title" + "\n");
        String title = scanner.nextLine();

        String stream = "default";
        String ask;
        do {
            System.out.println("\n" + "Enter courses's stream");
            System.out.println("*** '1' for Java / '2' for C# ***" + "\n");
            ask = scanner.nextLine();
            switch (ask) {
                case "1":
                    stream = "Java";
                    break;
                case "2":
                    stream = "C#";
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while ((!ask.equals("1")) && (!ask.equals("2")));

        String type = "default";
        String ask1;
        do {
            System.out.println("\n" + "Enter course's type");
            System.out.println("*** '1' for Mandatory / '2' for Optional ***" + "\n");
            ask1 = scanner.nextLine();
            switch (ask1) {
                case "1":
                    type = "Mandatory";
                    break;
                case "2":
                    type = "Optional";
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while ((!ask1.equals("1")) && (!ask1.equals("2")));

        Date start_date = sd1;
        Date end_date = ed1;
        String ask4;
        do {

            System.out.println("\n" + "Enter course's start and end date.(For first term:2019-09-09/For second term:2020-02-03)");
            System.out.println("First term courses start in 2019-09-09 and end in 2020-01-24. Second term caurses start in 2020-02-03and end in 2020-06-12 )");
            System.out.println("Type '1' for first term , '2' for second term, or '3' to enter custom date.");

            ask4 = scanner.nextLine();
            switch (ask4) {
                case "1":
                    start_date = sd1;
                    end_date = ed1;
                    term = "1";
                    break;
                case "2":
                    start_date = sd2;
                    end_date = ed2;
                    term = "2";
                    break;
                case "3":
                    System.out.println("Start date");
                    start_date = Checker.dateCheckandgetInput();
                    System.out.println("End date");
                    end_date = Checker.dateCheckandgetInput();
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        } while ((!ask4.equals("1")) && (!ask4.equals("2")) && (!ask4.equals("3")));

        InputAutoFill.setTrainerstoInputCourse(inp_tr, arT);
        InputAutoFill.setStudentstoInputCourse(inp_st, arS);

        String ask2;
        do {
            System.out.println("\n" + "Add a trainer to the course with 't' or skip with typing 'skip'." + "\n" + "If you want to see the list of the teaching stuff type '0'." + "\n" + "***Trainers will also apply for teaching the course at will.***");
            ask2 = scanner.nextLine();
            switch (ask2) {
                case "0":
                    Print.printAll(arT);
                    break;
                case "t":
                    inp_tr.add((Trainer) Finder.findaPerson(arT));
                    System.out.println("\n" + "You successfully added the trainer to the course." + "\n");
                    break;
                case "skip":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask2.equals("skip"));

        String ask3;
        do {
            System.out.println("\n" + "Add a student to the course with 's' or skip with typing 'skip'." + "\n" + "If you want to see the list of the students type '0'." + "\n" + "***Students will also apply for the course at will.***");
            ask3 = scanner.nextLine();
            switch (ask3) {
                case "0":
                    Print.printAll(arS);
                    break;
                case "s":
                    inp_st.add((Student) Finder.findaPerson(arS));
                    System.out.println("\n" + "You successfully added the student to the course." + "\n");
                    break;
                case "skip":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask3.equals("skip"));

        Course c1 = new Course(title, stream, type, start_date, end_date, term, inp_tr, inp_st);
        arC.add(c1);

        System.out.println("\n" + "You successfully added a new course! What would you like to do next?" + "\n");

        return arC;
    }

    public static void inputStudentOMark(ArrayList<Student> arS) {

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
        } while (!ask1.equals("2") && (found == false));

        System.out.println("\n" + "Which assignment?");
        Assignment a = Finder.findanAssignment(s.getAssignments());

        String omark;
        boolean done = false;
        do {
            System.out.println("\n" + "Type 'A' for Excellent"
                    + "\n" + "     'B' for Good"
                    + "\n" + "     'C' for Pass"
                    + "\n" + "     'D' for No Pass"
                    + "\n" + "     'back' for cancel.");

            omark = scanner.nextLine();
            switch (omark) {
                case "A":
                    a.setOralMark("A");
                    done = true;
                    System.out.println("\n" + "You added the mark." + "\n");
                    break;
                case "B":
                    a.setOralMark("B");
                    done = true;
                    System.out.println("\n" + "You added the mark." + "\n");
                    break;
                case "C":
                    a.setOralMark("C");
                    done = true;
                    System.out.println("\n" + "You added the mark." + "\n");
                    break;
                case "D":
                    a.setOralMark("D");
                    done = true;
                    System.out.println("\n" + "You added the mark." + "\n");
                    break;
                case "back":
                    System.out.println("\n" + "Action cancelled." + "\n");
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while ((!omark.equals("back")) && (done == false));
    }

    public static void inputStudentTMark(ArrayList<Student> arS) {

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
        } while (!ask1.equals("2") && (found == false));

        System.out.println("\n" + "Which assignment?");
        Assignment a = Finder.findanAssignment(s.getAssignments());

        String tmark;
        boolean done = false;
        do {
            System.out.println("\n" + "Type 'A' for Excellent" + "\n" + "     'B' for Good" + "\n" + "     'C' for Pass" + "\n" + "     'D' for No Pass" + "\n" + "     'back' for cancel.");
            tmark = scanner.nextLine();
            switch (tmark) {
                case "A":
                    a.setTotalMark("A");
                    done = true;
                    System.out.println("\n" + "You added the mark." + "\n");
                    break;
                case "B":
                    a.setTotalMark("B");
                    done = true;
                    System.out.println("\n" + "You added the mark." + "\n");
                    break;
                case "C":
                    a.setTotalMark("C");
                    done = true;
                    System.out.println("\n" + "You added the mark." + "\n");
                    break;
                case "D":
                    a.setTotalMark("D");
                    done = true;
                    System.out.println("\n" + "You added the mark." + "\n");
                    break;
                case "back":
                    System.out.println("\n" + "Action cancelled." + "\n");
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }

        } while ((!tmark.equals("back")) && (done == false));
    }

    public static void inputStudentTuition(ArrayList<Student> arS) {

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
                    s.setTuitionFees(Checker.doubleCheck());
                    found = true;
                    break;
                case "1":
                    s = (Student) Finder.findaPerson(arS);
                    s.setTuitionFees(Checker.doubleCheck());
                    found = true;
                    break;
                case "2":
                    System.out.println("\n" + "Action cancelled" + "\n");
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask1.equals("2") && (found == false));

        System.out.println("\n" + "Tuition fees successfully added." + "\n");
    }

}
