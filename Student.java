// Rowan Yee Xiao Peng
// DSF Y1S3

import java.util.Arrays;

public class Student extends Person {
    private String studentID;
    private int yearOfStudy;
    private Course[] courseList;
    private Programme programme;
    private Result[] result;
    private Exam[] examList;
    private double GPA;
    private double CGPA = 0;

    // constructor
    public Student(){
    	this("", "", "", "", 0, new Course[5], new Programme(), new Result[5], new Exam[5]);
    }
    public Student(String name, String email, String contactNo, String studentID, int yearOfStudy, Course[] courseList, Programme programme, Result[] result, Exam[] examList) {
        super(name, email, contactNo);
        this.studentID = studentID;
        this.yearOfStudy = yearOfStudy;
        this.courseList = courseList != null ? Arrays.copyOf(courseList, courseList.length) : new Course[0];
        this.programme = programme;
        this.result = result;
        this.result = result != null ? Arrays.copyOf(result, result.length) : new Result[0];
        this.examList = examList != null ? Arrays.copyOf(examList, examList.length) : new Exam[0];
        calcGPA(result);
        this.CGPA += GPA;
    }

    // setters
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setCourseList(Course[] courseList) {
        this.courseList = Arrays.copyOf(courseList, courseList.length);
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public void setResult(Result[] result) {
        this.result = Arrays.copyOf(result, result.length);
    }

    public void setExamList(Exam[] examList) {
        this.examList = Arrays.copyOf(examList, examList.length);
    }
    public void setGPA(double GPA){
    	this.GPA = GPA;
    }
    public void setCGPA(double CGPA){
    	this.CGPA = CGPA;
    }

    // getters
    public String getStudentID() {
        return this.studentID;
    }

    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    public Course[] getCourseList() {
        return Arrays.copyOf(courseList, courseList.length);
    }

    public Programme getProgramme() {
        return this.programme;
    }

    public Result[] getResult() {
        return Arrays.copyOf(result, result.length);
    }
    public double getGPA(){
    	return this.GPA;
    }
    public double getCGPA(){
    	return this.CGPA;
    }

    public Exam[] getExamList() {
        return Arrays.copyOf(examList, examList.length);
    }

    // register course
    public void registerCourse(Course course) {
        if (course == null) return;

        for (Course c : courseList) {
            if (c != null && c.getCourseID().equals(course.getCourseID())) {
                return;
            }
        }

        Course[] newList = Arrays.copyOf(courseList, courseList.length + 1);
        newList[newList.length - 1] = course;
        courseList = newList;
    }
    
    // unregister course
    public void unregisterCourse(Course course) {
        if (course == null) return;

        courseList = Arrays.stream(courseList)
                           .filter(c -> c != null && !c.getCourseID().equals(course.getCourseID()))
                           .toArray(Course[]::new);
    }
    
    //calcGPA
    public void calcGPA(Result[] result){
    	double total = 0;
    	String grade;
    	for(Result res: result){
    		if(res != null){
    		grade = res.getGrade();
    		if(grade == "A+" || grade == "A") total += 4.0;
    		else if(grade == "A-") total += 3.67;
    		else if(grade == "B") total += 3.0;
    		else if(grade == "C") total += 2.0;
    		else total += 0.0;
    		}
    	}
    	double length = result.length;
    	if(length == 0){
    		this.GPA = 0.0;
    	}
    	this.GPA = total/length;
    }
    
    @Override
    // tostring
    public String toString() {
        return super.toString() +
               "\nStudentID: " + this.studentID +
               "\nYear: " + this.yearOfStudy +
               "\nProgramme: " + (programme != null ? programme.getProgrammeID() : "None") +
               "\nCourses: " + Arrays.toString(courseList) +
               "\nResult:\n" + Arrays.toString(result) +
               "\nGPA: " + this.GPA +
               "\nCGPA: " + this.CGPA;
    }
    
    // equals
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return this.studentID != null && this.studentID.equals(other.studentID);
    }
}
