package auxiliary.bl_backend;

public class Business {

	private String name;
	private String address;
	private String city;
	private String category;
	private String description;
	private String owner; //maybe change to owner object?
	private double longitude;
	private double latitude;
	public Business(String name,String address,String city,String category,String description,String owner) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.category = category;
		this.description = description;
		this.owner = owner;
		this.longitude = 0;
		this.latitude = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setCoordinates(double longitude, double latitude){
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public double getLongitude(){
		return this.longitude;
	}
	
	public double getLatitude(){
		return this.latitude;
	}
}
