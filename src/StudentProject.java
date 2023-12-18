import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    class Student {
    String firstName;
    String lastName;
    int registration;
    int grade;
    int year;


    public void printFullName() {
        System.out.println(firstName + " " + lastName);
    }

    public boolean isApproved() {
        if(grade>=60){
            return true;
        }
        else
        {
            return false;
        }
    }

    public int changeYearIfApproved() {
        if (isApproved()) {
            year++;
            System.out.println("Congratulations!");
        }
        return year;
    }

        public Student(String firstName, String lastName, int registration, int grade, int year) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.registration = registration;
            this.grade = grade;
            this.year = year;
        }

        public Student(String firstName, String lastName, int registration) {
            this(firstName, lastName, registration, 0, 1);
        }

        public Student(String firstName, String lastName) {
            this(firstName, lastName, 0, 0, 1);
        }
}
class Course {
    String courseName;
    String professorName;
    int year;
    List<Student> enrolledStudents;


    public Course(String courseName, String professorName, int year) {
        this.courseName = courseName;
        this.professorName = professorName;
        this.year = year;
        this.enrolledStudents = new ArrayList<>();
    }


    public void enroll(Student student) {
        enrolledStudents.add(student);
    }

    public void enroll(List<Student> students) {
        enrolledStudents.addAll(students);
    }

    public void unEnroll(Student student) {
        for (Student enrolledStudent : enrolledStudents) {
            if (enrolledStudent.registration == student.registration) {
                enrolledStudents.remove(enrolledStudent);
                break;
            }
        }
    }

    public int countStudents() {
        return enrolledStudents.size();
    }

    public int bestGrade() {
        int maxGrade = 0;
        for (Student student : enrolledStudents) {
            maxGrade = Math.max(maxGrade, student.grade);
        }
        return maxGrade;
    }
}

public class StudentProject {
    public static void main(String[] args) {

        Student s1 = new Student("Supriya", "Raj", 1, 70, 1);
        Student s2 = new Student("Sonali", "Singh", 2, 85, 1);
        Student s3 = new Student("Nikita", "Prasad", 3, 95, 1);

        Course c1 = new Course("Java Programming", "Prof. Tiwari", 2023);


        c1.enroll(s1);
        c1.enroll(s2);


        System.out.println("Number of students: " + c1.countStudents());
        System.out.println("Best grade in the course: " + c1.bestGrade());


        List<Student> studentList = Arrays.asList(s3);
        c1.enroll(studentList);


        System.out.println("Number of students after enrolling a list: " + c1.countStudents());
        System.out.println("Best grade in the course after enrolling a list: " + c1.bestGrade());
    }
}