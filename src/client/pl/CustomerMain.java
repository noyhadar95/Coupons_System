package client.pl;

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

import auxiliary.bl_backend.GPS;
import auxiliary.bl_backend.Location;
import auxiliary.bl_backend.Sensor;
import client.bl.BusinessController;
import client.bl.CouponController;
import client.bl.CustomerController;
import client.bl.ILocationController;
import client.bl.ISensorController;
import client.bl.LocationController;
import client.bl.SensorController;
import client.bl.UserController;
import client.dal.DAL;


public class CustomerMain extends JFrame {

	private JPanel contentPane;
	private JTextField txt_search;
	private JTable table;
	private DefaultTableModel lastModel;
	private static CouponController cc;
	private static UserController uc;
	private static BusinessController bc;
	private static ILocationController lc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CustomerMain frame = new CustomerMain();//TODO: Gave sl
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
	public CustomerMain() { //TODO: Got isl 
		cc =new CouponController();
		uc = new UserController();
		bc = new BusinessController();
		lc = new LocationController();
		lastModel = createModel();
		
		Timer timer = new Timer ();
		TimerTask hourlyTask = new TimerTask () {
		    @Override
		    public void run () {
		        checkNotificationByPreference();
		    }
		};
		final JComboBox cmbx_By = new JComboBox();
		// schedule the task to run starting now and then every hour...
		//timer.schedule (hourlyTask, 0l, 1000*10*60);   // 1000*10*60 every 10 minutes
		//timer.schedule (hourlyTask, 0l, 60*60); 
		timer.scheduleAtFixedRate(hourlyTask, 1000*10*60, 1000*10*60);
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
                if(comboBox.getSelectedIndex()==0){
                	cmbx_By.removeAllItems();
                		cmbx_By.insertItemAt("By Business", 0);
                		cmbx_By.insertItemAt("By Category", 1);
                		cmbx_By.insertItemAt("By City", 2);
                		cmbx_By.insertItemAt("By Current Location", 3);
                		cmbx_By.insertItemAt("Show all", 4);
                		cmbx_By.setVisible(true);
                }
                
                else{
                	cmbx_By.removeAllItems();
                		cmbx_By.insertItemAt("By Category", 0);
                		cmbx_By.insertItemAt("By City", 1);
                		cmbx_By.insertItemAt("By Current Location", 2);
                		cmbx_By.insertItemAt("Show all", 3);
                }
                	
                
				
			}
		});
		cmbx_Type.setModel(new DefaultComboBoxModel(new String[] {"Coupon", "Business"}));
		
		txt_search = new JTextField();
		txt_search.setColumns(10);
		
		
		cmbx_By.setModel(new DefaultComboBoxModel(new String[] {"By Business", "By Category", "By City", "By Current Location", "Show all"}));
		
		JButton btn_search = new JButton("Search");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = null;
				if(cmbx_Type.getSelectedIndex() == 0){
				switch (cmbx_By.getSelectedIndex()) {
				case 0:
					 model = cc.getCouponsByFilter("Business", txt_search.getText()); 
					break;
				case 1:
					 model = cc.getCouponsByFilter("Category", txt_search.getText()); 
					 break;
				case 2: 
					model = cc.getCouponsByCity(txt_search.getText());
					break;
				case 3:
					Location loc = lc.getLocationByIp();
					try{
					model = cc.getCouponsByLocation(loc.getLongitude(),loc.getLatitude(),Integer.parseInt(txt_search.getText()));
					}
					catch (Exception e2) {
						System.err.println("Bad inputs");
						model = cc.getApprovedCoupons();
					}
					break;
				default:
					model = cc.getApprovedCoupons();
					break;
				}
				
for(int i=0;i<model.getRowCount(); i++){
		        	
	model.setValueAt("Purchase", i, 7);

		        }
				
				
				 Action purchase = new AbstractAction()
			        {
			            public void actionPerformed(ActionEvent e)
			            {
			                JTable table = (JTable)e.getSource();
			                int modelRow = Integer.valueOf( e.getActionCommand() );

			               cc.purchaseCoupon((String)table.getValueAt(modelRow, 0), uc.getUsername());
			               
			               JOptionPane.showMessageDialog((JFrame)cmbx_By.getTopLevelAncestor(), uc.getUsername()+" bought " + (String)table.getValueAt(modelRow, 0));

			            }
			        };
			         table.setModel(model);
			        ButtonColumn buttonColumn = new ButtonColumn(table, purchase, 7);
				}
				else{
					switch (cmbx_By.getSelectedIndex()) {
					case 0:
						 model = bc.getBusinessByFilter("Category", txt_search.getText()); 
						break;
					case 1:
						 model = bc.getBusinessByFilter("City", txt_search.getText()); 
						 break;
					case 2:
						Location loc = lc.getLocationByIp();
						try{
						model = bc.getBusinessByLocation(loc.getLongitude(),loc.getLatitude(),Integer.parseInt(txt_search.getText()));
						}
						catch (Exception e2) {
							System.err.println("Bad inputs");
							model = bc.getBusinessesDetails();
						}
						break;
					default:
						model = bc.getBusinessesDetails();
						break;
					}
					table.setModel(model);	
				}
				
			}
		});
		
	
		DefaultTableModel coupons = cc.getApprovedCoupons();
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

	               cc.purchaseCoupon((String)table.getValueAt(modelRow, 0), uc.getUsername());
	               uc.initializePurchases(DAL.getInstance().getUsername());
	    
	               JOptionPane.showMessageDialog((JFrame)cmbx_By.getTopLevelAncestor(), uc.getUsername()+" bought " + (String)table.getValueAt(modelRow, 0));

	            }
	        };
	         
	        ButtonColumn buttonColumn = new ButtonColumn(table, purchase, 7);
		
		
		
		
		
		
		
		
		
		
		JButton btnObserveMyCoupons = new JButton("Observe My Coupons");
		btnObserveMyCoupons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame newFrame = new CustomersCoupons(); //TODO: Gave sl
				
			}
		});
		
		JButton btnLogout = new JButton("logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f=new LoginFrame();
				setVisible(false);
				f.setVisible(true);
			}
		});
		
		JLabel lblAlertsMode = new JLabel("Alerts Mode:");
		
		final JComboBox cmbx_Mode = new JComboBox();
		cmbx_Mode.setModel(new DefaultComboBoxModel(new String[] {"By Preferences", "By Location", "Mixed"}));
		cmbx_Mode.setSelectedIndex(uc.getMode());
		cmbx_Mode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				uc.setMode(cmbx_Mode.getSelectedIndex());
				lastModel = createModel();
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSearch)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbx_Type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txt_search, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(cmbx_By, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btn_search)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogout)
					.addContainerGap(67, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(227, Short.MAX_VALUE)
					.addComponent(btnObserveMyCoupons, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
					.addGap(217))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(183)
					.addComponent(lblAlertsMode)
					.addGap(18)
					.addComponent(cmbx_Mode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(433, Short.MAX_VALUE))
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
						.addComponent(btn_search)
						.addComponent(btnLogout))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlertsMode)
						.addComponent(cmbx_Mode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
					.addComponent(btnObserveMyCoupons, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(groupLayout);
	}
	
	
	
	
	
	
	
	void checkNotificationByPreference(){
		if(uc.getNumAlertsToday() < 10){
		DefaultTableModel newModel = createModel();
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i < newModel.getRowCount(); i++){
			if(inTable((String)newModel.getValueAt(i, 0), lastModel)==false) 
				list.add((String)newModel.getValueAt(i, 0));
				
		}
		
		if(!list.isEmpty()){
			uc.Alerted();
			String newCoupons = "There are new coupons: \n";
			for (int i = 0; i < list.size(); i++) {
				newCoupons+= list.get(i) + "\n";
			}
		
			JOptionPane.showMessageDialog(this, newCoupons, "NEW COUPONS",JOptionPane.INFORMATION_MESSAGE);
		}
		
		lastModel = newModel;
		}
		else{
			//quota of alerts reached
		}
	}
	
	private boolean inTable(String item,DefaultTableModel table){
		for (int i = 0; i < table.getRowCount(); i++) {
			if(table.getValueAt(i, 0).equals(item))
				return true;
		}
		return false;
	}
	
	private DefaultTableModel createModel(){
		switch (uc.getMode()) {
		case 0:
			return cc.getCouponsByPreference(uc.getUsername());
		case 1:
			Location loc = lc.getLocationByIp();
			try{
			return cc.getCouponsByLocation(loc.getLongitude(),loc.getLatitude(),10);
			}
			catch (Exception e2) {
				System.err.println("Bad inputs");
				return cc.getCouponsByPreference(uc.getUsername());
			}
			
		case 2:
			Location loc2 = lc.getLocationByIp();
			try{
			return cc.getCouponsByPreferencesAndLocation(uc.getUsername() ,loc2.getLongitude(),loc2.getLatitude(),10);
			}
			catch (Exception e2) {
				System.err.println("Bad inputs");
				return cc.getCouponsByPreference(uc.getUsername());
			}

		default:
			return cc.getCouponsByPreference(uc.getUsername());
		}
		
	}
}
