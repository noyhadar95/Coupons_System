package tests.client.bl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.bl.BL;
import server.bl.IBL;
import auxiliary.bl_backend.Admin;
import auxiliary.bl_backend.Business;
import auxiliary.bl_backend.BusinessOwner;
import auxiliary.bl_backend.Category;
import auxiliary.bl_backend.Coupon;
import auxiliary.bl_backend.Customer;
import auxiliary.bl_backend.Purchase;

public class BLTests {

	IBL bl;

	@Before
	public void setUp() throws Exception {
		bl = new BL();

	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test//v
	public void testTryLogin() {
		Customer customer = new Customer("latscgqfySs", "pass",
				"mail@gmail.com", "0129712");
		bl.insertCustomer(customer);
		boolean result1=bl.tryLogin(customer.getUsername(), customer.getPassword(), "Customer");
		boolean result2=bl.tryLogin(customer.getUsername(), customer.getPassword(), "Admin");//no permissions
		boolean result3=bl.tryLogin(customer.getUsername(), customer.getPassword()+"sd", "Customer");//wrong password
		bl.deleteCustomer(customer.getUsername());
		assertTrue(result1);
		assertFalse(result2);
		assertFalse(result3);
		
	}
	
	@Test//v
	public void testupdatePurchaseRating() {
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		bl.insertCustomer(customer);
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		bl.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		bl.insertBusiness(business);
		Category category = new Category(1, "cat1");
		bl.insertCategory(category);
		Coupon coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name",0);
		bl.insertCoupon(coupon);
		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1",0);
		bl.insertPurchase(purchase);
		
		boolean result1= bl.updatePurchaseRating(purchase.getSerialKey(), 3);
		boolean result2=bl.updatePurchaseRating(purchase.getSerialKey()+"qdqas", 3);

		// delete the purchase
		bl.deletePurchase(purchase.getSerialKey());
		// delete the coupon
		bl.deleteCoupon(coupon.getName());
		// delete category
		bl.deleteCategory(category.getId());
		// delete business
		bl.deleteBusiness(business.getName());
		// delete business owner
		bl.deleteBusinessOwner(owner.getUsername());
		// delete customer
		bl.deleteCustomer(customer.getUsername());
		boolean result3=bl.updatePurchaseRating(purchase.getSerialKey(), 3);
		
		bl.deleteCustomer(customer.getUsername());
		assertTrue(result1);
		assertFalse(result2);
		assertFalse(result3);
		
	}

	@Test//v
	public void testAddDeleteCustomer() {
		Customer customer = new Customer("latscgqfySs", "pass",
				"mail@gmail.com", "0129712");
		bl.insertCustomer(customer);
		Customer test_customer = bl.selectCustomer(customer.getUsername());
		assertTrue(test_customer.getUsername().equals(customer.getUsername()));
		bl.deleteCustomer(customer.getUsername());
		test_customer = bl.selectCustomer(customer.getUsername());
		assertTrue(test_customer == null);
	}

	@Test//v
	public void testAddDeleteAdmin() {
		Admin admin = new Admin("latgfsscdyS", "pass", "mail@gmail.com",
				"0129712");
		bl.insertAdmin(admin);
		Admin test_admin = bl.selectAdmin(admin.getUsername());
		assertTrue(test_admin.getUsername().equals(admin.getUsername()));
		bl.deleteAdmin(admin.getUsername());
		test_admin = bl.selectAdmin(admin.getUsername());
		assertTrue(test_admin == null);
	}

	@Test//v
	public void testAddBusinessOwner() {
		BusinessOwner owner = new BusinessOwner("owner", "pass",
				"mail@gmail.com", "0129712");
		bl.inserBusinessOwner(owner);
		BusinessOwner temp_owner = bl.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner.getUsername().equals(owner.getUsername()));

		bl.deleteBusinessOwner(owner.getUsername());
		temp_owner = bl.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner == null);
	}

	@Test//v
	public void testUpdateOwner() {
		BusinessOwner owner = new BusinessOwner("owner3", "pass",
				"mail@gmail.com", "0129712");
		bl.inserBusinessOwner(owner);

		owner.setPassword("pass2");
		owner.setEmail("smail@gmail.com");

		bl.updateBusinessOwner(owner);

		BusinessOwner temp_owner = bl.selectBusinessOwner(owner.getUsername());
		assertTrue(temp_owner.getPassword().equals(owner.getPassword())
				&& temp_owner.getEmail().equals(owner.getEmail()));
		bl.deleteBusinessOwner(owner.getUsername());

	}

	@Test//v
	public void testAddDeleteBusiness() {
		// insert business owner
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		bl.inserBusinessOwner(owner);

		Business business = new Business("cas", "pqwfqwass", "asc", "wqfqwf",
				"uu", "owner1");
		bl.insertBusiness(business);
		Business test_business = bl.selectBusiness(business.getName());
		assertTrue(test_business.getName().equals(business.getName()));
		bl.deleteBusiness(business.getName());
		test_business = bl.selectBusiness(business.getName());
		assertTrue(test_business == null);

		// delete business owner
		bl.deleteBusinessOwner(owner.getUsername());
	}

	@Test//v
	public void testAddDeleteCoupon() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And insert a category.
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		bl.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		bl.insertBusiness(business);
		Category category = new Category(1, "cat1");
		bl.insertCategory(category);

		Coupon coupon = new Coupon("coupon_name", "description", 1, 40, 20, 4,
				"business_name",0);
		bl.insertCoupon(coupon);
		Coupon test_coupon = bl.selectCoupon(coupon.getName());
		assertTrue(test_coupon.getName().equals(coupon.getName()));
		bl.deleteCoupon(coupon.getName());
		test_coupon = bl.selectCoupon(coupon.getName());
		assertTrue(test_coupon == null);

		// delete category
		bl.deleteCategory(category.getId());
		// delete business
		bl.deleteBusiness(business.getName());
		// delete business owner
		bl.deleteBusinessOwner(owner.getUsername());
	}

	@Test//v
	public void testUpdateCoupon() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And insert a category.
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		bl.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		bl.insertBusiness(business);
		Category category = new Category(1, "cat1");
		bl.insertCategory(category);

		// insert coupon
		Coupon coupon = new Coupon("coupon_name", "description", 1, 40, 20, 4,
				"business_name",0);
		bl.insertCoupon(coupon);

		// update the coupon
		coupon.setRating(4);
		coupon.setDescription("some description");

		bl.updateCoupon(coupon);

		Coupon temp_coupon = bl.selectCoupon(coupon.getName());
		assertTrue((temp_coupon.getRating() == coupon.getRating())
				&& temp_coupon.getDescription().equals(coupon.getDescription()));

		// delete the coupon
		bl.deleteCoupon(coupon.getName());
		// delete category
		bl.deleteCategory(category.getId());
		// delete business
		bl.deleteBusiness(business.getName());
		// delete business owner
		bl.deleteBusinessOwner(owner.getUsername());

	}

	@Test//v
	public void testAddDeletePurchase() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And then insert coupon and
		// customer in order to insert a purchase.
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		bl.insertCustomer(customer);
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		bl.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		bl.insertBusiness(business);
		Category category = new Category(1, "cat1");
		bl.insertCategory(category);
		Coupon coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name",0);
		bl.insertCoupon(coupon);

		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1",0);
		bl.insertPurchase(purchase);
		Purchase test_purchase = bl.selectPurchase(purchase.getSerialKey());
		assertTrue(test_purchase.getSerialKey().equals(purchase.getSerialKey()));
		bl.deletePurchase(purchase.getSerialKey());
		test_purchase = bl.selectPurchase(purchase.getSerialKey());
		assertTrue(test_purchase == null);

		// delete the coupon
		bl.deleteCoupon(coupon.getName());
		// delete category
		bl.deleteCategory(category.getId());
		// delete business
		bl.deleteBusiness(business.getName());
		// delete business owner
		bl.deleteBusinessOwner(owner.getUsername());
		// delete customer
		bl.deleteCustomer(customer.getUsername());
	}

	@Test//v
	public void testUpdatePurchase() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And then insert coupon and
		// customer in order to insert a purchase.
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		bl.insertCustomer(customer);
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		bl.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		bl.insertBusiness(business);
		Category category = new Category(1, "cat1");
		bl.insertCategory(category);
		Coupon coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name",0);
		bl.insertCoupon(coupon);

		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1",0);
		bl.insertPurchase(purchase);

		// update the purchase
		purchase.setRating(1);

		bl.updatePurchase(purchase);

		Purchase test_purchase = bl.selectPurchase(purchase.getSerialKey());
		assertTrue((test_purchase.getRating() == purchase.getRating()));

		// delete the purchase
		bl.deletePurchase(purchase.getSerialKey());
		// delete the coupon
		bl.deleteCoupon(coupon.getName());
		// delete category
		bl.deleteCategory(category.getId());
		// delete business
		bl.deleteBusiness(business.getName());
		// delete business owner
		bl.deleteBusinessOwner(owner.getUsername());
		// delete customer
		bl.deleteCustomer(customer.getUsername());
	}


}
