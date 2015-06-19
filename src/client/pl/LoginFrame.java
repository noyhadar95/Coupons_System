package pl;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import bl_backend.EmailSender;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

import sl.ISL;
import sl.SL;

public class LoginFrame extends JFrame {

	static final String COMPANY_NAME = "Coupons For You";
	static final String COMPANY_EMAIL = "couponsforyouapp";
	private final int WINDOW_WIDTH = 700, WINDOW_HEIGHT = 550;
	private final String[] authTypes = {"Customer", "Admin", "Bussines Owner"};
	private JPanel contentPane;
	private ISL sl;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JComboBox authTypeCB;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JButton btnForgotPass;
	private JButton btnBack;
	private	JButton btnLogin;

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
		super(COMPANY_NAME);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setContentPane(contentPane);
		
		sl = new SL();
		
		btnLogin = new JButton("login");
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
						switch (authType) {
						case "Customer":
							JFrame customerFrame = new CustomerMain(sl);
							customerFrame.setLocation(getLocation()); 
							customerFrame.setVisible(true);
							// close current frame
							setVisible(false);
							break;
						case "Admin":
							JFrame adminFrame = new MainAdminFrame(sl);
							adminFrame.setLocation(getLocation()); 
							adminFrame.setVisible(true);
							// close current frame
							setVisible(false);
							break;
						case "Bussines Owner":
							JFrame ownerFrame = new BusinessOwnerMain(sl);
							ownerFrame.setLocation(getLocation()); 
							ownerFrame.setVisible(true);
							// close current frame
							setVisible(false);
							break;
						default:
							break;
						}
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
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldPassword.setColumns(10);
		
		authTypeCB = new JComboBox(authTypes);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setVisible(false);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldPhone.setColumns(10);
		textFieldPhone.setVisible(false);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setVisible(false);
		
		lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setVisible(false);
		
		JButton btnSignUp = new JButton("sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldPassword.getText() == null || textFieldPassword.getText().equals("") ||
						textFieldUsername.getText() == null || textFieldUsername.getText().equals("")){
					JOptionPane.showMessageDialog((Component) e.getSource(),
							"enter all fields in order to sign up");
				}
				else if(textFieldEmail.getText() == null || textFieldEmail.getText().equals("") ||
						!textFieldEmail.isVisible() || textFieldPhone.getText() == null ||
						textFieldPhone.getText().equals("") || !textFieldPhone.isVisible()){
					setSignUpPanelVisibility(true);
					JOptionPane.showMessageDialog((Component) e.getSource(),
							"enter all fields in order to sign up");
				}
				else{
					
					String authType = (String) authTypeCB.getSelectedItem();
					if(!authType.equals("Customer")){
						JOptionPane.showMessageDialog((Component) e.getSource(),
								"sign up could be done only as a customer, please try again");
					}
					else{
						trySignUp(e);
					}
					
				}
			}

			private void trySignUp(ActionEvent e) {
				String username = textFieldUsername.getText();
				String password = textFieldPassword.getText();
				String email = textFieldEmail.getText();
				String phone = textFieldPhone.getText();
				
				boolean isStrongPass = checkStrongPass(password);
				
				if(!isStrongPass){
					JOptionPane.showMessageDialog((Component) e.getSource(),
							"your password is not strong enough.\nA strong password contains digits "+
								"and lettes and it's length is at least 5.");
				}
				else{
					// the password is strong
					boolean success = sl.signUp(username, password, email, phone);
					if(success){
						setSignUpPanelVisibility(false);
						JOptionPane.showMessageDialog((Component) e.getSource(),
								"you are now signed up to 'coupons for you'\ntry to login to your new account");
						textFieldUsername.setText("");;
						textFieldPassword.setText("");
					}
					else{
						JOptionPane.showMessageDialog((Component) e.getSource(),
								"incorrect information, please try again");
					}
				}
				
			}
			
			boolean checkStrongPass(String password){
				if(password.length()<5)
					return false;
				
				boolean foundDigit=false,foundLetter=false;
				for(int i=0; i<password.length(); i++){
					if(password.charAt(i)>'0' && password.charAt(i)<'9'){
						foundDigit=true;
					}
					if((password.charAt(i)>'a' && password.charAt(i)<'z') ||
							(password.charAt(i)>'A' && password.charAt(i)<'Z')){
						foundLetter=true;
					}
				}
				return (foundDigit && foundLetter);
			}

			
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnForgotPass = new JButton("forgot my password");
		btnForgotPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldUsername.getText() == null || textFieldUsername.getText().equals("")){
					JOptionPane.showMessageDialog((Component) e.getSource(),
							"enter your username and we will send your password to your email");
				}
				else{
					String username = textFieldUsername.getText();
					String authType = (String) authTypeCB.getSelectedItem();
					String password = sl.getPasswordByUsername(username, authType);
					if(password == null){
						JOptionPane.showMessageDialog((Component) e.getSource(),
								"username does not exist");
					}
					else{
						EmailSender emailSender = new EmailSender();
						String userEmail = sl.getEmailByUsername(username, authType);
						boolean success = emailSender.sendEmail(userEmail, COMPANY_EMAIL,
								COMPANY_NAME + ": retrived password", "your password is: "+ password);
						if(success){
							JOptionPane.showMessageDialog((Component) e.getSource(),
									"your password has been sent to your email");
						}
						else{
							JOptionPane.showMessageDialog((Component) e.getSource(),
									"network problems, could not send the password to your email");
						}
					}
				}
			}
			
		});
		
		btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSignUpPanelVisibility(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setVisible(false);
		
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(202)
							.addComponent(lblWelcomeToCoupons))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPassword)
										.addComponent(lblEmail)
										.addComponent(lblPhone))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textFieldPassword, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
										.addComponent(textFieldUsername, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
										.addComponent(textFieldEmail)
										.addComponent(textFieldPhone)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnForgotPass))
									.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(authTypeCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addGap(163))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblWelcomeToCoupons, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldPhone, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhone))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnForgotPass)
						.addComponent(authTypeCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
							.addComponent(btnSignUp, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)))
					.addContainerGap())
		);
		contentPane.setLayout(groupLayout);
		

		
	}
	
	// make the appropriated fields for sign up process visible.
	private void setSignUpPanelVisibility(boolean vis) {
		lblEmail.setVisible(vis);
		lblPhone.setVisible(vis);
		textFieldEmail.setVisible(vis);
		textFieldPhone.setVisible(vis);
		btnBack.setVisible(vis);
		// these buttons are set to not(vis)
		btnForgotPass.setVisible(!vis);
		btnLogin.setVisible(!vis);
	}
				
				
}

