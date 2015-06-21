package client.bl;

import javax.swing.table.DefaultTableModel;
import server.sl.*;
import auxiliary.bl_backend.*;


public interface IBusinessController {

	public boolean updateBusiness(Business business);
	public DefaultTableModel getBusinessesDetails();
	public void insertBusiness(Business business);
	public DefaultTableModel getBusinessByFilter(String filter, String text);
	public Business selectBusiness(String name);
	public void deleteBusiness(String name);
}