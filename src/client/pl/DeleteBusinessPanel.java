package client.pl;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import auxiliary.bl_backend.*;
import client.bl.*;

public class DeleteBusinessPanel extends JPanel {
	
	private IBusinessController businessCont=new BusinessController();
	
	/**
	 * Create the panel.
	 */
	public DeleteBusinessPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDeleteBusiness = new JLabel("Delete Business");
		GridBagConstraints gbc_lblDeleteBusiness = new GridBagConstraints();
		gbc_lblDeleteBusiness.insets = new Insets(0, 0, 5, 0);
		gbc_lblDeleteBusiness.gridx = 6;
		gbc_lblDeleteBusiness.gridy = 0;
		add(lblDeleteBusiness, gbc_lblDeleteBusiness);
		
		JButton btnShowBusiness = new JButton("Show Businesses");
		btnShowBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame=new JFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().setLayout(new BorderLayout());
				frame.setSize(900, 700);
				 ViewBusinessesPanel v=new ViewBusinessesPanel();
				 frame.getContentPane().add(v, BorderLayout.CENTER);
				 frame.pack();
				 frame.setVisible(true);
				 
			}
		});
		GridBagConstraints gbc_btnShowBusiness = new GridBagConstraints();
		gbc_btnShowBusiness.insets = new Insets(0, 0, 5, 0);
		gbc_btnShowBusiness.gridx = 6;
		gbc_btnShowBusiness.gridy = 1;
		add(btnShowBusiness, gbc_btnShowBusiness);
		
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
				businessCont.deleteBusiness(toDelete);
				comboBox.removeItemAt(index);
				//JOptionPane.showMessageDialog(null, "deleted!");
				
				//=========
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 6;
		gbc_btnDelete.gridy = 4;
		add(btnDelete, gbc_btnDelete);
		
		
		List data=businessCont.getTableArrayList("businesses");
		for (int i = 0; i < data.size(); i++) {
			HashMap business = (HashMap) data.get(i);
			label.setText(label.getText()+" "+(String) business.get("Name"));
			comboBox.addItem((String) business.get("Name"));
		}
		if(data.size()==0)
			label.setText("0 length");
	}

}
