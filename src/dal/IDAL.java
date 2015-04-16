package dal;

import bl_backend.Customer;

public interface IDAL {

	void insertCustomer(Customer cus);

	Customer selectCustomer(String username);
	

}
