package bl;

import javax.swing.table.DefaultTableModel;

import bl_backend.Admin;
import bl_backend.Business;
import bl_backend.BusinessOwner;
import bl_backend.Category;
import bl_backend.Coupon;
import bl_backend.Customer;
import bl_backend.Purchase;

public interface IBL {

	boolean tryLogin(String username, String password, String authType);

	boolean updatePurchaseRating(String serialKey, int rating);

	DefaultTableModel getCouponsNamesRatings(String customerName);

	boolean updateCoupon(Coupon coupon);

	DefaultTableModel getCouponsDetails();

	boolean useCoupon(String serialKey);

	boolean signUp(String username, String password, String email, String phone);

	String getPasswordByUsername(String username, String authType);

	String getEmailByUsername(String username, String authType);

	void insertBusinessOwner(BusinessOwner owner);

	void insertBusiness(Business business);

	void insertCoupon(Coupon coupon);

	int getNumOfUnapprovedCoupons();

	DefaultTableModel getResultset(String table);

	DefaultTableModel getApprovedCoupons();

	DefaultTableModel getCouponsByFilter(String text, String filter);

	DefaultTableModel getBusinessByFilter(String text, String filter);

	void purchaseCoupon(String couponName, String customerName);

	DefaultTableModel getCouponsByPreference(String customerName);

	void insertCustomer(Customer customer);

	Customer selectCustomer(String username);

	void deleteCustomer(String username);

	void insertAdmin(Admin admin);

	Admin selectAdmin(String username);

	void deleteAdmin(String username);

	void inserBusinessOwner(BusinessOwner owner);

	BusinessOwner selectBusinessOwner(String username);

	void deleteBusinessOwner(String username);

	void updateBusinessOwner(BusinessOwner owner);

	Business selectBusiness(String name);

	void deleteBusiness(String name);

	void insertCategory(Category category);

	Coupon selectCoupon(String name);

	void deleteCoupon(String name);

	void deleteCategory(int id);

	void insertPurchase(Purchase purchase);

	Purchase selectPurchase(String serialKey);

	void deletePurchase(String serialKey);

	void updatePurchase(Purchase purchase);

}
