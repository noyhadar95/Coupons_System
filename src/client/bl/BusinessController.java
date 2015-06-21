package client.bl;

import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;

public class BusinessController implements IBusinessController {

	private ISL sl;

	public BusinessController() {
		sl = new SL();
	}
	
	@Override
	public boolean updateBusiness(Business business){
		sl.updateBusiness(business);
		return true;
		
	}
	
	@Override
	public DefaultTableModel getBusinessesDetails() {
		return sl.selectAllBusinesses();
	}
	
	@Override
	public void insertBusiness(Business business) {
		dal.insertBusiness(business);

	}
	
	@Override
	public DefaultTableModel getBusinessByFilter(String filter, String text) {
		return dal.getBusinessByFilter(filter, text);
	}
	
	@Override
	public Business selectBusiness(String name) {
		return dal.selectBusiness(name);
	}

	@Override
	public void deleteBusiness(String name) {
		dal.deleteBusiness(name);
		
	}
}
