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
		this("", "", "", "", new Course[3], new Exam[3]);
			}
	
	//constructor with 3-arguments
	public Lecturer(String name, String email, String contactNo, String lecturerID, Course [] courseTaught, Exam [] examMarked){
		super(name, email, contactNo);
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
	
	//addCourse
	public void addCourse(Course courseID){
		for(int i = 0; i < courseTaught.length; i++){
			if(courseTaught[i] == null)
				this.courseTaught[i] = courseID;
				break;	
		}
	}
	
	//toString
	@Override
		public String toString(){
			return 	super.toString() 
				+	"\nLecturer ID \t: " + this.lecturerID
				+	"\nCourse taught \t: " + this.courseTaught[0].getCourseID() + ", " + this.courseTaught[1].getCourseID() + ", " + this.courseTaught[2].getCourseID()
				+	"\nExam marked \t: " + this.examMarked[0].getExamID() + ", " + this.examMarked[1].getExamID() + ", " + this.examMarked[2].getExamID()
				+ 	"\nNumber of lecturers: " + Lecturer.noOfLecturer;
		}
	
	//equals
	@Override
		public boolean equals(Object obj){
			if(this == obj)
				return true;
			if(obj == null || getClass() != obj.getClass()) 
				return false;
			Lecturer other = (Lecturer) obj;
			return lecturerID != null && lecturerID.equals(other.lecturerID);
		}
}