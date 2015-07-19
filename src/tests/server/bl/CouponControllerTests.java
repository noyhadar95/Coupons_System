package tests.server.bl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import server.bl.BusinessController;
import server.bl.BusinessOwnerController;
import server.bl.CategoryController;
import server.bl.CouponController;
import auxiliary.bl_backend.Business;
import auxiliary.bl_backend.BusinessOwner;
import auxiliary.bl_backend.Category;
import auxiliary.bl_backend.Coupon;

public class CouponControllerTests {
	private CouponController coupc;
	private CategoryController catc;
	private BusinessController bc;
	private BusinessOwnerController boc;
	@Before
	public void setUp() throws Exception {
		coupc=new CouponController();
		catc=new CategoryController();
		bc=new BusinessController();
		boc=new BusinessOwnerController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddDeleteCoupon() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And insert a category.
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		boc.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		bc.insertBusiness(business);
		Category category = new Category(1, "cat1");
		catc.insertCategory(category);

		Coupon coupon = new Coupon("coupon_name", "description", 1, 40, 20, 4,
				"business_name",0);
		coupc.insertCoupon(coupon);
		Coupon test_coupon = coupc.selectCoupon(coupon.getName());
		assertTrue(test_coupon.getName().equals(coupon.getName()));
		coupc.deleteCoupon(coupon.getName());
		test_coupon = coupc.selectCoupon(coupon.getName());
		assertTrue(test_coupon == null);

		// delete category
		catc.deleteCategory(category.getId());
		// delete business
		bc.deleteBusiness(business.getName());
		// delete business owner
		boc.deleteBusinessOwner(owner.getUsername());
	}

	@Test
	public void testUpdateCoupon() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And insert a category.
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		boc.inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		bc.insertBusiness(business);
		Category category = new Category(1, "cat1");
		catc.insertCategory(category);

		// insert coupon
		Coupon coupon = new Coupon("coupon_name", "description", 1, 40, 20, 4,
				"business_name",0);
		coupc.insertCoupon(coupon);

		// update the coupon
		coupon.setRating(4);
		coupon.setDescription("some description");

		coupc.updateCoupon(coupon);

		Coupon temp_coupon = coupc.selectCoupon(coupon.getName());
		assertTrue((temp_coupon.getRating() == coupon.getRating())
				&& temp_coupon.getDescription().equals(coupon.getDescription()));

		// delete the coupon
		coupc.deleteCoupon(coupon.getName());
		// delete category
		catc.deleteCategory(category.getId());
		// delete business
		bc.deleteBusiness(business.getName());
		// delete business owner
		boc.deleteBusinessOwner(owner.getUsername());

	}
}
