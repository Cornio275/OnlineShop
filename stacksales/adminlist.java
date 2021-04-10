package stacksales;

public class adminlist {
		private int id;
		private String fname, nationality, user_name, password, email, phone;
		private byte[] Image;
		
		public adminlist(int id,String fname,String nationality,String user_name,String password,String email,String phone,byte[]Image) {
			
			this.id=id;
			this.fname=fname;
			this.nationality=nationality;
			this.user_name=user_name;
			this.password=password;
			this.email=email;
			this.phone=phone;
			this.Image=Image;
			this.nationality=nationality;
			
		}
		
		public int getid() {
			return id;
		} 
		public String getfname() {
			return fname;
		} 
		public String getnationality() {
			return nationality;
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

