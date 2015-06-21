package client.bl;

import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.*;


public interface IBusinessController {

	/**
	 * returns a DefaultTableModel object that contains the details of all the
	 * businesses in the db.
	 * 
	 * @return a DefaultTableModel object.
	 */
	
	public DefaultTableModel getBusinessesDetails();
	public void insertBusiness(Business business);
	public DefaultTableModel getBusinessByFilter(String filter, String text);
	public Business selectBusiness(String name);
	public void deleteBusiness(String name);
	public boolean updateBusinessByOwner(Business business);
	DefaultTableModel getResultset(String table);
}
