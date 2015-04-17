package dal;

import bl_backend.*;

public interface IDAL {

	// insert
	void insertCustomer(Customer cus);

	void insertAdmin(Admin admin);

	void inserBusinessOwner(BusinessOwner owner);

	void insertBusiness(Business business);

	void insertCoupon(Coupon coupon);

	// select
	Customer selectCustomer(String username);

	Admin selectAdmin(String username);

	BusinessOwner selectBusinessOwner(String username);

	Business selectBusiness(String name);

	Coupon selectCoupon(String name);

	// delete
	void deleteCustomer(String username);

	void deleteAdmin(String username);

	void deleteBusinessOwner(String username);

	void deleteBusiness(String name);

	void deleteCoupon(String name);

	// update
	void updateBusinessOwner(BusinessOwner owner);

	void updateCoupon(Coupon coupon);

}
