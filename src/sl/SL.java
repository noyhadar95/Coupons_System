package sl;

import bl.BL;
import bl.IBL;

public class SL implements ISL {

	IBL bl;

	public SL() {
		bl = new BL();
	}

	@Override
	public boolean tryLogin(String username, String password, String authType) {
		return bl.tryLogin(username, password, authType);
	}
}
