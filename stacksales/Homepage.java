package stacksales;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.UIManager;

public class Homepage extends JFrame {

	
	private static final long serialVersionUID = 8099972501946829634L;
	
	
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Homepage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\software\\Online_store\\image\\Logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 195, 152));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.setForeground(UIManager.getColor("CheckBox.light"));
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new admin().setVisible(true);
			}
		});
		btnNewButton.setBounds(112, 450, 100, 39);
		contentPane.add(btnNewButton);
		
		JButton btnUser = new JButton("User");
		btnUser.setForeground(UIManager.getColor("CheckBox.light"));
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new userlogin().setVisible(true);
				
			}
		});
		btnUser.setBackground(UIManager.getColor("Button.light"));
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUser.setBounds(330, 450, 100, 39);
		contentPane.add(btnUser);
		
		JButton btnVisitor = new JButton("Visitor");
		btnVisitor.setForeground(UIManager.getColor("CheckBox.light"));
		btnVisitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Visitor().setVisible(true);
			}
		});
		btnVisitor.setBackground(UIManager.getColor("Button.light"));
		btnVisitor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVisitor.setBounds(542, 450, 100, 39);
		contentPane.add(btnVisitor);
		
		JLabel label_5 = new JLabel("");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(99, 293, 140, 130);
		contentPane.add(label_5);	
;
		
		label_5.setIcon(new ImageIcon("F:\\software\\Online_store\\image\\admin.png"));
		
		JLabel label_6 = new JLabel("");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(316, 316, 130, 94);
		contentPane.add(label_6);
		
		
		label_6.setIcon(new ImageIcon("F:\\\\software\\\\Online_store\\\\image\\\\user.png"));
		
		JLabel label_7 = new JLabel("");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(527, 316, 130, 94);
		contentPane.add(label_7);
		
		
		
		label_7.setIcon(new ImageIcon("F:\\\\software\\\\Online_store\\\\image\\\\visitor.png"));
		
		
		JLabel lblWelcome = new JLabel("Stack Sales ");
		lblWelcome.setBounds(215, 21, 360, 39);
		contentPane.add(lblWelcome);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel label_1 = new JLabel("Find it, love it, buy it! ");
		label_1.setBounds(251, 71, 287, 39);
		contentPane.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	       
		
	}
}
