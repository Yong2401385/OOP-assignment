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
		this.associatedLecturer = (associatedLecturer != null) ? associatedLecturer : new Lecturer[5];
		this.programmeList = (programmeList != null) ? programmeList : new Programme[5];
	}
	
	//setter
	public void setDepartmentID(String departmentID){
		this.departmentID = departmentID;
	}
	public void setDepartmentName(String departmentName){
		this.departmentName = departmentName;
	}
	public void setAssociatedLecturer(Lecturer[] associatedLecturer){
		this.associatedLecturer = associatedLecturer;
	}
	public void setProgrammeList(Programme[] programmeList){
		this.programmeList = programmeList;
	}
	//getter
	public String getDepartmentID(){
		return departmentID;
	}
	public String getDepartmentName(){
		return departmentName;
	}
	public Lecturer[] getAssociatedLecturer(){
		return Arrays.copyOf(associatedLecturer, associatedLecturer.length);
	}
	public Programme[] getProgrammeList(){
		return Arrays.copyOf(programmeList, programmeList.length);
	}
	
	// Helper methods
	public boolean addLecturer(Lecturer lecturer){
		for (int i = 0; i < associatedLecturer.length; i++){
			if (associatedLecturer[i] == null){
				associatedLecturer[i] = lecturer;
				return true;
			}
		}
		return false;
	}
	
	public boolean addProgramme(Programme programme){
		for (int i = 0; i < programmeList.length; i++){
			if (programmeList[i] == null){
				programmeList[i] = programme;
				return true;
			}
		}
		return false;
	}
	
	//toString
	public String toString(){
		return "DepartmentID: " + departmentID
				+ "\nDepartmentName: " + departmentName
				+ "\nAssociated Lecturer: " + Arrays.toString(associatedLecturer)
				+ "\nProgramme List: " + Arrays.toString(programmeList);
	}
}