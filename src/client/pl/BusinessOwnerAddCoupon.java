package client.pl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import auxiliary.bl_backend.Coupon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.JComboBox;

import client.bl.BusinessController;
import client.bl.CouponController;
import client.bl.UserController;
import server.bl.BusinessOwnerController;

public class BusinessOwnerAddCoupon extends JFrame {

	private static BusinessController bc;
	private static CouponController cc;
	private static UserController uc;
	private JPanel contentPane;
	private JTextField txtDesc;
	private JTextField txtName;
	private JTextField txtCategory;
	private JTextField txtInitialPrice;
	private JTextField txtDiscount;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessOwnerAddCoupon frame = new BusinessOwnerAddCoupon();
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
	public BusinessOwnerAddCoupon() {
		bc = new BusinessController();
		cc = new CouponController();
		uc = new UserController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblAddCoupon = new JLabel("Add Coupon !");
		lblAddCoupon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAddCoupon = new GridBagConstraints();
		gbc_lblAddCoupon.gridheight = 2;
		gbc_lblAddCoupon.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddCoupon.gridx = 0;
		gbc_lblAddCoupon.gridy = 0;
		contentPane.add(lblAddCoupon, gbc_lblAddCoupon);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 2;
		contentPane.add(lblName, gbc_lblName);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 2;
		contentPane.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblDesc = new JLabel("Desc:");
		GridBagConstraints gbc_lblDesc = new GridBagConstraints();
		gbc_lblDesc.anchor = GridBagConstraints.EAST;
		gbc_lblDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesc.gridx = 0;
		gbc_lblDesc.gridy = 3;
		contentPane.add(lblDesc, gbc_lblDesc);
		
		txtDesc = new JTextField();
		GridBagConstraints gbc_txtDesc = new GridBagConstraints();
		gbc_txtDesc.insets = new Insets(0, 0, 5, 5);
		gbc_txtDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDesc.gridx = 1;
		gbc_txtDesc.gridy = 3;
		contentPane.add(txtDesc, gbc_txtDesc);
		txtDesc.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category:");
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.anchor = GridBagConstraints.EAST;
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 4;
		contentPane.add(lblCategory, gbc_lblCategory);
		
		txtCategory = new JTextField();
		GridBagConstraints gbc_txtCategory = new GridBagConstraints();
		gbc_txtCategory.insets = new Insets(0, 0, 5, 5);
		gbc_txtCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCategory.gridx = 1;
		gbc_txtCategory.gridy = 4;
		contentPane.add(txtCategory, gbc_txtCategory);
		txtCategory.setColumns(10);
		
		JLabel lblInitialPrice = new JLabel("Initial Price:");
		GridBagConstraints gbc_lblInitialPrice = new GridBagConstraints();
		gbc_lblInitialPrice.anchor = GridBagConstraints.EAST;
		gbc_lblInitialPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitialPrice.gridx = 0;
		gbc_lblInitialPrice.gridy = 5;
		contentPane.add(lblInitialPrice, gbc_lblInitialPrice);
		
		txtInitialPrice = new JTextField();
		GridBagConstraints gbc_txtInitialPrice = new GridBagConstraints();
		gbc_txtInitialPrice.insets = new Insets(0, 0, 5, 5);
		gbc_txtInitialPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInitialPrice.gridx = 1;
		gbc_txtInitialPrice.gridy = 5;
		contentPane.add(txtInitialPrice, gbc_txtInitialPrice);
		txtInitialPrice.setColumns(10);
		
		JLabel lblDiscountPrice = new JLabel("Discount Price:");
		GridBagConstraints gbc_lblDiscountPrice = new GridBagConstraints();
		gbc_lblDiscountPrice.anchor = GridBagConstraints.EAST;
		gbc_lblDiscountPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiscountPrice.gridx = 0;
		gbc_lblDiscountPrice.gridy = 6;
		contentPane.add(lblDiscountPrice, gbc_lblDiscountPrice);
		
		txtDiscount = new JTextField();
		GridBagConstraints gbc_txtDiscount = new GridBagConstraints();
		gbc_txtDiscount.insets = new Insets(0, 0, 5, 5);
		gbc_txtDiscount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiscount.gridx = 1;
		gbc_txtDiscount.gridy = 6;
		contentPane.add(txtDiscount, gbc_txtDiscount);
		txtDiscount.setColumns(10);
		
		JLabel lblBusiness = new JLabel("Business:");
		GridBagConstraints gbc_lblBusiness = new GridBagConstraints();
		gbc_lblBusiness.anchor = GridBagConstraints.EAST;
		gbc_lblBusiness.insets = new Insets(0, 0, 5, 5);
		gbc_lblBusiness.gridx = 0;
		gbc_lblBusiness.gridy = 7;
		contentPane.add(lblBusiness, gbc_lblBusiness);
		
		JButton btnAddCoupon = new JButton("Add Your Coupon !");
		btnAddCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=txtName.getText();
				String desc=txtDesc.getText();
				int cat=Integer.parseInt(txtCategory.getText());
				int initial=Integer.parseInt(txtInitialPrice.getText());
				int discount=Integer.parseInt(txtDiscount.getText());
				int rating=0;
				String business=comboBox.getSelectedItem().toString();
				
				cc.insertCoupon(new Coupon(name, desc, cat, initial, discount, rating, business,0));
			}
		});
		
	     comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 7;
		contentPane.add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_btnAddCoupon = new GridBagConstraints();
		gbc_btnAddCoupon.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddCoupon.gridx = 1;
		gbc_btnAddCoupon.gridy = 8;
		contentPane.add(btnAddCoupon, gbc_btnAddCoupon);
		
		String owner=uc.getUsername();
		
		List data=bc.getTableArrayList("businesses WHERE owner='"+owner+"'");
		for (int i = 0; i < data.size(); i++) {
			HashMap business = (HashMap) data.get(i);
			comboBox.addItem((String) business.get("Name"));
		}

		
		
	}

}
