/**
 * @(#)Course.java
 *
 *
 * @author 
 * @version 1.00 2025/4/15
 Low Jia MIng 24SMD09939
 DSF1S3
 */


public class Course {
	private String courseID;
	private String courseName;
	private int creditHour;
	private Exam exam;
	private int batchYear;
	private static int numberOfCourses;
	//constructors
    public Course() {
    	this(" "," ",0,0,new Exam());	
    }
    public Course(String courseID, String courseName, int creditHour, int batchYear, Exam exam){
    	this.courseID = courseID;
    	this.courseName = courseName;
    	this.creditHour = creditHour;
    	this.batchYear = batchYear;
    	this.exam = exam;	 
    	numberOfCourses++;
    }
    //setters
    public void setCourseID(String courseID){
    	this.courseID = courseID;
    }
    public void setCourseName(String courseName){
    	this.courseName = courseName;
    }
    public void setCreditHour(int creditHour){
    	this.creditHour = creditHour;
    }
    public void setBatchYear(int batchYear){
    	this.batchYear = batchYear;
    }
    public void setExam(Exam exam){
    	this.exam = exam;
    }
    //getters
    public String getCourseID(){
		return courseID;
	}
	public String getCourseName(){
		return courseName;
	}
	public int getCreditHour(){
		return creditHour;
	}
    public int getBatchYear(){
		return batchYear;
	}
	public Exam getExam(){
		return exam;
	}
	public static int getNumberOfCourses(){
		return numberOfCourses;
	}
	//toString
	public String toString(){
		return "\nCourseID : " + courseID
			+ "\nCourseName : " + courseName
			+ "\nCredit Hour : " + creditHour
			+ "\nBatch Year : " + batchYear
			+ exam.toString()
			;
	}
    
}
