// Yong Hao Cheng 2401385
// DSF1S3

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class registerCourse{
	 private static Scanner scanner = UniversityExaminationSystem.scanner;
	
	public static void viewCourses(Student student) {
        Course[] courses = student.getCourseList();
        
        System.out.println("\n===== Registered Courses =====");
        if (courses.length == 0) {
            System.out.println("No courses registered.");
        } else {
            System.out.printf("%-10s %-40s %-12s\n", "Course ID", "Course Name", "Credit Hours");
            System.out.println("-------------------------------------------------------------------");
            
            for (Course course : courses) {
                if (course != null) {
                    System.out.printf("%-10s %-40s %-12d\n", 
                        course.getCourseID(), course.getCourseName(), course.getCreditHour());
                }
            }
        }
        
        // Wait for user input before returning
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    /**
     * Add a course
     */
    public static void addCourse(Student student, Course[] courses) {
        System.out.println("\n===== Add Course =====");
        System.out.println("Available Courses:");
        int i = 0;
        // Display available courses
        for (Course cour: courses) {
        	if(cour != null)
            System.out.println((i+1) + ". " + cour.getCourseID() + " - " + cour.getCourseName());
            i++;
        }
        
        System.out.print("\nEnter the number of the course to add (or 0 to cancel): ");
        int choice = getIntInput();
        
        if (choice >= 1 && choice <= courses.length) {
            Course selectedCourse = courses[choice-1];
            
            // Check if already registered
            boolean alreadyRegistered = false;
            for (Course course : student.getCourseList()) {
                if (course != null && course.getCourseID().equals(selectedCourse.getCourseID())) {
                    alreadyRegistered = true;
                    break;
                }
            }
            
            if (alreadyRegistered) {
                System.out.println("You are already registered for this course.");
            } else {
                student.registerCourse(selectedCourse);
                
                // Create and add a new Result object
        		Result[] currentResults = student.getResult();
        		Result[] newResults = Arrays.copyOf(currentResults, currentResults.length + 1);
        
        		// Create new Result with 0.0 mark initially
        		Result newResult = new Result(selectedCourse, 0.0);
        		newResults[currentResults.length] = newResult;
        
        		// Update student's results
        		student.setResult(newResults);
                
                System.out.println("Successfully registered for " + selectedCourse.getCourseName() + "!");
            }
        } else if (choice != 0) {
            System.out.println("Invalid choice.");
        }
        
        // Wait for user input before returning
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
     private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}