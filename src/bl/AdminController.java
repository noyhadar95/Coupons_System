package bl;

import dal.DAL;
import dal.IDAL;
import bl_backend.Admin;

public class AdminController implements IAdminController {
	
	private IDAL dal;

	public AdminController() {
		dal = new DAL();
	}
	
	@Override
	public void insertAdmin(Admin admin) {
		dal.insertAdmin(admin);
		
	}

	@Override
	public Admin selectAdmin(String username) {
		return dal.selectAdmin(username);
	}

	@Override
	public void deleteAdmin(String username) {
		dal.deleteAdmin(username);
		
	}


}
