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
		Customer customer = new Customer("latscgqfySs", "pass",
				"mail@gmail.com", "0129712");
		dal.insertCustomer(customer);
		Customer test_customer = dal.selectCustomer(customer.getUsername());
		assertTrue(test_customer.getUsername().equals(customer.getUsername()));
		dal.deleteCustomer(customer.getUsername());
		test_customer = dal.selectCustomer(customer.getUsername());
		assertTrue(test_customer == null);
	}

	@Test
	public void testAddDeleteAdmin() {
		Admin admin = new Admin("latgfsscdyS", "pass", "mail@gmail.com",
				"0129712");
		dal.insertAdmin(admin);
		Admin test_admin = dal.selectAdmin(admin.getUsername());
		assertTrue(test_admin.getUsername().equals(admin.getUsername()));
		dal.deleteAdmin(admin.getUsername());
		test_admin = dal.selectAdmin(admin.getUsername());
		assertTrue(test_admin == null);
	}

	@Test
	public void testAddBusinessOwner() {
		BusinessOwner owner = new BusinessOwner("owner", "pass",
				"mail@gmail.com", "0129712");
		dal.inserBusinessOwner(owner);
		BusinessOwner temp_owner = dal.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner.getUsername().equals(owner.getUsername()));

		dal.deleteBusinessOwner(owner.getUsername());
		temp_owner = dal.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner == null);
	}

	@Test
	public void testUpdateOwner() {
		BusinessOwner owner = new BusinessOwner("owner3", "pass",
				"mail@gmail.com", "0129712");
		dal.inserBusinessOwner(owner);

		owner.setPassword("pass2");
		owner.setEmail("smail@gmail.com");

		dal.updateBusinessOwner(owner);

		BusinessOwner temp_owner = dal.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner.getPassword().equals(owner.getPassword())
				&& temp_owner.getEmail().equals(owner.getEmail()));
		dal.deleteBusinessOwner(owner.getUsername());

	}

	@Test
	public void testAddDeleteBusiness() {
		// insert business owner
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		dal.inserBusinessOwner(owner);

		Business business = new Business("cas", "pqwfqwass", "asc", "wqfqwf",
				"uu", "owner1"); // TODO make sure owner exists?
		dal.insertBusiness(business);
		Business test_business = dal.selectBusiness(business.getName());
		assertTrue(test_business.getName().equals(business.getName()));
		dal.deleteBusiness(business.getName());
		test_business = dal.selectBusiness(business.getName());
		assertTrue(test_business == null);

		// delete business owner
		dal.deleteBusinessOwner(owner.getUsername());
	}

	@Test
	public void testAddDeleteCoupon() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And insert a category.
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		dal.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		dal.insertBusiness(business);
		Category category = new Category(1, "cat1");
		dal.insertCategory(category);

		Coupon coupon = new Coupon("coupon_name", "description", 1, 40, 20, 4,
				"business_name");
		dal.insertCoupon(coupon);
		Coupon test_coupon = dal.selectCoupon(coupon.getName());
		assertTrue(test_coupon.getName().equals(coupon.getName()));
		dal.deleteCoupon(coupon.getName());
		test_coupon = dal.selectCoupon(coupon.getName());
		assertTrue(test_coupon == null);

		// delete category
		dal.deleteCategory(category.getId());
		// delete business
		dal.deleteBusiness(business.getName());
		// delete business owner
		dal.deleteBusinessOwner(owner.getUsername());
	}

	@Test
	public void testUpdateCoupon() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And insert a category.
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		dal.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		dal.insertBusiness(business);
		Category category = new Category(1, "cat1");
		dal.insertCategory(category);

		// insert coupon
		Coupon coupon = new Coupon("coupon_name", "description", 1, 40, 20, 4,
				"business_name");
		dal.insertCoupon(coupon);

		// update the coupon
		coupon.setRating(4);
		coupon.setDescription("some description");

		dal.updateCoupon(coupon);

		Coupon temp_coupon = dal.selectCoupon(coupon.getName());
		assertTrue((temp_coupon.getRating() == coupon.getRating())
				&& temp_coupon.getDescription().equals(coupon.getDescription()));

		// delete the coupon
		dal.deleteCoupon(coupon.getName());
		// delete category
		dal.deleteCategory(category.getId());
		// delete business
		dal.deleteBusiness(business.getName());
		// delete business owner
		dal.deleteBusinessOwner(owner.getUsername());

	}

	@Test
	public void testAddDeletePurchase() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And then insert coupon and
		// customer in order to insert a purchase.
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		dal.insertCustomer(customer);
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		dal.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		dal.insertBusiness(business);
		Category category = new Category(1, "cat1");
		dal.insertCategory(category);
		Coupon coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name");
		dal.insertCoupon(coupon);

		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1");
		dal.insertPurchase(purchase);
		Purchase test_purchase = dal.selectPurchase(purchase.getSerialKey());
		assertTrue(test_purchase.getSerialKey().equals(purchase.getSerialKey()));
		dal.deletePurchase(purchase.getSerialKey());
		test_purchase = dal.selectPurchase(purchase.getSerialKey());
		assertTrue(test_purchase == null);

		// delete the coupon
		dal.deleteCoupon(coupon.getName());
		// delete category
		dal.deleteCategory(category.getId());
		// delete business
		dal.deleteBusiness(business.getName());
		// delete business owner
		dal.deleteBusinessOwner(owner.getUsername());
		// delete customer
		dal.deleteCustomer(customer.getUsername());
	}

	@Test
	public void testUpdatePurchase() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And then insert coupon and
		// customer in order to insert a purchase.
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		dal.insertCustomer(customer);
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		dal.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		dal.insertBusiness(business);
		Category category = new Category(1, "cat1");
		dal.insertCategory(category);
		Coupon coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name");
		dal.insertCoupon(coupon);

		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1");
		dal.insertPurchase(purchase);

		// update the purchase
		purchase.setRating(1);

		dal.updatePurchase(purchase);

		Purchase test_purchase = dal.selectPurchase(purchase.getSerialKey());
		assertTrue((test_purchase.getRating() == purchase.getRating()));

		// delete the purchase
		dal.deletePurchase(purchase.getSerialKey());
		// delete the coupon
		dal.deleteCoupon(coupon.getName());
		// delete category
		dal.deleteCategory(category.getId());
		// delete business
		dal.deleteBusiness(business.getName());
		// delete business owner
		dal.deleteBusinessOwner(owner.getUsername());
		// delete customer
		dal.deleteCustomer(customer.getUsername());
	}

	/*
	 * test that one can't add a business without a business owner. we insert a
	 * business without a business owner and check that it throws exception.
	 */
	@Test
	public void testBusinessOwnerFKBusiness() {
//		dal.sele(owner.getUsername());
	}

}
