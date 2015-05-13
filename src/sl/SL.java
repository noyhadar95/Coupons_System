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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCouponRating(String couponName, int rating) {
		return bl.updateCouponRating(couponName, rating);
	}

	@Override
	public boolean updateCouponByAdmin(Coupon coupon) {
		return bl.updateCoupon(coupon);
	}

	@Override
	public DefaultTableModel getCouponsDetails() {
		return bl.getCouponsDetails();
	}
}
