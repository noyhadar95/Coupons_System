package tests.server.bl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.bl.BusinessOwnerController;
import auxiliary.bl_backend.BusinessOwner;

public class BusinessOwnerControllerTests {
	BusinessOwnerController boc;
	
	@Before
	public void setUp() throws Exception {
		boc=new BusinessOwnerController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddBusinessOwner() {
		BusinessOwner owner = new BusinessOwner("owner", "pass",
				"mail@gmail.com", "0129712");
		boc.inserBusinessOwner(owner);
		BusinessOwner temp_owner = boc.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner.getUsername().equals(owner.getUsername()));

		boc.deleteBusinessOwner(owner.getUsername());
		temp_owner = boc.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner == null);
	}

	@Test
	public void testUpdateOwner() {
		BusinessOwner owner = new BusinessOwner("owner3", "pass",
				"mail@gmail.com", "0129712");
		boc.inserBusinessOwner(owner);

		owner.setPassword("pass2");
		owner.setEmail("smail@gmail.com");

		boc.updateBusinessOwner(owner);

		BusinessOwner temp_owner = boc.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner.getPassword().equals(owner.getPassword())
				&& temp_owner.getEmail().equals(owner.getEmail()));
		boc.deleteBusinessOwner(owner.getUsername());

	}

}
