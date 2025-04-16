// Yong Hao Cheng 2401385
// DSF1S3

import java.util.Arrays;

public class Department {
	private String departmentID;
	private String departmentName;
	private Lecturer[] associatedLecturer = new Lecturer[5];
	private Programme[] programmeList = new Programme[5];
	
	//constructors
	public Department(){
		this(" "," ",new Lecturer[5],new Programme[5]);
	}
	public Department(String departmentID, String departmentName,
	Lecturer[] associatedLecturer, Programme[] programmeList){
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.associatedLecturer = associatedLecturer;
		this.programmeList = programmeList;
	}
	
	//setter
	public void setDepartmentID(String departmentID){
		this.departmentID = departmentID;
	}
	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}
	public void setAssociatedLecture(Lecturer[] associatedLecturer){
		this.associatedLecturer = associatedLecturer;
	}
	public void setProgrammeList(Programme[] programmeList){
		this.programmeList = programmeList;
	}
	//getter
	public String DepartmentID(){
		return departmentID;
	}
	public String DepartmentName(){
		return departmentName;
	}
	public Lecturer[] AssociatedLecturer(){
		return associatedLecturer;
	}
	public Programme[] ProgrammeList(){
		return programmeList;
	}
	
	//toString
	public String toString(){
		return "DepartmentID: " + departmentID
				+ "\nDepartmentName: " + departmentName
				+ "\nAssociated Lecturer: " + Arrays.toString(associatedLecturer)
				+ "\nProgramme List: " + Arrays.toString(programmeList);
	}
	
}