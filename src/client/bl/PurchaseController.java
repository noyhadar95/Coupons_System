package client.bl;


import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;


public class PurchaseController implements IPurchaseController {
	private ISL sl;
	
	public PurchaseController() {
		sl=new SL();
	}

	@Override
	public boolean updatePurchaseRating(String serialKey, int rating) {
		return sl.updatePurchaseRating(serialKey, rating);
	}

	@Override
	public boolean useCoupon(String serialKey) {
		return sl.useCoupon(serialKey);
	}

	@Override
	public DefaultTableModel getResultset(String table) {
		return sl.getResultset(table);
	}

	@Override
	public void insertPurchase(Purchase purchase) {
		sl.insertPurchase(purchase);
		
	}

	@Override
	public Purchase selectPurchase(String serialKey) {
		return sl.selectPurchase(serialKey);
	}

	@Override
	public void deletePurchase(String serialKey) {
		sl.deletePurchase(serialKey);
		
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		sl.updatePurchase(purchase);
		
	}
	
	
	
}
