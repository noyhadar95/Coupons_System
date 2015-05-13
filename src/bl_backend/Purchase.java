package bl_backend;

public class Purchase {

	private String serial_key;
	private int rating;
	private String customer_name;
	private String coupon_name;
	private int used;

	public Purchase(String serial_key, int rating, String customer_name,
			String coupon_name,int used) {
		this.serial_key = serial_key;
		this.rating = rating;
		this.customer_name = customer_name;
		this.coupon_name = coupon_name;
		this.used=used;
	}

	public String getSerialKey() {
		return serial_key;
	}

	public int getRating() {
		return rating;
	}

	public String getCustomerName() {
		return customer_name;
	}

	public String getCouponName() {
		return coupon_name;
	}

	public void setRating(int rating) {
		this.rating = rating;

	}
	
	public int getUsed() {
		return used;
	}

}
