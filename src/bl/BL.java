package bl;

import java.util.UUID;

import javax.swing.table.DefaultTableModel;

import bl_backend.*;
import dal.DAL;
import dal.IDAL;

public class BL implements IBL {

	private IDAL dal;

	public BL() {
		dal = new DAL();
	}

	@Override
	public boolean tryLogin(String username, String password, String authType) {
		boolean successFlag = false;
		User user = getUserByAuthType(username, authType);

		if (user != null && user.getUsername().equals(username)
				&& user.getPassword().equals(password)) {
			successFlag = true;
		}

		return successFlag;
	}

	@Override
	public boolean updatePurchaseRating(String serialKey, int rating) {
		Purchase purchase = dal.selectPurchase(serialKey);
		if (purchase == null)
			return false;
		// update the rating of the purchase
		purchase.setRating(rating);
		dal.updatePurchase(purchase);

		// calculate average rating for the newly rated coupon in the coupons
		// table
		String couponName = purchase.getCouponName();
		Coupon coupon = dal.selectCoupon(couponName);
		int avgRating = (coupon.getRating() + rating) / 2;
		coupon.setRating(avgRating);

		// update the rating of the coupon
		dal.updateCoupon(coupon);

		return true;
	}

	@Override
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
	public boolean useCoupon(String serialKey) {
		Purchase purchase = dal.selectPurchase(serialKey);
		if (purchase == null)
			return false;

		// update the used field of the purchase to 1 ("used")
		purchase.setUsed(1);
		dal.updatePurchase(purchase);

		return true;
	}

	@Override
	public boolean signUp(String username, String password, String email,
			String phone) {
		Customer cus = new Customer(username, password, email, phone);
		dal.insertCustomer(cus);
		return true;
	}

	@Override
	public String getPasswordByUsername(String username, String authType) {
		String pass = null;
		User user = getUserByAuthType(username, authType);

		if (user != null && user.getUsername().equals(username)) {
			pass = user.getPassword();
		}

		return pass;
	}

	// return a User object from the database according to the given username
	// and authorization type.
	// returns NULL if no user was found.
	private User getUserByAuthType(String username, String authType) {
		User user = null;

		switch (authType) {
		case "Admin":
			user = dal.selectAdmin(username);
			break;
		case "Customer":
			user = dal.selectCustomer(username);
			break;
		case "Bussines Owner":
			user = dal.selectBusinessOwner(username);
			break;
		default:
			break;
		}

		return user;
	}

	@Override
	public String getEmailByUsername(String username, String authType) {
		String email = null;
		User user = getUserByAuthType(username, authType);

		if (user != null && user.getUsername().equals(username)) {
			email = user.getEmail();
		}

		return email;
	}

	@Override
	public void insertBusinessOwner(BusinessOwner owner) {
		dal.inserBusinessOwner(owner);

	}

	@Override
	public void insertBusiness(Business business) {
		dal.insertBusiness(business);

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
	public DefaultTableModel getResultset(String table) {
		return dal.getResultset(table);
	}

	@Override
	public DefaultTableModel getApprovedCoupons() {
		return dal.getApprovedCoupons();
	}

	@Override
	public DefaultTableModel getCouponsByFilter(String text, int filter) {
		return dal.getCouponsByFilter(text, filter);
	}

	@Override
	public DefaultTableModel getBusinessByFilter(String text, int filter) {
		return dal.getBusinessByFilter(text, filter);
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
	public DefaultTableModel getCouponsByPreference(String customerName) {
		return dal.getCouponsByPreference(customerName);
	}

}
