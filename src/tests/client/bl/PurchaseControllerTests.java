package tests.client.bl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import client.bl.BusinessController;
import client.bl.BusinessOwnerController;
import client.bl.CategoryController;
import client.bl.CouponController;
import client.bl.CustomerController;
import client.bl.PurchaseController;
import auxiliary.bl_backend.Business;
import auxiliary.bl_backend.BusinessOwner;
import auxiliary.bl_backend.Category;
import auxiliary.bl_backend.Coupon;
import auxiliary.bl_backend.Customer;
import auxiliary.bl_backend.Purchase;

public class PurchaseControllerTests {
	private CouponController coupc;
	private CategoryController catc;
	private BusinessController bc;
	private BusinessOwnerController boc;
	private PurchaseController pc;
	private CustomerController custc;
	
	@Before
	public void setUp() throws Exception {
		coupc=new CouponController();
		catc=new CategoryController();
		bc=new BusinessController();
		boc=new BusinessOwnerController();
		pc=new PurchaseController();
		custc=new CustomerController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testupdatePurchaseRating() {
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		custc.insertCustomer(customer);
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		boc.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		bc.insertBusiness(business);
		Category category = new Category(1, "cat1");
		catc.insertCategory(category);
		Coupon coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name",0);
		coupc.insertCoupon(coupon);
		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1",0);
		pc.insertPurchase(purchase);
		
		boolean result1= pc.updatePurchaseRating(purchase.getSerialKey(), 3);
		boolean result2=pc.updatePurchaseRating(purchase.getSerialKey()+"qdqas", 3);

		// delete the purchase
		pc.deletePurchase(purchase.getSerialKey());
		// delete the coupon
		coupc.deleteCoupon(coupon.getName());
		// delete category
		catc.deleteCategory(category.getId());
		// delete business
		bc.deleteBusiness(business.getName());
		// delete business owner
		boc.deleteBusinessOwner(owner.getUsername());
		// delete customer
		custc.deleteCustomer(customer.getUsername());
		boolean result3=pc.updatePurchaseRating(purchase.getSerialKey(), 3);
		
		custc.deleteCustomer(customer.getUsername());
		assertTrue(result1);
		assertFalse(result2);
		assertFalse(result3);
		
	}
	

	@Test
	public void testAddDeletePurchase() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And then insert coupon and
		// customer in order to insert a purchase.
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		custc.insertCustomer(customer);
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		boc.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		bc.insertBusiness(business);
		Category category = new Category(1, "cat1");
		catc.insertCategory(category);
		Coupon coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name",0);
		coupc.insertCoupon(coupon);

		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1",0);
		pc.insertPurchase(purchase);
		Purchase test_purchase = pc.selectPurchase(purchase.getSerialKey());
		assertTrue(test_purchase.getSerialKey().equals(purchase.getSerialKey()));
		pc.deletePurchase(purchase.getSerialKey());
		test_purchase = pc.selectPurchase(purchase.getSerialKey());
		assertTrue(test_purchase == null);

		// delete the coupon
		coupc.deleteCoupon(coupon.getName());
		// delete category
		catc.deleteCategory(category.getId());
		// delete business
		bc.deleteBusiness(business.getName());
		// delete business owner
		boc.deleteBusinessOwner(owner.getUsername());
		// delete customer
		custc.deleteCustomer(customer.getUsername());
	}

	@Test
	public void testUpdatePurchase() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And then insert coupon and
		// customer in order to insert a purchase.
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		custc.insertCustomer(customer);
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		boc.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		bc.insertBusiness(business);
		Category category = new Category(1, "cat1");
		catc.insertCategory(category);
		Coupon coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name",0);
		coupc.insertCoupon(coupon);

		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1",0);
		pc.insertPurchase(purchase);

		// update the purchase
		purchase.setRating(1);

		pc.updatePurchase(purchase);

		Purchase test_purchase = pc.selectPurchase(purchase.getSerialKey());
		assertTrue((test_purchase.getRating() == purchase.getRating()));

		// delete the purchase
		pc.deletePurchase(purchase.getSerialKey());
		// delete the coupon
		coupc.deleteCoupon(coupon.getName());
		// delete category
		catc.deleteCategory(category.getId());
		// delete business
		bc.deleteBusiness(business.getName());
		// delete business owner
		boc.deleteBusinessOwner(owner.getUsername());
		// delete customer
		custc.deleteCustomer(customer.getUsername());
	}

}
