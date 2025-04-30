// Yong Hao Cheng 2401385
// DSF1S3

import java.util.Arrays;

public class Programme {
	private String programmeID;
	private String programmeLeader;
	private int programmeDuration;
	private Course[] courseList;
	private static int courseCount; // Track number of courses added
	
	// constructors
	public Programme(){
		this(" "," ",0);
	}
	
	public Programme(String programmeID, String programmeLeader,int programmeDuration){
		this.programmeID = programmeID;
		this.programmeLeader = programmeLeader;
		this.programmeDuration = programmeDuration;
		this.courseList = new Course[15];
		this.courseCount = 0;
	}
	
	// setter
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
		if (courseList != null){
			this.courseList = Arrays.copyOf(courseList, Math.min(courseList.length, 15));
			this.courseCount = countCourses();
		}
		
	}
	
	// getter
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
		return Arrays.copyOf(courseList, courseList.length);
	}
	
	// Helper method to count non-null courses
	private int countCourses(){
		int count = 0;
		for (Course course : courseList){
			if (course != null){
				count++;
			}
		}
		return count;
	}
	
	// Add Course
	public boolean addCourse(Course course){
		if (course == null || courseCount >= courseList.length){
			return false; // cannot add course
		}
		
		courseList[courseCount++] = course;
		return true;
	}
	
	// toString
	public String toString(){
		return "ProgrammeID: " + programmeID 
				+ "\nProgramme Leader: " + programmeLeader
				+ "\nProgramme Duration: " + programmeDuration
				+ "\nCourse List: " + Arrays.toString(courseList);
	}
}
