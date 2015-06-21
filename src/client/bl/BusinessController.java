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
	public boolean updateBusinessByOwner(Business business){
		sl.updateBusinessByOwner(business);
		return true;
		
	}
	
	@Override
	public DefaultTableModel getBusinessesDetails() {
		return sl.getBusinessesDetails();
	}
	
	@Override
	public void insertBusiness(Business business) {
		sl.insertBusiness(business);

	}
	
	@Override
	public DefaultTableModel getBusinessByFilter(String filter, String text) {
		return sl.getBusinessByFilter(filter, text);
	}
	
	@Override
	public Business selectBusiness(String name) {
		return sl.selectBusiness(name);
	}

	@Override
	public void deleteBusiness(String name) {
		sl.deleteBusiness(name);
		
	}
}
