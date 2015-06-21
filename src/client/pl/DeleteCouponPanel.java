package client.pl;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import auxiliary.bl_backend.*;
import client.bl.*;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteCouponPanel extends JPanel {
	private ICouponController couponCont=new CouponController();
	/**
	 * Create the panel.
	 */
	public DeleteCouponPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDeleteCoupon = new JLabel("Delete Coupon");
		GridBagConstraints gbc_lblDeleteCoupon = new GridBagConstraints();
		gbc_lblDeleteCoupon.insets = new Insets(0, 0, 5, 0);
		gbc_lblDeleteCoupon.gridx = 6;
		gbc_lblDeleteCoupon.gridy = 0;
		add(lblDeleteCoupon, gbc_lblDeleteCoupon);
		
		JButton btnShowCoupons = new JButton("Show Coupons");
		btnShowCoupons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame=new JFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().setLayout(new BorderLayout());
				frame.setSize(900, 700);
				 ViewCoupons v=new ViewCoupons();
				 frame.getContentPane().add(v, BorderLayout.CENTER);
				 frame.pack();
				 frame.setVisible(true);
				 
			}
		});
		GridBagConstraints gbc_btnShowCoupons = new GridBagConstraints();
		gbc_btnShowCoupons.insets = new Insets(0, 0, 5, 0);
		gbc_btnShowCoupons.gridx = 6;
		gbc_btnShowCoupons.gridy = 1;
		add(btnShowCoupons, gbc_btnShowCoupons);
		
		final JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 6;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		final JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 6;
		gbc_label.gridy = 3;
		add(label, gbc_label);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//============
				String toDelete=comboBox.getSelectedItem().toString();
				label.setText(toDelete);
				int index=comboBox.getSelectedIndex();
				couponCont.deleteCoupon(toDelete);
				comboBox.removeItemAt(index);
				//JOptionPane.showMessageDialog(null, "deleted!");
				
				//=========
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 6;
		gbc_btnDelete.gridy = 4;
		add(btnDelete, gbc_btnDelete);
		
		
		List data=couponCont.getTableArrayList("coupons");
		for (int i = 0; i < data.size(); i++) {
			HashMap coupon = (HashMap) data.get(i);
			label.setText(label.getText()+" "+(String) coupon.get("Name"));
			comboBox.addItem((String) coupon.get("Name"));
		}
		if(data.size()==0)
			label.setText("0 length");

	}

}
