// Rowan Yee Xiao Peng
// DSF Y1S3

import java.util.Arrays;

public class Result {
    private String resultID;
    private Course course;
    private double mark;
    private String grade;
    //private double totalMark;

    // constructor
    public Result(String resultID, Course course, double mark) {
        this.resultID = resultID;
        this.course = course;
        this.mark = mark;
		this.grade = calcGrade(mark);
    }

    // setters
    public void setResultID(String resultID) {
        this.resultID = resultID;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setMark(double mark) {
        this.mark = mark;;
       	this.grade = calcGrade(mark);
    }

    // getters
    public String getResultID() {
        return resultID;
    }

    public Course getCourse() {
        return this.course;
    }

    public double getMarks() {
        return this.mark;
    }
    public String getGrade(){
    	return this.grade;
    }
    
    // calculation methods
    public String calcGrade(double mark) {
    	String grade = "";
        if(mark >= 90) grade = "A+";
        else if(mark >= 80) grade = "A";
        else if(mark >= 70) grade = "A-";
        else if(mark >= 60) grade = "B";
        else if(mark >= 50) grade = "C";
        else grade = "F";
        return grade;
    }
    
    // tostring
    public String toString() {
        return "\nResultID: " + resultID +
        	   "\n" + course.getCourseID() + " " + course.getCourseName() + ": " + mark + "%";
    }
}
