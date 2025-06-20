package Student_Management;

import javax.swing.*;

public class Certificate {
    private String studentName;
    private int rollNo;
    private String courseName;
    private double percentage;
    private String grade;

    public Certificate(String studentName, int rollNo, String courseName, double percentage, String grade) {
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.courseName = courseName;
        this.percentage = percentage;
        this.grade = grade;
    }

    public void generateCertificate() {
        String certificateText = "<html><body style='font-family: Arial;'>"
                + "<h2 style='color:#0A539F;'>Certificate of Completion</h2>"
                + "<p><strong>Congratulations, " + studentName + "!</strong></p>"
                + "<p>Roll No: " + rollNo + "</p>"
                + "<p>You have successfully completed the course: <b>" + courseName + "</b></p>"
                + "<p>Percentage: " + percentage + "%</p>"
                + "<p>Grade: " + grade + "</p>"
                + "<p>Date Issued: " + java.time.LocalDate.now() + "</p>"
                + "</body></html>";

        JOptionPane.showMessageDialog(null, certificateText, "Certificate", JOptionPane.INFORMATION_MESSAGE);
    }
}
