package client.pl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import client.bl.IPurchaseController;
import client.bl.IUserController;
import client.bl.PurchaseController;


public class ViewPurchases extends JPanel {
	private JTable table;

	private IUserController userController;
	private IPurchaseController purchaseController;
	
	/**
	 * Create the panel.
	 */
	public ViewPurchases() {
		purchaseController = new PurchaseController();
		String name = userController.getUsername();
		String query = "purchases WHERE CustomerName='"+name+"'";
		DefaultTableModel purchases = purchaseController.getResultset(query);
		
		
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
