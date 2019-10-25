package privateschoolstructure;

import java.text.ParseException;
import java.util.Scanner;

public class PrivateSchoolStructure {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

        Data d = new Data();

        System.out.println("\n" + "*******************************************************************************************");
        System.out.println("\n" + "**                                      Welcome to                                       **");
        System.out.println("\n" + "**                              -Fantastic Private School-                               **");
        System.out.println("\n" + "**                                       console!                                        **");
        System.out.println("\n" + "*******************************************************************************************" + "\n");

        Generators.generateSyntheticData(d.students, d.courses, d.assignments, d.rand_fnames, d.rand_snames, d.start_date1, d.start_date2);
        MenuMethods.mainMenu(d.students, d.trainers, d.courses, d.opt_courses, d.assignments, d.start_date1, d.start_date2, d.end_date1, d.end_date2);

    }
}
