package bl;

import javax.swing.table.DefaultTableModel;

import bl_backend.Purchase;

public interface IPurchaseController {

	boolean updatePurchaseRating(String serialKey, int rating);
	boolean useCoupon(String serialKey);
	DefaultTableModel getResultset(String custumerName);
	void insertPurchase(Purchase purchase);
	Purchase selectPurchase(String serialKey);
	void deletePurchase(String serialKey);
	void updatePurchase(Purchase purchase);
}
