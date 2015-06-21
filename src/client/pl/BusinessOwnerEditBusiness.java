package pl;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

import dal.DAL;
import dal.IDAL;
import bl_backend.Business;
import bl_backend.Coupon;
import sl.ISL;
import sl.SL;

public class BusinessOwnerEditBusiness extends JPanel {

	private  IDAL dal= new DAL();
	private JTable table;
	private ISL isl;
	/**
	 * Create the panel.
	 */
	public BusinessOwnerEditBusiness(ISL sl) {//TODO: GOT ISL
		isl =sl;
		
		String owner = sl.getUsername();
		DefaultTableModel business=dal.getResultset("businesses WHERE owner='"+owner+"'");
		
int colcount = business.getColumnCount();
		
		Vector<String> colNames = new Vector<String>();
		    for(int col = 0;col < colcount;col++) { //the plus one is for the button
		       colNames.add(business.getColumnName(col));
		    }
		
		//TODO: Where i get the items, make sure that the Approval is already changed 
        DefaultTableModel model = new DefaultTableModel(business.getDataVector(),colNames)
        {
        	@Override
			public boolean isCellEditable(int row, int column)
            {
        		
               if ((column>=1 && column<=4))
            	   return true;
               else
            	   return false;
            }
        };
		
        
        
        
		
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
	                        
	                        isl.updateBusinessByOwner(getBusinessFromRow(row, table));
	                    }
	                });
	        
	        
	        
		 
		 GroupLayout groupLayout = new GroupLayout(this);
		 groupLayout.setHorizontalGroup(
		 	groupLayout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addContainerGap()
		 			.addPreferredGap(ComponentPlacement.RELATED)
		 			.addComponent(spTable, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE))
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
	
	private Business getBusinessFromRow(int row, JTable table){

		Business business = new Business (table.getValueAt(row, 0).toString(), table.getValueAt(row, 1).toString(), table.getValueAt(row, 2).toString(),table.getValueAt(row, 3).toString(),table.getValueAt(row, 4).toString(),table.getValueAt(row, 5).toString());
				
		return business;
	}

	}


