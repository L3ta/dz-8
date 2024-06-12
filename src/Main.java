import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String firstName;
    private String lastName;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (ID: " + id + ")";
    }
}

class StudentsGroup {
    private Student monitor;
    private List<Student> students;
    private List<String> tasks;

    public StudentsGroup(Student monitor) {
        if (monitor == null) {
            throw new IllegalArgumentException("Група не може існувати без старости.");
        }
        this.monitor = monitor;
        this.students = new ArrayList<>();
        this.tasks = new ArrayList<>();
        students.add(monitor);
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            System.out.println("Додано студента: " + student);
        }
    }

    public void removeStudent(Student student) {
        if (students.remove(student)) {
            System.out.println("Видалено студента: " + student);
        } else {
            System.out.println("Студента не знайдено: " + student);
        }
    }

    public void changeMonitor(Student newMonitor) {
        if (students.contains(newMonitor)) {
            this.monitor = newMonitor;
            System.out.println("Новий староста групи: " + newMonitor);
        } else {
            System.out.println("Новий староста має бути частиною групи.");
        }
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Додано завдання: " + task);
    }

    public void markTaskCompleted(Student student, String task) {
        if (students.contains(student)) {
            System.out.println("Завдання \"" + task + "\" виконано студентом: " + student);
        } else {
            System.out.println("Студент не знаходиться в групі: " + student);
        }
    }

    public void printStudents() {
        System.out.println("Список студентів:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Тетяна", "Година");
        Student student2 = new Student(2, "Роман", "Полончук");
        Student student3 = new Student(3, "Володимир", "Троць");

        StudentsGroup group = new StudentsGroup(student1);

        group.addStudent(student2);
        group.addStudent(student3);

        group.printStudents();

        group.addTask("Вивчити інкапсуляцію");

        group.markTaskCompleted(student2, "Вивчити інкапсуляцію");

        group.changeMonitor(student2);

        group.removeStudent(student3);

        group.printStudents();
    }
}