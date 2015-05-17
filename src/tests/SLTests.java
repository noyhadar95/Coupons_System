package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sl.SL;
import sl.ISL;
import bl_backend.Admin;
import bl_backend.Business;
import bl_backend.BusinessOwner;
import bl_backend.Category;
import bl_backend.Coupon;
import bl_backend.Customer;
import bl_backend.Purchase;

public class SLTests {

	ISL sl;

	@Before
	public void setUp() throws Exception {
		sl = new SL();

	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testTryLogin() {
		Customer customer = new Customer("latscgqfySs", "pass",
				"mail@gmail.com", "0129712");
		sl.insertCustomer(customer);
		boolean result1=sl.tryLogin(customer.getUsername(), customer.getPassword(), "Customer");
		boolean result2=sl.tryLogin(customer.getUsername(), customer.getPassword(), "Admin");//no permissions
		boolean result3=sl.tryLogin(customer.getUsername(), customer.getPassword()+"sd", "Customer");//wrong password
		sl.deleteCustomer(customer.getUsername());
		assertTrue(result1);
		assertFalse(result2);
		assertFalse(result3);
		
	}
	@Test
	public void testupdatePurchaseRating() {
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		sl.insertCustomer(customer);
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		sl.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		sl.insertBusiness(business);
		Category category = new Category(1, "cat1");
		sl.insertCategory(category);
		Coupon coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name",0);
		sl.insertCoupon(coupon);
		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1",0);
		sl.insertPurchase(purchase);
		
		boolean result1= sl.updatePurchaseRating(purchase.getSerialKey(), 3);
		boolean result2=sl.updatePurchaseRating(purchase.getSerialKey()+"qdqas", 3);

		// delete the purchase
		sl.deletePurchase(purchase.getSerialKey());
		// delete the coupon
		sl.deleteCoupon(coupon.getName());
		// delete category
		sl.deleteCategory(category.getId());
		// delete business
		sl.deleteBusiness(business.getName());
		// delete business owner
		sl.deleteBusinessOwner(owner.getUsername());
		// delete customer
		sl.deleteCustomer(customer.getUsername());
		boolean result3=sl.updatePurchaseRating(purchase.getSerialKey(), 3);
		
		sl.deleteCustomer(customer.getUsername());
		assertTrue(result1);
		assertFalse(result2);
		assertFalse(result3);
		
	}

	@Test
	public void testAddDeleteCustomer() {
		Customer customer = new Customer("latscgqfySs", "pass",
				"mail@gmail.com", "0129712");
		sl.insertCustomer(customer);
		Customer test_customer = sl.selectCustomer(customer.getUsername());
		assertTrue(test_customer.getUsername().equals(customer.getUsername()));
		sl.deleteCustomer(customer.getUsername());
		test_customer = sl.selectCustomer(customer.getUsername());
		assertTrue(test_customer == null);
	}

	@Test
	public void testAddDeleteAdmin() {
		Admin admin = new Admin("latgfsscdyS", "pass", "mail@gmail.com",
				"0129712");
		sl.insertAdmin(admin);
		Admin test_admin = sl.selectAdmin(admin.getUsername());
		assertTrue(test_admin.getUsername().equals(admin.getUsername()));
		sl.deleteAdmin(admin.getUsername());
		test_admin = sl.selectAdmin(admin.getUsername());
		assertTrue(test_admin == null);
	}

	@Test
	public void testAddBusinessOwner() {
		BusinessOwner owner = new BusinessOwner("owner", "pass",
				"mail@gmail.com", "0129712");
		sl.inserBusinessOwner(owner);
		BusinessOwner temp_owner = sl.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner.getUsername().equals(owner.getUsername()));

		sl.deleteBusinessOwner(owner.getUsername());
		temp_owner = sl.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner == null);
	}

	@Test
	public void testUpdateOwner() {
		BusinessOwner owner = new BusinessOwner("owner3", "pass",
				"mail@gmail.com", "0129712");
		sl.inserBusinessOwner(owner);

		owner.setPassword("pass2");
		owner.setEmail("smail@gmail.com");

		sl.updateBusinessOwner(owner);

		BusinessOwner temp_owner = sl.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner.getPassword().equals(owner.getPassword())
				&& temp_owner.getEmail().equals(owner.getEmail()));
		sl.deleteBusinessOwner(owner.getUsername());

	}

	@Test
	public void testAddDeleteBusiness() {
		// insert business owner
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		sl.inserBusinessOwner(owner);

		Business business = new Business("cas", "pqwfqwass", "asc", "wqfqwf",
				"uu", "owner1");
		sl.insertBusiness(business);
		Business test_business = sl.selectBusiness(business.getName());
		assertTrue(test_business.getName().equals(business.getName()));
		sl.deleteBusiness(business.getName());
		test_business = sl.selectBusiness(business.getName());
		assertTrue(test_business == null);

		// delete business owner
		sl.deleteBusinessOwner(owner.getUsername());
	}

	@Test
	public void testAddDeleteCoupon() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And insert a category.
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		sl.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		sl.insertBusiness(business);
		Category category = new Category(1, "cat1");
		sl.insertCategory(category);

		Coupon coupon = new Coupon("coupon_name", "description", 1, 40, 20, 4,
				"business_name",0);
		sl.insertCoupon(coupon);
		Coupon test_coupon = sl.selectCoupon(coupon.getName());
		assertTrue(test_coupon.getName().equals(coupon.getName()));
		sl.deleteCoupon(coupon.getName());
		test_coupon = sl.selectCoupon(coupon.getName());
		assertTrue(test_coupon == null);

		// delete category
		sl.deleteCategory(category.getId());
		// delete business
		sl.deleteBusiness(business.getName());
		// delete business owner
		sl.deleteBusinessOwner(owner.getUsername());
	}

	@Test
	public void testUpdateCoupon() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And insert a category.
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		sl.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		sl.insertBusiness(business);
		Category category = new Category(1, "cat1");
		sl.insertCategory(category);

		// insert coupon
		Coupon coupon = new Coupon("coupon_name", "description", 1, 40, 20, 4,
				"business_name",0);
		sl.insertCoupon(coupon);

		// update the coupon
		coupon.setRating(4);
		coupon.setDescription("some description");

		sl.updateCoupon(coupon);

		Coupon temp_coupon = sl.selectCoupon(coupon.getName());
		assertTrue((temp_coupon.getRating() == coupon.getRating())
				&& temp_coupon.getDescription().equals(coupon.getDescription()));

		// delete the coupon
		sl.deleteCoupon(coupon.getName());
		// delete category
		sl.deleteCategory(category.getId());
		// delete business
		sl.deleteBusiness(business.getName());
		// delete business owner
		sl.deleteBusinessOwner(owner.getUsername());

	}

	@Test
	public void testAddDeletePurchase() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And then insert coupon and
		// customer in order to insert a purchase.
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		sl.insertCustomer(customer);
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		sl.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		sl.insertBusiness(business);
		Category category = new Category(1, "cat1");
		sl.insertCategory(category);
		Coupon coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name",0);
		sl.insertCoupon(coupon);

		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1",0);
		sl.insertPurchase(purchase);
		Purchase test_purchase = sl.selectPurchase(purchase.getSerialKey());
		assertTrue(test_purchase.getSerialKey().equals(purchase.getSerialKey()));
		sl.deletePurchase(purchase.getSerialKey());
		test_purchase = sl.selectPurchase(purchase.getSerialKey());
		assertTrue(test_purchase == null);

		// delete the coupon
		sl.deleteCoupon(coupon.getName());
		// delete category
		sl.deleteCategory(category.getId());
		// delete business
		sl.deleteBusiness(business.getName());
		// delete business owner
		sl.deleteBusinessOwner(owner.getUsername());
		// delete customer
		sl.deleteCustomer(customer.getUsername());
	}

	@Test
	public void testUpdatePurchase() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And then insert coupon and
		// customer in order to insert a purchase.
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		sl.insertCustomer(customer);
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		sl.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		sl.insertBusiness(business);
		Category category = new Category(1, "cat1");
		sl.insertCategory(category);
		Coupon coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name",0);
		sl.insertCoupon(coupon);

		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1",0);
		sl.insertPurchase(purchase);

		// update the purchase
		purchase.setRating(1);

		sl.updatePurchase(purchase);

		Purchase test_purchase = sl.selectPurchase(purchase.getSerialKey());
		assertTrue((test_purchase.getRating() == purchase.getRating()));

		// delete the purchase
		sl.deletePurchase(purchase.getSerialKey());
		// delete the coupon
		sl.deleteCoupon(coupon.getName());
		// delete category
		sl.deleteCategory(category.getId());
		// delete business
		sl.deleteBusiness(business.getName());
		// delete business owner
		sl.deleteBusinessOwner(owner.getUsername());
		// delete customer
		sl.deleteCustomer(customer.getUsername());
	}


}
