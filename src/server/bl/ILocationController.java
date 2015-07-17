package server.bl;

import auxiliary.bl_backend.Location;

public interface ILocationController {

	 Location getLocationByIp(String ip);
}
