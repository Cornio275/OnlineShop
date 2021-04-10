package stacksales;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;

public class admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7179185206559299668L;

	private JPanel contentPane;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JLabel label_8;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\software\\Online_store\\image\\Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 191, 512);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 195, 152));
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(31, 212, 129, 147);
		panel_1.add(label_1);
		label_1.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\admin login.png"));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAdminLogin = new JLabel("Admin");
		lblAdminLogin.setBounds(21, 370, 139, 50);
		panel_1.add(lblAdminLogin);
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setForeground(Color.WHITE);
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 195, 152));
		panel_2.setBounds(191, 1, 537, 511);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		
		JLabel label_5 = new JLabel("User Name  :");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_5.setBounds(10, 210, 101, 25);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("Password    :");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_6.setBounds(10, 315, 101, 25);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Email          :");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_7.setBounds(11, 266, 100, 25);
		panel_2.add(label_7);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(136, 210, 141, 25);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(136, 316, 141, 23);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(136, 267, 141, 23);
		panel_2.add(textField_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			private String welcomeName;
	

			public void actionPerformed(ActionEvent e) {
				
				try {
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
			          Statement stmt = con.createStatement();
			          
			          String user_name =textField.getText();
			          String password =textField_1.getText(); 
			          String email =textField_2.getText().toString();
			          
			          if(email.equals("")||user_name.equals("")|| password.equals(""))
			  			{JOptionPane.showMessageDialog(null, "Please Input First");
			  			
			  			}
			          else {
			          
			          String sql="SELECT * FROM admin_signup WHERE  user_name='"+user_name+"'and password='"+password+"' and email='"+email+"'";
			  
			         
			           
			          ResultSet rs=stmt.executeQuery(sql);
			          if( rs.next())
			          {
			        	  
			        	  welcomeName = rs.getString("fname");
			        	  
				            JOptionPane.showMessageDialog(null, "Welcome "+welcomeName);
				        	  JOptionPane.showMessageDialog(null, "Login Successful");
				               new admin_home().setVisible(true);
					
					
				         }
			          else if( !rs.next())
				        	
			  			{JOptionPane.showMessageDialog(null, "Wrong info");}
			        	  
			        con.close();
			        }
			          }catch(Exception e1) {
			          System.out.println(e1);
			        }
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setBounds(136, 369, 100, 30);
		panel_2.add(btnNewButton);
		
		JButton btnRegistration = new JButton("SignUp");
		btnRegistration.setBounds(409, 470, 118, 30);
		panel_2.add(btnRegistration);
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new adminreg().setVisible(true);
			}
		});
		btnRegistration.setForeground(UIManager.getColor("Button.foreground"));
		btnRegistration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistration.setBackground(UIManager.getColor("Button.light"));
		
		JLabel label = new JLabel("Stack Sales");
		label.setBounds(105, 24, 219, 50);
		panel_2.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));

	

	}
}
