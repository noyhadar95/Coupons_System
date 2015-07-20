package tests.client.bl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.bl.CategoryController;
import auxiliary.bl_backend.Category;

public class CategoryControllerTests {
	private CategoryController cc;

	@Before
	public void setUp() throws Exception {
		cc=new CategoryController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCategory() {
		Category cat = new Category(9999, "name");
		cc.insertCategory(cat);
		Category temp_cat = cc.selectCategory(cat.getName());
		assertTrue(temp_cat.getName().equals(cat.getName()));

		cc.deleteCategory(cat.getId());
		temp_cat = cc.selectCategory(cat.getName());
		assertTrue(temp_cat == null);
	}

}
