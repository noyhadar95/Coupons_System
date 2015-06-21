package server.bl;

import auxiliary.bl_backend.Admin;

public interface IAdminController {

	public void insertAdmin(Admin admin);
	public Admin selectAdmin(String username);
	public void deleteAdmin(String username);
	
}
