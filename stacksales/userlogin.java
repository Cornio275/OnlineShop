package stacksales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
//import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class userlogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4496325850991596010L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public static String welcomeName = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlogin frame = new userlogin();
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
	public userlogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\software\\Online_store\\image\\Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelimage = new JLabel("");
		labelimage.setBounds(0, 0, 790, 545);
		labelimage.setBackground(Color.BLACK);
		ImageIcon icon = new ImageIcon ("D:\\Level 2 Term 1\\Java\\Poject\\Project Image\\pexels3.png");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(labelimage.getWidth(), labelimage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon  ScaledIcon = new ImageIcon(imgScale);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 728, 511);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
	
		labelimage.setIcon(ScaledIcon);
		contentPane.add(labelimage);
	
		

		JLabel lblNewLabel = new JLabel("Stack Sales");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(269, 36, 161, 57);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(363, 233, 141, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(229, 283, 100, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblUserName = new JLabel("Email  :");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUserName.setBounds(229, 230, 101, 25);
		panel.add(lblUserName);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(363, 286, 141, 23);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(363, 341, 141, 23);
		panel.add(textField_2);
		
		JLabel lblPassword = new JLabel("Password    :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(228, 338, 101, 25);
		panel.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
			          Statement stmt = con.createStatement();
			          
			          String email =textField.getText();
			          String user_name =textField_1.getText(); 
			          String password =textField_2.getText().toString();
			          
			          if(email.equals("")||user_name.equals("")|| password.equals(""))
			  			{JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			          
			          String sql="SELECT * FROM signup WHERE email='"+email+"'and user_name='"+user_name+"'and password='"+password+"'";
			  
			         
			           
			          ResultSet rs=stmt.executeQuery(sql);
			          if( rs.next())
			          {   
			        	  welcomeName = rs.getString("fname");
			        	  String welcomeName2 = rs.getString("lname");
			        	  
			        	  JOptionPane.showMessageDialog(null, "Login Successful");
			        	  JOptionPane.showMessageDialog(null, "Welcome " +welcomeName +welcomeName2  );
					 new Sales_homepage().setVisible(true);
					
					
				         }
			          else if( !rs.next())
				        	
			  			{JOptionPane.showMessageDialog(null, "Wrong Password");}
			        	  
			        con.close();
			        }
			          }catch(Exception e1) {
			          System.out.println(e1);
			        }
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(363, 395, 100, 30);
		panel.add(btnNewButton);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new usersignup().setVisible(true);
			}
		});
		btnSignup.setBackground(UIManager.getColor("Button.light"));
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSignup.setBounds(615, 470, 100, 30);
		panel.add(btnSignup);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\user.png"));
		
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(43, 230, 130, 108);
		panel.add(label);
		
		JLabel lblUserLogin = new JLabel("User");
		lblUserLogin.setForeground(Color.WHITE);
		lblUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserLogin.setBounds(86, 340, 161, 57);
		panel.add(lblUserLogin);
	}
}
