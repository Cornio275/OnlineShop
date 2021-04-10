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
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;

public class adminreg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8122847805589000768L;
	/**
	 * 
	 */
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	String s;
	JLabel label1 = new JLabel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminreg frame = new adminreg();
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
	public adminreg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\software\\Online_store\\image\\Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 195, 152));
		panel_1.setBounds(0, 0, 201, 541);
		contentPane.add(panel_1);
		
		JLabel label_2 = new JLabel("");
		
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(40, 207, 129, 147);
		panel_1.add(label_2);

		
		
		
		
		label_2.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\admin reg.png"));
		
		JLabel lblMatikatdhakaCant = new JLabel("Matikata,Dhaka can't");
		lblMatikatdhakaCant.setForeground(Color.WHITE);
		lblMatikatdhakaCant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatikatdhakaCant.setBounds(30, 473, 129, 17);
		panel_1.add(lblMatikatdhakaCant);
		
		JLabel label_4 = new JLabel("stacksales@gmail.com");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(30, 501, 137, 17);
		panel_1.add(label_4);
		
		JLabel label = new JLabel("Stack Sales");
		label.setForeground(Color.WHITE);
		label.setBounds(40, 38, 151, 50);
		panel_1.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(199, 0, 545, 541);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFullName = new JLabel("Full Name  :");
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFullName.setBounds(140, 110, 103, 20);
		panel.add(lblFullName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(280, 110, 160, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("User Name :");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(140, 150, 103, 20);
		panel.add(label_1);
		
		JLabel label_5 = new JLabel("Email :");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(140, 190, 103, 20);
		panel.add(label_5);
		
		JLabel lblPin = new JLabel("OTP:");
		lblPin.setForeground(Color.WHITE);
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPin.setBounds(140, 390, 103, 20);
		panel.add(lblPin);
		
		JLabel label_6 = new JLabel("Password    :");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(140, 230, 103, 20);
		panel.add(label_6);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password  :");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmPassword.setBounds(140, 270, 141, 20);
		panel.add(lblConfirmPassword);
		
		JLabel label_7 = new JLabel("Phone :");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(140, 310, 103, 20);
		panel.add(label_7);
		
		JLabel lblNatinality = new JLabel("Nationality :");
		lblNatinality.setForeground(Color.WHITE);
		lblNatinality.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNatinality.setBounds(140, 348, 103, 20);
		panel.add(lblNatinality);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(280, 150, 160, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(280, 190, 160, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(280, 230, 160, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(280, 270, 160, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(280, 350, 160, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBackground(Color.WHITE);
		textField_6.setBounds(280, 310, 160, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(280, 390, 160, 20);
		panel.add(textField_7);   
		
		JButton button = new JButton("SignUp");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				
				
				try {
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");

			          String fname       = textField.getText();
			          String user_name   = textField_1.getText();
			          String email       = textField_2.getText();
			          String password    = textField_3.getText();
			          String cpassword   = textField_4.getText();
			          String nationality = textField_5.getText();
			          String phone       = textField_6.getText();
			          String otp = textField_7.getText();
			          
			          
			          
			          if(fname.equals("")||user_name.equals("")||email.equals("")|| password.equals("")||cpassword.equals("")||otp.equals(""))
			  			{
			        	 JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			        	  if(!password.equals(cpassword)){
			        		  JOptionPane.showMessageDialog(null, "Wrong Password"); 
			        	  }
			        	  else
			        		  {if(otp.equals("8798") && password.equals(cpassword)){
				          String query="INSERT INTO `admin_signup`(`fname`,`user_name`,`email`, `password`, `otp`,`phone`, `nationality`,Image) "
					          		+ "VALUES (?,?,?,?,?,?,?,?)";
				          PreparedStatement stmt = con.prepareStatement(query);
				          InputStream is = new FileInputStream(new File(s));
				        stmt.setString(1, fname);
				        stmt.setString(2, user_name);	  
				        stmt.setString(3, email);
				        stmt.setString(4, password);
				        stmt.setString(5,otp);
				        stmt.setString(6,phone);
				        stmt.setString(7,nationality);
				        stmt.setBlob(8,is);
				        
				         int x= stmt.executeUpdate();
			 
				        if (x > 0) {
							JOptionPane.showMessageDialog(null, "Registration Complete");
							new admin().setVisible(true);
						}
				        
				        con.close();
				        
			  			}
			        	  
			          else {
			        	  JOptionPane.showMessageDialog(null, "Wrong Otp Input");
			          }
			        	  
			        		  }

				     } }catch(Exception e1) {
			          System.out.println(e1);
			        }
				
				
			
				
				
			}
			
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(UIManager.getColor("Button.light"));
		button.setBounds(318, 480, 89, 29);
		panel.add(button);
		
		JButton button_1 = new JButton("Login");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin().setVisible(true);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBackground(UIManager.getColor("Button.light"));
		button_1.setBounds(158, 480, 100, 30);
		panel.add(button_1);
		
		JLabel label_8 = new JLabel("Picture :");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(140, 430, 77, 20);
		panel.add(label_8);
		
		JLabel label1 = new JLabel();
		label1.setBounds(230, 430, 45, 20);
		panel.add(label1);
		
		JButton button_2 = new JButton("Browse");
		button_2.addActionListener(new ActionListener() {
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
		button_2.setBounds(280, 431, 160, 20);
		panel.add(button_2);
		
		JLabel lblAdminRegistration = new JLabel("Admin Registration");
		lblAdminRegistration.setBounds(186, 50, 180, 22);
		panel.add(lblAdminRegistration);
		lblAdminRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminRegistration.setForeground(Color.WHITE);
		lblAdminRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		
	}
   

}