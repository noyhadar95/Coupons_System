package pl;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import sl.*;
import bl_backend.Coupon;
import bl_backend.Customer;
import dal.DAL;
import dal.IDAL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCouponPanel extends JPanel {
	private JTextField txtName;
	private JTextField txtDesc;
	private JTextField txtCat;
	private JTextField txtInitial;
	private JTextField txtDiscount;
	private JTextField txtRating;
	private JTextField txtBusiness;
	private JLabel lblAddCoupon;
	private JButton btnAdd;
	private ISL sl=new SL();

	/**
	 * Create the panel.
	 */
	public AddCouponPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblAddCoupon = new JLabel("Add Coupon");
		GridBagConstraints gbc_lblAddCoupon = new GridBagConstraints();
		gbc_lblAddCoupon.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddCoupon.gridx = 3;
		gbc_lblAddCoupon.gridy = 0;
		add(lblAddCoupon, gbc_lblAddCoupon);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 3;
		gbc_lblName.gridy = 2;
		add(lblName, gbc_lblName);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 4;
		gbc_txtName.gridy = 2;
		add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Desc: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		GridBagConstraints gbc_txtDesc = new GridBagConstraints();
		gbc_txtDesc.insets = new Insets(0, 0, 5, 0);
		gbc_txtDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDesc.gridx = 4;
		gbc_txtDesc.gridy = 3;
		add(txtDesc, gbc_txtDesc);
		
		JLabel lblCategory = new JLabel("Category:");
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.anchor = GridBagConstraints.EAST;
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 3;
		gbc_lblCategory.gridy = 4;
		add(lblCategory, gbc_lblCategory);
		
		txtCat = new JTextField();
		txtCat.setColumns(10);
		GridBagConstraints gbc_txtCat = new GridBagConstraints();
		gbc_txtCat.insets = new Insets(0, 0, 5, 0);
		gbc_txtCat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCat.gridx = 4;
		gbc_txtCat.gridy = 4;
		add(txtCat, gbc_txtCat);
		
		JLabel lblInitialPrice = new JLabel("Initial Price:");
		GridBagConstraints gbc_lblInitialPrice = new GridBagConstraints();
		gbc_lblInitialPrice.anchor = GridBagConstraints.EAST;
		gbc_lblInitialPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitialPrice.gridx = 3;
		gbc_lblInitialPrice.gridy = 5;
		add(lblInitialPrice, gbc_lblInitialPrice);
		
		txtInitial = new JTextField();
		txtInitial.setColumns(10);
		GridBagConstraints gbc_txtInitial = new GridBagConstraints();
		gbc_txtInitial.insets = new Insets(0, 0, 5, 0);
		gbc_txtInitial.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInitial.gridx = 4;
		gbc_txtInitial.gridy = 5;
		add(txtInitial, gbc_txtInitial);
		
		JLabel lblDiscountPrice = new JLabel("Discount Price:");
		GridBagConstraints gbc_lblDiscountPrice = new GridBagConstraints();
		gbc_lblDiscountPrice.anchor = GridBagConstraints.EAST;
		gbc_lblDiscountPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiscountPrice.gridx = 3;
		gbc_lblDiscountPrice.gridy = 6;
		add(lblDiscountPrice, gbc_lblDiscountPrice);
		
		txtDiscount = new JTextField();
		txtDiscount.setColumns(10);
		GridBagConstraints gbc_txtDiscount = new GridBagConstraints();
		gbc_txtDiscount.insets = new Insets(0, 0, 5, 0);
		gbc_txtDiscount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiscount.gridx = 4;
		gbc_txtDiscount.gridy = 6;
		add(txtDiscount, gbc_txtDiscount);
		
		JLabel lblRating = new JLabel("Rating:");
		GridBagConstraints gbc_lblRating = new GridBagConstraints();
		gbc_lblRating.anchor = GridBagConstraints.EAST;
		gbc_lblRating.insets = new Insets(0, 0, 5, 5);
		gbc_lblRating.gridx = 3;
		gbc_lblRating.gridy = 7;
		add(lblRating, gbc_lblRating);
		
		txtRating = new JTextField();
		txtRating.setColumns(10);
		GridBagConstraints gbc_txtRating = new GridBagConstraints();
		gbc_txtRating.insets = new Insets(0, 0, 5, 0);
		gbc_txtRating.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRating.gridx = 4;
		gbc_txtRating.gridy = 7;
		add(txtRating, gbc_txtRating);
		
		JLabel lblBusiness = new JLabel("Business:");
		GridBagConstraints gbc_lblBusiness = new GridBagConstraints();
		gbc_lblBusiness.anchor = GridBagConstraints.EAST;
		gbc_lblBusiness.insets = new Insets(0, 0, 5, 5);
		gbc_lblBusiness.gridx = 3;
		gbc_lblBusiness.gridy = 8;
		add(lblBusiness, gbc_lblBusiness);
		
		txtBusiness = new JTextField();
		txtBusiness.setColumns(10);
		GridBagConstraints gbc_txtBusiness = new GridBagConstraints();
		gbc_txtBusiness.insets = new Insets(0, 0, 5, 0);
		gbc_txtBusiness.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBusiness.gridx = 4;
		gbc_txtBusiness.gridy = 8;
		add(txtBusiness, gbc_txtBusiness);
		//((DAL)(dal)).testAddDeleteCoupon();
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=txtName.getText();
				String desc=txtDesc.getText();
				int cat=Integer.parseInt(txtCat.getText());
				int initial=Integer.parseInt(txtInitial.getText());
				int discount=Integer.parseInt(txtDiscount.getText());
				int rating=Integer.parseInt(txtRating.getText());
				String business=txtBusiness.getText();
				sl.insertCoupon(new Coupon(name, desc, cat, initial, discount, rating, business,0));
				
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 3;
		gbc_btnAdd.gridy = 9;
		add(btnAdd, gbc_btnAdd);

	}

}
