package privateschoolstructure;

import privateschoolstructure.Entities.*;
import java.util.*;
import static privateschoolstructure.PrivateSchoolStructure.scanner;

public class Remove {

    public static void deleteaCourse(ArrayList<Course> arC) {
        String ask;
        do {
            System.out.println("\n" + "Procced to deleting a course with 'c' or cancel by typing 'back'." 
                             + "\n" + "If you want to see the list of the courses type '0'.");
            ask = scanner.nextLine();
            switch (ask) {
                case "0":
                    Print.printAll(arC);
                    break;
                case "c":
                    String new_t_name;
                    boolean foundA = false;
                    do {
                        System.out.println("\n" + "Enter course's title or 'back' to cancel." + "\n");
                        new_t_name = scanner.nextLine();
                        Iterator<Course> itr = arC.iterator();
                        while (itr.hasNext()) {
                            Course c = itr.next();
                            if (new_t_name.equals(c.getTitle())) {
                                itr.remove();
                                foundA = true;
                                System.out.println("\n" + "You deleted the course." + "\n");
                            }
                        }
                    } while ((foundA == false) && (!new_t_name.equals("back")));
                    break;
                case "back":
                    System.out.println("\n" + "Action cancelled." + "\n");
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask.equals("back"));
    }

    public static void deleteaPerson(ArrayList<? extends Person> arP) {
        String ask;
        do {
            System.out.println("\n" + "Procced to deleting with 'd' or cancel by typing 'back'." 
                             + "\n" + "If you want to see the list, type '0'.");
            ask = scanner.nextLine();
            switch (ask) {
                case "0":
                    Print.printAll(arP);
                    break;
                case "d":
                    String new_pe_fname;
                    String new_pe_sname;
                    boolean foundA = false;
                    do {
                        System.out.println("\n" + "Enter first name or 'back' to cancel." + "\n");
                        new_pe_fname = scanner.nextLine();
                        System.out.println("\n" + "Enter surname or 'back' to cancel." + "\n");
                        new_pe_sname = scanner.nextLine();
                        Iterator<? extends Person> itr = arP.iterator();
                        while (itr.hasNext()) {
                            Person pe = itr.next();
                            if ((new_pe_fname.equals(pe.getFirstName())) && (new_pe_sname.equals(pe.getLastName()))) {
                                itr.remove();
                                foundA = true;
                                System.out.println("\n" + "Successfully deleted." + "\n");
                            }
                        }
                    } while ((foundA == false) && (!new_pe_sname.equals("back")) && (!new_pe_fname.equals("back")));
                    break;
                case "back":
                    System.out.println("\n" + "Action cancelled." + "\n");
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask.equals("back"));
    }

}
