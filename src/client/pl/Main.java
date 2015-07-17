package client.pl;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.GPS;
import server.dal.DAL;

public class Main {

	public static void main(String[] args) {
		JFrame couponSystem = new LoginFrame();
		couponSystem.setVisible(true);
		DAL dal = new DAL();
		GPS gps = new GPS();
		gps.start();
		DefaultTableModel model = dal.getLocationByIP("82.102.141.253");
		dal.testAddDeleteCoupon1();// adding some sample records to the db

	}

}
