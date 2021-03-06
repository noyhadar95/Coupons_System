package server.bl;

import javax.swing.table.DefaultTableModel;

import server.dal.DAL;
import server.dal.IDAL;
import auxiliary.bl_backend.Customer;

public class CustomerController implements ICustomerController {
	private IDAL dal;
	
	public CustomerController() {
		dal=new DAL();
	}
	
	@Override
	public boolean signUp(String username, String password, String email,
			String phone) {
		Customer cus = new Customer(username, password, email, phone);
		dal.insertCustomer(cus);
		return true;
	}
	
	@Override
	public DefaultTableModel getResultset(String table) {
		return dal.getResultset(table);
	}
	
	@Override
	public void insertCustomer(Customer customer) {
		dal.insertCustomer(customer);
		
	}

	@Override
	public Customer selectCustomer(String username) {
		return dal.selectCustomer(username);
	}

	@Override
	public void deleteCustomer(String username) {
		dal.deleteCustomer(username);
		
	}

}
