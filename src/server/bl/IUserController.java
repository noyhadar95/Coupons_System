package server.bl;

public interface IUserController {

	boolean tryLogin(String username, String password, String authType);
	
	boolean signUp(String username, String password, String email, String phone);
	
	String getPasswordByUsername(String username, String authType);

	String getEmailByUsername(String username, String authType);
	
}
