// Rowan Yee Xiao Peng
// DSF Y1S3

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class lecturerAddExam {
	static int examCount = Exam.getNumberOfExamination(); // Track how many exams we have
	
    public static void addExam(Exam[] exams) {
        Scanner scanner = UniversityExaminationSystem.scanner;
        
        System.out.println("=== Lecturer Exam Management System ===");
        System.out.println("Currently have " + examCount + " exams in system.");
        
        while (examCount < exams.length) {
            System.out.println("\nOptions:");
            System.out.println("1. Add new exam");
            System.out.println("2. View all exams");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    // Input new exam details
                    System.out.println("\nEnter new exam details:");
                    
                    System.out.print("Exam ID: ");
                    String examID = checkInput(scanner);
                    
                    System.out.print("Exam Date (YYYY-MM-DD): ");
                    String examDate = checkInput(scanner);
                    
                    System.out.print("Start Time (HH:MM): ");
                    String startTime = checkInput(scanner);
                    
					System.out.print("Duration (hours): ");
					double duration;
					try {
					    if (scanner.hasNextDouble()) {
					        duration = scanner.nextDouble();
					    } else {
					        System.out.println("Invalid duration. Using default of 2 hours.");
					        duration = 2.0;
					        scanner.next(); // Discard the invalid token
					    }
					} catch (Exception e) {
					    System.out.println("Error reading input. Using default of 2 hours.");
					    duration = 2.0;
					}
					
					scanner.nextLine(); // Consume the newline after reading the input
                    
                    System.out.print("Venue: ");
                    String venue = checkInput(scanner);
                    
                    // Create and store new exam
                    exams[examCount] = new Exam(examID, examDate, startTime, duration, venue);
                    examCount++;
                    
                    System.out.println("Exam added successfully!");
                    break;
                    
                case 2:
                    // Display all exams
                    System.out.println("\n=== All Exams ===");
                    for (int i = 0; i < examCount; i++) {
                        System.out.println(exams[i].toString());
                        System.out.println("-------------------");
                    }
                    break;
                    
                case 3:
                    System.out.println("Exiting system...");
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        System.out.println("Exam storage is full (10 exams reached).");
        scanner.close();
    }
    
    private static String checkInput(Scanner scanner){
    String input = "";
    boolean continueInput = true;
    do{
        try{
            input = scanner.nextLine();
            continueInput = false; // Exit the loop if input is successful
        }catch(IllegalArgumentException ex){
            System.out.println("Invalid input. Try again");
        }
    }while(continueInput);
    return input;
}
}