package client.bl;

import server.sl.*;
import auxiliary.bl_backend.*;
public class AdminController implements IAdminController {
	
	private ISL sl;

	public AdminController() {
		sl = new  SL();
	}
	
	@Override
	public void insertAdmin(Admin admin) {
		sl.insertAdmin(admin);
		
	}

	@Override
	public Admin selectAdmin(String username) {
		return sl.selectAdmin(username);
	}

	@Override
	public void deleteAdmin(String username) {
		sl.deleteAdmin(username);
		
	}


}
