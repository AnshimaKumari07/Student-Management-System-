package Student_Management;

import javax.swing.*;
import java.awt.*;

public class mainDashboard extends JFrame {
    private Student student;
    private Course selectedCourse;
    private Exam exam;

    public mainDashboard() {
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Failed to apply Nimbus theme.");
        }

        getContentPane().setBackground(new Color(210, 230, 255));

        JLabel headingLabel = new JLabel("Student Management System", JLabel.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setForeground(new Color(0, 70, 140));
        add(headingLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 15, 15));
        buttonPanel.setBackground(new Color(230, 245, 255));

        JButton registerButton = createStyledButton("Register Student");
        JButton courseButton = createStyledButton("Select Course");
        JButton examButton = createStyledButton("Enter Exam Results");
        JButton certificateButton = createStyledButton("Generate Certificate");

        registerButton.addActionListener(e -> registerStudent());
        courseButton.addActionListener(e -> selectCourse());
        examButton.addActionListener(e -> enterExamResults());
        certificateButton.addActionListener(e -> generateCertificate());

        buttonPanel.add(registerButton);
        buttonPanel.add(courseButton);
        buttonPanel.add(examButton);
        buttonPanel.add(certificateButton);

        add(buttonPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    private JButton createStyledButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(new Color(100, 149, 237));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        return button;
    }

    private void registerStudent() {
        String name = JOptionPane.showInputDialog("Enter Student Name:");
        if (name == null || name.trim().isEmpty()) return;

        int rollNo;
        try {
            rollNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Roll Number:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Roll Number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String email = JOptionPane.showInputDialog("Enter Email:");
        if (email == null || email.trim().isEmpty()) return;

        student = new Student(1, rollNo, name, email);
        JOptionPane.showMessageDialog(this, "Student Registered Successfully!");
    }

    private void selectCourse() {
        if (student == null) {
            JOptionPane.showMessageDialog(this, "Please register a student first!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String courseName = JOptionPane.showInputDialog("Enter Course Name:");
        int duration;
        try {
            duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Duration (months):"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid duration!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        selectedCourse = new Course(101, courseName, duration);
        Course.enrollCourse(selectedCourse);
        JOptionPane.showMessageDialog(this, "Course Selected Successfully!");
    }

    private void enterExamResults() {
        if (student == null) {
            JOptionPane.showMessageDialog(this, "Please register a student first!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        exam = new Exam(student.getRollNo());

        for (int i = 1; i <= 5; i++) {
            try {
                int marks = Integer.parseInt(JOptionPane.showInputDialog("Enter marks for Subject " + i + ":"));
                exam.addMarks(marks);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter numeric marks.", "Error", JOptionPane.ERROR_MESSAGE);
                i--;
            }
        }

        exam.displayResults();
    }

    private void generateCertificate() {
        if (student != null && selectedCourse != null && exam != null) {
            Certificate cert = new Certificate(
                    student.getName(),
                    student.getRollNo(),
                    selectedCourse.getCourseName(),
                    exam.getPercentage(),
                    exam.getGrade()
            );
            cert.generateCertificate();
        } else {
            JOptionPane.showMessageDialog(this, "Ensure student registration, course, and exam details are filled first.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(mainDashboard::new);
    }
}
