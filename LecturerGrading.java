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
        Scanner scanner = UniversityExaminationSystem.scanner;
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
    	  			int num = 0;
    	  			boolean loop = true;
    	  			do{
	    	  			num = scanner.nextInt();
	    	  			if(num > 0 && num <= iii) 
	    	  				loop = false;
	    	  			else 
	    	  				System.out.println("Not a student in the list. Please try again");
    	  			}while(loop);
    	  			System.out.println("How many marks?: " );
    	  			double num2 = scanner.nextDouble();
    	  			
    	  			Student studentToGrade = new_student_list[num-1];
    				Result[] results = studentToGrade.getResult();
    				boolean markUpdated = false;
    
    				for (int j = 0; j < results.length; j++) {
        				Result result = results[j];
        				if (result != null && result.getCourse() != null && 
            				result.getCourse().getCourseName().equals(courselist[list_num-1].getCourseName())) {
            
            				result.setMark(num2);
            				markUpdated = true;
            				System.out.println("Student Name: " + studentToGrade.getName() + "\tNew Marks: " + num2);
            				break;
        				}
    				}
    
    				if (!markUpdated) {
        				// If no result found for this course, create a new one
        				Result newResult = new Result(courselist[list_num-1], num2);
        
        				Result[] newResults = Arrays.copyOf(results, results.length + 1);
        				newResults[results.length] = newResult;
        				studentToGrade.setResult(newResults);
        
        				System.out.println("Created new result entry.");
        				System.out.println("Student Name: " + studentToGrade.getName() + "\tNew Marks: " + num2);
    				}
    				break;
    				
    				case 2:
    				end1 = true; // Set flag to exit the loop
    				break;
    				
    			default:
    				System.out.println("Invalid choice. Please enter 1 or 2.");
    	  			}
    		} while(!end1);
	}
}