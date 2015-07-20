package tests.server.bl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.bl.UserController;
import server.bl.CustomerController;
import auxiliary.bl_backend.Customer;

public class CustomerControllerTests {
	private CustomerController cc;
	
	@Before
	public void setUp() throws Exception {
		cc=new CustomerController();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void testAddDeleteCustomer() {
		Customer customer = new Customer("latscgqfySs", "pass",
				"mail@gmail.com", "0129712");
		cc.insertCustomer(customer);
		Customer test_customer = cc.selectCustomer(customer.getUsername());
		assertTrue(test_customer.getUsername().equals(customer.getUsername()));
		cc.deleteCustomer(customer.getUsername());
		test_customer = cc.selectCustomer(customer.getUsername());
		assertTrue(test_customer == null);
	}

}
