package bl_backend;

public class Customer {
	private String username;
	private String password;
	private String email;
	private String phone;
	
	public Customer(String username,String password,String email, String phone){
		this.username=username;
		this.password=password;
		this.email=email;
		this.phone=phone;
	}

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	
}
