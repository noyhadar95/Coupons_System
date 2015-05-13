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

import dal.DAL;
import dal.IDAL;

public class CustomersCoupons extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomersCoupons frame = new CustomersCoupons();
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
	public CustomersCoupons() {
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        IDAL dal = new DAL();
		String name="cust1";
		String query="SELECT CouponName,Rating FROM couponsdb.purchases WHERE CustomerName='"+name+"'";
		DefaultTableModel coupons=((DAL)dal).getResultSetFromQuery(query);

		String[] btnArray = new String[coupons.getRowCount()];
		
		for(int i=0; i<btnArray.length; i++){
			btnArray[i] = "Use";
		}
		
		
		coupons.addColumn("Use Coupon", btnArray);
		
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
               if (column >= 1)
            	   return true;
               else
            	   return false;
            }
        };
        final JTable table = new JTable(model);
        
        Action use = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                ((DefaultTableModel)table.getModel()).removeRow(modelRow);
            }
        };
         
        ButtonColumn buttonColumn = new ButtonColumn(table, use, 2);
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
                        String name = table.getValueAt(row, 0).toString();
                        
                        System.out.println("Update: " + name + " with rating: " + result);
                    }
                });

        add(new JScrollPane(table));
        setLocationByPlatform(true);
        pack();
        setVisible(true);

}
}
