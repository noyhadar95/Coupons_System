package tests.client.bl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.bl.AdminController;
import auxiliary.bl_backend.Admin;

public class AdminControllerTests {

	private AdminController ac;
	@Before
	public void setUp() throws Exception {
		ac=new AdminController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddDeleteAdmin() {
		Admin admin = new Admin("latgfsscdyS", "pass", "mail@gmail.com",
				"0129712");
		ac.insertAdmin(admin);
		Admin test_admin = ac.selectAdmin(admin.getUsername());
		assertTrue(test_admin.getUsername().equals(admin.getUsername()));
		ac.deleteAdmin(admin.getUsername());
		test_admin = ac.selectAdmin(admin.getUsername());
		assertTrue(test_admin == null);
	}


}
