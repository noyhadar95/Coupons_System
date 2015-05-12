package bl;

import bl_backend.Customer;
import dal.DAL;
import dal.IDAL;

public class BL implements IBL {

	private IDAL dal;

	public BL() {
		dal = new DAL();
	}

	@Override
	public boolean tryLogin(String username, String password) {
		boolean successFlag = false;
		Customer cust = dal.selectCustomer(username);

		if (cust != null && cust.getUsername().equals(username)
				&& cust.getPassword().equals(password)) {
			successFlag = true;
		}

		return successFlag;
	}

}
