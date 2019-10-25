package privateschoolstructure;

import privateschoolstructure.Entities.*;
import java.text.ParseException;
import java.util.*;
import static privateschoolstructure.PrivateSchoolStructure.scanner;

public class MenuMethods {

    public static void mainMenu(ArrayList<Student> arS, ArrayList<Trainer> arT, ArrayList<Course> arC, ArrayList<Course> arOC, ArrayList<Assignment> arA, Date sd1, Date sd2, Date ed1, Date ed2) throws ParseException {

        String x;
        do {
            System.out.println("\n");
            System.out.println("*******************************************************************************************");
            System.out.println("**                                      Main Menu                                        **");
            System.out.println("*******************************************************************************************");
            System.out.println("\n"
                    + "-If you want to enter Trainers Menu, type..............................................'1'-");
            System.out.println("\n"
                    + "-If you want to enter Courses Menu, type...............................................'2'-");
            System.out.println("\n"
                    + "-If you want to enter Students Menu, type..............................................'3'-");
            System.out.println("\n"
                    + "-If you want to input an assignment type...............................................'4'-");
            System.out.println("***By default every course has two assignments(Individual/Group).You may want to enter a new assignment.***" + "\n");
            System.out.println("\n"
                    + "-If you want skip editing and explore our current structure, type......................'5'-");
            System.out.println("\n"
                    + "-If you want to end the application, type .............................................'6'-");
            System.out.println("\n"
                    + "                                                       ***The console is case sensitive.***" + "\n");
            System.out.println("*******************************************************************************************" + "\n");

            x = scanner.nextLine();

            switch (x) {
                case "1":
                    TrainersMenu(arT, arC);
                    break;
                case "2":
                    CoursesMenu(arC, arS, arT, arA, sd1, sd2, ed1, ed2);
                    break;
                case "3":
                    StudentsMenu(arS, arC, arA);
                    break;
                case "4":
                    Input.inputAssignments(arA);
                    break;
                case "5":
                    userAction(arS, arT, arA, arC, arOC);
                    break;
                case "6":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!"6".equals(x));

        System.out.println("\n" + "******************************* You ended the application *********************************");
    }

    public static void userAction(ArrayList<Student> arS, ArrayList<Trainer> arT, ArrayList<Assignment> arA, ArrayList<Course> arC, ArrayList<Course> arOC) throws ParseException {

        String input;
        do {
            System.out.println("\n");
            System.out.println("*************************************************************************************************");
            System.out.println("**                           Exploring Fantastic School Structure                              **");
            System.out.println("*************************************************************************************************");
            System.out.println("\n");
            System.out.println("-For printing a list of all the students, type...............................................'1'-"
                    + "\n" + "-For printing a list of all the trainers, type...............................................'2'-"
                    + "\n" + "-For printing a list of all the assignments, type............................................'3'-"
                    + "\n" + "-For printing a list of all the courses, type ...............................................'4'-"
                    + "\n" + "-For printing all the students per course, type..............................................'5'-"
                    + "\n" + "-For printing all the trainers per course, type..............................................'6'-"
                    + "\n" + "-For printing all the assignments per course, type...........................................'7'-"
                    + "\n" + "-For printing all the assignments per student, type..........................................'8'-"
                    + "\n" + "-For printing the list of students that belong to more than one courses, type................'9'-"
                    + "\n" + "-For printing the list of students who need to submit one or more assignments on the same"
                    + "\n" + "calendar week as the date that you give, type...............................................'10'-"
                    + "\n" + "-To return to Main Menu, type...............................................................'11'-"
                    + "\n" + "\n" + "*************************************************************************************************" + "\n");

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("\n" + "**************************** Students of 'Fantastic Private School' *****************************" + "\n");
                    Print.printAll(arS);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "2":
                    System.out.println("\n" + "**************************** Trainers of 'Fantastic Private School' *****************************" + "\n");
                    Print.printAll(arT);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "3":
                    System.out.println("\n" + "************************** Assignments of 'Fantastic Private School' ****************************" + "\n");
                    Print.printAll(arA);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "4":
                    System.out.println("\n" + "**************************** Courses of 'Fantastic Private School' ******************************" + "\n");
                    Print.printAll(arC);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "5":
                    Print.printAllStudentsperCourse(arC);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "6":
                    Print.printAllTrainersperCourse(arC);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "7":
                    Print.printAllAssignmentsperCourse(arC, arA);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "8":
                    Print.printAllAssignmentperStudent(arS);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "9":
                    Print.printStsmorethanoneOptCourses(arS, arOC);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "10":
                    Print.printStudenttoSubmit(arS);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "11":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!"11".equals(input));

    }

    public static void StudentsMenu(ArrayList<Student> arS, ArrayList<Course> arC, ArrayList<Assignment> arA) throws ParseException {

        String ask;
        do {
            System.out.println("\n" + "************************************* Students Menu ***************************************");
            System.out.println("\n" + "To see the list of the students, type...................................................'1'"
                    + "\n" + "To input a student, type................................................................'2'"
                    + "\n" + "To delete a student, type...............................................................'3'"
                    + "\n" + "To edit student's elements (marks/tuition) to a student type............................'4'"
                    + "\n" + "To overview student's elements(marks/tuition/birth date), type..........................'5'"
                    + "\n" + "To see the courses of a student, type...................................................'6'"
                    + "\n" + "To see the assignments of a student, type...............................................'7'"
                    + "\n" + "To return to Main Menu, type............................................................'8'"
                    + "\n" + "*******************************************************************************************" + "\n");

            ask = scanner.nextLine();

            switch (ask) {
                case "1":
                    System.out.println("\n" + "*********************** Students of 'Fantastic Private School' *************************" + "\n");
                    Print.printAll(arS);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "2":
                    Input.inputStudents(arS, arC, arA);
                    break;
                case "6":
                    Print.printCoursesofaStudent(arS);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "7":
                    Print.printAssignmentsofaStudent(arS);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "5":
                    Print.overviewStudentElements(arS);
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "3":
                    Remove.deleteaPerson(arS);
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                case "4":
                    System.out.println("\n" + "To set oral mark, type.........................'1'"
                            + "\n" + "To set total mark, type........................'2'"
                            + "\n" + "To edit tuition, type..........................'3'"
                            + "\n" + "***By default tuition of each student depends on how many courses the student participates in. You may want to edit tuition in case of scholarship,discount or additional fees"
                            + "\n" + "If you want to cancel type.....................'4'");

                    String ask2 = scanner.nextLine();

                    switch (ask2) {
                        case "1":
                            Input.inputStudentOMark(arS);
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "2":
                            Input.inputStudentTMark(arS);
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "3":
                            Input.inputStudentTuition(arS);
                            System.out.println("\n" + "What would you like to do next?" + "\n");
                            break;
                        case "4":
                            System.out.println("\n" + "Action cancelled." + "\n");
                            break;
                        default:
                            System.out.println("\n" + "Invalid input.Try again." + "\n");
                            break;
                    }
                    break;
                case "8":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask.equals("8"));

    }

    public static void TrainersMenu(ArrayList<Trainer> arT, ArrayList<Course> arC) throws ParseException {

        String ask;
        do {
            System.out.println("\n" + "************************************* Trainers Menu ***************************************");
            System.out.println("\n" + "To see the list of the trainers, type...................................................'1'"
                    + "\n" + "To input a trainer, type................................................................'2'"
                    + "\n" + "To delete a trainer, type...............................................................'3'"
                    + "\n" + "To see the courses that a trainer is involved, type.....................................'4'"
                    + "\n" + "To return to Main Menu, type............................................................'5'"
                    + "\n" + "*******************************************************************************************" + "\n");

            ask = scanner.nextLine();

            switch (ask) {
                case "1":
                    System.out.println("\n" + "*********************** Trainers of 'Fantastic Private School' *************************" + "\n");
                    Print.printAll(arT);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "2":
                    Input.inputTrainers(arT);
                    break;
                case "4":
                    Print.printCoursesofaTrainer(arT, arC);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "3":
                    Remove.deleteaPerson(arT);
                case "5":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask.equals("5"));
    }

    public static void CoursesMenu(ArrayList<Course> arC, ArrayList<Student> arS, ArrayList<Trainer> arT, ArrayList<Assignment> arA, Date sd1, Date sd2, Date ed1, Date ed2) throws ParseException {

        String ask;
        do {
            System.out.println("\n" + "************************************** Courses Menu ***************************************");
            System.out.println("\n" + "To see the list of the courses, type....................................................'1'"
                    + "\n" + "To input a course, type.................................................................'2'"
                    + "\n" + "To delete a course, type................................................................'3'"
                    + "\n" + "To print the students of a course, type.................................................'4'"
                    + "\n" + "To print the trainers of a course, type.................................................'5'"
                    + "\n" + "To return to Main Menu, type............................................................'6'"
                    + "\n" + "*******************************************************************************************" + "\n");

            ask = scanner.nextLine();

            switch (ask) {
                case "1":
                    Print.printAll(arC);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "4":
                    Print.printStudentsofaCourse(arC);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "5":
                    Print.printTrainersofaCourse(arC);
                    System.out.println("\n" + "*************************************************************************************************" + "\n");
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                    break;
                case "2":
                    Input.inputCourses(sd1, sd2, ed1, ed2, arC, arS, arT);
                    break;
                case "3":
                    Remove.deleteaCourse(arC);
                    System.out.println("\n" + "What would you like to do next?" + "\n");
                case "6":
                    break;
                default:
                    System.out.println("\n" + "Invalid input. Try again." + "\n");
                    break;
            }
        } while (!ask.equals("6"));
    }
}
