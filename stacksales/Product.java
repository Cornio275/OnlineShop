package stacksales;

public class Product {

	private int id;
	private String catagory, p_id, p_name, p_price, p_fprice, description;
	private byte[] Image;
	public Product(int id,String catagory,String p_id,String p_name,String p_price,String p_fprice,String description,byte[]Image) {
		
		this.id=id;
		this.catagory=catagory;
		this.p_id=p_id;
		this.p_name=p_name;
		this.p_price=p_price;
		this.p_fprice=p_fprice;
		this.description=description;
        this.Image=Image;

		
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
	public String getp_fprice() {
		return p_fprice;
	} 
	public String getdescription() {
		return description;
	} 
	public byte[] getImage() {
		return Image;
	} 
}


