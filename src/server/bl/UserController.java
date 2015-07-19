package server.bl;



import java.util.List;
import server.dal.DAL;
import server.dal.IDAL;
import auxiliary.bl_backend.Category;
import auxiliary.bl_backend.Customer;
import auxiliary.bl_backend.User;

public class UserController implements IUserController {

	private IDAL dal;

	public UserController() {
		dal = new DAL();
	}
	
	@Override
	public boolean tryLogin(String username, String password, String authType) {
		boolean successFlag = false;
		User user = getUserByAuthType(username, authType);

		if (user != null && user.getUsername().equals(username)
				&& user.getPassword().equals(password)) {
			successFlag = true;
		}

		return successFlag;
	}

	@Override
	public boolean signUp(String username, String password, String email,
			String phone) {
		Customer cus = new Customer(username, password, email, phone);
		dal.insertCustomer(cus);
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
			user = dal.selectAdmin(username);
			break;
		case "Customer":
			user = dal.selectCustomer(username);
			break;
		case "Bussines Owner":
			user = dal.selectBusinessOwner(username);
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
	public void addCustomerPreferences(List<Category> categories,String username){
		for (int i = 0; i < categories.size(); i++) {
			dal.AddPreferenceToCustomer(username, categories.get(i).getId());
		}
	}

}
