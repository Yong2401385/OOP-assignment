// Yong Hao Cheng 2401385
// DSF1S3

import java.util.Arrays;

public class Programme {
	private String programmeID;
	private String programmeLeader;
	private int programmeDuration;
	private Course[] courseList = new Course[15];
	
	//constructors
	public Programme(){
		this(" "," ",0,new Course[15]);
	}
	public Programme(String programmeID, String programmeLeader,
	int programmeDuration, Course[] courseList){
		this.programmeID = programmeID;
		this.programmeLeader = programmeLeader;
		this.programmeDuration = programmeDuration;
		this.courseList = courseList;
	}
	
	//setter
	public void setProgrammeID(String programmeID){
		this.programmeID = programmeID;
	}
	public void setProgrammeLeader(String programmeLeader){
		this.programmeLeader = programmeLeader;
	}
	public void setProgrammeDuration(int programmeDuration){
		this.programmeDuration = programmeDuration;
	}
	public void setCourseList(Course[] courseList){
		this.courseList = courseList;
	}
	
	//getter
	public String getProgrammeID(){
		return programmeID;
	}
	public String getProgrammeLeader(){
		return programmeLeader;
	}
	public int getProgrammeDuration(){
		return programmeDuration;
	}
	public Course[] getCourseList(){
		return courseList;
	}
	
	//addCourse
	public void addCourse(Course course){
		for(int i = 0; i < courseList.length; i++){
			if(courseList[i] == null){
				this.courseList[i] = course;
				break;
			}
		}
	}
	
	//toString
	public String toString(){
		return "ProgrammeID: " + programmeID 
				+ "\nProgramme Leader: " + programmeLeader
				+ "\nProgramme Duration: " + programmeDuration
				+ "\nCourse List: " + Arrays.toString(courseList);
	}
}