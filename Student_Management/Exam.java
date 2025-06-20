package Student_Management;

import java.util.ArrayList;

public class Exam {
    private int studentRollNo;
    private ArrayList<Integer> marks = new ArrayList<>();
    private static final int SUBJECT_COUNT = 5;

    public Exam(int studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public void addMarks(int mark) {
        if (marks.size() < SUBJECT_COUNT) {
            marks.add(mark);
        } else {
            System.out.println("Marks for all subjects already entered.");
        }
    }

    public int getTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double getPercentage() {
        return (double) getTotalMarks() / SUBJECT_COUNT;
    }

    public String getGrade() {
        double percent = getPercentage();
        if (percent >= 90) return "Outstanding";
        if (percent >= 80) return "Excellent";
        if (percent >= 70) return "Very Good";
        if (percent >= 60) return "Good";
        if (percent >= 50) return "Pass";
        return "Needs Improvement";
    }

    public void displayResults() {
        System.out.println("Exam Results for Roll No: " + studentRollNo);
        for (int i = 0; i < marks.size(); i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks.get(i) + " marks");
        }
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Percentage: " + getPercentage() + "%");
        System.out.println("Grade: " + getGrade());
    }
}
