/*Vincent Chiew Jia Cheng 2402394
 *DSF Y1S3*/

import java.util.Arrays;

public class Lecturer extends Person{
	//data fields
	private String lecturerID;
	private Course [] courseTaught = new Course[3];
	private Exam [] examMarked = new Exam[3];
	private static int noOfLecturer =0;
	//no-arg constructor
	public Lecturer(){
		this("", {"","",""}, {"","",""});
			}
	
	//constructor with 3-arguments
	public Lecturer(String lecturerID, Course [] courseTaught, Exam [] examMarked){
		this.lecturerID = lecturerID;
		System.arraycopy(courseTaught, 0, this.courseTaught, 0, 3);
		System.arraycopy(examMarked, 0, this.examMarked, 0, 3);
		Lecturer.noOfLecturer++;
	}
	
	//getters 
	public String getLecturerID(){
		return this.lecturerID;
	}
	public String getLecturerName(){
		return super.getName();
	}
	public String getLecturerEmail(){
		return super.getEmail();
	}
	public Course[] getCourseTaught(){
		return this.courseTaught;
	}
	public Exam[] getExamMarked(){
		return this.examMarked;
	}
	public int getNoOfLecturer(){
		return Lecturer.noOfLecturer;
	}
	
	//addCourseTaught
	public void addCourseTaught(Course courseID){
		for(int i = 0; i < courseTaught.length; i++){
			if(courseTaught[i] == null)
				this.courseTaught[i] = courseID;	
		}
	}
	
	//toString
	public String toString(){
		return 	super.toString() 
			+	"\nLecturer ID \t: " + this.lecturerID
			+	"\nCourse taught \t: " + Arrays.toString(this.getCourseTaught())
			+	"\nExam marked \t: " + Arrays.toString(this.getExamMarked());
	}
}