package client.bl;

import auxiliary.bl_backend.Sensor;

public interface ISensorController {

	public Object startSensor(Sensor sensor);
	public Object stopSensor(Sensor sensor);
}
