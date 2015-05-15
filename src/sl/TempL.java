package sl;

import javax.swing.table.DefaultTableModel;

public class TempL extends SL implements TempSL{

	@Override
	public DefaultTableModel getAllCoupons() {
		
		return this.getCouponsDetails();
	}

	@Override
	public DefaultTableModel getCouponsByFilter(String text, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultTableModel getBusinessByFilter(String text, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean purchaseCoupon(String customerName, String couponName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DefaultTableModel getCouponsByPreference(String customerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
