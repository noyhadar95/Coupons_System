package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bl_backend.Customer;
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
	public void testAddCustomer() {
		Customer customer = new Customer("latgfyS","pass","mail@gmail.com","0129712");
		dal.insertCustomer(customer);
		Customer test_customer = dal.selectCustomer(customer.getUsername());
		assertTrue(test_customer.getUsername().equals(customer.getUsername()));
		//need to delete the added row
	}

}
