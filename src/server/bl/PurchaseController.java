package server.bl;


import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.Coupon;
import auxiliary.bl_backend.Purchase;
import server.dal.DAL;
import server.dal.IDAL;

public class PurchaseController implements IPurchaseController {
	private IDAL dal;
	
	public PurchaseController() {
		dal=new DAL();
	}
	
	@Override
	public boolean updatePurchaseRating(String serialKey, int rating) {
		Purchase purchase = dal.selectPurchase(serialKey);
		if (purchase == null)
			return false;
		// update the rating of the purchase
		purchase.setRating(rating);
		dal.updatePurchase(purchase);

		// calculate average rating for the newly rated coupon in the coupons
		// table
		String couponName = purchase.getCouponName();
		Coupon coupon = dal.selectCoupon(couponName);
		int avgRating = (coupon.getRating() + rating) / 2;
		coupon.setRating(avgRating);

		// update the rating of the coupon
		dal.updateCoupon(coupon);

		return true;
	}
	
	@Override
	public boolean useCoupon(String serialKey) {
		Purchase purchase = dal.selectPurchase(serialKey);
		if (purchase == null)
			return false;

		// update the used field of the purchase to 1 ("used")
		purchase.setUsed(1);
		dal.updatePurchase(purchase);

		return true;
	}
	
	@Override
	public DefaultTableModel getResultset(String query) {
		return dal.getResultset(query);
	}
	
	@Override
	public void insertPurchase(Purchase purchase) {
		dal.insertPurchase(purchase);
		
	}

	@Override
	public Purchase selectPurchase(String serialKey) {
		return dal.selectPurchase(serialKey);
	}

	@Override
	public void deletePurchase(String serialKey) {
		dal.deletePurchase(serialKey);
		
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		dal.updatePurchase(purchase);
		
	}

	@Override
	public Vector<Vector<Object>> getPruchases(String username) {
		return dal.getPruchases(username);
	}
	
	
}
