package server.dal;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.*;

public interface IDAL {

	// insert
	void insertCustomer(Customer cus);

	void insertAdmin(Admin admin);

	void inserBusinessOwner(BusinessOwner owner);

	void insertBusiness(Business business);

	void insertCoupon(Coupon coupon);

	void insertPurchase(Purchase purchase);

	void insertCategory(Category category);

	// select
	Customer selectCustomer(String username);

	Admin selectAdmin(String username);

	BusinessOwner selectBusinessOwner(String username);

	Business selectBusiness(String name);

	Coupon selectCoupon(String name);

	Purchase selectPurchase(String serialKey);

	DefaultTableModel selectCouponsNamesRatingsByCustomer(String customerName);

	DefaultTableModel selectAllCoupons();

	// delete
	void deleteCustomer(String username);

	void deleteAdmin(String username);

	void deleteBusinessOwner(String username);

	void deleteBusiness(String name);

	void deleteCoupon(String name);

	void deletePurchase(String serialKey);

	void deleteCategory(int id);

	// update
	void updateBusinessOwner(BusinessOwner owner);

	void updateCoupon(Coupon coupon);

	void updatePurchase(Purchase purchase);

	// others
	DefaultTableModel getResultset(String string);

	List getTableArrayList(String table);

	int getNumOfUnapprovedCoupons();

	DefaultTableModel getApprovedCoupons();

	DefaultTableModel getCouponsByFilter(String filter, String text);

	DefaultTableModel getBusinessByFilter(String filter, String text);

	DefaultTableModel getCouponsByPreference(String customerName);

	DefaultTableModel selectAllBusinesses();

	void updateBusiness(Business business);


}
