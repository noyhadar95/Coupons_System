package server.bl;

import javax.swing.table.DefaultTableModel;

import auxiliary.bl_backend.Business;
import auxiliary.bl_backend.BusinessOwner;

public interface IBusinessOwnerController {
	DefaultTableModel getBusinessesDetails();

	boolean updateBusiness(Business business);
	
	void insertBusinessOwner(BusinessOwner owner);

	
	DefaultTableModel getBusinessByFilter(String text, String filter);

	BusinessOwner selectBusinessOwner(String username);
	
	void deleteBusinessOwner(String username);

	void updateBusinessOwner(BusinessOwner owner);
}
