package server.bl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.Coupon;

public interface ICouponController {

	DefaultTableModel getCouponsNamesRatings(String customerName);
	
	boolean updateCoupon(Coupon coupon);
	
	DefaultTableModel getCouponsDetails();
	
	void insertCoupon(Coupon coupon);
	int getNumOfUnapprovedCoupons();
	
	DefaultTableModel getApprovedCoupons();
	
	DefaultTableModel getCouponsByFilter(String text, String filter);
	
	DefaultTableModel getCouponsByLocation(double longitude, double latitude, double radius);
	
	DefaultTableModel getCouponsByPreference(String customerName);
	
	Coupon selectCoupon(String name);

	void deleteCoupon(String name);
	
	public DefaultTableModel getResultset(String table);
	
	public List getTableArrayList(String string) ;
	
	public void purchaseCoupon(String couponName, String customerName);
}
