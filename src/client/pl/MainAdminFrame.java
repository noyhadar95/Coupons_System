package client.pl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.SwingConstants;

import client.bl.CouponController;
import client.bl.IAdminController;
import client.bl.ICouponController;
import client.bl.IUserController;
import client.bl.UserController;

public class MainAdminFrame extends JFrame {

	private IUserController userCont;
	private ICouponController couponCont;
	private JPanel contentPane;
	private final int WINDOW_WIDTH = 900, WINDOW_HEIGHT = 700;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	MainAdminFrame frame = new MainAdminFrame();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainAdminFrame() {
		super("Admin");
		
		userCont = new UserController();
		couponCont = new CouponController();
		//((DAL)(dal)).testAddDeleteCoupon();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		 this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{411, 105, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{16, 79, 29, 29, 29, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: deleted sl from constructor
				AdminAddFrame addFrame = new AdminAddFrame();
				addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		         
		        //Create and set up the content pane.
				// TODO: deleted sl from constructor
		        CardLayoutDemo demo = new CardLayoutDemo();
		        demo.addComponentToPane(addFrame.getContentPane());
		         
		        //Display the window.
		        addFrame.pack();
		        addFrame.setVisible(true);
			}
		});
		
		JLabel lblWelconeAdmin = new JLabel("Welcone, "+userCont.getUsername()+"!");
		GridBagConstraints gbc_lblWelconeAdmin = new GridBagConstraints();
		gbc_lblWelconeAdmin.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblWelconeAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelconeAdmin.gridx = 1;
		gbc_lblWelconeAdmin.gridy = 0;
		contentPane.add(lblWelconeAdmin, gbc_lblWelconeAdmin);
		
		JButton btnLogout = new JButton("logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new LoginFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		         setVisible(false);
		        //Display the window.
		        frame.pack();
		        frame.setVisible(true);
				
			}
		});
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogout.gridx = 10;
		gbc_btnLogout.gridy = 0;
		contentPane.add(btnLogout, gbc_btnLogout);
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 2;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		JButton btnEdit = new JButton("Edit Coupons");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		         
				JPanel panel=new AdminEditCoupons();
				frame.getContentPane().add(panel);
		         
		        //Display the window.
		        frame.pack();
		        frame.setVisible(true);
			}
		});
		
		JLabel lblApprove = new JLabel("You have coupons to approve!");
		GridBagConstraints gbc_lblApprove = new GridBagConstraints();
		gbc_lblApprove.insets = new Insets(0, 0, 5, 5);
		gbc_lblApprove.gridx = 0;
		gbc_lblApprove.gridy = 3;
		contentPane.add(lblApprove, gbc_lblApprove);
		lblApprove.setVisible(false);
		lblApprove.setVisible(true);
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 3;
		contentPane.add(btnEdit, gbc_btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDeleteFrame addFrame = new AdminDeleteFrame();
				addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		         
		        //Create and set up the content pane.
				// TODO: deleted sl from constructor
		        AdminDeleteCardLayout demo = new AdminDeleteCardLayout();
		        demo.addComponentToPane(addFrame.getContentPane());
		         
		        //Display the window.
		        addFrame.pack();
		        addFrame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 4;
		contentPane.add(btnDelete, gbc_btnDelete);
		
		//TODO: check if there are coupons to approve
		int toApprove=couponCont.getNumOfUnapprovedCoupons();
		if(toApprove>0){
			lblApprove.setText("You Have "+toApprove+" Coupons to Approve! ->");
			
		}
		else{
			lblApprove.setText("You Have No Coupons to Approve! ->");
		}
	}
}
