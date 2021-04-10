package stacksales;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
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
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class product_update extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7892827024281110123L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTable table_1;
	
	String s;
	JLabel label1 = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					product_update frame = new product_update();
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
	          
	          
	           String query="SELECT * FROM product" ;
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
		DefaultTableModel model =(DefaultTableModel)table_1.getModel();
		
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
	public product_update() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\software\\Online_store\\image\\Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 167, 551);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(10, 11, 151, 50);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Admin Panel");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(10, 72, 129, 22);
		panel.add(label_1);
		
		JLabel lblMatikatadhakaCant = new JLabel("Matikata,Dhaka can't");
		lblMatikatadhakaCant.setForeground(Color.WHITE);
		lblMatikatadhakaCant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatikatadhakaCant.setBounds(20, 495, 137, 17);
		panel.add(lblMatikatadhakaCant);
		
		JLabel label_3 = new JLabel("stacksales@gmail.com");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(20, 523, 137, 17);
		panel.add(label_3);
		
		JButton button = new JButton("Logout");
		button.setForeground(UIManager.getColor("Button.foreground"));
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(UIManager.getColor("Button.light"));
		button.setBounds(20, 454, 91, 30);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 126, 142, 219);
		panel.add(lblNewLabel);
		
		
		
		
		
		
		
		lblNewLabel.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\buy list.jpg"));
		
		JLabel label_14 = new JLabel("User Name :");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(10, 356, 74, 36);
		panel.add(label_14);
		
		JLabel lblMim = new JLabel("mim27");
		lblMim.setForeground(Color.WHITE);
		lblMim.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMim.setBounds(86, 356, 108, 36);
		panel.add(lblMim);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 50, 67));
		panel_1.setBounds(167, 0, 867, 551);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProductInformatiom = new JLabel("Product Update");
		lblProductInformatiom.setBounds(320, 11, 273, 50);
		lblProductInformatiom.setForeground(Color.WHITE);
		lblProductInformatiom.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblProductInformatiom);
		
		JLabel label_5 = new JLabel("Catagory  :");
		label_5.setBounds(10, 304, 103, 20);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(label_5);
		
		JComboBox combo = new JComboBox();
		combo.setBounds(123, 306, 131, 20);
		combo.setBackground(Color.WHITE);
		panel_1.add(combo);
		
		combo.addItem("Mobile Phone");
		combo.addItem("Men");
		combo.addItem("Women");
		combo.addItem("Electronics");
		combo.addItem("Vehicles");
		combo.addItem("grocery");
		JLabel lblProductName = new JLabel("Product  Name:");
		lblProductName.setBounds(10, 375, 123, 20);
		lblProductName.setForeground(Color.WHITE);
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblProductName);
		
		textField = new JTextField();
		textField.setBounds(123, 344, 131, 20);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(Color.GRAY);
		panel_1.add(textField);
		
		JLabel lblProductBrand = new JLabel("Product  Brand:");
		lblProductBrand.setBounds(10, 344, 123, 20);
		lblProductBrand.setForeground(Color.WHITE);
		lblProductBrand.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblProductBrand);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 375, 131, 20);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(123, 406, 131, 20);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.GRAY);
		panel_1.add(textField_2);
		
		JLabel lblProductQuantity = new JLabel("price:");
		lblProductQuantity.setBounds(10, 406, 131, 20);
		lblProductQuantity.setForeground(Color.WHITE);
		lblProductQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblProductQuantity);
		
		JLabel label_9 = new JLabel("Quantity :");
		label_9.setBounds(10, 437, 103, 20);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(label_9);
		
		textField_3 = new JTextField();
		textField_3.setBounds(123, 437, 131, 20);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.GRAY);
		panel_1.add(textField_3);
		
		JLabel label_10 = new JLabel("Description :");
		label_10.setBounds(10, 468, 103, 20);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(label_10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(123, 468, 131, 20);
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.GRAY);
		panel_1.add(textField_4);
		
		JLabel label_11 = new JLabel("Image :");
		label_11.setBounds(10, 500, 103, 20);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(10, 72, 244, 207);
		panel_1.add(label_12);
		
		JButton button_1 = new JButton("Choose");
		button_1.setBackground(UIManager.getColor("Button.light"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		         JFileChooser fileChooser = new JFileChooser();
		         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             String path = selectedFile.getAbsolutePath();
		             label_12.setIcon(ResizeImage(path));
		             s = path;
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("No Data");
		         }
			}
			public ImageIcon ResizeImage(String imgPath){
		        ImageIcon MyImage = new ImageIcon(imgPath);
		        Image img = MyImage.getImage();
		        Image newImage = img.getScaledInstance(label_12.getWidth(), label_12.getHeight(),Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImage);
		        return image;
		    }
		});
		button_1.setBounds(123, 499, 131, 23);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(button_1);
		
		JButton btnUpdate = new JButton("Save");
		btnUpdate.setBounds(736, 482, 110, 38);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
			          
			          String catagory       = (String) combo.getSelectedItem();
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
							JOptionPane.showMessageDialog(null, "Product Update Successfully");
							new admin_home().setVisible(true);
						}
				        
				        con.close();
				        
				}}catch(Exception e1) {
			          System.out.println(e1);
			        }
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBackground(UIManager.getColor("Button.light"));
		panel_1.add(btnUpdate);
		
		JButton button_3 = new JButton("Home");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_home().setVisible(true);
			}
		});
		button_3.setBounds(306, 482, 110, 38);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_3.setBackground(UIManager.getColor("Button.light"));
		panel_1.add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 72, 593, 306);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
			      int i =table_1.getSelectedRow();
			      TableModel model = table_1.getModel();
			      
                  textField.setText(model.getValueAt(i, 2).toString());
			      textField_1.setText(model.getValueAt(i, 3).toString());
			      textField_2.setText(model.getValueAt(i, 4).toString());
			      textField_3.setText(model.getValueAt(i, 5).toString());
			      textField_4.setText(model.getValueAt(i, 6).toString());
			      
		
			      
			      ImageIcon image = new ImageIcon(new ImageIcon(productlist().get(i).getImage()).getImage().getScaledInstance(label_12.getWidth(), label_12.getHeight(),Image.SCALE_SMOOTH));
			      label_12.setIcon(image);     
			      
	      
			      
			}
		        
		     
		        
		    
		    
			
		});
		
		
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.I", "Catagory", "Product Brand", "Product Name", "Product Price", "Quantity", "Description"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(83);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(79);
		scrollPane.setViewportView(table_1);
		
		
		JButton button_2 = new JButton("Update");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");

			          int row =table_1.getSelectedRow();
			          
			          String value =(table_1.getModel().getValueAt(row, 0).toString());
			          
			          String query="UPDATE `product` SET `catagory`=?,`p_id`=?,`p_name`=?,`p_price`=?,`p_fprice`=?,`description`=?,`Image`=? WHERE id="+value;
			          
			        PreparedStatement stmt = con.prepareStatement(query);
			        
			          String catagory       = (String) combo.getSelectedItem();
			          String p_id       = textField.getText();
			          String p_name        = textField_1.getText();
			          String p_price       = textField_2.getText();
			          String p_fprice    = textField_3.getText();
			          String description   = textField_4.getText();
				    
			          InputStream is = new FileInputStream(new File(s));
				        stmt.setString(1, catagory); 
				        stmt.setString(2, p_id);
				        stmt.setString(3, p_name);	  
				        stmt.setString(4, p_price);
				        stmt.setString(5, p_fprice);
				        stmt.setString(6,description);
				        stmt.setBlob(7,is);
				     
				        stmt.executeUpdate();
			            DefaultTableModel model =(DefaultTableModel)table_1.getModel();
				        model.setRowCount(0);
				        show_product();
				        JOptionPane.showMessageDialog(null, "Product Update Successfully");
				        con.close();
			          }catch(Exception e1) {
			          System.out.println(e1);
			        }
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_2.setBackground(UIManager.getColor("Button.light"));
		button_2.setBounds(456, 482, 110, 38);
		panel_1.add(button_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");

			          int row =table_1.getSelectedRow();
			          
			          String value =(table_1.getModel().getValueAt(row, 0).toString());
			          
			          String query="DELETE FROM `product`WHERE id="+value;
			          
			        PreparedStatement stmt = con.prepareStatement(query);
			        
				     
				        stmt.executeUpdate();
			            DefaultTableModel model =(DefaultTableModel)table_1.getModel();
				        model.setRowCount(0);
				        show_product();
				        JOptionPane.showMessageDialog(null, "Product Delete Successfully");
				        con.close();
			          }catch(Exception e1) {
			          System.out.println(e1);
			        }
			}
			
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBackground(UIManager.getColor("Button.light"));
		btnDelete.setBounds(598, 482, 110, 38);
		panel_1.add(btnDelete);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(474, 411, 46, 23);
		panel_1.add(label_4);
		
		show_product();
	}
}
