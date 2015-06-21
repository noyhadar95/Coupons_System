package client.bl;

import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;

public class BusinessOwnerController implements IBusinessOwnerController {
	
	private IDAL dal;

	 public BusinessOwnerController() {
		dal = new DAL();
	}
	
	public boolean updateBusiness(Business business){
		dal.updateBusiness(business);
		return true;
		
	}
	@Override
	public DefaultTableModel getBusinessesDetails() {
		return dal.selectAllBusinesses();
	}
	
	@Override
	public void insertBusinessOwner(BusinessOwner owner) {
		dal.inserBusinessOwner(owner);

	}
	public DefaultTableModel getBusinessByFilter(String filter, String text) {
		return dal.getBusinessByFilter(filter, text);
	}

	
	@Override
	public BusinessOwner selectBusinessOwner(String username) {
		return dal.selectBusinessOwner(username);
	}
	
	@Override
	public void deleteBusinessOwner(String username) {
		dal.deleteBusinessOwner(username);
		
	}

	@Override
	public void updateBusinessOwner(BusinessOwner owner) {
		dal.updateBusinessOwner(owner);
		
	}
	
}
