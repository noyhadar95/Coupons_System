package client.bl;

import server.sl.ISL;
import server.sl.SL;
import auxiliary.bl_backend.GPS;
import auxiliary.bl_backend.Location;
import auxiliary.bl_backend.Sensor;

public class LocationController implements ILocationController {
	public LocationController() {
		isl = new SL();
		sc = new SensorController();
	}


	private ISL isl;
	private SensorController sc;
	
	@Override
	public Location getLocationByIp() {
		Sensor sensor = new GPS();
		return isl.getLocationByIp(sc.startSensor(sensor).toString());
	}

}
