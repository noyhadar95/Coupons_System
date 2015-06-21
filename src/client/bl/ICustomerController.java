package client.bl;

import javax.swing.table.DefaultTableModel;
import server.sl.*;
import auxiliary.bl_backend.*;
public interface ICustomerController {
	
	boolean signUp(String username, String password, String email,
			String phone);
	DefaultTableModel getResultset(String table);
	void insertCustomer(Customer customer);
	Customer selectCustomer(String username);
	void deleteCustomer(String username);
	
}
