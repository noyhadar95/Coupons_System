package auxiliary.bl_backend;

public class Coupon {

	private String name;
	private String description;
	private int category;
	private int initial_price;
	private int discount_price;
	private int rating;
	private String business_name;
	private int approved;

	public Coupon(String name, String description, int category,
			int initial_price, int discount_price, int rating,
			String business_name,int approved) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.initial_price = initial_price;
		this.discount_price = discount_price;
		this.rating = rating;
		this.business_name = business_name;
		this.approved=approved;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getCategory() {
		return category;
	}

	public int getInitial_price() {
		return initial_price;
	}

	public int getDiscount_price() {
		return discount_price;
	}

	public int getRating() {
		return rating;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getApproved() {
		return approved;
	}
	
	public void setApproved(int app){
		approved = app;
	}
}
