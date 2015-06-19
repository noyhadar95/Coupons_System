package bl;

import javax.swing.table.DefaultTableModel;

import bl_backend.Business;
import bl_backend.BusinessOwner;

public interface IBusinessOwnerController {
	DefaultTableModel getBusinessesDetails();

	boolean updateBusiness(Business business);
	
	void insertBusinessOwner(BusinessOwner owner);

	
	DefaultTableModel getBusinessByFilter(String text, String filter);

	BusinessOwner selectBusinessOwner(String username);
	
	void deleteBusinessOwner(String username);

	void updateBusinessOwner(BusinessOwner owner);
}
