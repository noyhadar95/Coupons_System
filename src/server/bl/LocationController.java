package server.bl;

import javax.swing.table.DefaultTableModel;

import server.dal.DAL;
import server.dal.IDAL;
import auxiliary.bl_backend.Location;
import dal.*;
public class LocationController implements ILocationController {
	private IDAL dal;
	
	public LocationController(){
		dal = new DAL();
	}
	
	@Override
	public Location getLocationByIp(String ip){
		DefaultTableModel model = dal.getLocationByIP(ip);
		int ip_from = (int)model.getValueAt(0, 0);
		int ip_to =(int)model.getValueAt(0, 1);
		String country_code=(String)model.getValueAt(0, 2);
		String country_name=(String)model.getValueAt(0, 3);
		String region_name= (String)model.getValueAt(0, 4);
		String city_name = (String)model.getValueAt(0, 5);
		int latitude = (int)model.getValueAt(0, 6);
		int longitude =(int)model.getValueAt(0, 7);
		String zip_code =(String)model.getValueAt(0, 8);
		
		
		
		return new Location(ip_from, ip_to, country_code, country_name, region_name, city_name, latitude, longitude, zip_code);
	}
}
