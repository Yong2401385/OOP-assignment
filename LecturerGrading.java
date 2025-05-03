/**
 * @(#)LecturerGrading.java
 *
 *
 * @author 
 * @version 1.00 2025/4/15
 Low Jia MIng 24SMD09939
 DSF1S3
 */
import java.util.Scanner;
import java.util.Arrays;

public class LecturerGrading {

     public static void grade(Lecturer lecturer, Student[] student_list){
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
        	if(student == null)
        		continue;
        	
        	Exam[] examList = student.getExamList();
        	if(examList != null)
        	for (Exam exam: examList){
        		if(exam == null)
        			continue;
        			
        		if(exam.getExamID() == examID){
        			new_student_list[ii] = student;
        			ii++;
        			continue;
        		}
        	}
        }
        System.out.printf("%-20s %-20s", "Name", "Marks");
        System.out.printf("\n%-20s %-20s", "---------", "----------");
//see which result in the result array have course intended to grade and get the mark of the result
		int iii = 0;
        for (Student student:new_student_list){
         if (student != null){
          Result[] result = student.getResult();
          double marks = 0;
          if(result != null)
          	for (Result actual_result: result){
          		if (actual_result != null && actual_result.getCourse() != null && actual_result.getCourse().getCourseName().equals(courselist[list_num-1].getCourseName())){
          			marks = actual_result.getMark();
          			break;
          		}
          	}
          iii++;
    	  System.out.printf("\n%1d %1s %-20s %-1.2f",(iii), ". ", student.getName(), marks);
    	  //options to grade or quit
        }
    	}
    	boolean end1 = false;
    	do {
    	  	System.out.println("\nEnter 1 to grade, Enter 2 to back: ");
    	  	int CHOICE = scanner.nextInt();
    	  	switch(CHOICE){
    	  		case 1:
    	  			System.out.println("Which student to grade?(number in list): " );
    	  			int num = scanner.nextInt();
    	  			System.out.println("How many marks?: " );
    	  			double num2 = scanner.nextDouble();
    	  			Result[] result_to_grade = new_student_list[num-1].getResult();
    	  			for(Result result2: result_to_grade){
          	     	if (result2.getCourse().getCourseName() == courselist[list_num-1].getCourseName()){
          			result2.setMark(num2);
          			break;
          	     	}
          	    }
          	    double new_marks = 0;
          	    for (Result result2: result_to_grade){
          	     	 if(result2 != null && result2.getCourse() != null && courselist[list_num-1] != null && result2.getCourse().getCourseName().equals(courselist[list_num-1].getCourseName())){
          			new_marks = result2.getMark();
          	     	}
          	    }
          	    System.out.println("Student Name :" + new_student_list[num-1].getName() + "\tNew Marks :" + new_marks);
          	    System.out.println("------------------------------------------------");
    	  		case 2: 
    	  			end1 = true;
    	  		
    	  	}
    	  	
    	  	
    }while(end1 == false);
    
}

    
}