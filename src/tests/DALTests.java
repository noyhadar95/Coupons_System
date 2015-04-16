package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bl_backend.BusinessOwner;
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
		Customer customer = new Customer("latgfyssad","pass","mail@gmail.com","0129712");
		dal.insertCustomer(customer);
		Customer test_customer = dal.selectCustomer(customer.getUsername());
		assertTrue(test_customer.getUsername().equals(customer.getUsername()));
		//need to delete the added row
	}
	
	@Test
	public void testAddBusinessOwner() {
		BusinessOwner owner = new BusinessOwner("owner","pass","mail@gmail.com","0129712");
		dal.inserBusinessOwner(owner);
		BusinessOwner temp_owner = dal.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner.getUsername().equals(owner.getUsername()));
		
		dal.deleteBusinessOwner(owner.getUsername());
		temp_owner = dal.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner==null);
	}
	
	@Test
	public void testUpdateOwner() {
		BusinessOwner owner = new BusinessOwner("owner3","pass","mail@gmail.com","0129712");
		dal.inserBusinessOwner(owner);
		
		owner.setPassword("pass2");
		owner.setEmail("smail@gmail.com");
		
		dal.updateBusinessOwner(owner);
		
		BusinessOwner temp_owner = dal.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner.getPassword().equals(owner.getPassword()) && temp_owner.getEmail().equals(owner.getEmail()));
		dal.deleteBusinessOwner(owner.getUsername());
		
	}
	


}
