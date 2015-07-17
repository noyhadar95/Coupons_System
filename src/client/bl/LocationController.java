package client.bl;

import server.sl.ISL;
import server.sl.SL;
import auxiliary.bl_backend.Location;

public class LocationController implements ILocationController {
	public LocationController() {
		isl = new SL();
	}


	private ISL isl;
	
	
	@Override
	public Location getLocationByIp(String ip) {
		return isl.getLocationByIp(ip);
	}

}
