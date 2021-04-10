package stacksales;

public class Cart {
	private int id;
	private String catagory, p_id, p_name, p_price, quantity, description;
	
	public Cart(int id,String catagory,String p_id,String p_name,String p_price,String quantity,String description) {
		
		this.id=id;
		this.catagory=catagory;
		this.p_id=p_id;
		this.p_name=p_name;
		this.p_price=p_price;
		this.quantity=quantity;
		this.description=description;
        
		
	}
	public int getid() {
		return id;
	} 
	public String getcatagory() {
		return catagory;
	} 
	public String getp_id() {
		return p_id;
	} 
	public String getp_name() {
		return p_name;
	} 
	public String getp_price() {
		return p_price;
	} 
	public String getquantity() {
		return quantity;
	} 
	public String getdescription() {
		return description;
	} 
	 
	
}



