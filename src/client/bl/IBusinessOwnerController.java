package client.bl;

import javax.swing.table.DefaultTableModel;
import server.sl.*;
import auxiliary.bl_backend.*;

public interface IBusinessOwnerController {
	DefaultTableModel getBusinessesDetails();

	boolean updateBusiness(Business business);
	
	void insertBusinessOwner(BusinessOwner owner);

	
	DefaultTableModel getBusinessByFilter(String text, String filter);

	BusinessOwner selectBusinessOwner(String username);
	
	void deleteBusinessOwner(String username);

	void updateBusinessOwner(BusinessOwner owner);
}
