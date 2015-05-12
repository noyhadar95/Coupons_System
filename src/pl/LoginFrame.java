package pl;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dal.IDAL;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import bl.BL;
import bl.IBL;
import bl_backend.Customer;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

	private final int WINDOW_WIDTH = 700, WINDOW_HEIGHT = 550;
	private JPanel contentPane;
	private IBL bl;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		super("Coupons For You");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setContentPane(contentPane);
		
		bl = new BL();
		
		JButton btnLogin = new JButton("login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textFieldPassword.getText() == null || textFieldPassword.getText().equals("") ||
						textFieldUsername.getText() == null || textFieldUsername.getText().equals("")){
					JOptionPane.showMessageDialog((Component) e.getSource(),
							"enter all fields");
				}
				else{
					// pass the username and password that was entered to be check on the BL
					String tryUsername = textFieldUsername.getText();
					String tryPassword = textFieldPassword.getText();
					boolean success = bl.tryLogin(tryUsername, tryPassword);
					if(success){
						JOptionPane.showMessageDialog((Component) e.getSource(),
								"success");
					}
					else{
						JOptionPane.showMessageDialog((Component) e.getSource(),
								"incorrect information, please try again");
					}
				}
				
			}
		});
		
		JLabel lblWelcomeToCoupons = new JLabel("Welcome to Coupons For You");
		lblWelcomeToCoupons.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(202)
							.addComponent(lblWelcomeToCoupons))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(257)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(156)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addGap(38)
									.addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addGap(5)
									.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))))
					.addGap(163))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblWelcomeToCoupons, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(67)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(132))))
		);
		contentPane.setLayout(groupLayout);
		

		
	}
}

/*
 * 
 * public class LoginFrame extends JFrame implements ActionListener {
 * 
 * public LoginFrame(IDAL dal) {
 * 
 * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * this.getContentPane().setLayout(new BorderLayout());
 * this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
 * 
 * this.setResizable(false);
 * 
 * this.dal = dal;
 * 
 * this.getContentPane().add(new JPanel(), BorderLayout.CENTER);
 * 
 * this.setFocusable(true); this.setVisible(true);
 * 
 * }
 * 
 * }
 */