package bl;

import javax.swing.table.DefaultTableModel;

import dal.DAL;
import dal.IDAL;
import bl_backend.Business;

public class BusinessController implements IBusinessController {

	private IDAL dal;

	public BusinessController() {
		dal = new DAL();
	}
	
	@Override
	public boolean updateBusiness(Business business){
		dal.updateBusiness(business);
		return true;
		
	}
	
	@Override
	public DefaultTableModel getBusinessesDetails() {
		return dal.selectAllBusinesses();
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
