package server.bl;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.Business;

public interface IBusinessController {

	public boolean updateBusiness(Business business);
	public DefaultTableModel getBusinessesDetails();
	public void insertBusiness(Business business);
	public DefaultTableModel getBusinessByFilter(String filter, String text);
	public Business selectBusiness(String name);
	public void deleteBusiness(String name);
	public List getTableArrayList(String string);
	DefaultTableModel getResultset(String table);
	DefaultTableModel getBusinessByLocation(double longitude, double latitude,
			double radius);
}
