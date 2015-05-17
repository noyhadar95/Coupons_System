package sl;

import javax.swing.table.DefaultTableModel;

import bl.BL;
import bl.IBL;
import bl_backend.Business;
import bl_backend.BusinessOwner;
import bl_backend.Coupon;

public class SL implements ISL {

	IBL bl;

	public SL() {
		bl = new BL();
	}

	@Override
	public boolean tryLogin(String username, String password, String authType) {
		return bl.tryLogin(username, password, authType);
	}

	@Override
	public DefaultTableModel getCouponsNamesRatings(String customerName) {
		return bl.getCouponsNamesRatings(customerName);
	}

	@Override
	public boolean updatePurchaseRating(String serialKey, int rating) {
		return bl.updatePurchaseRating(serialKey, rating);
	}

	@Override
	public boolean updateCouponByAdmin(Coupon coupon) {
		return bl.updateCoupon(coupon);
	}

	@Override
	public DefaultTableModel getCouponsDetails() {
		return bl.getCouponsDetails();
	}

	@Override
	public boolean useCoupon(String serialKey) {
		return bl.useCoupon(serialKey);
	}

	@Override
	public boolean signUp(String username, String password, String email,
			String phone) {
		return bl.signUp(username, password, email, phone);
	}

	@Override
	public String getPasswordByUsername(String username, String authType) {
		return bl.getPasswordByUsername(username, authType);
	}

	@Override
	public String getEmailByUsername(String username, String authType) {
		return bl.getEmailByUsername(username, authType);
	}

	public void insertBusinessOwner(BusinessOwner owner) {
		bl.insertBusinessOwner(owner);
	}

	public void insertBusiness(Business business) {
		bl.insertBusiness(business);
	}

	public void insertCoupon(Coupon coupon) {
		bl.insertCoupon(coupon);
	}

	public int getNumOfUnapprovedCoupons() {
		return bl.getNumOfUnapprovedCoupons();
	}

	public DefaultTableModel getResultset(String table) {
		return bl.getResultset(table);
	}

	@Override
	public DefaultTableModel getApprovedCoupons() {
		return bl.getApprovedCoupons();
	}

	@Override
	public DefaultTableModel getCouponsByFilter(String filter, String text) {
		return bl.getCouponsByFilter(filter, text);
	}

	@Override
	public DefaultTableModel getBusinessByFilter(String filter, String text) {
		return bl.getBusinessByFilter(filter, text);
	}

	@Override
	public void purchaseCoupon(String couponName, String customerName) {
		bl.purchaseCoupon(couponName, customerName);

	}

	@Override
	public DefaultTableModel getCouponsByPreference(String customerName) {
		return bl.getCouponsByPreference(customerName);
	}

}
