// Yong Hao Cheng 2401385
// DSF1S3

public class Programme {
	private String programmeID;
	private String programmeLeader;
	private int programmeDuration;
	private Course courseList;
	
	//constructors
	public Programme(){
		this(" "," ",0,new Course());
	}
	public Programme(String programmeID, String programmeLeader,
	int programmeDuration, Course courseList){
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
	public void setCourseList(Course courseList){
		this.courseList = courseList;
	}
	
	//getter
	public String ProgrammeID(){
		return programmeID;
	}
	public String ProgrammeLeader(){
		return programmeLeader;
	}
	public int ProgrammeDuration(){
		return programmeDuration;
	}
	public Course CourseList(){
		return courseList;
	}
	
	//toString
	public String toString(){
		return "ProgrammeID: " + programmeID
				+ "\nProgramme Leader: " + programmeLeader
				+ "\nProgramme Duration: " + programmeDuration
				+ "\nCourse List: " + courseList;
	}
}