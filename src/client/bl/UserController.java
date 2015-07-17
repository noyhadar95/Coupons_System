package client.bl;

import java.util.Vector;

import client.dal.DAL;
import server.sl.*;
import auxiliary.bl_backend.*;

public class UserController implements IUserController {

	private ISL sl;

	public UserController() {
		sl = new SL();
	}

	@Override
	public boolean tryLogin(String username, String password, String authType) {
		boolean successFlag = false;
		User user = getUserByAuthType(username, authType);

		if (user != null && user.getUsername().equals(username)
				&& user.getPassword().equals(password)) {
			successFlag = true;
		}

		if(successFlag){
			setUsername(username);
		}
		
		return successFlag;
	}

	@Override
	public boolean signUp(String username, String password, String email,
			String phone) {
		Customer cus = new Customer(username, password, email, phone);
		sl.insertCustomer(cus);
		return true;
	}

	@Override
	public String getPasswordByUsername(String username, String authType) {
		String pass = null;
		User user = getUserByAuthType(username, authType);

		if (user != null && user.getUsername().equals(username)) {
			pass = user.getPassword();
		}

		return pass;
	}

	// return a User object from the database according to the given username
	// and authorization type.
	// returns NULL if no user was found.
	private User getUserByAuthType(String username, String authType) {
		User user = null;

		switch (authType) {
		case "Admin":
			user = sl.selectAdmin(username);
			break;
		case "Customer":
			user = sl.selectCustomer(username);
			break;
		case "Bussines Owner":
			user = sl.selectBusinessOwner(username);
			break;
		default:
			break;
		}

		return user;
	}

	@Override
	public String getEmailByUsername(String username, String authType) {
		String email = null;
		User user = getUserByAuthType(username, authType);

		if (user != null && user.getUsername().equals(username)) {
			email = user.getEmail();
		}

		return email;
	}

	@Override
	public void setUsername(String username) {
		DAL.getInstance().setUsername(username);

	}

	@Override
	public String getUsername() {
		return DAL.getInstance().getUsername();
	}
	
	@Override
	public void initializePurchases(String username){
		Vector<Vector<Object>> purchases=sl.getPruchases(username);
		DAL.getInstance().initializePurchases(purchases);
	}

}
