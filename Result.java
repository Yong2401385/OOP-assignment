// Rowan Yee Xiao Peng
// DSF Y1S3

import java.util.Arrays;

public class Result {
	private String resultID;
	private Course[] courseList;
	private double[] marks;
	private char grade;
	private double totalMark;
	private double GPA;
	private double CGPA;
	
	// contructor
	public Result(String resultID, Course[] courseList, double[] marks) {
		this.resultID = resultID;
        this.courseList = courseList;
        this.marks = marks;
	}
	
	// setter
	public void setResultID(String resultID) {
		this.resultID = resultID;
		}
	public void setCourseList(Course[] courseList) {
		this.courseList = courseList;
		}
	public void setMarks(double[] marks) {
		this.marks = marks;
		}
	public void setGrade(char grade) {
		this.grade = grade;
		}
	
	// getter
	public String getResultID() {
		return resultID;
		}
    public Course[] getCourseList() {
    	return courseList;
    	}
    public double[] getMarks() {
    	return marks;
    	}
    public char getGrade() {
    	return grade;
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
    	
    // calculation
    public void calcTotalMark(double[] marks) {
        double sum = 0;
        for (double m : marks) sum += m;
        this.totalMark = sum;
    }
    
    public void calcGPA(double GPA) {
        this.GPA = GPA;
    }

    public void calcCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
    
    @Override
    public String toString() {
        return "ResultID: " + resultID + ", TotalMark: " + totalMark + ", GPA: " + GPA + ", CGPA: " + CGPA;
    }
}