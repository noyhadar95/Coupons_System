package client.bl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;
public class CouponController implements ICouponController {
	private ISL sl;

	public CouponController() {
		sl = new SL();
	}
	
	@Override
	public DefaultTableModel getCouponsNamesRatings(String customerName) {
		return sl.getCouponsNamesRatings(customerName);
	}
	@Override
	public boolean updateCoupon(Coupon coupon) {
		sl.updateCoupon(coupon);
		return true;
	}
	
	@Override
	public DefaultTableModel getCouponsDetails() {
		return sl.getCouponsDetails();
	}
	
	public void insertCoupon(Coupon coupon) {
		sl.insertCoupon(coupon);
	}
	
	public int getNumOfUnapprovedCoupons() {
		return sl.getNumOfUnapprovedCoupons();
	}
	@Override
	public DefaultTableModel getApprovedCoupons() {
		return sl.getApprovedCoupons();
	}
	@Override
	public DefaultTableModel getCouponsByFilter(String filter, String text) {
		return sl.getCouponsByFilter(filter, text);
	}
	
	@Override
	public DefaultTableModel getCouponsByPreference(String customerName) {
		return sl.getCouponsByPreference(customerName);
	}

	@Override
	public void deleteCoupon(String name) {
		sl.deleteCoupon(name);
	}
	
	@Override
	public void updateCouponByAdmin(Coupon coupon) {
		sl.updateCoupon(coupon);
	}

	@Override
	
	public Coupon selectCoupon(String name) {
		return sl.selectCoupon(name);
	}
	
	@Override
	public DefaultTableModel getResultset(String table) {
		return sl.getResultset(table);
	}
	
	@Override
	public List getTableArrayList(String string) {
		return sl.getTableArrayList(string);
	}
	
}
