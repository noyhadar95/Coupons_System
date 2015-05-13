package bl;

import bl_backend.*;
import dal.DAL;
import dal.IDAL;

public class BL implements IBL {

	private IDAL dal;

	public BL() {
		dal = new DAL();
	}

	@Override
	public boolean tryLogin(String username, String password, String authType) {
		boolean successFlag = false;

		switch (authType) {
		case "Admin":
			Admin admin = dal.selectAdmin(username);

			if (admin != null && admin.getUsername().equals(username)
					&& admin.getPassword().equals(password)) {
				successFlag = true;
			}
			break;

		case "Customer":
			Customer cust = dal.selectCustomer(username);

			if (cust != null && cust.getUsername().equals(username)
					&& cust.getPassword().equals(password)) {
				successFlag = true;
			}
			break;

		case "Bussines Owner":
			BusinessOwner businessOwner = dal.selectBusinessOwner(username);

			if (businessOwner != null
					&& businessOwner.getUsername().equals(username)
					&& businessOwner.getPassword().equals(password)) {
				successFlag = true;
			}
			break;

		default:
			break;
		}

		return successFlag;
	}

}
