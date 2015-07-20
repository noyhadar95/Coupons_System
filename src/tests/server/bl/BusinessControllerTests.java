package tests.server.bl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.bl.BusinessController;
import server.bl.BusinessOwnerController;
import auxiliary.bl_backend.Business;
import auxiliary.bl_backend.BusinessOwner;

public class BusinessControllerTests {
	BusinessController bc;
	BusinessOwnerController boc;
	@Before
	public void setUp() throws Exception {
		bc=new BusinessController();
		boc=new BusinessOwnerController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddDeleteBusiness() {
		// insert business owner
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		boc.insertBusinessOwner(owner);

		Business business = new Business("cas", "pqwfqwass", "asc", "wqfqwf",
				"uu", "owner1");
		bc.insertBusiness(business);
		Business test_business = bc.selectBusiness(business.getName());
		assertTrue(test_business.getName().equals(business.getName()));
		bc.deleteBusiness(business.getName());
		test_business = bc.selectBusiness(business.getName());
		assertTrue(test_business == null);

		// delete business owner
		boc.deleteBusinessOwner(owner.getUsername());
	}

}
