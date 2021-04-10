package stacksales;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class ProductUpload extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	String s;
	JLabel label1 = new JLabel();
	private JTable table;
	
	public ArrayList<User> userlist(){
		ArrayList<User> userlist = new ArrayList<>();
		

	          
		try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
	          
	           String query="SELECT * FROM signup";
	           Statement stmt = con.createStatement();
	           ResultSet rs=stmt.executeQuery(query);
	        
	        User user;
	        while (rs.next()){ 
	        	user= new User(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("user_name")
	        			,rs.getString("password"),rs.getString("email"),rs.getString("phone"),rs.getBytes("Image"));
	        	userlist.add(user);
          
	        
	        	   
		      
	        }
		
		
	          
             con.close(); 
        }catch (Exception e){ 
             //Your exception handling mechanism goes here. 
        } 
		return userlist;	
	}
	public void show_user() {
		ArrayList<User> list = userlist();
		DefaultTableModel model =(DefaultTableModel)table.getModel();
		
		Object[] row = new Object[8];
		
	for(int i=0;i<list.size();i++) {
		row[0]=list.get(i).getid();
		row[1]=list.get(i).getfname();
		row[2]=list.get(i).getlname();
		row[3]=list.get(i).getuser_name();
		row[4]=list.get(i).getemail();
		row[5]=list.get(i).getpassword();
		row[6]=list.get(i).getphone();
		row[7]=list.get(i).getImage();
		model.addRow(row);
		
		
	}
	

	
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductUpload frame = new ProductUpload();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductUpload() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\software\\Online_store\\image\\Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 200, 511);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(30, 22, 151, 50);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Admin Panel");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(30, 71, 129, 22);
		panel.add(label_1);
		
		JLabel lblMatikatadhakaCant = new JLabel("Matikata,Dhaka can't");
		lblMatikatadhakaCant.setForeground(Color.WHITE);
		lblMatikatadhakaCant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatikatadhakaCant.setBounds(30, 440, 137, 17);
		panel.add(lblMatikatadhakaCant);
		
		JLabel label_3 = new JLabel("stacksales@gmail.com");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(30, 470, 137, 17);
		panel.add(label_3);
		
		JButton button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin().setVisible(true);
			}
		});
		button.setForeground(UIManager.getColor("Button.foreground"));
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(UIManager.getColor("Button.light"));
		button.setBounds(30, 395, 115, 30);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		
		
		
		
		
		lblNewLabel.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\saleshomepgae.jpg"));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 50, 67));
		panel_1.setBounds(198, 0, 611, 511);
		contentPane.add(panel_1);
		
		JLabel lblProductUpload = new JLabel("Product Upload");
		lblProductUpload.setForeground(Color.WHITE);
		lblProductUpload.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProductUpload.setBounds(210, 20, 211, 50);
		panel_1.add(lblProductUpload);
		
		JLabel lblCatagory = new JLabel("Catagory  :");
		lblCatagory.setForeground(Color.WHITE);
		lblCatagory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCatagory.setBounds(35, 250, 103, 20);
		panel_1.add(lblCatagory);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(165, 250, 131, 20);
		panel_1.add(comboBox);
		
		
		comboBox.addItem("Mobile Phone");
		comboBox.addItem("Men");
		comboBox.addItem("Women");
		comboBox.addItem("Electronics");
		comboBox.addItem("Vehicles");
		comboBox.addItem("Fashion");
		comboBox.addItem("Grocery");
		
		JLabel lblProductId = new JLabel("Product  Name :");
		lblProductId.setForeground(Color.WHITE);
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductId.setBounds(35, 295, 123, 20);
		panel_1.add(lblProductId);
		
		
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.GRAY);
		textField.setBounds(165, 295, 131, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblProductId_1 = new JLabel("Product  Brand :");
		lblProductId_1.setForeground(Color.WHITE);
		lblProductId_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductId_1.setBounds(35, 340, 123, 20);
		panel_1.add(lblProductId_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(165, 340, 131, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.GRAY);
		textField_2.setBounds(165, 385, 131, 20);
		panel_1.add(textField_2);
		
		JLabel lblProductPrice = new JLabel("Price :");
		lblProductPrice.setForeground(Color.WHITE);
		lblProductPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductPrice.setBounds(35, 385, 123, 20);
		panel_1.add(lblProductPrice);
		
		JLabel lblDiscount = new JLabel("Quantity:");
		lblDiscount.setForeground(Color.WHITE);
		lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiscount.setBounds(320, 250, 120, 20);
		panel_1.add(lblDiscount);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.GRAY);
		textField_3.setBounds(449, 250, 131, 20);
		panel_1.add(textField_3);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescription.setBounds(320, 295, 120, 20);
		panel_1.add(lblDescription);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.GRAY);
		textField_4.setBounds(449, 295, 131, 25);
		panel_1.add(textField_4);
		
		JLabel lblImage = new JLabel("Image :");
		lblImage.setForeground(Color.WHITE);
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImage.setBounds(320, 340, 120, 20);
		panel_1.add(lblImage);
		
		JLabel label1 = new JLabel("");
		label1.setBounds(159, 73, 292, 155);
		panel_1.add(label1);
		
		JButton btnNewButton = new JButton("Choose");
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		         JFileChooser fileChooser = new JFileChooser();
		         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             String path = selectedFile.getAbsolutePath();
		             label1.setIcon(ResizeImage(path));
		             s = path;
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("No Data");
		         }
		         
			}
			public ImageIcon ResizeImage(String imgPath){
		        ImageIcon MyImage = new ImageIcon(imgPath);
		        Image img = MyImage.getImage();
		        Image newImage = img.getScaledInstance(label1.getWidth(), label1.getHeight(),Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImage);
		        return image;
		    }
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(449, 339, 131, 23);
		panel_1.add(btnNewButton);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
			          
			          String catagory       = (String) comboBox.getSelectedItem();
			          String p_id       = textField.getText();
			          String p_name        = textField_1.getText();
			          String p_price       = textField_2.getText();
			          String p_fprice    = textField_3.getText();
			          String description   = textField_4.getText();

			          
			          
			          if(catagory.equals("")||p_id.equals("")||p_name.equals("")||p_price.equals("")|| p_fprice.equals("")||description.equals(""))
			  			{
			        	 JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			        	 
			        	  
				          String query="INSERT INTO product(catagory,`p_id`,`p_name`,`p_price`, `p_fprice`, `description`,Image) "
					          		+ "VALUES (?,?,?,?,?,?,?)";
				          PreparedStatement stmt = con.prepareStatement(query);
				          InputStream is = new FileInputStream(new File(s));
				         stmt.setString(1, catagory); 
				        stmt.setString(2, p_id);
				        stmt.setString(3, p_name);	  
				        stmt.setString(4, p_price);
				        stmt.setString(5, p_fprice);
				        stmt.setString(6,description);
				        stmt.setBlob(7,is);
				        
				         int x= stmt.executeUpdate();
			 
				        if (x > 0) {
							JOptionPane.showMessageDialog(null, "Product Upload Successfully");
							new admin_home().setVisible(true);
						}
				        
				        con.close();
				        
			  			}
			        	  
			          
			        	  
			        		  

				     } catch(Exception e1) {
			          System.out.println(e1);
			        }
				
				
				
			}
			
		});
		btnUpload.setBackground(UIManager.getColor("Button.light"));
		btnUpload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpload.setBounds(320, 448, 131, 37);
		panel_1.add(btnUpload);
		
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new admin_home().setVisible(true);
			}
		});
		btnHome.setBackground(UIManager.getColor("Button.light"));
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHome.setBounds(151, 448, 131, 37);
		panel_1.add(btnHome);
		
		table = new JTable();
		table.setBounds(38, 461, 1, 1);
		panel_1.add(table);
		show_user();
	}
}
