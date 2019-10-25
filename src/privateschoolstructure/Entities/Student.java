package privateschoolstructure.Entities;

import java.util.ArrayList;
import java.util.Date;

public class Student extends Person {

    private Date dateOfBirth;
    private String stream;
    private double tuitionFees;
    private ArrayList<Course> courses;
    private ArrayList<Assignment> assignments;

    public Student(String firstName, String lastName, Date dateOfBirth, String stream, double tuitionFees, ArrayList<Course> courses, ArrayList<Assignment> assignments) {
        
        super.firstName = firstName;
        super.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.stream = stream;
        this.tuitionFees = tuitionFees;
        this.courses = courses;
        this.assignments = assignments;
    }

    public Student() {
    }
    

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", stream=" + stream + ", tuitionFees=" + tuitionFees + "euros" + '}';
    }

}
