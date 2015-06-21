package client.pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.*;
import client.bl.*;

import com.mysql.jdbc.ResultSetMetaData;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;



public class AdminEditCoupons extends JPanel {
	private JTable table;
	private ICouponController couponCont=new CouponController();
	/**
	 * Create the panel.
	 */
	public AdminEditCoupons() {//ActionListener actionListener
		final int APPROVE_COLUMN = 7;
		
		DefaultTableModel coupons=couponCont.getCouponsDetails();
		
int colcount = coupons.getColumnCount();
		
		Vector<String> colNames = new Vector<String>();
		    for(int col = 0;col < colcount;col++) { //the plus one is for the button
		       colNames.add(coupons.getColumnName(col));
		    }
		
		//TODO: Where i get the items, make sure that the Approval is already changed 
        DefaultTableModel model = new DefaultTableModel(coupons.getDataVector(),colNames)
        {
        	@Override
			public boolean isCellEditable(int row, int column)
            {
        		if(column==APPROVE_COLUMN)
        		{
        			Object o =  table.getValueAt(row, column);
        			if((String)o == "Approve")
        				return true;
        			else 
        				return false;
        		}
        		
               if ((column>=1 && column<=4))
            	   return true;
               else
            	   return false;
            }
        };
		
        
        //Change the 0 - to approve and 1 to approved.
        for(int i=0;i<model.getRowCount(); i++){
        	
        	if((int)model.getValueAt(i, APPROVE_COLUMN) == 0)
        			model.setValueAt("Approve", i, APPROVE_COLUMN);
        	else
        		model.setValueAt("Approved", i, APPROVE_COLUMN);

        }
        
        
		
		 table = new JTable(model);
		 JScrollPane spTable = new JScrollPane(table);
		 
		 
		 table.putClientProperty("terminateEditOnFocusLost", true);
	        table.getDefaultEditor(String.class).addCellEditorListener(
	                new CellEditorListener() {
	                    public void editingCanceled(ChangeEvent e) {
	                    	System.out.println("canceled: apply additional action");
	                    }

	                    public void editingStopped(ChangeEvent e) {
	                        System.out.println("editingStopped: apply additional action");
	                        int row = table.getSelectedRow();
	                        int col = table.getSelectedColumn();
	                        
	                        String result = table.getValueAt(row, col).toString();
	                        // id is the primary key of my DB
	                        String name = table.getValueAt(row, 0).toString();
	                        
	                        couponCont.updateCouponByAdmin(getCouponFromRow(row, table));
	                    }
	                });
	        
	        
	        Action approve = new AbstractAction()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                JTable table = (JTable)e.getSource();
	                int modelRow = Integer.valueOf( e.getActionCommand() );
	                Coupon coup = getCouponFromRow(modelRow, table);
	                coup.setApproved(1);
	                couponCont.updateCouponByAdmin(coup);
	                //((DefaultTableModel)table.getModel()).removeRow(modelRow);
	                
	            }
	        };
	         
	        ButtonColumn buttonColumn = new ButtonColumn(table, approve, 7);
	        buttonColumn.setMnemonic(KeyEvent.VK_D);
		 
		 //JOptionPane.showMessageDialog(null, spTable);
		 
		 JLabel lblNewLabel = new JLabel("New label");
		 GroupLayout groupLayout = new GroupLayout(this);
		 groupLayout.setHorizontalGroup(
		 	groupLayout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(lblNewLabel)
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addComponent(spTable, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE))
		 );
		 groupLayout.setVerticalGroup(
		 	groupLayout.createParallelGroup(Alignment.LEADING)
		 		.addComponent(spTable, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
		 		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
		 			.addContainerGap(151, Short.MAX_VALUE)
		 			.addComponent(lblNewLabel)
		 			.addGap(133))
		 );
		 setLayout(groupLayout);
		 spTable.setVisible(true);
		

	}
	
	private Coupon getCouponFromRow(int row, JTable table){

		Coupon coup = new Coupon(table.getValueAt(row, 0).toString(), table.getValueAt(row, 1).toString(), Integer.parseInt(table.getValueAt(row, 2).toString()), Integer.parseInt(table.getValueAt(row, 3).toString()), Integer.parseInt(table.getValueAt(row, 4).toString()), Integer.parseInt(table.getValueAt(row, 5).toString()), table.getValueAt(row, 6).toString(), 0);
		if((String)table.getValueAt(row, 7) != "Approve")
			coup.setApproved(1);
		return coup;
	}
}
