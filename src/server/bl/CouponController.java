package server.bl;

import javax.swing.table.DefaultTableModel;

import server.bl_backend.Coupon;
import server.dal.DAL;
import server.dal.IDAL;

public class CouponController implements ICouponController {
	private IDAL dal;

	public CouponController() {
		dal = new DAL();
	}
	
	public DefaultTableModel getCouponsNamesRatings(String customerName) {
		return dal.selectCouponsNamesRatingsByCustomer(customerName);
	}
	
	@Override
	public boolean updateCoupon(Coupon coupon) {
		dal.updateCoupon(coupon);
		return true;
	}
	
	@Override
	public DefaultTableModel getCouponsDetails() {
		return dal.selectAllCoupons();
	}
	
	@Override
	public void insertCoupon(Coupon coupon) {
		dal.insertCoupon(coupon);

	}
	
	@Override
	public int getNumOfUnapprovedCoupons() {
		return dal.getNumOfUnapprovedCoupons();
	}
	@Override
	public DefaultTableModel getApprovedCoupons() {
		return dal.getApprovedCoupons();
	}
	
	@Override
	public DefaultTableModel getCouponsByFilter(String filter, String text) {
		return dal.getCouponsByFilter(filter, text);
	}
	
	@Override
	public DefaultTableModel getCouponsByPreference(String customerName) {
		return dal.getCouponsByPreference(customerName);
	}
	
	@Override
	public Coupon selectCoupon(String name) {
		return dal.selectCoupon(name);
	}
	
	@Override
	public void deleteCoupon(String name) {
		dal.deleteCoupon(name);
		
	}
	
}
