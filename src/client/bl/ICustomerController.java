package client.bl;

import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;
public interface ICustomerController {
	
	/**
	 * sign up a new user account in the database with the given fields.
	 * 
	 * @param username
	 *            username to login with.
	 * @param password
	 *            password to login with.
	 * @param email
	 *            email to login with.
	 * @param phone
	 *            phone to login with.
	 * @return true on success, false otherwise.
	 */
	boolean signUp(String username, String password, String email, String phone);
	DefaultTableModel getResultset(String table);
	void insertCustomer(Customer customer);
	Customer selectCustomer(String username);
	void deleteCustomer(String username);
	
}
