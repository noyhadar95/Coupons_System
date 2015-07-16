package client.dal;

import java.awt.List;
import java.util.ArrayList;

import auxiliary.bl_backend.*;

public class DAL implements IDAL{
	private static DAL instance=null;
	private String username=null;
	private ArrayList<auxiliary.bl_backend.Coupon> coupons;
	
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
	
	
}
