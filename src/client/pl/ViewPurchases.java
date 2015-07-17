package client.pl;

import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import client.bl.ICouponController;
import client.bl.IPurchaseController;
import client.bl.IUserController;
import client.dal.DAL;
import server.bl.ICustomerController;
import server.sl.ISL;


public class ViewPurchases extends JPanel {
	private JTable table;

	private IUserController userController;
	private IPurchaseController purchaseController;
	/**
	 * Create the panel.
	 */
	// TODO: get  SL
	public ViewPurchases() {
		
		//String name=userController.getUsername();
		//String query="purchases WHERE CustomerName='"+name+"'";
		//DefaultTableModel purchases=purchaseController.getResultset(query);//TODO change this to customer name
		DefaultTableModel purchases=purchaseController.getPurchases();
		 table = new JTable(purchases);
		 JScrollPane spTable = new JScrollPane(table);
		 //JOptionPane.showMessageDialog(null, spTable);
		 
		 GroupLayout groupLayout = new GroupLayout(this);
		 groupLayout.setHorizontalGroup(
		 	groupLayout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addContainerGap()
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addComponent(spTable, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE))
		 );
		 groupLayout.setVerticalGroup(
		 	groupLayout.createParallelGroup(Alignment.LEADING)
		 		.addComponent(spTable, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
		 		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
		 			.addContainerGap(151, Short.MAX_VALUE)
		 			.addGap(133))
		 );
		 setLayout(groupLayout);
		 spTable.setVisible(true);
		 

	}

}
