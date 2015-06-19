package pl;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.text.TabExpander;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sl.ISL;
import sl.SL;


public class CustomersCoupons extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static ISL isl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomersCoupons frame = new CustomersCoupons(isl);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomersCoupons(ISL sl) {
		
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final int USE_COLUMN = 3;
        
        isl = sl;
        
		String name="cust1";
		DefaultTableModel coupons=isl.getCouponsNamesRatings(name);

		
		
		int colcount = coupons.getColumnCount();
		
		Vector<String> colNames = new Vector<String>();
		    for(int col = 0;col < colcount;col++) { 
		       colNames.add(coupons.getColumnName(col));
		    }
		
		
        DefaultTableModel model = new DefaultTableModel(coupons.getDataVector(),colNames)
        {
        	@Override
			public boolean isCellEditable(int row, int column)
            {
        		if(column==USE_COLUMN)
        		{
        			Object o =  this.getValueAt(row, column);
        			if((String)o == "Use")
        				return true;
        			else 
        				return false;
        		}
        		
               if (column >= 2)
            	   return true;
               else
            	   return false;
            }
        };
        
        
for(int i=0;i<model.getRowCount(); i++){
        	
        	if((int)model.getValueAt(i, USE_COLUMN) == 0)
        			model.setValueAt("Use", i, USE_COLUMN);
        	else
        		model.setValueAt("Used", i, USE_COLUMN);

        }
        
        final JTable table = new JTable(model);
        
        Action use = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );

                if(isl.useCoupon(table.getValueAt(modelRow, 0).toString()))
                	table.setValueAt("Used", modelRow, USE_COLUMN);
            }
        };
         
        ButtonColumn buttonColumn = new ButtonColumn(table, use, 3);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
        
       
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
                        String serialKey = table.getValueAt(row, 0).toString();
                        isl.updatePurchaseRating(serialKey, Integer.parseInt(result));
                       
                    }
                });

        add(new JScrollPane(table));
        setLocationByPlatform(true);
        pack();
        setVisible(true);

}
}
