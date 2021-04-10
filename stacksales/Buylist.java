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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class Buylist extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2846869266815713056L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buylist frame = new Buylist();
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
	
	
	public ArrayList<Buy> buylist(){
		ArrayList<Buy> buylist = new ArrayList<>();
		

	          
		try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_discount","root","");
	          
	           String query="SELECT * FROM buy_item";
	           Statement stmt = con.createStatement();
	           ResultSet rs=stmt.executeQuery(query);
	        
	           Buy buy;
	        while (rs.next()){ 
	        	buy= new Buy(rs.getInt("id"),rs.getString("fullname"),rs.getString("email"),rs.getString("address"),rs.getString("p_name")
	        			,rs.getString("p_price"),rs.getString("p_id"),rs.getString("quantity"));
	        	buylist.add(buy);
           }
		
		
	          
             con.close(); 
        }catch (Exception e){ 
             
        } 
		return buylist;	
	}
	
	public void show_buylist() {
		ArrayList<Buy> list = buylist();
		DefaultTableModel model =(DefaultTableModel)table.getModel();
		
		Object[] row = new Object[8];
		
	for(int i=0;i<list.size();i++) {
		row[0]=list.get(i).getid();
		row[1]=list.get(i).getfullname();
		row[2]=list.get(i).getemail();
		row[3]=list.get(i).getaddress();
		row[4]=list.get(i).getp_name();
		row[5]=list.get(i).getp_id();
		row[6]=list.get(i).getp_price();
		row[7]=list.get(i).getquantity();
	
	
		
		model.addRow(row);
		
		
	}
	}
	
	
	
	
	public Buylist() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\software\\Online_store\\image\\Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 195, 152));
		panel_1.setBounds(0, 0, 1025, 511);
		contentPane.add(panel_1);
		
		JLabel lblOrderDetails = new JLabel("Order Details");
		lblOrderDetails.setForeground(Color.WHITE);
		lblOrderDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOrderDetails.setBounds(537, 61, 184, 45);
		panel_1.add(lblOrderDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(273, 144, 742, 195);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.I", "Buyer  Name", "Email", "Address", "Product Brand", "Product Name", "Product price", "Quantity"
			}
		) {
			/**
			 * 
			 */
			
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, String.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(474, 411, 46, 23);
		panel_1.add(label_16);
		
		JLabel label = new JLabel("Stack Sales");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(41, 11, 151, 50);
		panel_1.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(368, 451, 88, 29);
		panel_1.add(btnHome);
		btnHome.setForeground(UIManager.getColor("Button.foreground"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new admin_home().setVisible(true);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHome.setBackground(UIManager.getColor("Button.light"));
		
		JButton button = new JButton("Logout");
		button.setBounds(20, 415, 88, 30);
		panel_1.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin().setVisible(true);
			}
		});
		button.setForeground(UIManager.getColor("Button.foreground"));
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBackground(UIManager.getColor("Button.light"));
		
		JLabel label_2 = new JLabel("Matikata,Dhaka can't");
		label_2.setBounds(10, 456, 137, 17);
		panel_1.add(label_2);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("stacksales@gmail.com");
		label_3.setBounds(10, 483, 137, 17);
		panel_1.add(label_3);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_7 = new JLabel("User Name :");
		label_7.setBounds(20, 350, 74, 36);
		panel_1.add(label_7);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel label_1 = new JLabel("Admin Panel");
		label_1.setBounds(41, 73, 129, 22);
		panel_1.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\saleshomepgae.jpg"));
		label_4.setBounds(20, 144, 161, 195);
		panel_1.add(label_4);
		
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(582, 42, 139, 36);
		panel_1.add(label_5);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton = new JButton("Confirm Order");
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Order Processing Started");	
			}
		});
		btnNewButton.setBounds(513, 452, 129, 29);
		panel_1.add(btnNewButton);
		
		JButton btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Order canceled. Message send to customer");	
			}
		});
		btnCancelOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelOrder.setBackground(UIManager.getColor("Button.light"));
		btnCancelOrder.setBounds(688, 451, 129, 29);
		panel_1.add(btnCancelOrder);
		
		JLabel lblNewLabel = new JLabel("mim27");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(104, 361, 66, 14);
		panel_1.add(lblNewLabel);
		show_buylist();
	}
}
