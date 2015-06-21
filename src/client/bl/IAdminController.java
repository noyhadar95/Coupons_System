package client.bl;

import server.sl.*;
import auxiliary.bl_backend.*;
public interface IAdminController {

	public void insertAdmin(Admin admin);
	public Admin selectAdmin(String username);
	public void deleteAdmin(String username);
	
}
