// Rowan Yee Xiao Peng
// DSF Y1S3

public class Student {
	private String studentID;
    private int yearOfStudy;
    private Course[] courseList;
    private Programme programme;
    private Result result;
    private Exam[] examList;
    
    // constructor
    public Student(String studentID, int yearOfStudy, Course[] courseList, Programme programme, Result result, Exam[] examList) {
    	this.studentID = studentID;
        this.yearOfStudy = yearOfStudy;
        this.courseList = courseList;
        this.programme = programme;
        this.result = result;
        this.examList = examList;
    }
    
    // setter
    public void setStudentID(String studentID) {
    	this.studentID = studentID;
    	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
		}
	public void setCourseList(Course[] courseList) {
		this.courseList = courseList;
		}
	public void setProgramme(Programme programme) {
		this.programme = programme;
		}
	public void setResult(Result result) {
		this.result = result;
		}
	public void setExamList(Exam[] examList) {
		this.examList = examList;
		}
    
    // getter
    public String getStudentID() {
    	return studentID; 
    	}
    public int getYearOfStudy() {
    	return yearOfStudy;
    	}
    public Course[] getCourseList() {
    	return courseList;
    	}
    public Programme getProgramme() {
    	return programme;
    	}
    public Result getResult() {
    	return result;
    	}
    public Exam[] getExamList() {
    	return examList;
    	}
    
    public void registerCourse(Course courseID) {
    }

    public void unregisterCourse(Course courseID) {
    }

    @Override
    public String toString() {
        return "StudentID: " + studentID + ", Year: " + yearOfStudy + ", Programme: " + programme.getProgrammeID();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return this.studentID.equals(other.studentID);
    }
}
