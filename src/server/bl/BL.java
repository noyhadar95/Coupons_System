package server.bl;

import java.util.List;
import java.util.UUID;

import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.*;
import server.dal.DAL;
import server.dal.IDAL;

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
	
	public boolean updateBusiness(Business business){
		dal.updateBusiness(business);
		return true;
		
	}

	@Override
	public DefaultTableModel getCouponsDetails() {
		return dal.selectAllCoupons();
	}
	
	@Override
	public DefaultTableModel getBusinessesDetails() {
		return dal.selectAllBusinesses();
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
	public DefaultTableModel getCouponsByFilter(String filter, String text) {
		return dal.getCouponsByFilter(filter, text);
	}

	@Override
	public DefaultTableModel getBusinessByFilter(String filter, String text) {
		return dal.getBusinessByFilter(filter, text);
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

	@Override
	public void insertCustomer(Customer customer) {
		dal.insertCustomer(customer);
		
	}

	@Override
	public Customer selectCustomer(String username) {
		return dal.selectCustomer(username);
	}

	@Override
	public void deleteCustomer(String username) {
		dal.deleteCustomer(username);
		
	}

	@Override
	public void insertAdmin(Admin admin) {
		dal.insertAdmin(admin);
		
	}

	@Override
	public Admin selectAdmin(String username) {
		return dal.selectAdmin(username);
	}

	@Override
	public void deleteAdmin(String username) {
		dal.deleteAdmin(username);
		
	}

	@Override
	public void inserBusinessOwner(BusinessOwner owner) {
		dal.inserBusinessOwner(owner);
		
	}

	@Override
	public BusinessOwner selectBusinessOwner(String username) {
		return dal.selectBusinessOwner(username);
	}

	@Override
	public void deleteBusinessOwner(String username) {
		dal.deleteBusinessOwner(username);
		
	}

	@Override
	public void updateBusinessOwner(BusinessOwner owner) {
		dal.updateBusinessOwner(owner);
		
	}

	@Override
	public Business selectBusiness(String name) {
		return dal.selectBusiness(name);
	}

	@Override
	public void deleteBusiness(String name) {
		dal.deleteBusiness(name);
		
	}

	@Override
	public void insertCategory(Category category) {
		dal.insertCategory(category);
		
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
	public void deleteCategory(int id) {
		dal.deleteCategory(id);
		
	}

	@Override
	public void insertPurchase(Purchase purchase) {
		dal.insertPurchase(purchase);
		
	}

	@Override
	public Purchase selectPurchase(String serialKey) {
		return dal.selectPurchase(serialKey);
	}

	@Override
	public void deletePurchase(String serialKey) {
		dal.deletePurchase(serialKey);
		
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		dal.updatePurchase(purchase);
		
	}

	@Override
	public List getTableArrayList(String string) {
		return dal.getTableArrayList(string);
	}

}
