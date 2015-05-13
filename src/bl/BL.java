package bl;

import javax.swing.table.DefaultTableModel;

import bl_backend.*;
import dal.DAL;
import dal.IDAL;

public class BL implements IBL {

	private IDAL dal;

	public BL() {
		dal = new DAL();
	}

	@Override
	public boolean tryLogin(String username, String password, String authType) {
		boolean successFlag = false;
		User user = null;

		switch (authType) {
		case "Admin":
			user = dal.selectAdmin(username);
			break;
		case "Customer":
			user = dal.selectCustomer(username);
			break;
		case "Bussines Owner":
			user = dal.selectBusinessOwner(username);
			break;
		default:
			break;
		}

		if (user != null && user.getUsername().equals(username)
				&& user.getPassword().equals(password)) {
			successFlag = true;
		}

		return successFlag;
	}

	@Override
	public boolean updateCouponRating(String couponName, int rating) {
		Coupon coupon = dal.selectCoupon(couponName);
		dal.updateCoupon(coupon);
		return false;
	}

	@Override
	public DefaultTableModel getCouponsDetails() {
		// TODO: implement
		return null;
	}

	@Override
	public boolean updateCoupon(Coupon coupon) {
		dal.updateCoupon(coupon);
		return true;
	}

}
