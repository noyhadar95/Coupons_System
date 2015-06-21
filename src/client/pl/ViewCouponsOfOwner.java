package client.pl;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import client.bl.ICouponController;
import client.bl.IUserController;


public class ViewCouponsOfOwner extends JPanel {

	private IUserController userController;
	private ICouponController coupController;
	private JTable table;
	/**
	 * Create the panel.
	 */
	
	//TODO: ViewCouponsOfOwner Get sl before change
	public ViewCouponsOfOwner() {
		
		//((DAL)(dal)).testAddDeleteCoupon();
		String query="coupons Join (select Name,Owner From couponsdb.businesses) b  on b.Name=coupons.business where b.Owner='"+userController.getUsername()+"'";
		DefaultTableModel coupons=coupController.getResultset(query);
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
