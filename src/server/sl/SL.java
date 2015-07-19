package server.sl;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import server.bl.*;
import auxiliary.bl_backend.Admin;
import auxiliary.bl_backend.Business;
import auxiliary.bl_backend.BusinessOwner;
import auxiliary.bl_backend.Category;
import auxiliary.bl_backend.Coupon;
import auxiliary.bl_backend.Customer;
import auxiliary.bl_backend.Location;
import auxiliary.bl_backend.Purchase;

public class SL implements ISL {

	IUserController userCont;
	IPurchaseController purchaseCont;
	ICouponController couponCont;
	ICustomerController customerCont;
	ICategoryController categoryCont;
	IBusinessController businessCont;
	IBusinessOwnerController businessOwnerCont;
	IAdminController adminCont;
	ILocationController locationCont;

	public SL() {

		userCont = new UserController();
		purchaseCont = new PurchaseController();
		couponCont = new CouponController();
		customerCont = new CustomerController();
		categoryCont = new CategoryController();
		businessCont = new BusinessController();
		businessOwnerCont = new BusinessOwnerController();
		adminCont = new AdminController();
		locationCont = new LocationController();
	}

	@Override
	public boolean tryLogin(String username, String password, String authType) {
		boolean result = userCont.tryLogin(username, password, authType);

		return result;
	}

	@Override
	public DefaultTableModel getCouponsNamesRatings(String customerName) {
		return couponCont.getCouponsNamesRatings(customerName);
	}

	@Override
	public boolean updatePurchaseRating(String serialKey, int rating) {
		return purchaseCont.updatePurchaseRating(serialKey, rating);
	}

	@Override
	public boolean updateCouponByAdmin(Coupon coupon) {
		return couponCont.updateCoupon(coupon);
	}

	public void updateBusinessByOwner(Business business) {
		businessCont.updateBusiness(business);

	}

	@Override
	public DefaultTableModel getCouponsDetails() {
		return couponCont.getCouponsDetails();
	}

	@Override
	public boolean useCoupon(String serialKey) {
		return purchaseCont.useCoupon(serialKey);
	}

	@Override
	public boolean signUp(String username, String password, String email,
			String phone) {
		return userCont.signUp(username, password, email, phone);
	}

	@Override
	public String getPasswordByUsername(String username, String authType) {
		return userCont.getPasswordByUsername(username, authType);
	}

	@Override
	public String getEmailByUsername(String username, String authType) {
		return userCont.getEmailByUsername(username, authType);
	}

	public void insertBusinessOwner(BusinessOwner owner) {
		businessOwnerCont.insertBusinessOwner(owner);
	}

	public void insertBusiness(Business business) {
		businessCont.insertBusiness(business);
	}

	public void insertCoupon(Coupon coupon) {
		couponCont.insertCoupon(coupon);
	}

	public int getNumOfUnapprovedCoupons() {
		return couponCont.getNumOfUnapprovedCoupons();
	}

	public DefaultTableModel getResultset(String table) {
		// can use either couponCont, businessCont or purchaseCont
		return couponCont.getResultset(table);
	}

	@Override
	public DefaultTableModel getApprovedCoupons() {
		return couponCont.getApprovedCoupons();
	}

	@Override
	public DefaultTableModel getCouponsByFilter(String filter, String text) {
		return couponCont.getCouponsByFilter(filter, text);
	}

	@Override
	public DefaultTableModel getBusinessByFilter(String filter, String text) {
		return businessCont.getBusinessByFilter(filter, text);
	}

	@Override
	public void purchaseCoupon(String couponName, String customerName) {
		couponCont.purchaseCoupon(couponName, customerName);

	}

	@Override
	public DefaultTableModel getCouponsByPreference(String customerName) {
		return couponCont.getCouponsByPreference(customerName);
	}

	@Override
	public void insertCustomer(Customer customer) {
		customerCont.insertCustomer(customer);

	}

	@Override
	public void deleteCustomer(String username) {
		customerCont.deleteCustomer(username);

	}

	@Override
	public void inserBusinessOwner(BusinessOwner owner) {
		businessOwnerCont.insertBusinessOwner(owner);

	}

	@Override
	public void insertCategory(Category category) {
		categoryCont.insertCategory(category);

	}

	@Override
	public void insertPurchase(Purchase purchase) {
		purchaseCont.insertPurchase(purchase);

	}

	@Override
	public void deletePurchase(String serialKey) {
		purchaseCont.deletePurchase(serialKey);

	}

	@Override
	public void deleteCoupon(String name) {
		couponCont.deleteCoupon(name);
	}

	@Override
	public void deleteCategory(int id) {
		categoryCont.deleteCategory(id);

	}

	@Override
	public void deleteBusiness(String name) {
		businessCont.deleteBusiness(name);

	}

	@Override
	public void deleteBusinessOwner(String username) {
		businessOwnerCont.deleteBusinessOwner(username);

	}

	@Override
	public Customer selectCustomer(String username) {
		return customerCont.selectCustomer(username);
	}

	@Override
	public void insertAdmin(Admin admin) {
		adminCont.insertAdmin(admin);

	}

	@Override
	public Admin selectAdmin(String username) {
		return adminCont.selectAdmin(username);
	}

	@Override
	public void deleteAdmin(String username) {
		adminCont.deleteAdmin(username);

	}

	@Override
	public BusinessOwner selectBusinessOwner(String username) {
		return businessOwnerCont.selectBusinessOwner(username);
	}

	@Override
	public void updateBusinessOwner(BusinessOwner owner) {
		businessOwnerCont.updateBusinessOwner(owner);

	}

	@Override
	public Business selectBusiness(String name) {
		return businessCont.selectBusiness(name);
	}

	@Override
	public Coupon selectCoupon(String name) {
		return couponCont.selectCoupon(name);
	}

	@Override
	public void updateCoupon(Coupon coupon) {
		couponCont.updateCoupon(coupon);

	}

	@Override
	public Purchase selectPurchase(String serialKey) {
		return purchaseCont.selectPurchase(serialKey);
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		purchaseCont.updatePurchase(purchase);

	}

	@Override
	public DefaultTableModel getBusinessesDetails() {
		return businessCont.getBusinessesDetails();
	}

	@Override
	public List getTableArrayList(String string) {
		// can use either couponCont or businessCont
		return couponCont.getTableArrayList(string);
	}

	@Override
	public Location getLocationByIp(String ip) {
		return locationCont.getLocationByIp(ip);
	}

	@Override
	public Vector<Vector<Object>> getPruchases(String username) {
		return purchaseCont.getPruchases(username);
	}
	
	@Override
	public DefaultTableModel getCouponsByCity(String city){
		return couponCont.getCouponsByCity(city);
		
	}
	
	@Override
	public DefaultTableModel getCouponsByLocation(double longitude,double latitude,double radius){
		return couponCont.getCouponsByLocation(longitude, latitude, radius);
	}
	
	@Override
	public DefaultTableModel getBusinessByLocation(double longitude, double latitude, double radius){
		return businessCont.getBusinessByLocation(longitude, latitude, radius);
	}
	
	@Override 
	public DefaultTableModel getCouponsByPreferencesAndLocations(String customerName, double longitude, double latitude, double radius){
		return couponCont.getCouponsByPreferencesAndLocations(customerName, longitude, latitude, radius);
	}

}
