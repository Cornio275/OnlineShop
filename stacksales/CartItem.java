package stacksales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class CartItem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7611556385002015306L;
	private JPanel contentPane;
	private JTable table;
	JLabel lblNewLabel;
	JLabel label_1;
	JLabel lblNewLabel_1;
	JLabel label_4;
	JLabel label_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartItem frame = new CartItem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public ArrayList<Cart> productlist(){
		ArrayList<Cart> productlist = new ArrayList<>();
		

	          
		try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
	          
	           String query="SELECT * FROM cart";
	           Statement stmt = con.createStatement();
	           ResultSet rs=stmt.executeQuery(query);
	        
	           Cart cart;
	        while (rs.next()){ 
	        	cart= new Cart(rs.getInt("id"),rs.getString("catagory"),rs.getString("p_id"),rs.getString("p_name")
	        			,rs.getString("p_price"),rs.getString("quantity"),rs.getString("description"));
	        	productlist.add(cart);
           }
		
		
	          
             con.close(); 
        }catch (Exception e){ 
             //Your exception handling mechanism goes here. 
        } 
		return productlist;	
	}
	
	public void show_product() {
		ArrayList<Cart> list = productlist();
		DefaultTableModel model =(DefaultTableModel)table.getModel();
		
		Object[] row = new Object[6];
		
	for(int i=0;i<list.size();i++) {
		row[0]=list.get(i).getid();
		row[1]=list.get(i).getcatagory();
		row[2]=list.get(i).getp_name();
		row[3]=list.get(i).getp_id();
		row[4]=list.get(i).getp_price();
		row[5]=list.get(i).getdescription();
	
		
		model.addRow(row);
		
		
	}
	}
	
	/**
	 * Create the frame.
	 */
	public CartItem() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\software\\Online_store\\image\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 200, 591);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(20, 22, 151, 50);
		panel.add(label);
		
		JLabel lblCartItem = new JLabel("Cart Item");
		lblCartItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartItem.setForeground(Color.WHITE);
		lblCartItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCartItem.setBounds(30, 77, 129, 22);
		panel.add(lblCartItem);
		
		JLabel lblMatikatadhakaCant = new JLabel("Matikata,Dhaka can't");
		lblMatikatadhakaCant.setForeground(Color.WHITE);
		lblMatikatadhakaCant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatikatadhakaCant.setBounds(20, 535, 137, 17);
		panel.add(lblMatikatadhakaCant);
		
		JLabel label_3 = new JLabel("stacksales@gmail.com");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(20, 563, 137, 17);
		panel.add(label_3);
		
		JButton button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new userlogin().setVisible(true);
				
			}
		});
		button.setForeground(UIManager.getColor("Button.foreground"));
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(UIManager.getColor("Button.light"));
		button.setBounds(20, 494, 100, 30);
		panel.add(button);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(20, 204, 170, 210);
		panel.add(label_11);
		
		

		
		
		label_11.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\stack.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 50, 67));
		panel_1.setBounds(201, 0, 806, 591);
		contentPane.add(panel_1);
		
		JLabel lblCartItems = new JLabel("Cart Items ");
		lblCartItems.setForeground(Color.WHITE);
		lblCartItems.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCartItems.setBounds(299, 0, 149, 50);
		panel_1.add(lblCartItems);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 786, 235);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			    int i =table.getSelectedRow();
			      TableModel model = table.getModel();
			      
			  lblNewLabel.setText("Product Details");
			  lblNewLabel_1.setText    ("Product Brand :"+model.getValueAt(i, 2).toString());
			  label_4.setText("Product Price :"+model.getValueAt(i, 4).toString());
			  label_5.setText("Product Name:"+model.getValueAt(i, 3).toString());
			 
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.I", "Catagory", "Product Brand", "Product Name", "Product Price", "Description"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		JButton btnBuyNow = new JButton("Buy Now");
		btnBuyNow.setBackground(UIManager.getColor("Button.light"));
		btnBuyNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
			          
			          int i =table.getSelectedRow();
				      TableModel model = table.getModel();
				      
				      String name=(model.getValueAt(i, 2).toString());
				      String ID=(model.getValueAt(i, 3).toString());
				      String price=(model.getValueAt(i, 4).toString());
				      
				    
				      
				      String fullname       = textField.getText();
			          String email        = textField_1.getText();
			          String address       = textField_2.getText();
			          String quantity  =    textField_3.getText();	  
			        
			          String p_id       = ID;
			          String p_name        = name;
			          String p_price       = price;
			          
			         
			          
			          if(fullname.equals("")||email.equals("")||address.equals("")|| quantity.equals(""))
			  			{
			        	 JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			          
			          String query="INSERT INTO buy_item(`fullname`,`email`,`address`,`quantity`,`p_id`,`p_name`,`p_price`) "
				          		+ "VALUES (?,?,?,?,?,?,?)";
			          PreparedStatement stmt = con.prepareStatement(query);
			          
			            
			            stmt.setString(1, fullname);
				        stmt.setString(2, address);
				        stmt.setString(3, email);
			            stmt.setString(4, quantity);
				        stmt.setString(5, p_id);
				        stmt.setString(6, p_name);	  
				        stmt.setString(7, p_price);
				     
				      
				        
				        
				        
				         int x= stmt.executeUpdate();
			 
				        if (x > 0) {
				        	   String name4=(model.getValueAt(i, 2).toString());
				        	  JOptionPane.showMessageDialog(null, "You Have  Buy "+quantity+name4+"On cash On Delivery");	
						}
				        
				        con.close();
				        
				}}catch(Exception e1) {
			          System.out.println(e1);
			        }
				
			}
		});
		btnBuyNow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuyNow.setBounds(615, 541, 164, 39);
		panel_1.add(btnBuyNow);
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.setBackground(UIManager.getColor("Button.light"));
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Sales_homepage().setVisible(true);
			}
		});
		btnHomePage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHomePage.setBounds(256, 541, 164, 39);
		panel_1.add(btnHomePage);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(370, 309, 219, 33);
		panel_1.add(lblNewLabel);
		
		 lblNewLabel_1 = new JLabel("");
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(370, 353, 369, 32);
		panel_1.add(lblNewLabel_1);
		
		label_4 = new JLabel("");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(370, 427, 369, 32);
		panel_1.add(label_4);
		
	    label_5 = new JLabel("");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBounds(370, 396, 369, 32);
		panel_1.add(label_5);
		
		
		JLabel lblBuyerInformation = new JLabel("Buyer Information");
		lblBuyerInformation.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuyerInformation.setForeground(Color.WHITE);
		lblBuyerInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBuyerInformation.setBounds(52, 309, 219, 33);
		panel_1.add(lblBuyerInformation);
		
		JLabel lblNewLabel_2 = new JLabel(" Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(30, 351, 63, 30);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(122, 353, 149, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(35, 390, 77, 30);
		panel_1.add(lblAddress);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 390, 149, 25);
		panel_1.add(textField_1);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(35, 432, 77, 30);
		panel_1.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 430, 149, 25);
		panel_1.add(textField_2);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantity.setBounds(35, 472, 77, 30);
		panel_1.add(lblQuantity);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(122, 477, 149, 25);
		panel_1.add(textField_3);
		
		JButton btnRemoveCart = new JButton("Remove Cart");
		btnRemoveCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");

			          int row =table.getSelectedRow();
			          
			          String value =(table.getModel().getValueAt(row, 0).toString());
			          
			          String query="DELETE FROM `cart`WHERE id="+value;
			          
			        PreparedStatement stmt = con.prepareStatement(query);
			        
				     
				        stmt.executeUpdate();
			            DefaultTableModel model =(DefaultTableModel)table.getModel();
				        model.setRowCount(0);
				        show_product();
				        JOptionPane.showMessageDialog(null, "Product is Remove From Cart");
				        con.close();
			          }catch(Exception e1) {
			          System.out.println(e1);
			        }
			}
		});
		btnRemoveCart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveCart.setBackground(UIManager.getColor("Button.light"));
		btnRemoveCart.setBounds(430, 541, 164, 39);
		panel_1.add(btnRemoveCart);
		
		show_product();
	}
}
