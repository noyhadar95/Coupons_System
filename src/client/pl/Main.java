package pl;

import javax.swing.JFrame;

import dal.DAL;

public class Main {

	public static void main(String[] args) {
		JFrame couponSystem=new LoginFrame();
		couponSystem.setVisible(true);
		DAL dal=new DAL();
		dal.testAddDeleteCoupon1();//adding some sample records to the db

	}

}
