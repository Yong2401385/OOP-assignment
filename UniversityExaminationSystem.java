/*Vincent Chiew Jia Cheng 2402394
 *DSF Y1S3*/
//student view result
//main driver program

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class UniversityExaminationSystem{
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
		int choice = 0;
		boolean end = false;
		Exam[] examArr = new Exam [10];
		//no need argument of end time because system will calculate start time + duration
		examArr[0] = new Exam("E1","2020-02-11", "09:00", 2, "D1 Hall");
		examArr[1] = new Exam("E2","2020-02-12", "09:00", 2, "D1 Hall");
		examArr[2] = new Exam("E3","2020-02-13", "09:00", 2, "D1 Hall");
		examArr[3] = new Exam("E4","2020-01-01", "09:00", 2, "Futsal Court");
		examArr[4] = new Exam("E5","2020-02-13", "14:00", 2, "D1 Hall");
		
		Course[] courArr = new Course [10];
		courArr[0] = new Course("C1", "Problem Solving and Programming", 3, 1, examArr[0]);
		courArr[1] = new Course("C2", "Software Engineering", 4, 1, examArr[1]);
		courArr[2] = new Course("C3", "Calculus and Algebra", 3, 1, examArr[2]);
		courArr[3] = new Course("C4", "Software Requirement and Design", 2, 1, examArr[2]);
		courArr[4] = new Course("C5", "Object Oriented Programming", 4, 1, examArr[4]);
		courArr[5] = new Course("K1", "Karate Do", 1, 1, examArr[3]);
		courArr[6] = new Course("K2", "Tae Kwon Do", 1, 1, examArr[3]);

		Programme p1 = new Programme("DSF", "Dr. Lee Ming", 2);
		Programme p2 = new Programme("DFT", "Prof. Sarah Wong", 2);
		p1.addCourse(courArr[0]);
		p1.addCourse(courArr[1]);
		p1.addCourse(courArr[2]);
		p1.addCourse(courArr[3]);
		p1.addCourse(courArr[4]);
		p1.addCourse(courArr[5]);
		p2.addCourse(courArr[0]);
		p2.addCourse(courArr[1]);
		p2.addCourse(courArr[2]);
		p2.addCourse(courArr[3]);
		p2.addCourse(courArr[4]);
		p2.addCourse(courArr[5]);
		
		Programme[] progArr = new Programme[10];
		progArr[0] = p1;
		progArr[1] = p2;
		
		Result r1 = new Result("R1", courArr[0], 100.00);
		Result r2 = new Result("R2", courArr[1], 90.00);
		Result r3 = new Result("R3", courArr[2], 80.00);
		Result r4 = new Result("R4", courArr[3], 70.00);
		Result r5 = new Result("R5", courArr[4], 60.00);
		Result r6 = new Result("R6", courArr[4], 75.00);
		Result r7 = new Result("R7", courArr[4], 90.00);
		Result r8 = new Result("R8", courArr[5], 100.00);

		Lecturer[] lectArr = new Lecturer[10];
		lectArr[0] = new Lecturer("Dr. Lee Ming", "leeming@lecturer.tarc.edu.my", "012345678", "0001", new Course[] {courArr[4]}, new Exam[] {examArr[0], examArr[1], examArr[2]});
		lectArr[1] = new Lecturer("Prof. Sarah Wong", "sarahwong@lecturer.tarc.edu.my", "0112304506", "0002", new Course[] {courArr[1]}, new Exam[] {examArr[0], examArr[1], examArr[2]});
		lectArr[2] = new Lecturer("Dr. Tan Cheng", "tancheng@lecturer.tarc.edu.my", "012345678", "0003", new Course[] {courArr[0], courArr[3]}, new Exam[] {examArr[0], examArr[1], examArr[2]});
		
		Department d1 = new Department("DCIT", "Department of Computing And Information Technology", new Lecturer[] {lectArr[0], lectArr[1], lectArr[2]}, new Programme[] {p1, p2});
		
		Student[] studArr = new Student[10];
		studArr[0] = new Student("Alvin Chin", "alvinchin@student.tarc.edu.my", "011234567", "2400001", 1, new Course[] {courArr[0], courArr[1], courArr[2]}, p1,new Result[] {r1, r2, r3}, new Exam[] {examArr[0], examArr[1], examArr[2]});
		studArr[1] = new Student("Ben Lim", "benlim@student.tarc.edu.my", "019345678", "2400002", 1, new Course[] {courArr[0], courArr[1], courArr[2]}, p2,new Result[] {r1, r2, r3}, new Exam[] {examArr[0], examArr[1], examArr[2]});
		studArr[2] = new Student("Carl Chan", "carlchan@student.tarc.edu.my", "018234567", "2400003", 1, new Course[] {courArr[0], courArr[1], courArr[2]}, p1,new Result[] {r1, r2, r3}, new Exam[] {examArr[0], examArr[1], examArr[2]});
		studArr[3] = new Student("David Ling", "davidling@student.tarc.edu.my", "017234567", "2400004", 1, new Course[] {courArr[3], courArr[4], courArr[5]}, p2,new Result[] {r4,r5,r8}, new Exam[] {examArr[0], examArr[4], examArr[2]});
		studArr[4] = new Student("John Doe", "johndoe@student.tarc.edu.my", "016234567", "2400005", 1, new Course[] {courArr[3], courArr[4], courArr[5]}, p2,new Result[] {r4,r6,r8}, new Exam[] {examArr[0], examArr[4], examArr[2]});
		studArr[5] = new Student("Jane Smith", "janesmith@student.tarc.edu.my", "015234567", "2400006", 1, new Course[] {courArr[3], courArr[4], courArr[5]}, p2,new Result[] {r4,r7,r8}, new Exam[] {examArr[0], examArr[4], examArr[2]});
		
		do{
			System.out.println("------------------------------------------------");
			System.out.println("Welcome to TARUMT University Examination System!");
			System.out.println("1 - Lecturer \n2 - Student \n3 - Exit");
			System.out.println("------------------------------------------------");	
			System.out.println("Please choose your role:");
			choice = checkChoice();
					
			switch(choice){
				case 1:	lecturerModule(lectArr, studArr, examArr); break;
				case 2: studentModule(studArr, courArr); break;
				case 3: System.out.println("End of session"); scanner.close(); return;
			}
		}while(!end);
		
		
	}
	
	public static int checkChoice(){
		int input = 0;
		boolean continueInput = true;
		do{
			try {
				input = scanner.nextInt();	
				if(input == 1 || input == 2 ||input == 3) continueInput = false;
				else System.out.println("Invalid choice. Please ensure it is 1, 2 or 3");
			}
			catch(InputMismatchException ex){
				System.out.println("Please try again and make sure to enter a number.");
				scanner.nextLine();
			}
		}while(continueInput);
		return input;
	}
	
	public static void lecturerModule(Lecturer[] lectArr, Student[] studArr, Exam[] examArr){
		int input = 0;
		boolean continueInput = true;
		boolean again = true;
		String id = "";
		Lecturer lecturer = new Lecturer();
			do{
				try{
					System.out.println("Please enter your lecturer ID:");
					id = scanner.next();
					lecturer = findLecturer(id, lectArr);
					System.out.println("------------------------------------------------");
					System.out.println("Welcome Lecturer " + lecturer.getName() + "!");
					continueInput = false;	
				}catch(IllegalArgumentException ex){
					System.out.println("Error: " + ex.getMessage());
					System.out.println("Please try again.");
					scanner.nextLine(); //clear invalid input to avoid infinite errors
				}catch(Exception ex){
					System.out.println("Something went wrong");
				}
			}while(continueInput);
			do{
				System.out.println("1 - Check and modify student result \n2 - Schedule new exam \n3 - Return");
				System.out.println("------------------------------------------------");
				System.out.println("What would you like to do?");
				
				input = checkChoice();	
				switch(input){
					case 1: checkStudResult(lecturer, studArr); break;
					case 2: scheduleNewExam(examArr); break;
					case 3: again = false; break;
				}
			}while(again);
	}
		//helper method to find lecturer with specific id
		private static Lecturer findLecturer(String id, Lecturer[] lectArr){
		for(Lecturer lecturer: lectArr)
			if(lecturer != null && lecturer.getLecturerID().equals(id))
				return lecturer;
								
		throw new IllegalArgumentException("Lecturer Not Found");
	}	
		
	public static void checkStudResult(Lecturer lecturer, Student[] studArr){
		LecturerGrading.grade(lecturer, studArr);
	}
	
	public static void studentModule(Student[] studArr, Course[] cocuArr){
		int input = 0;
		boolean continueInput = true;
		boolean again = true;
		String id = "";	
		Student student = new Student();
		do{	
			try{
				System.out.println("Enter your student ID:");
				id = scanner.next();
				student = findStudent(id, studArr);
				System.out.println("------------------------------------------------");
				System.out.println("Welcome Student "+ student.getName() + " !");
				continueInput = false;
			} catch(IllegalArgumentException ex){
				System.out.println("Error: " + ex.getMessage());
				System.out.println("Please try again.");
				scanner.nextLine();//clear invalid input to avoid infinite errors
			}catch(Exception ex){
				System.out.println("Something went wrong.");
			}
		}while(continueInput);
		do{
			System.out.println("What would you like to do?");
			System.out.println("1 - Check result \n2 - Register new course \n3 - Return");
			System.out.println("------------------------------------------------");
			
			input = checkChoice();
			
			switch(input){
				case 1: checkResult(student); break;
				case 2: registerCourse(student, cocuArr); break;
				case 3: again = false; return;
			}
		}while(again);
	}
	
	public static void checkResult(Student student){
		System.out.println("============================Exam Results============================");
		System.out.printf("%-10s %-40s %-10s %-10s\n", "CourseID", "Course Name", "Mark", "Grade");
		System.out.println("--------------------------------------------------------------------");
		Result[] results = student.getResult();
		if(results == null || results.length ==0){
			System.out.println("No results found for this student");
			return;
		}
		for(Result result: results){
			if(result != null && result.getCourse() != null && result.getMark() != 0 && result.getGrade() != null)
			System.out.printf("%-10s %-40s %-10s %-10s\n", result.getCourse().getCourseID(), result.getCourse().getCourseName(), result.getMark(), result.getGrade());
		}
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-60s %5.2f", "GPA: ", student.getGPA());
		System.out.printf("\n%-60s %5.2f", "CGPA: ", student.getCGPA());
		System.out.println("\n====================================================================");
	}
	
	//helper method to find student with specific id
	private static Student findStudent(String id, Student[] studArr){
		for(Student student: studArr)
			if(student != null && student.getStudentID().equals(id))
				return student;
								
		throw new IllegalArgumentException("Student Not Found");
	}		
		
	private static void registerCourse(Student student, Course[] cocuArr){
		registerCourse.viewCourses(student);
		registerCourse.addCourse(student, cocuArr);
	}
	
	private static void scheduleNewExam(Exam[] examArr){
		lecturerAddExam.addExam(examArr);
	}
}