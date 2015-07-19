package server.bl;

import java.util.List;
import java.util.UUID;

import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.Coupon;
import auxiliary.bl_backend.Purchase;
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
	
	@Override
	public DefaultTableModel getResultset(String table) {
		return dal.getResultset(table);
	}
	@Override
	public List getTableArrayList(String string) {
		return dal.getTableArrayList(string);
	}
	
	@Override
	public void purchaseCoupon(String couponName, String customerName) {
		String serial_key = genSerialKey();
		Purchase purchase = new Purchase(serial_key, 0, customerName,
				couponName, 0);
		dal.insertPurchase(purchase);
	}
	// returns a new special serial key.
		private String genSerialKey() {
			return UUID.randomUUID().toString().toUpperCase();

		}

		@Override
		public DefaultTableModel getCouponsByLocation(double longitude,
				double latitude, double radius) {
		return dal.getCouponsByLocation(latitude, longitude, radius);
		
		}
		
		@Override
		public DefaultTableModel getCouponsByCity(String city){
			return dal.getCouponsByCity(city);
		}
}
