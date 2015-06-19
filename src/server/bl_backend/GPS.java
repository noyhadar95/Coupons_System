package server.bl_backend;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GPS implements Sensor {
	public void start() {
		InetAddress IP = null;
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (IP != null) {
			System.out.println("IP of my system is := " + IP.getHostAddress());
		}
	}

	public void stop() {

	}
}
