package bl;

import javax.swing.table.DefaultTableModel;

import bl_backend.Coupon;

public interface IBL {

	boolean tryLogin(String username, String password, String authType);

	boolean updatePurchaseRating(String serialKey, int rating);

	DefaultTableModel getCouponsNamesRatings(String customerName);

	boolean updateCoupon(Coupon coupon);

	DefaultTableModel getCouponsDetails();

	boolean useCoupon(String serialKey);

}
