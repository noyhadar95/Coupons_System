package client.bl;

import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;
public interface IPurchaseController {

	/**
	 * updates the rating field of a specific purchase according to a given
	 * purchase serial key.
	 * 
	 * @param serialKey
	 *            the serial key (id) of the purchase.
	 * @param rating
	 *            the new rating to be set
	 * @return true on success, false otherwise.
	 */
	boolean updatePurchaseRating(String serialKey, int rating);
	/**
	 * update the status of the coupon in the given purchase to used.
	 * 
	 * @param serialKey
	 *            the serial key of a purchase.
	 * @return true on success, false otherwise.
	 */
	boolean useCoupon(String serialKey);
	DefaultTableModel getResultset(String table);
	void insertPurchase(Purchase purchase);
	Purchase selectPurchase(String serialKey);
	void deletePurchase(String serialKey);
	void updatePurchase(Purchase purchase);
}
