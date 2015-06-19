package server.bl;

import javax.swing.table.DefaultTableModel;

import server.bl_backend.Coupon;

public interface ICouponController {

	DefaultTableModel getCouponsNamesRatings(String customerName);
	
	boolean updateCoupon(Coupon coupon);
	
	DefaultTableModel getCouponsDetails();
	
	void insertCoupon(Coupon coupon);
	int getNumOfUnapprovedCoupons();
	
	DefaultTableModel getApprovedCoupons();
	
	DefaultTableModel getCouponsByFilter(String text, String filter);
	
	DefaultTableModel getCouponsByPreference(String customerName);
	
	Coupon selectCoupon(String name);

	void deleteCoupon(String name);
}
