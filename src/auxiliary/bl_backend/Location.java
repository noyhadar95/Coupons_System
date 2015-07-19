package auxiliary.bl_backend;

public class Location {
	
	public Location(int ip_from, int ip_to, String country_code,
			String country_name, String region_name, String city_name,
			double latitude, double longitude, String zip_code) {
		this.ip_from = ip_from;
		this.ip_to = ip_to;
		this.country_code = country_code;
		this.country_name = country_name;
		this.region_name = region_name;
		this.city_name = city_name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.zip_code = zip_code;
	}
	
	public Location (String country_code, String country_name,String region,String  city,double latitude, double longitude, String zipCode){
		this.country_code = country_code;
		this.country_name = country_name;
		this.region_name = region;
		this.city_name = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.zip_code = zipCode;
	}
	private int ip_from;
	private int ip_to;
	private String country_code;
	private String country_name;
	private String region_name;
	private String city_name;
	private double latitude;
	private double longitude;
	private String zip_code;
	
	
	public int getIp_from() {
		return ip_from;
	}
	public void setIp_from(int ip_from) {
		this.ip_from = ip_from;
	}
	public int getIp_to() {
		return ip_to;
	}
	public void setIp_to(int ip_to) {
		this.ip_to = ip_to;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
}
