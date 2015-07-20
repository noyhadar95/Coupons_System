package client.bl;


import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import client.dal.DAL;
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
	
	@Override
	public void initializeLocalPurchases(String username){
		Vector<Vector<Object>> purchasesVec=DAL.getInstance().getPurchases(); //TODO weird!
		
	}
	
	@Override
	public DefaultTableModel getPurchases(){
		Vector<Vector<Object>> data =DAL.getInstance().getPurchases();
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("SerialKey");
		columnNames.add("Rating");
		columnNames.add( "CustomerName");
		columnNames.add("Used");
		return new DefaultTableModel(data, columnNames);
	}
	
	@Override
	public DefaultTableModel getPurchasesNoHeader(){
		return null;
	}
	
	
}
