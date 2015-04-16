package dal;

import bl_backend.*;

public interface IDAL {

	void insertCustomer(Customer cus);

	Customer selectCustomer(String username);
	
	void insertAdmin(Admin admin);

	Admin selectAdmin(String username);
	
	void deleteAdmin(String username);
	
	void deleteCustomer(String username);
}
