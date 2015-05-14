package sl;

import dal.DAL;
import bl.BL;
import bl_backend.Business;
import bl_backend.BusinessOwner;
import bl_backend.Coupon;

public class TempAdminSL {
	DAL dal=new DAL();
	public void inserBusinessOwner(BusinessOwner owner){
		dal.inserBusinessOwner(owner);
	}
	public void insertBusiness(Business business){
		dal.insertBusiness(business);
	}
	
	public void insertCoupon(Coupon coupon) {
		dal.insertCoupon(coupon);
	}

}
