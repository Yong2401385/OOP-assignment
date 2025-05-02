/**
 * LoginSystem.java
 * 
 * Main interface for the University Examination System
 * @version 1.0 2025/05/01
 */
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginSystem {
    private static Map<String, Student> studentAccounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Student currentUser = null;
    
    // Store all the static data for the system
    private static Department[] departments;
    private static Programme[] programmes;
    private static Map<String, Course[]> programmeCourses;
    private static Course[] cocurricularCourses;
    
    public static void main(String[] args) {
        initializeSystem();
        
        boolean running = true;
        while (running) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                showStudentMenu();
            }
        }
        
        scanner.close();
    }
    
    /**
     * Initialize the system with predefined data
     */
    private static void initializeSystem() {
        // Initialize departments
        departments = new Department[3];
        departments[0] = new Department("FCIT", "Faculty of Computing and Information Technology", 
                                        new Lecturer[5], new Programme[5]);
        departments[1] = new Department("FAFB", "Faculty of Accountancy, Finance and Business", 
                                        new Lecturer[5], new Programme[5]);
        departments[2] = new Department("FSSH", "Faculty of Social Science and Humanities", 
                                        new Lecturer[5], new Programme[5]);
        
        // Initialize programmes
        programmes = new Programme[5];
        programmes[0] = new Programme("DSF", "Dr. Lee Ming", 3); // Diploma in Software Engineering
        programmes[1] = new Programme("BFT", "Prof. Sarah Wong", 4); // Bachelor of IT
        programmes[2] = new Programme("DBF", "Dr. Tan Cheng", 3); // Diploma in Banking and Finance
        programmes[3] = new Programme("BAF", "Prof. David Lim", 4); // Bachelor of Business
        programmes[4] = new Programme("DHM", "Dr. Jessica Ong", 3); // Diploma in Hotel Management
        
        // Associate programmes with departments
        departments[0].addProgramme(programmes[0]); // DSF to FCIT
        departments[0].addProgramme(programmes[1]); // BFT to FCIT
        departments[1].addProgramme(programmes[2]); // DBF to FAFB
        departments[1].addProgramme(programmes[3]); // BAF to FAFB
        departments[2].addProgramme(programmes[4]); // DHM to FSSH
        
        // Initialize courses for each programme
        programmeCourses = new HashMap<>();
        
        // DSF Courses
        Course[] dsfCourses = new Course[5];
        dsfCourses[0] = new Course("DSF1001", "Problem Solving and Programming", 3, 2023, createExam("E101"));
        dsfCourses[1] = new Course("DSF1002", "Software Engineering", 4, 2023, createExam("E102"));
        dsfCourses[2] = new Course("DSF1003", "Calculus and Algebra", 3, 2023, createExam("E103"));
        dsfCourses[3] = new Course("DSF1004", "Software Requirement and Design", 4, 2023, createExam("E104"));
        dsfCourses[4] = new Course("DSF1005", "English for Tertiary Studies", 2, 2023, createExam("E105"));
        programmeCourses.put("DSF", dsfCourses);
        
        // Add courses to programme
        for (Course course : dsfCourses) {
            programmes[0].addCourse(course);
        }
        
        // BFT Courses
        Course[] bftCourses = new Course[5];
        bftCourses[0] = new Course("BFT1001", "IT Fundamentals", 3, 2023, createExam("E201"));
        bftCourses[1] = new Course("BFT1002", "Systems Analysis and Design", 4, 2023, createExam("E202"));
        bftCourses[2] = new Course("BFT1003", "Integrative Programming", 4, 2023, createExam("E203"));
        bftCourses[3] = new Course("BFT1004", "Fundamentals of Computer Networks", 3, 2023, createExam("E204"));
        bftCourses[4] = new Course("BFT1005", "English for Career Preparation", 2, 2023, createExam("E205"));
        programmeCourses.put("BFT", bftCourses);
        
        // Add courses to programme
        for (Course course : bftCourses) {
            programmes[1].addCourse(course);
        }
        
        // DBF Courses
        Course[] dbfCourses = new Course[5];
        dbfCourses[0] = new Course("DBF1001", "Principles of Accounting", 3, 2023, createExam("E301"));
        dbfCourses[1] = new Course("DBF1002", "Economics", 3, 2023, createExam("E302"));
        dbfCourses[2] = new Course("DBF1003", "Quantitative Studies", 3, 2023, createExam("E303"));
        dbfCourses[3] = new Course("DBF1004", "Introduction to Business", 3, 2023, createExam("E304"));
        dbfCourses[4] = new Course("DBF1005", "English for Tertiary Studies", 2, 2023, createExam("E305"));
        programmeCourses.put("DBF", dbfCourses);
        
        // Add courses to programme
        for (Course course : dbfCourses) {
            programmes[2].addCourse(course);
        }
        
        // BAF Courses
        Course[] bafCourses = new Course[5];
        bafCourses[0] = new Course("BAF1001", "IT Fundamentals and Applications", 3, 2023, createExam("E401"));
        bafCourses[1] = new Course("BAF1002", "Business Communication", 3, 2023, createExam("E402"));
        bafCourses[2] = new Course("BAF1003", "Quantitative Methods", 3, 2023, createExam("E403"));
        bafCourses[3] = new Course("BAF1004", "Economics", 3, 2023, createExam("E404"));
        bafCourses[4] = new Course("BAF1005", "English for Career Preparation", 2, 2023, createExam("E405"));
        programmeCourses.put("BAF", bafCourses);
        
        // Add courses to programme
        for (Course course : bafCourses) {
            programmes[3].addCourse(course);
        }
        
        // DHM Courses
        Course[] dhmCourses = new Course[5];
        dhmCourses[0] = new Course("DHM1001", "Economics for Hospitality Industry", 3, 2023, createExam("E501"));
        dhmCourses[1] = new Course("DHM1002", "Introduction to Hospitality Industry", 3, 2023, createExam("E502"));
        dhmCourses[2] = new Course("DHM1003", "Marketing for Hospitality Management", 3, 2023, createExam("E503"));
        dhmCourses[3] = new Course("DHM1004", "Introduction to Information Technology", 2, 2023, createExam("E504"));
        dhmCourses[4] = new Course("DHM1005", "English for Tertiary Studies", 2, 2023, createExam("E505"));
        programmeCourses.put("DHM", dhmCourses);
        
        // Add courses to programme
        for (Course course : dhmCourses) {
            programmes[4].addCourse(course);
        }
        
        // Co-curricular Courses
        cocurricularCourses = new Course[5];
        cocurricularCourses[0] = new Course("CC1001", "Karate Do", 1, 2023, createExam("E601"));
        cocurricularCourses[1] = new Course("CC1002", "Badminton", 1, 2023, createExam("E602"));
        cocurricularCourses[2] = new Course("CC1003", "Net Ball", 1, 2023, createExam("E603"));
        cocurricularCourses[3] = new Course("CC1004", "Volleyball", 1, 2023, createExam("E604"));
        cocurricularCourses[4] = new Course("CC1005", "Basketball", 1, 2023, createExam("E605"));
        
        // Create sample student accounts
        createSampleStudents();
    }
    
    /**
     * Create sample exam with given ID
     */
    private static Exam createExam(String examID) {
        String examDate = "2025-06-10";
        String startTime = "09:00";
        double duration = 2.0;
        String venue = "Exam Hall " + examID.substring(1);
        
        return new Exam(examID, examDate, startTime, duration, venue);
    }
    
    /**
     * Create sample student accounts
     */
    private static void createSampleStudents() {
        // DSF Student
        Student dsfStudent = new Student(
            "John Lee", 
            "john.lee@student.edu", 
            "012-3456789", 
            "DSF001", 
            2, 
            new Course[0], 
            programmes[0], 
            new Result[0], 
            new Exam[0]
        );
        
        // Register for default courses
        for (Course course : programmeCourses.get("DSF")) {
            dsfStudent.registerCourse(course);
        }
        
        // BFT Student
        Student bftStudent = new Student(
            "Sarah Tan", 
            "sarah.tan@student.edu", 
            "012-7654321", 
            "BFT001", 
            3, 
            new Course[0], 
            programmes[1], 
            new Result[0], 
            new Exam[0]
        );
        
        // Register for default courses
        for (Course course : programmeCourses.get("BFT")) {
            bftStudent.registerCourse(course);
        }
        
        // Add students to accounts
        studentAccounts.put("DSF001", dsfStudent);
        studentAccounts.put("BFT001", bftStudent);
    }
    
    /**
     * Display the login menu
     */
    private static void showLoginMenu() {
        System.out.println("\n===== University Examination System =====");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                System.out.println("Exiting system. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    /**
     * Handle user login
     */
    private static void login() {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        
        if (studentAccounts.containsKey(studentID)) {
            currentUser = studentAccounts.get(studentID);
            System.out.println("Login successful! Welcome, " + currentUser.getName() + "!");
        } else {
            System.out.println("Student ID not found. Please try again.");
        }
    }
    
    /**
     * Display the student menu
     */
    private static void showStudentMenu() {
        System.out.println("\n===== Student Menu =====");
        System.out.println("Welcome, " + currentUser.getName() + " (" + currentUser.getStudentID() + ")");
        System.out.println("1. View Programme Information");
        System.out.println("2. View Registered Courses");
        System.out.println("3. View Exam Timetable");
        System.out.println("4. Add Co-curricular Course");
        System.out.println("5. View Results");
        System.out.println("6. Logout");
        System.out.print("Enter your choice: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                viewProgramme();
                break;
            case 2:
//              viewCourses();
                break;
            case 3:
                viewExamTimetable();
                break;
            case 4:
//                addCocurricularCourse();
                break;
            case 5:
                viewResults();
                break;
            case 6:
                logout();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    /**
     * View programme information
     */
    private static void viewProgramme() {
        Programme programme = currentUser.getProgramme();
        System.out.println("\n===== Programme Information =====");
        System.out.println("Programme ID: " + programme.getProgrammeID());
        
        // Find the full name based on the ID
        String fullName = "";
        switch (programme.getProgrammeID()) {
            case "DSF":
                fullName = "Diploma in Software Engineering";
                break;
            case "BFT":
                fullName = "Bachelor of Information Technology (Honours) in Software Systems Development";
                break;
            case "DBF":
                fullName = "Diploma in Banking and Finance";
                break;
            case "BAF":
                fullName = "Bachelor of Business (Honours) Accounting and Finance";
                break;
            case "DHM":
                fullName = "Diploma in Hotel Management";
                break;
        }
        
        System.out.println("Programme Name: " + fullName);
        System.out.println("Programme Leader: " + programme.getProgrammeLeader());
        System.out.println("Duration: " + programme.getProgrammeDuration() + " years");
        
        // Find department
        for (Department dept : departments) {
            for (Programme prog : dept.getProgrammeList()) {
                if (prog != null && prog.getProgrammeID().equals(programme.getProgrammeID())) {
                    System.out.println("Department: " + dept.getDepartmentName());
                    break;
                }
            }
        }
        
        // Wait for user input before returning
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    /**
     * View registered courses
     */
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
     * View exam timetable
     */
    private static void viewExamTimetable() {
        Course[] courses = currentUser.getCourseList();
        
        System.out.println("\n===== Exam Timetable =====");
        if (courses.length == 0) {
            System.out.println("No courses registered.");
        } else {
            System.out.printf("%-10s %-40s %-12s %-12s %-15s\n", 
                "Course ID", "Course Name", "Exam Date", "Time", "Venue");
            System.out.println("------------------------------------------------------------------------------");
            
            for (Course course : courses) {
                if (course != null) {
                    Exam exam = course.getExam();
                    System.out.printf("%-10s %-40s %-12s %-12s %-15s\n", 
                        course.getCourseID(), course.getCourseName(), 
                        exam.getExamDate(), exam.getStartTime() + " - " + exam.getEndTime(), 
                        exam.getVenue());
                }
            }
        }
        
        // Wait for user input before returning
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    /**
     * Add a co-curricular course
     */
    public static void addCocurricularCourse(Student student, Course[] cocurricularCourses) {
        System.out.println("\n===== Add Co-curricular Course =====");
        System.out.println("Available Co-curricular Courses:");
        int i = 0;
        // Display available co-curricular courses
        for (Course cocu: cocurricularCourses) {
        	if(cocu != null)
            System.out.println((i+1) + ". " + cocu.getCourseID() + " - " + cocu.getCourseName());
            i++;
        }
        
        System.out.print("\nEnter the number of the course to add (or 0 to cancel): ");
        int choice = getIntInput();
        
        if (choice >= 1 && choice <= cocurricularCourses.length) {
            Course selectedCourse = cocurricularCourses[choice-1];
            
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
                System.out.println("Successfully registered for " + selectedCourse.getCourseName() + "!");
            }
        } else if (choice != 0) {
            System.out.println("Invalid choice.");
        }
        
        // Wait for user input before returning
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    /**
     * View student results
     */
    private static void viewResults() {
        Result[] results = currentUser.getResult();
        
        System.out.println("\n===== Exam Results =====");
        if (results.length == 0) {
            System.out.println("No results available.");
            
            // Generate some sample results for demonstration
            System.out.println("\nGenerating sample results for demonstration...");
            
            // Create sample results for the student's courses
            Course[] courses = currentUser.getCourseList();
            Result[] sampleResults = new Result[courses.length];
            
            for (int i = 0; i < courses.length; i++) {
                if (courses[i] != null) {
                    // Generate a random mark between 50 and 95
                    double mark = 50 + Math.random() * 45;
                    sampleResults[i] = new Result("R" + (i+1) + currentUser.getStudentID(), courses[i], mark);
                }
            }
            
            // Set the results for the student
            currentUser.setResult(sampleResults);
            results = sampleResults;
            
            System.out.println("Sample results generated!");
        }
        
        // Display results
        System.out.printf("%-10s %-40s %-10s %-10s\n", 
            "Course ID", "Course Name", "Mark", "Grade");
        System.out.println("------------------------------------------------------");
        
        for (Result result : results) {
            if (result != null) {
                Course course = result.getCourse();
                System.out.printf("%-10s %-40s %-10.2f %-10s\n", 
                    course.getCourseID(), course.getCourseName(), 
                    result.getMark(), result.getGrade());
            }
        }
        
        // Display GPA
        System.out.println("\nGPA: " + String.format("%.2f", currentUser.getGPA()));
        System.out.println("CGPA: " + String.format("%.2f", currentUser.getCGPA()));
        
        // Wait for user input before returning
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    /**
     * Logout the current user
     */
    private static void logout() {
        System.out.println("Logging out...");
        currentUser = null;
    }
    
    /**
     * Helper method to safely get integer input
     */
    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}