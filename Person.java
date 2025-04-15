/*Vincent Chiew Jia Cheng 2402394
 *DSF Y1S3*/

public class Person{
	//data fields
	private String name;
	private String email;
	
	//no-arg constructor
	public Person(){}
	//constructor with 2-arguments
	public Person(String name, String email){
		this.name = name;
		this.email = email;
	}
	
	//getters
	public String getName(){
		return this.name;
	}
	public String getEmail(){
		return this.email;
	}
	
	//setters
	public void setName(String name){
		this.name = name;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	//toString
	public String toString(){
		return 	"Name \t: " + this.name
			+	"\nEmail \t: " + this.email;
	}
}