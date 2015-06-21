package client.bl;

import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;

public interface IBusinessOwnerController {
	
	void insertBusinessOwner(BusinessOwner owner);

	BusinessOwner selectBusinessOwner(String username);
	
	void deleteBusinessOwner(String username);

	void updateBusinessOwner(BusinessOwner owner);

	void inserBusinessOwner(BusinessOwner owner);
}
