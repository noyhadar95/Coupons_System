package client.dal;

import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;


public class DAL implements IDAL{
	private static DAL instance=null;
	private String username=null;
	private ArrayList<auxiliary.bl_backend.Coupon> coupons=null;
	private Vector<Vector<Object>> purchases;
	private int mode = 0; //0 - preferences, 1 - location, 2 -mixed
	private int numAlertsToday = 0;
	private DAL(){	}
	
	public static DAL getInstance(){
		if(instance==null)
			instance=new DAL();
	      return instance;
	   }
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void initializePurchases(Vector<Vector<Object>> purchases){
		System.out.println("init purchases");
		this.purchases=purchases;
	}
	
	public Vector<Vector<Object>> getPurchases(){
		return this.purchases;
	}
	
	public void setMode(int mode){
		this.mode = mode;
	}
	
	public int getMode(){
		return this.mode;
	}
	
	public int getNumAlertsToday(){
		return this.numAlertsToday;
	}
	
	public void Alerted(){
		this.numAlertsToday++;
	}
	
	
	
}
