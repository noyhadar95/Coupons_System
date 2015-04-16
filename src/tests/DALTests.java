package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bl_backend.*;
import dal.DAL;
import dal.IDAL;

public class DALTests {

	IDAL dal;

	@Before
	public void setUp() throws Exception {
		dal = new DAL();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddDeleteCustomer() {
		Customer customer = new Customer("latscgqfySs","pass","mail@gmail.com","0129712");
		dal.insertCustomer(customer);
		Customer test_customer = dal.selectCustomer(customer.getUsername());
		assertTrue(test_customer.getUsername().equals(customer.getUsername()));
		dal.deleteCustomer(customer.getUsername());
		test_customer=dal.selectCustomer(customer.getUsername());
		assertTrue(test_customer==null);
	}
	
	@Test
	public void testAddDeleteAdmin() {
		Admin admin = new Admin("latgfsscdyS","pass","mail@gmail.com","0129712");
		dal.insertAdmin(admin);
		Admin test_admin = dal.selectAdmin(admin.getUsername());
		assertTrue(test_admin.getUsername().equals(admin.getUsername()));
		dal.deleteAdmin(admin.getUsername());
		test_admin=dal.selectAdmin(admin.getUsername());
		assertTrue(test_admin==null);
	}

}
