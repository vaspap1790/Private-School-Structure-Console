package privateschoolstructure;

import privateschoolstructure.Entities.*;
import java.text.*;
import java.util.*;

public class Data {

    public Trainer t1 = new Trainer("George", "Iraklides", "Object Oriented Programming");
    public Trainer t2 = new Trainer("Nikos", "Karapas", "Object Oriented Programming");
    public Trainer t3 = new Trainer("George", "Pasparakis", "Web");
    public Trainer t4 = new Trainer("Carl", "Sassenrath", "Hardware");
    public Trainer t5 = new Trainer("Guido", "Van Rassum", "Python");
    public Trainer t6 = new Trainer("James", "Gosling", "Java");
    public Trainer t7 = new Trainer("John", "McCarthy", "Artificial Intelligence");
    public Trainer t8 = new Trainer("Anders", "Heljsberg", "C#");
    public Trainer t9 = new Trainer("Alan", "Turing", "Computer Science");
    public Trainer t10 = new Trainer("Alan", "Kay", "Object Oriented Programming");
    public Trainer t11 = new Trainer("Dennis", "Ritchie", "Procedural Programming");
    public Trainer t12 = new Trainer("Linus", "Torvalds", "Operating Systems");
    public Trainer t13 = new Trainer("Bill", "Gates", "Software and Computing");
    public Trainer t14 = new Trainer("Steve", "Jobs", "Apples");
    public Trainer t15 = new Trainer("Mark", "Zuckerberg", "Social Network");
    public Trainer t16 = new Trainer("Tim", "Berners-Lee", "Web");
    public Trainer t17 = new Trainer("Ada", "Lovelace", "Procedural Programming");
    public Trainer t18 = new Trainer("Larry", "Page", "Web");
    public Trainer t19 = new Trainer("Barbara", "Liskov", "Coding");
    public Trainer t20 = new Trainer("Brendan", "Eich", "Javascript");

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date sd;

    public Data() throws ParseException {
        this.sd = formatter.parse(strd1);
    }
    String strd1 = "2019-09-09";
    String strd2 = "2020-01-24";
    String strd3 = "2020-02-03";
    String strd4 = "2020-06-12";

    Date start_date1 = formatter.parse(strd1);
    Date end_date1 = formatter.parse(strd2);
    Date start_date2 = formatter.parse(strd3);
    Date end_date2 = formatter.parse(strd4);

    public Course c1 = new Course("Introduction to Python", "Java and C# Streams", "Mandatory", start_date1, end_date1, "1", new ArrayList<>(Arrays.asList(t1, t5, t11)), new ArrayList<>());
    public Course c2 = new Course("Computer Science 101", "Java and C# Streams", "Mandatory", start_date1, end_date1, "1", new ArrayList<>(Arrays.asList(t9, t13, t17)), new ArrayList<>());
    public Course c3 = new Course("Java Fundamentals", "Java Stream", "Mandatory", start_date1, end_date1, "1", new ArrayList<>(Arrays.asList(t1, t2, t6)), new ArrayList<>());
    public Course c4 = new Course("Intoduction to Object Oriented Programming", "Java and C# Streams", "Mandatory", start_date1, end_date1, "1", new ArrayList<>(Arrays.asList(t1, t2, t10)), new ArrayList<>());
    public Course c5 = new Course("C# Fundamentals", "C# Stream", "Mandatory", start_date1, end_date1, "1", new ArrayList<>(Arrays.asList(t8, t19)), new ArrayList<>());
    public Course c6 = new Course("Javascript", "Java and C# Streams", "Optional", start_date1, end_date1, "1", new ArrayList<>(Arrays.asList(t19, t20)), new ArrayList<>());
    public Course c7 = new Course("Web 1", "Java and C# Streams", "Mandatory", start_date1, end_date1, "1", new ArrayList<>(Arrays.asList(t3, t16, t18)), new ArrayList<>());
    public Course c8 = new Course("Introduction to Artificial Intelligence", "Java and C# Streams", "Optional", start_date2, end_date2, "2", new ArrayList<>(Arrays.asList(t7)), new ArrayList<>());
    public Course c9 = new Course("Software and Computing", "Java and C# Streams", "Mandatory", start_date2, end_date2, "2", new ArrayList<>(Arrays.asList(t11, t13, t17)), new ArrayList<>());
    public Course c10 = new Course("Java", "Java Stream", "Mandatory", start_date2, end_date2, "2", new ArrayList<>(Arrays.asList(t6)), new ArrayList<>());
    public Course c11 = new Course("C#", "C# Stream", "Mandatory", start_date2, end_date2, "2", new ArrayList<>(Arrays.asList(t8, t19)), new ArrayList<>());
    public Course c12 = new Course("Web 2", "Java and C# Streams", "Mandatory", start_date2, end_date2, "2", new ArrayList<>(Arrays.asList(t15, t13, t12)), new ArrayList<>());
    public Course c13 = new Course("Apples", "Java and C# Streams", "Optional", start_date2, end_date2, "2", new ArrayList<>(Arrays.asList(t14)), new ArrayList<>());
    public Course c14 = new Course("Operating Systems", "Java and C# Streams", "Optional", start_date2, end_date2, "2", new ArrayList<>(Arrays.asList(t4, t16, t18)), new ArrayList<>());

    public String[] rand_fnames = {"Marie", "Albert", "Salvador", "Vincent", "Stephen", "Leonardo", "Alfred", "Andy", "Johan", "Edgar Alan", "William", "Frida", "Sigmund", "Constantine", "Sebastian", "Ernest", "Ammadeus", "Oscar", "Pablo", "Ludwig Van", "Michael", "Elvis", "Francis Ford", "Nina", "Scottie", "Edith", "Karl", "Mahatma", "Diego Armando", "Quentin", "Lars Von", "John", "Bob", "Lionel", "Charles", "Isaac", "Galileo", "Nicola", "Louis"};
    public String[] rand_snames = {"Dali", "Hawking", "Einstein", "Van Gogh", "Mozart", "Bach", "Beethoven", "Curie", "Hitchcock", "Warhol", "Kahlo", "Baudelaire", "Nerouda", "Shakespeare", "Bukowski", "Poe", "Kavafy", "Freud", "Hemingway", "Picasso", "Wild", "Da Vinci", "Copola", "Simone", "Jordan", "Schumacher", "Piaf", "Dickens", "Marx", "Marley", "Gandhi", "Lennon", "Tarantino", "Trier", "Messi", "Maradona", "Jackson", "Dylan", "Prisley", "Darwin", "Newton", "Galilei", "Tesla", "Pasteur", "Amstrong",};

    public ArrayList<Trainer> trainers = new ArrayList<Trainer>(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20));
    public ArrayList<Course> courses = new ArrayList<Course>(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14));
    public ArrayList<Course> opt_courses = new ArrayList<Course>(Arrays.asList(c6, c8, c13, c14));
    public ArrayList<Student> students = new ArrayList<>();
    ArrayList<Assignment> assignments = new ArrayList<>();
}
