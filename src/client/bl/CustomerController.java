package client.bl;

import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;

public class CustomerController implements ICustomerController {
	private ISL sl;
	
	public CustomerController() {
		sl=new SL();
	}

	@Override
	public boolean signUp(String username, String password, String email,
			String phone) {
		return sl.signUp(username, password, email, phone);
	}

	@Override
	public DefaultTableModel getResultset(String table) {
		return sl.getResultset(table);
	}

	@Override
	public void insertCustomer(Customer customer) {
		sl.insertCustomer(customer);
		
	}

	@Override
	public Customer selectCustomer(String username) {
		return sl.selectCustomer(username);
	}

	@Override
	public void deleteCustomer(String username) {
		sl.deleteCustomer(username);
		
	}
	

}
