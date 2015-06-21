package server.sl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.Admin;
import auxiliary.bl_backend.Business;
import auxiliary.bl_backend.BusinessOwner;
import auxiliary.bl_backend.Category;
import auxiliary.bl_backend.Coupon;
import auxiliary.bl_backend.Customer;
import auxiliary.bl_backend.Purchase;

public interface ISL {

	/**
	 * try to login with the given username and password as the given
	 * authorization, according to auth type.
	 * 
	 * @param username
	 *            username to login with.
	 * @param password
	 *            password to login with.
	 * @param authType
	 *            the type of the authorization that is trying to login.
	 * @return if login succeeded return true, else return false.
	 */
	boolean tryLogin(String username, String password, String authType);

	/**
	 * updates the rating field of a specific purchase according to a given
	 * purchase serial key.
	 * 
	 * @param serialKey
	 *            the serial key (id) of the purchase.
	 * @param rating
	 *            the new rating to be set
	 * @return true on success, false otherwise.
	 */
	boolean updatePurchaseRating(String serialKey, int rating);

	/**
	 * returns a DefaultTableModel containing the details of all coupon names
	 * and rating for a specific customer.
	 * 
	 * @param customerName
	 *            the name of the requesting customer.
	 * @return a DefaultTableModel.
	 */
	DefaultTableModel getCouponsNamesRatings(String customerName);

	/**
	 * updates the coupon with the name of a given coupon, according to the
	 * fields of the given coupon.
	 * 
	 * @param coupon
	 *            a coupon with the updated fields.
	 * @return true on success, false otherwise.
	 */
	boolean updateCouponByAdmin(Coupon coupon);

	/**
	 * returns a DefaultTableModel object that contains the details of all the
	 * coupons in the db.
	 * 
	 * @return a DefaultTableModel object.
	 */
	DefaultTableModel getCouponsDetails();

	/**
	 * update the status of the coupon in the given purchase to used.
	 * 
	 * @param serialKey
	 *            the serial key of a purchase.
	 * @return true on success, false otherwise.
	 */
	boolean useCoupon(String serialKey);

	/**
	 * sign up a new user account in the database with the given fields.
	 * 
	 * @param username
	 *            username to login with.
	 * @param password
	 *            password to login with.
	 * @param email
	 *            email to login with.
	 * @param phone
	 *            phone to login with.
	 * @return true on success, false otherwise.
	 */
	boolean signUp(String username, String password, String email, String phone);

	/**
	 * return the password of a specific user by it's username.
	 * 
	 * @param username
	 *            the user's username.
	 * @param authType
	 *            the authorization type of the user.
	 * @return
	 */
	String getPasswordByUsername(String username, String authType);

	/**
	 * 
	 * @param username
	 * @param authType
	 * @return
	 */
	String getEmailByUsername(String username, String authType);

	void insertBusinessOwner(BusinessOwner owner);

	void insertBusiness(Business business);

	void insertCoupon(Coupon coupon);

	int getNumOfUnapprovedCoupons();

	DefaultTableModel getResultset(String table);
	
	DefaultTableModel getApprovedCoupons();

	DefaultTableModel getCouponsByFilter(String filter, String text);
	
	DefaultTableModel getBusinessByFilter(String filter, String text);
	
	void purchaseCoupon(String couponName, String customerName);
	
	DefaultTableModel getCouponsByPreference(String customerName);

	void insertCustomer(Customer customer);

	void deleteCustomer(String username);

	void inserBusinessOwner(BusinessOwner owner);

	void insertCategory(Category category);

	void insertPurchase(Purchase purchase);

	void deletePurchase(String serialKey);

	void deleteCoupon(String name);

	void deleteCategory(int id);

	void deleteBusiness(String name);

	void deleteBusinessOwner(String username);

	Customer selectCustomer(String username);

	void insertAdmin(Admin admin);

	Admin selectAdmin(String username);

	void deleteAdmin(String username);

	BusinessOwner selectBusinessOwner(String username);

	void updateBusinessOwner(BusinessOwner owner);

	Business selectBusiness(String name);

	Coupon selectCoupon(String name);

	void updateCoupon(Coupon coupon);

	Purchase selectPurchase(String serialKey);

	void updatePurchase(Purchase purchase);
	
	void setUsername(String username);
	
	String getUsername();
	/**
	 * returns a DefaultTableModel object that contains the details of all the
	 * businesses in the db.
	 * 
	 * @return a DefaultTableModel object.
	 */
	
	DefaultTableModel getBusinessesDetails();

	void updateBusinessByOwner(Business business);

	List getTableArrayList(String string);

}
