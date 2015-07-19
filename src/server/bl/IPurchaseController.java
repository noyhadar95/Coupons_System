package server.bl;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.Purchase;

public interface IPurchaseController {

	boolean updatePurchaseRating(String serialKey, int rating);
	
	boolean useCoupon(String serialKey);
	
	DefaultTableModel getResultset(String query);
	
	void insertPurchase(Purchase purchase);
	
	Purchase selectPurchase(String serialKey);
	
	void deletePurchase(String serialKey);
	
	void updatePurchase(Purchase purchase);
	
	Vector<Vector<Object>> getPruchases(String username);
	
}
