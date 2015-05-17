package pl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTable;

import sl.ISL;
import sl.SL;

public class CustomerMain extends JFrame {

	private JPanel contentPane;
	private JTextField txt_search;
	private JTable table;
	private ISL isl;
	private DefaultTableModel lastModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMain frame = new CustomerMain();
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
	public CustomerMain() { 
		this.isl = new SL();
		lastModel = isl.getCouponsByPreference("cust1");
		
		Timer timer = new Timer ();
		TimerTask hourlyTask = new TimerTask () {
		    @Override
		    public void run () {
		        checkNotificationByPreference();
		    }
		};

		// schedule the task to run starting now and then every hour...
		timer.schedule (hourlyTask, 0l, 1000*60*60);   // 1000*10*60 every 10 minut
		//timer.schedule (hourlyTask, 0l, 60*60); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSearch = new JLabel("Search");
		
		final JComboBox cmbx_Type = new JComboBox();
		cmbx_Type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox = (JComboBox) e.getSource();

                Object selected = comboBox.getSelectedItem();
				
			}
		});
		cmbx_Type.setModel(new DefaultComboBoxModel(new String[] {"Coupon", "Business"}));
		
		txt_search = new JTextField();
		txt_search.setColumns(10);
		
		final JComboBox cmbx_By = new JComboBox();
		cmbx_By.setModel(new DefaultComboBoxModel(new String[] {"By Business", "By Category"}));
		
		JButton btn_search = new JButton("Search");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model;
				if(cmbx_Type.getSelectedIndex() == 0){
				switch (cmbx_By.getSelectedIndex()) {
				case 0:
					 model = isl.getCouponsByFilter("Business", txt_search.getText()); 
					break;
				case 1:
					 model = isl.getCouponsByFilter("Category", txt_search.getText()); 
				
				default:
					model = (DefaultTableModel)table.getModel();
					break;
				}
				}
				else{
					switch (cmbx_By.getSelectedIndex()) {
					case 0:
						 model = isl.getCouponsByFilter("Business", txt_search.getText()); 
						break;
					case 1:
						 model = isl.getCouponsByFilter("Category", txt_search.getText()); 
					
					default:
						model = (DefaultTableModel)table.getModel();
						break;
					}
				}
				table.setModel(model);
				
				DefaultTableModel coupons=isl.getApprovedCoupons();
				
				
				
				
				for(int i=0;i<table.getRowCount(); i++){
		        	
		        	table.setValueAt("Purchase", i, 7);

		        }
				
				
				 Action purchase = new AbstractAction()
			        {
			            public void actionPerformed(ActionEvent e)
			            {
			                JTable table = (JTable)e.getSource();
			                int modelRow = Integer.valueOf( e.getActionCommand() );

			               isl.purchaseCoupon((String)table.getValueAt(modelRow, 0), "cust1");
			    
			               JOptionPane.showMessageDialog((JFrame)cmbx_By.getTopLevelAncestor(), "cust1 bought " + (String)table.getValueAt(modelRow, 0));

			            }
			        };
			         
			        ButtonColumn buttonColumn = new ButtonColumn(table, purchase, 7);
			}
		});
		
	
		DefaultTableModel coupons=isl.getApprovedCoupons();
		table = new JTable(coupons);
		table.getColumnModel().getColumn(1).setHeaderValue("Name");
		
		for(int i=0;i<table.getRowCount(); i++){
        	
        	table.setValueAt("Purchase", i, 7);

        }
		
		
		 Action purchase = new AbstractAction()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                JTable table = (JTable)e.getSource();
	                int modelRow = Integer.valueOf( e.getActionCommand() );

	               isl.purchaseCoupon((String)table.getValueAt(modelRow, 0), "cust1");
	    
	               JOptionPane.showMessageDialog((JFrame)cmbx_By.getTopLevelAncestor(), "cust1 bought " + (String)table.getValueAt(modelRow, 0));

	            }
	        };
	         
	        ButtonColumn buttonColumn = new ButtonColumn(table, purchase, 7);
		
		
		
		
		
		
		
		
		
		
		JButton btnObserveMyCoupons = new JButton("Observe My Coupons");
		btnObserveMyCoupons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame newFrame = new CustomersCoupons();
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSearch)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cmbx_Type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txt_search, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cmbx_By, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_search)))
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(227, Short.MAX_VALUE)
					.addComponent(btnObserveMyCoupons, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
					.addGap(217))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearch)
						.addComponent(cmbx_Type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbx_By, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_search))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
					.addComponent(btnObserveMyCoupons, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(groupLayout);
		
	
		
	}
	
	
	
	
	
	
	
	void checkNotificationByPreference(){
		DefaultTableModel newModel = isl.getCouponsByPreference("Cust1");
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i < newModel.getRowCount(); i++){
			if(inTable((String)newModel.getValueAt(i, 0), lastModel)==true) 
				list.add((String)newModel.getValueAt(i, 0));
				
		}
		
		if(!list.isEmpty()){
			String newCoupons = "There are new coupons: ";
			for (int i = 0; i < list.size(); i++) {
				newCoupons+= list.get(i) + "\n";
			}
		
			JOptionPane.showMessageDialog(this, newCoupons, "NEW COUPONS",JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	
	private boolean inTable(String item,DefaultTableModel table){
		for (int i = 0; i < table.getRowCount(); i++) {
			if(table.getValueAt(i, 0).equals(item))
				return true;
		}
		return false;
	}
}
