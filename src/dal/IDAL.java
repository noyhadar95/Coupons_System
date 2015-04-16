package dal;

import bl_backend.BusinessOwner;
import bl_backend.Customer;

public interface IDAL {

	void insertCustomer(Customer cus);

	Customer selectCustomer(String username);
	
	void inserBusinessOwner(BusinessOwner owner);
	BusinessOwner selectBusinessOwner(String username);
	void deleteBusinessOwner(String username);
	void updateBusinessOwner(BusinessOwner owner);
}
