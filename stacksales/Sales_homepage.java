package stacksales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JComboBox;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class Sales_homepage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2484667656138489338L;
	private JPanel contentPane;
	private JTable table;
	JLabel lblNewLabel ;
	JLabel label_1;
	JLabel label_6;
	JLabel label_7 ;
	JLabel label_8 ;
	
	String s;

	private JLabel image_label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales_homepage frame = new Sales_homepage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public ArrayList<Product> productlist(){
		ArrayList<Product> productlist = new ArrayList<>();
		

	          
		try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
	          
	           String query="SELECT * FROM product";
	           Statement stmt = con.createStatement();
	           ResultSet rs=stmt.executeQuery(query);
	        
	        Product product;
	        while (rs.next()){ 
	        	product= new Product(rs.getInt("id"),rs.getString("catagory"),rs.getString("p_id"),rs.getString("p_name")
	        			,rs.getString("p_price"),rs.getString("p_fprice"),rs.getString("description"),rs.getBytes("Image"));
	        	productlist.add(product);
           }
		
		
	          
             con.close(); 
        }catch (Exception e){ 
             //Your exception handling mechanism goes here. 
        } 
		return productlist;	
	}
	
	public void show_product() {
		ArrayList<Product> list = productlist();
		DefaultTableModel model =(DefaultTableModel)table.getModel();
		
		Object[] row = new Object[8];
		
	for(int i=0;i<list.size();i++) {
		row[0]=list.get(i).getid();
		row[1]=list.get(i).getcatagory();
		row[2]=list.get(i).getp_name();
		row[3]=list.get(i).getp_id();
		row[4]=list.get(i).getp_price();
		row[5]=list.get(i).getp_fprice();
		row[6]=list.get(i).getdescription();
		row[7]=list.get(i).getImage();
		model.addRow(row);
		
		
	}
	}
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public Sales_homepage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\software\\Online_store\\image\\Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 186, 591);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(20, 22, 151, 50);
		panel.add(label);
		
		JLabel label_2 = new JLabel("Matikata,Dhaka can't");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(18, 535, 129, 17);
		panel.add(label_2);
		
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
		button.setBounds(20, 492, 107, 30);
		panel.add(button);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(20, 185, 137, 195);
		panel.add(label_4);
		
		
		
        
		
		
		label_4.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\user.png"));
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(93, 446, -44, 22);
		panel.add(textArea);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 50, 67));
		panel_1.setBounds(181, 0, 711, 591);
		contentPane.add(panel_1);
		
		JLabel lblOurProducts = new JLabel("Our Products");
		lblOurProducts.setForeground(Color.WHITE);
		lblOurProducts.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblOurProducts.setBounds(275, -1, 219, 50);
		panel_1.add(lblOurProducts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 678, 237);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			      int i =table.getSelectedRow();
			      TableModel model = table.getModel();
			      label_1.setText("Product Details");
				
				lblNewLabel.setText    ("Product Name :"+model.getValueAt(i, 3).toString());
			    label_6.setText("Product Price :"+model.getValueAt(i, 4).toString());
				label_7.setText("Product Brand:"+model.getValueAt(i, 2).toString());
				label_8.setText("Description:"+model.getValueAt(i, 6).toString());
				
			ImageIcon image = new ImageIcon(new ImageIcon(productlist().get(i).getImage()).getImage().getScaledInstance(image_label.getWidth(), image_label.getHeight(),Image.SCALE_SMOOTH));
			image_label.setIcon(image);     
				      
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.I", "Catagory", "Product Brand", "Product Name", "Product Price", "Quantity", "Description"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(30, 365, 270, 23);
		panel_1.add(lblNewLabel);
		
		label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_1.setBounds(237, 308, 219, 33);
		panel_1.add(label_1);
		
		 label_6 = new JLabel("");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(30, 405, 270, 23);
		panel_1.add(label_6);
		
		label_7 = new JLabel("");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(30, 445, 270, 23);
		panel_1.add(label_7);
		
		label_8 = new JLabel("");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(30, 485, 270, 23);
		panel_1.add(label_8);
		
		image_label = new JLabel("");
		image_label.setBackground(Color.BLACK);
		image_label.setBounds(410, 365, 270, 147);
		panel_1.add(image_label);
		
		JButton btnNewButton = new JButton("Add to Card");
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				try {
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
			          
			          int i =table.getSelectedRow();
				      TableModel model = table.getModel();
				      
				      String cat=(model.getValueAt(i, 1).toString());
				      String ID=(model.getValueAt(i, 3).toString());
				      String name=(model.getValueAt(i, 2).toString());
				      String price=(model.getValueAt(i, 4).toString());
				      String quan=(model.getValueAt(i, 5).toString());
				      String des=(model.getValueAt(i, 6).toString());
				      
				    		  
			          String catagory       = cat;
			          String p_id       = ID;
			          String p_name        = name;
			          String p_price       = price;
			          String quantity    = quan;
			          String description   = des;
			          
			          if(catagory.equals("")||p_id.equals("")||p_name.equals("")||p_price.equals("")|| quantity.equals("")||description.equals(""))
			  			{
			        	 JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			          
			          String query="INSERT INTO cart(catagory,`p_id`,`p_name`,`p_price`, `quantity`, `description`) "
				          		+ "VALUES (?,?,?,?,?,?)";
			          PreparedStatement stmt = con.prepareStatement(query);
			          
				        stmt.setString(1, catagory); 
				        stmt.setString(2, p_id);
				        stmt.setString(3, p_name);	  
				        stmt.setString(4, p_price);
				        stmt.setString(5, quantity);
				        stmt.setString(6,description);
				        
				        
				        
				         int x= stmt.executeUpdate();
			 
				        if (x > 0) {
							JOptionPane.showMessageDialog(null, "Cart Add Successfully");
							new Sales_homepage().setVisible(true);
						}
				        
				        con.close();
				        
				}}catch(Exception e1) {
			          System.out.println(e1);
			        }
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(158, 541, 164, 39);
		panel_1.add(btnNewButton);
		
		JButton btnBuyNow = new JButton("Buy Now");
		btnBuyNow.setBackground(UIManager.getColor("Button.light"));
	
		btnBuyNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int i =table.getSelectedRow();
			      TableModel model = table.getModel();
			      
			     
			      String name=(model.getValueAt(i, 3).toString());
			   
			      JOptionPane.showMessageDialog(null, "You Have  Buy "+name+"\nPay On Delivery Time");		  
		     
				
			}
		});
		btnBuyNow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuyNow.setBounds(503, 541, 164, 39);
		panel_1.add(btnBuyNow);
		
		JButton btnCardItems = new JButton("Card Items");
		btnCardItems.setBounds(345, 541, 129, 39);
		panel_1.add(btnCardItems);
		btnCardItems.setBackground(UIManager.getColor("Button.light"));
		btnCardItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CartItem().setVisible(true);
			}
		});
		btnCardItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		show_product();
	}
}
