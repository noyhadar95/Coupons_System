package client.bl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;
public interface ICouponController {

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
	 * @param coupon
	 * @return true if update succeed
	 */
	boolean updateCoupon(Coupon coupon);
	
	/**
	 * returns a DefaultTableModel object that contains the details of all the
	 * coupons in the db.
	 * 
	 * @return a DefaultTableModel object.
	 */
	DefaultTableModel getCouponsDetails();

	
	/**
	 * updates the coupon with the name of a given coupon, according to the
	 * fields of the given coupon.
	 * 
	 * @param coupon
	 *            a coupon with the updated fields.
	 */
	void updateCouponByAdmin(Coupon coupon);

	/**
	 * insert coupon into database
	 * @param coupon
	 */
	void insertCoupon(Coupon coupon);
	
	
	/**
	 * 
	 * @return number of unaproved coupon 
	 */
	int getNumOfUnapprovedCoupons();
	
	
	/**
	 * * returns a DefaultTableModel object that contains the details of all the
	 * approved coupons in the db. 
	 * @return a DefaultTableModel object.
	 */
	DefaultTableModel getApprovedCoupons();
	
	
	/**
	 *
	 * returns a DefaultTableModel object that contains the details of all
	 *  coupons in the db that correspond to the filter. 
	 * @param filter
	 * @param text
	 * @return a DefaultTableModel object. 
	 */
	DefaultTableModel getCouponsByFilter(String filter, String text);
	
	
	/**
	 * returns a DefaultTableModel object that contains the details of all
	 *  coupons in the db that correspond to the preference. 
	 * @param customerName
	 * @return a DefaultTableModel object.
	 */
	DefaultTableModel getCouponsByPreference(String customerName);
	
	
	/**
	 * select Coupon
	 * @param name
	 * @return coupon 
	 */
	Coupon selectCoupon(String name);

	/**
	 * delete coupon
	 * @param name
	 */
	void deleteCoupon(String name);
	
	public DefaultTableModel getResultset(String table);
	
	public List getTableArrayList(String string);
	
	public void purchaseCoupon(String couponName, String customerName);

	DefaultTableModel getCouponsByCity(String city);

	DefaultTableModel getCouponsByLocation(double longitude, double latitude,
			double radius);

	DefaultTableModel getCouponsByPreferencesAndLocation(String customerName,
			double longitude, double latitude, double radius);
}
