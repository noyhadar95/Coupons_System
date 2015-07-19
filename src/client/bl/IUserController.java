package client.bl;

public interface IUserController {

	/**
	 * try to login with the given username and password as the given
	 * authorization, according to auth type.
	 * 
	 * @param username
	 *            username to login with.
	 * @param password
	 *            password to login with.
	 * @param authType
	 *            the type of the authorization that is trying to login.
	 * @return if login succeeded return true, else return false.
	 */
	boolean tryLogin(String username, String password, String authType);

	/**
	 * sign up a new user account in the database with the given fields.
	 * 
	 * @param username
	 *            username to login with.
	 * @param password
	 *            password to login with.
	 * @param email
	 *            email to login with.
	 * @param phone
	 *            phone to login with.
	 * @return true on success, false otherwise.
	 */
	boolean signUp(String username, String password, String email, String phone);

	/**
	 * return the password of a specific user by it's username.
	 * 
	 * @param username
	 *            the user's username.
	 * @param authType
	 *            the authorization type of the user.
	 * @return the password of the user.
	 */
	String getPasswordByUsername(String username, String authType);

	/**
	 * return the email of a specific user by it's username.
	 * 
	 * @param username
	 *            the user's username.
	 * @param authType
	 *            the authorization type of the user.
	 * @return the email of the user.
	 */
	String getEmailByUsername(String username, String authType);

	/**
	 * set the username of the current logged in user.
	 * 
	 * @param username
	 *            the user's username.
	 */
	void setUsername(String username);

	/**
	 * return the username of the current logged in user.
	 * 
	 * @return a username.
	 */
	String getUsername();
	
	void initializePurchases(String username);

	void setMode(int mode);

	int getMode();

}
