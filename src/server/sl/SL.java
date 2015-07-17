package server.sl;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import server.bl.BL;
import server.bl.IBL;
import auxiliary.bl_backend.Admin;
import auxiliary.bl_backend.Business;
import auxiliary.bl_backend.BusinessOwner;
import auxiliary.bl_backend.Category;
import auxiliary.bl_backend.Coupon;
import auxiliary.bl_backend.Customer;
import auxiliary.bl_backend.Location;
import auxiliary.bl_backend.Purchase;

public class SL implements ISL {

	IBL bl;

	public SL() {
		bl = new BL();
	}

	@Override
	public boolean tryLogin(String username, String password, String authType) {
		boolean result= bl.tryLogin(username, password, authType);
		
		return result;
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
	public void updateBusinessByOwner(Business business){
		 bl.updateBusiness(business);
		
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

	@Override
	public void insertCustomer(Customer customer) {
		bl.insertCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(String username) {
		bl.deleteCustomer(username);
		
	}

	@Override
	public void inserBusinessOwner(BusinessOwner owner) {
		bl.inserBusinessOwner(owner);
		
	}

	@Override
	public void insertCategory(Category category) {
		bl.insertCategory(category);
		
	}

	@Override
	public void insertPurchase(Purchase purchase) {
		bl.insertPurchase(purchase);
		
	}

	@Override
	public void deletePurchase(String serialKey) {
		bl.deletePurchase(serialKey);
		
	}

	@Override
	public void deleteCoupon(String name) {
		bl.deleteCoupon(name);
	}

	@Override
	public void deleteCategory(int id) {
		bl.deleteCategory(id);
		
	}

	@Override
	public void deleteBusiness(String name) {
		bl.deleteBusiness(name);
		
	}

	@Override
	public void deleteBusinessOwner(String username) {
		bl.deleteBusinessOwner(username);
		
	}

	@Override
	public Customer selectCustomer(String username) {
		return bl.selectCustomer(username);
	}

	@Override
	public void insertAdmin(Admin admin) {
		bl.insertAdmin(admin);
		
	}

	@Override
	public Admin selectAdmin(String username) {
		return bl.selectAdmin(username);
	}

	@Override
	public void deleteAdmin(String username) {
		bl.deleteAdmin(username);
		
	}

	@Override
	public BusinessOwner selectBusinessOwner(String username) {
		return bl.selectBusinessOwner(username);
	}

	@Override
	public void updateBusinessOwner(BusinessOwner owner) {
		bl.updateBusinessOwner(owner);
		
	}

	@Override
	public Business selectBusiness(String name) {
		return bl.selectBusiness(name);
	}

	@Override
	public Coupon selectCoupon(String name) {
		return bl.selectCoupon(name);
	}

	@Override
	public void updateCoupon(Coupon coupon) {
		bl.updateCoupon(coupon);
		
	}

	@Override
	public Purchase selectPurchase(String serialKey) {
		return bl.selectPurchase(serialKey);
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		bl.updatePurchase(purchase);
		
	}

	@Override
	public DefaultTableModel getBusinessesDetails() {
		return bl.getBusinessesDetails();
	}

	@Override
	public List getTableArrayList(String string) {
		return bl.getTableArrayList(string);
	}
	
	@Override
	public Location getLocationByIp(String ip){
		return null; //TODO implement
	}

	@Override
	public Vector<Vector<Object>> getPruchases(String username) {
		return bl.getPruchases(username);
	}

}
