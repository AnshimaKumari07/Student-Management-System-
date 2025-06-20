package Student_Management;

public class Student {
    private int id;
    private int rollNo;
    private String name;
    private String email;

    // Constructor
    public Student(int id, int rollNo, String name, String email) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
    }

    // Getter methods
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Display student info (for CLI/debug)
    public void displayStudentInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
