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

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

import sl.ISL;
import sl.SL;

public class LoginFrame extends JFrame {

	private final int WINDOW_WIDTH = 700, WINDOW_HEIGHT = 550;
	private final String[] authTypes = { "Admin", "Customer", "Bussines Owner"};
	private JPanel contentPane;
	private ISL sl;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JComboBox authTypeCB;

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
		
		sl = new SL();
		
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
					String authType = (String) authTypeCB.getSelectedItem();
					boolean success = sl.tryLogin(tryUsername, tryPassword, authType);
					
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
		
		authTypeCB = new JComboBox(authTypes);
		
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(202)
							.addComponent(lblWelcomeToCoupons))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(156)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblPassword)
										.addGap(38)
										.addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))))
					.addGap(163))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(390, Short.MAX_VALUE)
					.addComponent(authTypeCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(256))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblWelcomeToCoupons, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(53)
					.addComponent(authTypeCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(groupLayout);
		

		
	}
	
}

