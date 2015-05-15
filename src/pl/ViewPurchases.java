package pl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import sl.TempAdminSL;
import dal.DAL;
import dal.IDAL;

public class ViewPurchases extends JPanel {
	private JTable table;
	/**
	 * Create the panel.
	 */
	public ViewPurchases() {
	TempAdminSL sl=new TempAdminSL();
		
		//((DAL)(dal)).testAddDeleteCoupon();
		String name="cust1";
		String query="purchases WHERE CustomerName='"+name+"'";
		DefaultTableModel coupons=sl.getResultset(query);
		 table = new JTable(coupons);
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
