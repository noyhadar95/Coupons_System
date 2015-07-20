package tests.server.bl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.bl.CustomerController;
import client.bl.UserController;
import auxiliary.bl_backend.Customer;

public class UserControllerTests {
	private UserController uc;
	private CustomerController cc;
	
	@Before
	public void setUp() throws Exception {
		uc=new UserController();
		cc=new CustomerController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTryLogin() {
		Customer customer = new Customer("latscgqfySs", "pass",
				"mail@gmail.com", "0129712");
		cc.insertCustomer(customer);
		boolean result1=uc.tryLogin(customer.getUsername(), customer.getPassword(), "Customer");
		boolean result2=uc.tryLogin(customer.getUsername(), customer.getPassword(), "Admin");//no permissions
		boolean result3=uc.tryLogin(customer.getUsername(), customer.getPassword()+"sd", "Customer");//wrong password
		cc.deleteCustomer(customer.getUsername());
		assertTrue(result1);
		assertFalse(result2);
		assertFalse(result3);
		
	}

}
