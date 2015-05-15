package sl;

import javax.swing.table.DefaultTableModel;

public interface TempSL extends ISL{
	
	//Gets all of the coupons that are approved
	DefaultTableModel getAllCoupons();
	

	//if text is "" then return all
	//text = text
	//type = 1-By Category
	//2-By City
	//3-By Sensor
	//4-By Map
	DefaultTableModel getCouponsByFilter(String text, int type);
	//if 
	//text = text
		//type = 1-By Category
		//2-By City
		//3-By Sensor
		//4-By Map
	DefaultTableModel getBusinessByFilter(String text, int type);
	
	//Purchase Coupon
	boolean purchaseCoupon(String customerName, String couponName);
	
	DefaultTableModel getCouponsByPreference(String customerName);
	
}
