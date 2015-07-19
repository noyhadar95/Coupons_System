package client.bl;

import server.sl.*;
import auxiliary.bl_backend.*;

public class SensorController implements ISensorController {

	@Override
	public Object startSensor(Sensor sensor) {
		return sensor.start();
	}

	@Override
	public Object stopSensor(Sensor sensor) {
		return sensor.stop();
	}

}
