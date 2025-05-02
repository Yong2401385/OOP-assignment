// Rowan Yee Xiao Peng
// DSF Y1S3

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class lectureinput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize exam array with 3 dummy exams
        Exam[] exams = new Exam[10];
        exams[0] = new Exam("EXM001", "2023-12-15", "09:00", 2.5, "Hall A");
        exams[1] = new Exam("EXM002", "2023-12-16", "14:00", 3.0, "Hall B");
        exams[2] = new Exam("EXM003", "2023-12-17", "10:30", 2.0, "Hall C");
        int examCount = 3; // Track how many exams we have
        
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
                    String examID = scanner.nextLine();
                    
                    System.out.print("Exam Date (YYYY-MM-DD): ");
                    String examDate = scanner.nextLine();
                    
                    System.out.print("Start Time (HH:MM): ");
                    String startTime = scanner.nextLine();
                    
                    System.out.print("Duration (hours): ");
                    double duration = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    
                    System.out.print("Venue: ");
                    String venue = scanner.nextLine();
                    
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
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        System.out.println("Exam storage is full (10 exams reached).");
        scanner.close();
    }
}