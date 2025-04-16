// Yong Hao Cheng 2401385
// DSF1S3

public class Department {
	private String departmentID;
	private String departmentName;
	private Lecturer associatedLecturer;
	private Programme programmeList;
	
	//constructors
	public Department(){
		this(" "," ",new Lecturer(),new Programme());
	}
	public Department(String departmentID, String departmentName,
	Lecturer associatedLecturer, Programme programmeList){
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
	public void setAssociatedLecture(Lecturer associatedLecturer){
		this.associatedLecturer = associatedLecturer;
	}
	public void setProgrammeList(Programme programmeList){
		this.programmeList = programmeList;
	}
	//getter
	public String DepartmentID(){
		return departmentID;
	}
	public String DepartmentName(){
		return departmentName;
	}
	public Lecturer AssociatedLecturer(){
		return associatedLecturer;
	}
	public Programme ProgrammeList(){
		return programmeList;
	}
	
	//toString
	public String toString(){
		return "DepartmentID: " + departmentID
				+ "\nDepartmentName: " + departmentName
				+ "\nAssociated Lecturer: " + associatedLecturer
				+ "\nProgramme List: " + programmeList;
	}
	
}