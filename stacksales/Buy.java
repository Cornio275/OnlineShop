package stacksales;

public class Buy {

	private int id;
	private String fullname, email,address, p_name,p_price,p_id,quantity;
	
	public Buy(int id,String fullname,String email,String address,String p_name,String p_price,String p_id,String quantity) {
		
		this.id=id;
		this.fullname=fullname;
		this.email=email;
		this.address=address;
		this.p_name=p_name;
		this.p_price=p_price;
		this.p_id=p_id;
		this.quantity=quantity;
		
	}
	public int getid() {
		return id;
	} 
	public String getfullname() {
		return fullname;
	} 
	public String getemail() {
		return email;
	} 
	public String getaddress() {
		return address;
	} 
	public String getp_name() {
		return p_name;
	} 
	public String getp_price() {
		return p_price;
	} 
	public String getp_id() {
		return p_id;
	} 
	public String getquantity() {
		return quantity;
	} 
}
