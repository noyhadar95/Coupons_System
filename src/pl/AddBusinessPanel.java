package pl;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import sl.TempAdminSL;
import bl_backend.Business;
import dal.DAL;
import dal.IDAL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBusinessPanel extends JPanel {
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtCat;
	private JTextField txtDesc;
	private JTextField txtOwner;
	private TempAdminSL sl=new TempAdminSL();

	/**
	 * Create the panel.
	 */
	public AddBusinessPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAddBusiness = new JLabel("Add Business");
		GridBagConstraints gbc_lblAddBusiness = new GridBagConstraints();
		gbc_lblAddBusiness.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddBusiness.gridx = 4;
		gbc_lblAddBusiness.gridy = 0;
		add(lblAddBusiness, gbc_lblAddBusiness);
		
		JLabel name = new JLabel("Name:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 2;
		add(name, gbc_lblNewLabel_1);
		
		txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 5;
		gbc_txtName.gridy = 2;
		add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel address = new JLabel("Address:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 3;
		add(address, gbc_lblNewLabel_2);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		GridBagConstraints gbc_txtAddress = new GridBagConstraints();
		gbc_txtAddress.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddress.gridx = 5;
		gbc_txtAddress.gridy = 3;
		add(txtAddress, gbc_txtAddress);
		
		JLabel city = new JLabel("City:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 4;
		add(city, gbc_lblNewLabel_3);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.insets = new Insets(0, 0, 5, 5);
		gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity.gridx = 5;
		gbc_txtCity.gridy = 4;
		add(txtCity, gbc_txtCity);
		
		JLabel cat = new JLabel("Category:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 5;
		add(cat, gbc_lblNewLabel_4);
		
		txtCat = new JTextField();
		txtCat.setColumns(10);
		GridBagConstraints gbc_txtCat = new GridBagConstraints();
		gbc_txtCat.insets = new Insets(0, 0, 5, 5);
		gbc_txtCat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCat.gridx = 5;
		gbc_txtCat.gridy = 5;
		add(txtCat, gbc_txtCat);
		
		JLabel desc = new JLabel("Description:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 6;
		add(desc, gbc_lblNewLabel_5);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		GridBagConstraints gbc_txtDesc = new GridBagConstraints();
		gbc_txtDesc.insets = new Insets(0, 0, 5, 5);
		gbc_txtDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDesc.gridx = 5;
		gbc_txtDesc.gridy = 6;
		add(txtDesc, gbc_txtDesc);
		
		JLabel owner = new JLabel("Owner:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 4;
		gbc_lblNewLabel_6.gridy = 7;
		add(owner, gbc_lblNewLabel_6);
		
		txtOwner = new JTextField();
		txtOwner.setColumns(10);
		GridBagConstraints gbc_txtOwner = new GridBagConstraints();
		gbc_txtOwner.insets = new Insets(0, 0, 5, 5);
		gbc_txtOwner.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOwner.gridx = 5;
		gbc_txtOwner.gridy = 7;
		add(txtOwner, gbc_txtOwner);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtName.getText();
				String address=txtAddress.getText();
				//city cat desc owner
				String city=txtCity.getText();
				String cat=txtCat.getText();
				String desc=txtDesc.getText();
				String owner=txtOwner.getText();
				sl.insertBusiness(new Business(name, address, city, cat, desc, owner));
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 5;
		gbc_btnAdd.gridy = 8;
		add(btnAdd, gbc_btnAdd);
		

	}

}
