package client.bl;

import javax.swing.table.DefaultTableModel;

import server.sl.*;
import auxiliary.bl_backend.*;

public class BusinessOwnerController implements IBusinessOwnerController {
	
	private ISL sl;

	 public BusinessOwnerController() {
		sl = new SL();
	}
	
	@Override
	public void insertBusinessOwner(BusinessOwner owner) {
		sl.inserBusinessOwner(owner);

	}
	@Override
	public void inserBusinessOwner(BusinessOwner owner){
		sl.inserBusinessOwner(owner);
	}
	

	
	@Override
	public BusinessOwner selectBusinessOwner(String username) {
		return sl.selectBusinessOwner(username);
	}
	
	@Override
	public void deleteBusinessOwner(String username) {
		sl.deleteBusinessOwner(username);
		
	}

	@Override
	public void updateBusinessOwner(BusinessOwner owner) {
		sl.updateBusinessOwner(owner);
		
	}


	
	
}
