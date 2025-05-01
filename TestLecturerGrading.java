/**
 * @(#)TestLecturerGrading.java
 *
 *
 * @author 
 * @version 1.00 2025/4/29
 */
import java.util.Scanner;
import java.util.Arrays;

public class TestLecturerGrading {

    public static void main(String[] args) {
    	//initialization
    	Exam DSF_Exam = new Exam("123","0001-01-01", "12:12", 1.5,"B1");
    	Course DSF = new Course("123", "DSF", 4, 1021, DSF_Exam);
    	Course[] course_list = {DSF};
    	Exam[] exam_list = {DSF_Exam};
    	Lecturer lecturerA = new Lecturer("calx", "a", "123", "123", course_list, exam_list);
    	Result DSF_Result = new Result("123", DSF, 99.2);
    	Result[] result_list = {DSF_Result};
    	Student Moon = new Student("Moon", "a", "101", "123",1021, course_list ,new Programme(), result_list,exam_list);
    	Student[] student_list = {Moon};
    	
    	int choice;
		
		boolean end = false;
		Scanner scanner = new Scanner(System.in);
		
    	
    	do{
    		System.out.println("Choose (1=grade marks, 2=end session): ");
    		choice = scanner.nextInt();
    		switch(choice){
    			case 1:
    				Grade(lecturerA, student_list);
    				break;
    			case 2:
    				end = true;
    				break;
    			default:
    				System.out.println("Invalid Input! Try again!");
    		}
    		
    	}while(end == false);
    	
    	
    	
    }
     public static void Grade(Lecturer lecturer, Student[] student_list){
        Scanner scanner = new Scanner(System.in);
    	System.out.println("Courses Taught:");
    	//generate a courselist for this specific lecturer
    	Course[] courselist = lecturer.getCourseTaught();
    	//continue
    	int i = 0;
    	for(Course course:courselist){
    		if (course != null) {
    		System.out.println((i+1) + ". " + course.getCourseName());
    		i++;
    		}
    	}
    	System.out.println("Course To Grade (number in list): ");
        int list_num = scanner.nextInt();
        
        //check if student have the examID, if have add into new _student_list
        String examID = courselist[list_num-1].getExam().getExamID();
        
        //create array to containe students with the course's examID
        Student[] new_student_list = new Student[100];
        int ii = 0;
        for (Student student:student_list){
        	//if contains, true if not, false
        	for (Exam exam:student.getExamList()){
        	  if (exam.getExamID() == examID){
        		new_student_list[ii] = student;
        		continue;
        	}
        	}
        	ii++;
        } 
        System.out.println("    Name\tMarks");
        System.out.println("    ---------\t----------");
//see which result in the result array have course intended to grade and get the mark of the result
		int iii = 0;
        for (Student student:new_student_list){
         if (student != null){
          Result[] result = student.getResult();
          double marks = 0;
          	for (Result actual_result: result){
          		if (actual_result.getCourse().getCourseName() == courselist[list_num-1].getCourseName()){
          			marks = actual_result.getMarks();
          			break;
          		}
          	}
          iii++;
    	  System.out.println((iii) + ". " + student.getName() + "      " + marks);
    	  //options to grade or quit
        }
    	}
    	boolean end1 = false;
    	do {
    	  	System.out.println("Enter 1 to grade, Enter 2 to back: ");
    	  	int CHOICE = scanner.nextInt();
    	  	switch(CHOICE){
    	  		case 1:
    	  			System.out.println("Which student to grade?(number in list): " );
    	  			int num = scanner.nextInt();
    	  			System.out.println("How many marks?: " );
    	  			double num2 = scanner.nextDouble();
    	  			Result[] result_to_grade = new_student_list[num-1].getResult();
    	  			for (Result result2: result_to_grade){
          	     	if (result2.getCourse().getCourseName() == courselist[list_num-1].getCourseName()){
          			result2.setMark(num2);
          			break;
          	     	}
          	    }
          	    double new_marks = 0;
          	    for (Result result2: result_to_grade){
          	     	if (result2.getCourse().getCourseName() == courselist[list_num-1].getCourseName()){
          			new_marks = result2.getMarks();
          	     	}
          	    }
          	    System.out.println("Student Name :" + new_student_list[num-1].getName() + "\tNew Marks :" + new_marks);
    	  		case 2: 
    	  			end1 = true;
    	  		
    	  	}
    	  	
    	  	
    }while(end1 == false);
    
}

    
}