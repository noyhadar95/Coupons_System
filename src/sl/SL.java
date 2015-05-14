package sl;

import javax.swing.table.DefaultTableModel;

import bl.BL;
import bl.IBL;
import bl_backend.Coupon;

public class SL implements ISL {

	IBL bl;

	public SL() {
		bl = new BL();
	}

	@Override
	public boolean tryLogin(String username, String password, String authType) {
		return bl.tryLogin(username, password, authType);
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

	@Override
	public DefaultTableModel getCouponsDetails() {
		return bl.getCouponsDetails();
	}

	@Override
	public boolean useCoupon(String serialKey) {
		return bl.useCoupon(serialKey);
	}
}
