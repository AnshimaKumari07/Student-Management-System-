package Student_Management;

import java.util.ArrayList;

public class Course {
    private int courseId;
    private String courseName;
    private int duration; // in months
    private static ArrayList<Course> selectedCourses = new ArrayList<>();

    public Course(int courseId, String courseName, int duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayCourseInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
    }

    public static void enrollCourse(Course course) {
        selectedCourses.add(course);
        System.out.println(course.courseName + " has been added to your course list.");
    }

    public static void displayEnrolledCourses() {
        System.out.println("\nEnrolled Courses:");
        for (Course course : selectedCourses) {
            course.displayCourseInfo();
        }
    }
}
