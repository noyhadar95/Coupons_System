package sl;

import javax.swing.table.DefaultTableModel;

import bl_backend.Coupon;

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

	String getPasswordByUsername(String username, String authType);

	String getEmailByUsername(String username, String authType);

}
