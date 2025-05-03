// Rowan Yee Xiao Peng
// DSF Y1S3

import java.util.Arrays;

public class Result {
    private Course course;
    private double mark;
    private String grade;
    //private double totalMark;

    // constructor
    public Result(Course course, double mark) {
        this.course = course;
        this.mark = mark;
		grade = calcGrade(mark);
    }

    // setters
    public void setCourse(Course course) {
        this.course = course;
    }

    public void setMark(double mark) {
        this.mark = mark;
       	this.grade = calcGrade(mark);
    }

    // getters
    public Course getCourse() {
        return this.course;
    }

    public double getMark() {
        return this.mark;
    }
    public String getGrade(){
    	return this.grade;
    }
    
    // calculation methods
    public String calcGrade(double mark) {
        if(mark >= 90) return "A+";
        else if(mark >= 80) return "A";
        else if(mark >= 70) return "A-";
        else if(mark >= 60) return "B";
        else if(mark >= 50) return "C";
        else return "F";
    }
    
    // tostring
    public String toString() {
        return "\n" + course.getCourseID() + " " + course.getCourseName() + ": " + mark + "%";
    }
}
