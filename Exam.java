	/**
 * @(#)Exam.java
 *
 *
 * @author 
 * @version 1.00 2025/4/14
 Low Jia MIng 24SMD09939
 DSF1S3
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class Exam {
	private String examID;
	private LocalDate examDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private double duration;
	private String venue;
	private static int numberOfExamination;
	//constructors
    public Exam() {
    	this("0000",
       	"0000-00-00",
    	"00:00",
    	0.0,
    	" ");
    }
    
    public Exam(String examID,String examDate, String startTime, double duration,String venue){
    	this.examID = examID;
    	//1212-12-12
    	this.examDate = LocalDate.parse(examDate);
    	int hours = (int) duration;
    	int minutes = (int) Math.round((duration - hours) * 60);
    	this.startTime = LocalTime.parse(startTime);
    	this.endTime = this.startTime.plusHours(hours).plusMinutes(minutes);
    	this.duration = duration;
    	this.venue = venue;
    	numberOfExamination++;
    }
    //setters
    /*
    public void setDate(int year, int month, int date){
    	this.date = new Date(year, month, date);
    }
    */
    public void setExamID(String examID){
    	this.examID = examID;
    }
    public void setExamDate(String examDate){
    	this.examDate = LocalDate.parse(examDate);
    }
    public void setStartTime(String startTime){
    	//13:30
    	int hours = (int) duration;
    	int minutes = (int) Math.round((duration - hours) * 60);
    	this.startTime = LocalTime.parse(startTime);
    	this.endTime = this.startTime.plusHours(hours).plusMinutes(minutes);
    }
    public void setDuration(double duration){
    	//0.2 hours
    	this.duration = duration;
    }
    public void setVenue(String venue){
    	this.venue = venue;
    }
    //getters
    public String getExamID(){
    	return examID;
    }
	public LocalDate getExamDate(){
		return examDate;
	}
	public LocalTime getStartTime(){
		return startTime;
	}
	public LocalTime getEndTime(){
		return endTime;
	}
	public double getDuration(){
		return duration;
	}
	public String getVenue(){
		return venue;
	}
	public int getNumberOfExamination(){
		return numberOfExamination;
	}
	//toStirng
    public String toString(){
    	return "Exam ID : " + examID 
    		+ "\nExam Date : " + examDate 
    		+ "\nTime : " + startTime + " ~ " +  endTime 
    		+ "\nDuration : " + duration 
    		+ "\nVenue : " + venue 
    		+ "\nNumber of Examinations currently : " + numberOfExamination
    		;
    }
}
