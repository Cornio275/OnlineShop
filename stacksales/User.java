package stacksales;

public class User {
	private int id;
	private String fname, lname, user_name, password, email, phone;
	private byte[] Image;
	public User(int id,String fname,String lname,String user_name,String password,String email,String phone,byte[]Image) {
		
		this.id=id;
		this.fname=fname;
		this.lname=lname;
		this.user_name=user_name;
		this.password=password;
		this.email=email;
		this.phone=phone;
		   this.Image=Image;
		
	}	
		public int getid() {
			return id;
		} 
		public String getfname() {
			return fname;
		} 
		public String getlname() {
			return lname;
		} 
		public String getuser_name() {
			return user_name;
		} 
		public String getpassword() {
			return password;
		} 
		public String getemail() {
			return email;
		} 
		public String getphone() {
			return phone;
		} 
		public byte[] getImage() {
			return Image;
		} 

}


