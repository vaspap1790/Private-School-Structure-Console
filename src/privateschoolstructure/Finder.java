package privateschoolstructure;

import privateschoolstructure.Entities.*;
import java.util.*;
import static privateschoolstructure.PrivateSchoolStructure.scanner;

public class Finder {

    public static Person findaPerson(ArrayList<? extends Person> arP) {

        Person pe = new Person();
        String new_pe_fname;
        String new_pe_sname;
        boolean foundA = false;
        do {
            System.out.println("\n" + "Enter first name or '0' to see the list." + "\n");
            new_pe_fname = scanner.nextLine();
            if (new_pe_fname.equals("0")) {
                Print.printAll(arP);
                System.out.println("\n" + "Enter first name." + "\n");
                new_pe_fname = scanner.nextLine();
            }
            System.out.println("\n" + "Enter surname." + "\n");
            new_pe_sname = scanner.nextLine();
            for (Person p : arP) {
                if ((new_pe_sname.equals(p.getLastName())) && (new_pe_fname.equals(p.getFirstName()))) {
                    pe = p;
                    foundA = true;
                }
            }
        } while (foundA == false);

        return pe;
    }

    public static Assignment findanAssignment(ArrayList<Assignment> arA) {

        Assignment a = new Assignment();

        String type = " ";
        String ask;
        do {
            System.out.println("\n" + "Enter type for assignment ('1': Individual / '2': Group )." + "\n");
            ask = scanner.nextLine();
            switch (ask) {
                case "1":
                    type = "Individual";
                    break;
                case "2":
                    type = "Group";
                    break;
                default:
                    System.out.println("Invalid Input. Try again.");
                    break;
            }
        } while ((!ask.equals("1")) && (!ask.equals("2")));

        String new_a_title;
        boolean foundA = false;
        do {
            System.out.println("\n" + "Enter assignment's title or '0' to see the list." + "\n");
            new_a_title = scanner.nextLine();

            if (new_a_title.equals("0")) {
                Print.printAll(arA);
                System.out.println("\n" + "Enter title." + "\n");
                new_a_title = scanner.nextLine();
            }
            for (Assignment as : arA) {
                if (new_a_title.equals(as.getTitle()) && (type.equals(as.getDescription()))) {
                    a = as;
                    foundA = true;
                }
            }
        } while (foundA == false);

        return a;
    }

    public static Course findaCourse(ArrayList<Course> arC) {

        Course c = new Course(null, null, null, null, null, null, null, null);

        String new_sb_title;
        boolean foundA = false;
        do {
            System.out.println("\n" + "Enter title or '0' to see the list." + "\n");
            new_sb_title = scanner.nextLine();

            if (new_sb_title.equals("0")) {
                Print.printAll(arC);
                System.out.println("\n" + "Enter title." + "\n");
                new_sb_title = scanner.nextLine();
            }
            for (Course s : arC) {
                if (new_sb_title.equals(s.getTitle())) {
                    c = s;
                    foundA = true;
                }
            }
        } while (foundA == false);

        return c;
    }

    public static ArrayList<Course> getFirstTermCourses(ArrayList<Course> arC, Date sd1) {

        ArrayList<Course> first = new ArrayList<>();
        for (Course c : arC) {
            if (c.getStart_date() == sd1) {
                first.add(c);
            }
        }
        return first;
    }

    public static ArrayList<Course> getSecondTermCourses(ArrayList<Course> arC, Date sd2) {

        ArrayList<Course> second = new ArrayList<>();
        for (Course c : arC) {
            if (c.getStart_date() == sd2) {
                second.add(c);
            }
        }
        return second;
    }
}
