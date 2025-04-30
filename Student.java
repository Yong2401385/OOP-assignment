// Rowan Yee Xiao Peng
// DSF Y1S3

import java.util.Arrays;

public class Student extends Person {
    private String studentID;
    private int yearOfStudy;
    private Course[] courseList;
    private Programme programme;
    private Result result;
    private Exam[] examList;

    // constructor
    public Student(String name, String email, String contactNo, String studentID, int yearOfStudy, Course[] courseList, Programme programme, Result result, Exam[] examList) {
        super(name, email, contactNo);
        this.studentID = studentID;
        this.yearOfStudy = yearOfStudy;
        this.courseList = courseList != null ? Arrays.copyOf(courseList, courseList.length) : new Course[0];
        this.programme = programme;
        this.result = result;
        this.examList = examList != null ? Arrays.copyOf(examList, examList.length) : new Exam[0];
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

    public void setResult(Result result) {
        this.result = result;
    }

    public void setExamList(Exam[] examList) {
        this.examList = Arrays.copyOf(examList, examList.length);
    }

    // getters
    public String getStudentID() {
        return studentID;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public Course[] getCourseList() {
        return Arrays.copyOf(courseList, courseList.length);
    }

    public Programme getProgramme() {
        return programme;
    }

    public Result getResult() {
        return result;
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
    
    // tostring
    public String toString() {
        return super.toString() +
               "\nStudentID: " + studentID +
               "\nYear: " + yearOfStudy +
               "\nProgramme: " + (programme != null ? programme.getProgrammeID() : "None") +
               "\nCourses: " + Arrays.toString(courseList) +
               "\nResult: " + (result != null ? result.toString() : "No result");
    }
    
    // equals
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return this.studentID != null && this.studentID.equals(other.studentID);
    }
}
