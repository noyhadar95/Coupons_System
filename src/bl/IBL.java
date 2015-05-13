package bl;

import javax.swing.table.DefaultTableModel;

import bl_backend.Coupon;

public interface IBL {

	boolean tryLogin(String username, String password, String authType);

	boolean updateCouponRating(String couponName, int rating);

	DefaultTableModel getCouponsNamesRatings(String customerName);

	boolean updateCoupon(Coupon coupon);

	DefaultTableModel getCouponsDetails();

}
