/*Vincent Chiew Jia Cheng 2402394
 *DSF Y1S3*/

public abstract class Person{
	//data fields
	private String name;
	private String email;
	private int contactNo;
	
	//no-arg constructor
	protected Person(){}
	//constructor with 2-arguments
	protected Person(String name, String email, int contactNo){
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
	}
	
	//getters
	public String getName(){
		return this.name;
	}
	public String getEmail(){
		return this.email;
	}
	public int getContactNo(){
		return this.contactNo;
	}
	
	//setters
	public void setName(String name){
		this.name = name;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setContactNo(int contactNo){
		this.contactNo = contactNo;
	}
	
	//toString
	public String toString(){
		return 	"Name \t: " + this.name
			+	"\nEmail \t: " + this.email
			+	"\nContact \t:" + this.contactNo;
	}
	
	@Override
		public boolean equals(Object obj){
			if(this == obj)
				return true;
			if(obj == null || getClass() != obj.getClass()) 
				return false;
			Person other = (Person) obj;
			return email != null && email.equals(other.email);
		}
}