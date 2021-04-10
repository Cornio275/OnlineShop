package stacksales;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//import java.awt.SystemColor;

//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.awt.event.ActionEvent;


import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.UIManager;
import java.awt.Toolkit;


public class usersignup extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -388296093231620310L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	
	private final JLabel lblNewLabel_1 = new JLabel("Stack Sales");
	JLabel labelimage;
	private final JLabel image = new JLabel("");
	private final JLabel lblNewLabel_2 = new JLabel("Matikata,Dhaka can't");
	private final JLabel lblStacksalesgmailcom = new JLabel("stacksales@gmail.com");
	private final JLabel lblNewLabel_3 = new JLabel("First Name :");
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_6 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JTextField textField_4 = new JTextField();
	private final JTextField textField_5 = new JTextField();
	private final JTextField textField_7 = new JTextField();
	private final JLabel lblEmail = new JLabel("Email :");
	private final JLabel lblLastName = new JLabel("Last Name :");
	private final JLabel lblUserName = new JLabel("User Name :");
	private final JLabel lblPassword = new JLabel("Password    :");
	private final JLabel lblConfirmPassword = new JLabel("Confirm Password :");
	private final JLabel lblPhone = new JLabel("Phone :");
	private final JButton btnNewButton = new JButton("SignUp");
	private final JButton btnLogin = new JButton("Login");
	String s;
	JLabel label1 = new JLabel();
	private final JLabel lblNewLabel_4 = new JLabel("UserSignUp");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usersignup frame = new usersignup();
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
	public usersignup() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\software\\Online_store\\image\\Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 215, 511);
		contentPane.add(panel);
		panel.setLayout(null);
		image.setFont(new Font("Tahoma", Font.PLAIN, 15));
		image.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\stack.png"));
		image.setBounds(33, 179, 130, 124);
		
		panel.add(image);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(33, 433, 130, 17);
		
		panel.add(lblNewLabel_2);
		lblStacksalesgmailcom.setForeground(Color.WHITE);
		lblStacksalesgmailcom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStacksalesgmailcom.setBounds(33, 461, 137, 17);
		
		panel.add(lblStacksalesgmailcom);
		btnLogin.setBounds(33, 393, 89, 29);
		panel.add(btnLogin);
		btnLogin.setForeground(UIManager.getColor("CheckBox.light"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new userlogin().setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBackground(UIManager.getColor("Button.light"));
		lblNewLabel_1.setBounds(33, 32, 151, 50);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 195, 152));
		panel_1.setBounds(212, 0, 622, 511);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		lblNewLabel_3.setBounds(84, 138, 103, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		
		panel_1.add(lblNewLabel_3);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setBounds(221, 139, 141, 23);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setColumns(10);
		
		panel_1.add(textField_1);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_6.setBounds(221, 310, 141, 23);
		textField_6.setColumns(10);
		
		panel_1.add(textField_6);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setBounds(221, 173, 141, 23);
		textField_2.setColumns(10);
		
		panel_1.add(textField_2);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_3.setBounds(221, 208, 141, 23);
		textField_3.setColumns(10);
		
		panel_1.add(textField_3);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_4.setBounds(221, 242, 141, 23);
		textField_4.setColumns(10);
		
		panel_1.add(textField_4);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_5.setBounds(221, 276, 141, 23);
		textField_5.setColumns(10);
		
		panel_1.add(textField_5);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_7.setBounds(221, 344, 141, 23);
		textField_7.setColumns(10);
		
		panel_1.add(textField_7);
		lblEmail.setBounds(84, 309, 103, 20);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panel_1.add(lblEmail);
		lblLastName.setBounds(84, 173, 103, 20);
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panel_1.add(lblLastName);
		lblUserName.setBounds(84, 207, 103, 20);
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panel_1.add(lblUserName);
		lblPassword.setBounds(84, 241, 103, 20);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panel_1.add(lblPassword);
		lblConfirmPassword.setBounds(80, 275, 135, 20);
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panel_1.add(lblConfirmPassword);
		lblPhone.setBounds(84, 343, 103, 20);
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panel_1.add(lblPhone);
		
		JLabel lblImage = new JLabel("Picture :");
		lblImage.setBounds(84, 383, 103, 20);
		lblImage.setForeground(Color.WHITE);
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblImage);
		
		panel_1.add(label1);
		label1.setBounds(305, 380, 45, 23);
		
		JButton button = new JButton("Browse");
		button.setForeground(UIManager.getColor("CheckBox.light"));
		button.setBounds(221, 384, 141, 23);
		button.addActionListener(new ActionListener() {
			

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

			
		});
		panel_1.add(button);
		btnNewButton.setBounds(221, 434, 89, 29);
		panel_1.add(btnNewButton);
		btnNewButton.setForeground(UIManager.getColor("CheckBox.light"));
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.addActionListener(new ActionListener() {
			
			
			

		

		

			public void actionPerformed(ActionEvent e) {
				
				try {
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");

			          String fname       = textField_1.getText();
			          String lname       = textField_2.getText();
			          String user_name   = textField_3.getText();
			          String password    = textField_4.getText();
			          String cpassword   = textField_5.getText();
			          String email       = textField_6.getText();
			          String phone       = textField_7.getText();
			          
			          if(fname.equals("")||lname.equals("")||user_name.equals("")|| password.equals("")||cpassword.equals("")||email.equals(""))
			  			{
			        	 JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			        	  
			        	  if(!password.equals(cpassword)){
			        		  JOptionPane.showMessageDialog(null, "Different Password "); 
			        	  }
			        	  
			        	  else {
			        	  
			          String query="INSERT INTO `signup`(`fname`, `lname`, `user_name`, `password`, `email`, `phone`,Image) "
				          		+ "VALUES (?,?,?,?,?,?,?)";
			          PreparedStatement stmt = con.prepareStatement(query);
			          InputStream is = new FileInputStream(new File(s));
			          
			        stmt.setString(1, fname);
			        stmt.setString(2, lname);	  
			        stmt.setString(3, user_name);
			        stmt.setString(4, password);
			        stmt.setString(5, email);
			        stmt.setString(6, phone);
			        stmt.setBlob(7,is);
			        
			        
			         int x= stmt.executeUpdate();
		 
			        if (x > 0) {
						JOptionPane.showMessageDialog(null, "Registration Complete");
						new userlogin().setVisible(true);
	                   
	                    }
			        con.close();
			        }
			          }
				     } catch(Exception e1) {
			          System.out.println(e1);
			        }
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(163, 69, 99, 31);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		
		
	}
	
    public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(label1.getWidth(), label1.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
}