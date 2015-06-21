package client.pl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

import client.bl.BusinessOwnerController;


import client.bl.UserController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusinessOwnerMain extends JFrame {

	static BusinessOwnerController boc;
	static UserController uc;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessOwnerMain frame = new BusinessOwnerMain();
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
	public BusinessOwnerMain() {//TODO: got isl
		this.boc = new BusinessOwnerController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblHello = new JLabel("Hello,");
		lblHello.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblHello = new GridBagConstraints();
		gbc_lblHello.insets = new Insets(0, 0, 5, 5);
		gbc_lblHello.gridx = 1;
		gbc_lblHello.gridy = 1;
		contentPane.add(lblHello, gbc_lblHello);
		
		JButton btnLogout = new JButton("logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f=new LoginFrame();
				setVisible(false);
				f.setVisible(true);
				uc.setUsername("");
			}
		});
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogout.gridx = 3;
		gbc_btnLogout.gridy = 1;
		contentPane.add(btnLogout, gbc_btnLogout);
		
		JLabel lblYouCanAdd = new JLabel("you can add a new coupon here ->");
		GridBagConstraints gbc_lblYouCanAdd = new GridBagConstraints();
		gbc_lblYouCanAdd.insets = new Insets(0, 0, 5, 5);
		gbc_lblYouCanAdd.gridx = 1;
		gbc_lblYouCanAdd.gridy = 2;
		contentPane.add(lblYouCanAdd, gbc_lblYouCanAdd);
		
		JButton btnAddCoupon = new JButton("Add Coupon");
		btnAddCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BusinessOwnerAddCoupon addFrame = new BusinessOwnerAddCoupon(); //TODO: Gave sl
				addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		         
		        //Display the window.
		        addFrame.pack();
		        addFrame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAddCoupon = new GridBagConstraints();
		gbc_btnAddCoupon.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddCoupon.gridx = 3;
		gbc_btnAddCoupon.gridy = 2;
		contentPane.add(btnAddCoupon, gbc_btnAddCoupon);
		
		JLabel lblObserveYourBusiness = new JLabel("Observe your businesses");
		GridBagConstraints gbc_lblObserveYourBusiness = new GridBagConstraints();
		gbc_lblObserveYourBusiness.insets = new Insets(0, 0, 5, 5);
		gbc_lblObserveYourBusiness.gridx = 1;
		gbc_lblObserveYourBusiness.gridy = 3;
		contentPane.add(lblObserveYourBusiness, gbc_lblObserveYourBusiness);
		
		JButton btnObserveBusinesses = new JButton("Observe businesses");
		btnObserveBusinesses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame=new JFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().setLayout(new BorderLayout());
				frame.setSize(900, 700);
				 ViewBusinessesOfOwnerPanel v=new ViewBusinessesOfOwnerPanel();//TODO: Gave sl
				 frame.getContentPane().add(v, BorderLayout.CENTER);
				 frame.pack();
				 frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnObserveBusinesses = new GridBagConstraints();
		gbc_btnObserveBusinesses.insets = new Insets(0, 0, 5, 0);
		gbc_btnObserveBusinesses.gridx = 3;
		gbc_btnObserveBusinesses.gridy = 3;
		contentPane.add(btnObserveBusinesses, gbc_btnObserveBusinesses);
		
		JLabel lblObserveCoupons = new JLabel("Observe coupons");
		GridBagConstraints gbc_lblObserveCoupons = new GridBagConstraints();
		gbc_lblObserveCoupons.insets = new Insets(0, 0, 5, 5);
		gbc_lblObserveCoupons.gridx = 1;
		gbc_lblObserveCoupons.gridy = 4;
		contentPane.add(lblObserveCoupons, gbc_lblObserveCoupons);
		
		JButton btnObserveCoupon = new JButton("Observe Coupon");
		btnObserveCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame=new JFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().setLayout(new BorderLayout());
				frame.setSize(900, 700);
				 ViewCouponsOfOwner v=new ViewCouponsOfOwner();//TODO: Gave sl
				 frame.getContentPane().add(v, BorderLayout.CENTER);
				 frame.pack();
				 frame.setVisible(true);
				
			}
		});
		GridBagConstraints gbc_btnObserveCoupon = new GridBagConstraints();
		gbc_btnObserveCoupon.insets = new Insets(0, 0, 5, 0);
		gbc_btnObserveCoupon.gridx = 3;
		gbc_btnObserveCoupon.gridy = 4;
		contentPane.add(btnObserveCoupon, gbc_btnObserveCoupon);
		
		JButton btnEditBusinesses = new JButton("Edit Businesses");
		btnEditBusinesses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		         
				JPanel panel=new BusinessOwnerEditBusiness();//TODO: Gave sl
				frame.getContentPane().add(panel);
		         
		        //Display the window.
		        frame.pack();
		        frame.setVisible(true);
			}
			
		});
		
		JLabel lblEditYoursBusinesses = new JLabel("Edit your's businesses");
		GridBagConstraints gbc_lblEditYoursBusinesses = new GridBagConstraints();
		gbc_lblEditYoursBusinesses.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditYoursBusinesses.gridx = 1;
		gbc_lblEditYoursBusinesses.gridy = 5;
		contentPane.add(lblEditYoursBusinesses, gbc_lblEditYoursBusinesses);
		GridBagConstraints gbc_btnEditBusinesses = new GridBagConstraints();
		gbc_btnEditBusinesses.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditBusinesses.gridx = 3;
		gbc_btnEditBusinesses.gridy = 5;
		contentPane.add(btnEditBusinesses, gbc_btnEditBusinesses);
	}

}
