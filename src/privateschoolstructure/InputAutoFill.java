package privateschoolstructure;

import privateschoolstructure.Entities.*;
import java.util.ArrayList;

public class InputAutoFill {

    public static Student setCoursestoInputStudent(String stream, Student s, ArrayList<Course> arCdata, ArrayList<Course> courses) {

        if (stream.equals("Java")) {

            courses.add(arCdata.get(0));
            courses.add(arCdata.get(1));
            courses.add(arCdata.get(2));
            courses.add(arCdata.get(3));
            courses.add(arCdata.get(6));
            courses.add(arCdata.get(8));
            courses.add(arCdata.get(9));
            courses.add(arCdata.get(11));

            s.setCourses(courses);
        }
        if (stream.equals("C#")) {

            courses.add(arCdata.get(0));
            courses.add(arCdata.get(1));
            courses.add(arCdata.get(3));
            courses.add(arCdata.get(4));
            courses.add(arCdata.get(6));
            courses.add(arCdata.get(8));
            courses.add(arCdata.get(10));
            courses.add(arCdata.get(11));

            s.setCourses(courses);
        }

        return s;
    }

    public static void setStudentstoInputCourse(ArrayList<Student> arS, ArrayList<Student> data) {
        int numb = (int) (Math.random() * 20);
        for (int i = 0; i < numb; i++) {
            arS.add(data.get((int) (Math.random() * data.size())));
        }
    }

    public static void setTrainerstoInputCourse(ArrayList<Trainer> arT, ArrayList<Trainer> data) {
        int numb = (int) (Math.random() * 3);
        for (int i = 0; i < numb; i++) {
            arT.add(data.get((int) (Math.random() * data.size())));
        }
    }
}
