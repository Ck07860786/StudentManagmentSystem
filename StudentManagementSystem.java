import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {

private String id;
private String name;
private int age;

public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        }

public String getId() {
        return id;
        }

public String getName() {
        return name;
        }

public int getAge() {
        return age;
        }
        }

class Course {
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}

class Enrollment {
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
}

public class StudentManagementSystem {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();
    private List<Enrollment> enrollments = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent(String id, String name, int age) {
        students.put(id, new Student(id, name, age));
    }

    public void addCourse(String courseId, String courseName) {
        courses.put(courseId, new Course(courseId, courseName));
    }

    public void enrollStudentInCourse(String studentId, String courseId) {
        if (students.containsKey(studentId) && courses.containsKey(courseId)) {
            Student student = students.get(studentId);
            Course course = courses.get(courseId);
            enrollments.add(new Enrollment(student, course));
            System.out.println("Enrollment successful.");
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void displayEnrollments() {
        System.out.println("Enrollments:");
        for (Enrollment enrollment : enrollments) {
            System.out.println("Student: " + enrollment.getStudent().getName() +
                    ", Course: " + enrollment.getCourse().getCourseName());
        }
    }

    public void run() {
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Display Enrollments");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.next();
                    System.out.print("Enter student name: ");
                    String studentName = scanner.next();
                    System.out.print("Enter student age: ");
                    int studentAge = scanner.nextInt();
                    addStudent(studentId, studentName, studentAge);
                    break;
                case 2:
                    System.out.print("Enter course ID: ");
                    String courseId = scanner.next();
                    System.out.print("Enter course name: ");
                    String courseName = scanner.next();
                    addCourse(courseId, courseName);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentId = scanner.next();
                    System.out.print("Enter course ID: ");
                    courseId = scanner.next();
                    enrollStudentInCourse(studentId, courseId);
                    break;
                case 4:
                    displayEnrollments();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.run();
    }
}