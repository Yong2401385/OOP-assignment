// Rowan Yee Xiao Peng
// DSF Y1S3

import java.util.Arrays;

public class Result {
    private String resultID;
    private Course[] courseList;
    private double[] marks;
    private double totalMark;
    private double GPA;
    private double CGPA;

    // constructor
    public Result(String resultID, Course[] courseList, double[] marks) {
        this.resultID = resultID;
        this.courseList = courseList != null ? Arrays.copyOf(courseList, courseList.length) : new Course[0];
        this.marks = marks != null ? Arrays.copyOf(marks, marks.length) : new double[0];
        calcTotalMark();
        calcGPA();
        this.CGPA = GPA;
    }

    // setters
    public void setResultID(String resultID) {
        this.resultID = resultID;
    }

    public void setCourseList(Course[] courseList) {
        this.courseList = Arrays.copyOf(courseList, courseList.length);
        calcTotalMark();
        calcGPA();
    }

    public void setMarks(double[] marks) {
        this.marks = Arrays.copyOf(marks, marks.length);
        calcTotalMark();
        calcGPA();
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    // getters
    public String getResultID() {
        return resultID;
    }

    public Course[] getCourseList() {
        return Arrays.copyOf(courseList, courseList.length);
    }

    public double[] getMarks() {
        return Arrays.copyOf(marks, marks.length);
    }

    public double getTotalMark() {
        return totalMark;
    }

    public double getGPA() {
        return GPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    // calculation methods
    private void calcTotalMark() {
        double sum = 0;
        for (double m : marks) sum += m;
        this.totalMark = sum;
    }

    private void calcGPA() {
        if (marks.length == 0) {
            this.GPA = 0;
            return;
        }
        double average = totalMark / marks.length;
        if (average >= 85) GPA = 4.0;
        else if (average >= 75) GPA = 3.5;
        else if (average >= 65) GPA = 3.0;
        else if (average >= 50) GPA = 2.0;
        else GPA = 1.0;
    }
    
    // tostring
    public String toString() {
        return "ResultID: " + resultID +
               "\nTotalMark: " + totalMark +
               "\nGPA: " + GPA +
               "\nCGPA: " + CGPA;
    }
}
