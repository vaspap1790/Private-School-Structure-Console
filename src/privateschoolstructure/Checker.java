package privateschoolstructure;

import java.text.*;
import java.util.Date;
import static privateschoolstructure.PrivateSchoolStructure.scanner;

public class Checker {

    public static Date dateCheckandget(String date) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date2;
        date2 = formatter.parse(date);

        try {
            date2 = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date2;
    }

    public static Date dateCheckandgetInput() throws ParseException {

        Date date2 = null;
        boolean correctFormat = false;
        do {
            System.out.println("\n" + "Enter Date.***Format YYYY-MM-DD***" + "\n");
            String date = scanner.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            // date2 = formatter.parse(date);

            try {
                date2 = formatter.parse(date);
                correctFormat = true;
            } catch (ParseException e) {
                System.out.println("\n" + "Invalid format." + "\n");
                correctFormat = false;
            }
        } while (!correctFormat);

        return date2;
    }

    static boolean isWithinRange(Date testDate, Date startDate, Date endDate) {
        return !(testDate.before(startDate) || testDate.after(endDate));
    }

    public static double doubleCheck() {

        double tuition = 0;
        boolean correct_form = false;

        while (correct_form == false) {

            System.out.println("\n" + "Enter tuition." + "\n");
            String s = scanner.nextLine();

            if (s.matches("^\\d+(\\.\\d+)?$")) {
                tuition = Double.parseDouble(s);
                correct_form = true;
            } else {
                System.out.println("\n" + "Invalid input. Try again.");
            }
        }

        return tuition;
    }

    public static int intCheck() {

        boolean correct_form = false;
        int index = 0;

        while (correct_form == false) {
            System.out.println("\n" + "Type the number." + "\n");
            String input = scanner.nextLine();

            try {
                index = Integer.parseInt(input);
                correct_form = true;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
        return index;
    }
}
