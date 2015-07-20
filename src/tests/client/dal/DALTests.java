package tests.client.dal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.dal.DAL;
import auxiliary.bl_backend.*;

public class DALTests {

	DAL dal;

	@Before
	public void setUp() throws Exception {
		dal = DAL.getInstance();

	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testUsername() {
		dal.setUsername("username");
		String testName=dal.getUsername();
		assertTrue(testName.equals("username"));
	}

	

}
