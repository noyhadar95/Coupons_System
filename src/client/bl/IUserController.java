package client.bl;
import server.sl.*;
import auxiliary.bl_backend.*;
public interface IUserController {

	boolean tryLogin(String username, String password, String authType);
	
	boolean signUp(String username, String password, String email, String phone);
	
	String getPasswordByUsername(String username, String authType);

	String getEmailByUsername(String username, String authType);
	
}
