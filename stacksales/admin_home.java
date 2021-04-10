package stacksales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.UIManager;

public class admin_home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8954946178224104360L;

	private JPanel contentPane;
	
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
					admin_home frame = new admin_home();
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
	
	
	public admin_home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\software\\Online_store\\image\\Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 195, 152));
		panel.setBounds(0, 0, 200, 551);
		contentPane.add(panel);
		
		JLabel lblMatikatadhakaCant = new JLabel("Matikata,Dhaka can't");
		lblMatikatadhakaCant.setForeground(Color.WHITE);
		lblMatikatadhakaCant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatikatadhakaCant.setBounds(21, 495, 137, 17);
		panel.add(lblMatikatadhakaCant);
		
		JLabel label_4 = new JLabel("stacksales@gmail.com");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(21, 523, 137, 17);
		panel.add(label_4);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin().setVisible(true);
			}
		});
		btnLogout.setForeground(UIManager.getColor("Button.foreground"));
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setBackground(UIManager.getColor("Button.light"));
		btnLogout.setBounds(21, 454, 94, 30);
		panel.add(btnLogout);
		
		
		
		
		
		JLabel lblUsername = new JLabel("User Name :");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(21, 383, 74, 36);
		panel.add(lblUsername);
		
		JLabel lblSk = new JLabel("mim27");
		lblSk.setForeground(Color.WHITE);
		lblSk.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSk.setBounds(96, 383, 94, 36);
		panel.add(lblSk);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\saleshomepgae.jpg"));
		lblNewLabel.setBounds(21, 157, 160, 203);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("Stack Sales");
		label.setBounds(39, 24, 151, 50);
		panel.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 50, 67));
		panel_1.setBounds(198, 1, 559, 550);
		contentPane.add(panel_1);
		
		
		
		
		JButton btnNewButton = new JButton("Product Upload");
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductUpload().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(73, 280, 170, 47);
		panel_1.add(btnNewButton);
		
		JButton btnStockUpdate = new JButton("Stock Update");
		btnStockUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new product_update().setVisible(true);
			}
		});
		btnStockUpdate.setBackground(UIManager.getColor("Button.light"));
		btnStockUpdate.setForeground(new Color(0, 0, 0));
		btnStockUpdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnStockUpdate.setBounds(332, 280, 180, 47);
		panel_1.add(btnStockUpdate);
		
		
		
		JButton btnManageOders = new JButton("Product Delivery");
		btnManageOders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Buylist().setVisible(true);
			}
		});
		btnManageOders.setBackground(UIManager.getColor("Button.light"));
		btnManageOders.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnManageOders.setBounds(204, 450, 180, 47);
		panel_1.add(btnManageOders);
		
		JLabel label_1 = new JLabel("");
		
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(90, 160, 130, 94);
		panel_1.add(label_1);
		
		
		label_1.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\database.png"));
		
		JLabel label_2 = new JLabel("");
		
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(356, 160, 130, 94);
		panel_1.add(label_2);
		
		
		label_2.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\market.png"));
		
	
		JLabel label_7 = new JLabel("");
		
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(228, 345, 130, 94);
		panel_1.add(label_7);
		
		label_7.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\delivery.png"));
		
		table = new JTable();
		table.setBounds(27, 421, 1, 1);
		panel_1.add(table);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setBounds(228, 76, 129, 22);
		panel_1.add(lblAdminPanel);
		lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPanel.setForeground(Color.WHITE);
		lblAdminPanel.setFont(new Font("Tahoma", Font.BOLD, 18));
		show_user();
	}
}