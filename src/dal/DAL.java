package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import bl_backend.*;

public class DAL implements IDAL {

	Connection conn = null;

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";
	 String db_name="";

	// Database credentials

	static final String USER = "root";
	static final String PASS = "";

	public DAL() {
		//initialDatabase();
		//testAddDeleteCoupon();
	}

	private void initialDatabase() {

		initializeCouponsDatabase();

		initializeAdministratorsTable();

		initializeBusinessOwnersTable();

		initializeBusinessesTable();

		initializeCategoryTable();

		initializeCustomersTable();

		initializeCouponsTable();

		initializeCustomersPrefencesTable();

		initializePurchasesTable();

	}

	private void initializeCouponsDatabase() {
		String query = "DROP DATABASE IF EXISTS couponsdb";
		executePassiveCommand(query);

		query = "CREATE DATABASE couponsdb";
		executePassiveCommand(query);

		db_name = "couponsdb";
	}

	private void initializePurchasesTable() {
		String query;
		query = "DROP TABLE IF EXISTS `purchases`;";
		executePassiveCommand(query);
		query = "CREATE TABLE `purchases` ("
				+ "`SerialKey` varchar(50) NOT NULL,"
				+ "`Rating` int(11) NOT NULL,"
				+ "`CustomerName` varchar(50) NOT NULL,"
				+ "`CouponName` varchar(50) NOT NULL,"
				+ "`Used` int(1) NOT NULL,"
				+ "PRIMARY KEY (`SerialKey`),"
				+ "KEY `FK_Purchase_Customers_idx` (`CustomerName`),"
				+ "KEY `FK_Purchase_Coupon_idx` (`CouponName`),"
				+ "CONSTRAINT `FK_Purchase_Coupon` FOREIGN KEY (`CouponName`) REFERENCES `coupons` (`Name`) ON DELETE NO ACTION ON UPDATE CASCADE,"
				+ "CONSTRAINT `FK_Purchase_Customers` FOREIGN KEY (`CustomerName`) REFERENCES `customers` (`Username`) ON DELETE NO ACTION ON UPDATE CASCADE"
				+ ")";
		executePassiveCommand(query);
	}

	private void initializeCustomersPrefencesTable() {
		String query;
		query = "DROP TABLE IF EXISTS `customers_preferences`;";
		executePassiveCommand(query);
		query = "CREATE TABLE `customers_preferences` ("
				+ "`Customer_Username` varchar(50) NOT NULL,"
				+ "`Category_Id` int(11) NOT NULL,"
				+ "PRIMARY KEY (`Category_Id`,`Customer_Username`),"
				+ "KEY `FK_Preference_Customer_idx` (`Customer_Username`),"
				+ "CONSTRAINT `FK_Preference_Category` FOREIGN KEY (`Category_Id`) REFERENCES `category` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "CONSTRAINT `FK_Preference_Customer` FOREIGN KEY (`Customer_Username`) REFERENCES `customers` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ")";
		executePassiveCommand(query);
	}

	private void initializeCouponsTable() {
		String query;
		query = "DROP TABLE IF EXISTS `coupons`;";
		executePassiveCommand(query);
		query = "CREATE TABLE `coupons` ("
				+ "`Name` varchar(50) NOT NULL,"
				+ "`Description` varchar(50) NOT NULL,"
				+ "`Category` int(11) NOT NULL,"
				+ "`InitialPrice` int(11) NOT NULL,"
				+ "`DiscountPrice` int(11) NOT NULL,"
				+ "`Rating` int(11) NOT NULL,"
				+ "`Business` varchar(45) NOT NULL,"
				+ "`Approved` int(1) NOT NULL,"
				+ "PRIMARY KEY (`Name`),"
				+ "KEY `fk_idx` (`Business`),"
				+ "KEY `FK-CouponCategory_idx` (`Category`),"
				+ "CONSTRAINT `FK-CouponCategory` FOREIGN KEY (`Category`) REFERENCES `category` (`Id`) ON DELETE RESTRICT ON UPDATE CASCADE,"
				+ "CONSTRAINT `FK_CouponsBusiness` FOREIGN KEY (`Business`) REFERENCES `businesses` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ") ";
		executePassiveCommand(query);
	}

	private void initializeCustomersTable() {
		String query;
		query = "DROP TABLE IF EXISTS `customers`;";
		executePassiveCommand(query);
		query = "CREATE TABLE `customers` ("
				+ "`Username` varchar(50) NOT NULL,"
				+ "`Password` varchar(50) NOT NULL,"
				+ "`Email` varchar(45) NOT NULL,"
				+ "`Phone` varchar(50) NOT NULL," + "PRIMARY KEY (`Username`)"
				+ ")";
		executePassiveCommand(query);
	}

	private void initializeCategoryTable() {
		String query;
		query = "DROP TABLE IF EXISTS `category`;";
		executePassiveCommand(query);
		query = "CREATE TABLE `category` (" + "`Id` int(11) NOT NULL,"
				+ "`Name` varchar(45) NOT NULL," + "PRIMARY KEY (`Id`),"
				+ "UNIQUE KEY `Name_UNIQUE` (`Name`)" + ") ";
		executePassiveCommand(query);
	}

	private void initializeBusinessesTable() {
		String query;
		query = "DROP TABLE IF EXISTS `businesses`;";
		executePassiveCommand(query);
		query = " CREATE TABLE `businesses` ("
				+ "`Name` varchar(50) NOT NULL,"
				+ "`Address` varchar(50) NOT NULL,"
				+ "`City` varchar(50) NOT NULL,"
				+ "`Category` varchar(50) NOT NULL,"
				+ "`Description` varchar(50) NOT NULL,"
				+ "`Owner` varchar(50) NOT NULL,"
				+ "PRIMARY KEY (`Name`),"
				+ "KEY `Owner_idx` (`Owner`),"
				+ "CONSTRAINT `FK_Owner` FOREIGN KEY (`Owner`) REFERENCES `businessowners` (`Username`) ON UPDATE CASCADE"
				+ ")";
		executePassiveCommand(query);
	}

	private void initializeBusinessOwnersTable() {
		String query;
		query = "DROP TABLE IF EXISTS `businessowners`;";
		executePassiveCommand(query);
		query = " CREATE TABLE `businessowners` ("
				+ "`Username` varchar(50) NOT NULL,"
				+ "`Password` varchar(50) NOT NULL,"
				+ "`Email` varchar(50) NOT NULL,"
				+ "`Phone` varchar(50) NOT NULL," + "PRIMARY KEY (`Username`)"
				+ ")";
		executePassiveCommand(query);
	}

	private void initializeAdministratorsTable() {
		String query;
		query = "DROP TABLE IF EXISTS couponsdb.administrators";
		executePassiveCommand(query);
		query = " CREATE TABLE `administrators` ("
				+ "  `Username` varchar(50) NOT NULL,"
				+ " `Password` varchar(50) NOT NULL,"
				+ " `Email` varchar(50) NOT NULL,"
				+ "   `Phone` varchar(50) NOT NULL,"
				+ "  PRIMARY KEY (`Username`)" + " )";
		executePassiveCommand(query);
	}

	public void connect() {

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			// System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL+db_name, USER, PASS);

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources

		}// end try
	}

	@Override
	public void insertCustomer(Customer cus) {

		String sql = String
				.format("INSERT INTO couponsdb.customers VALUES ('%s', '%s', '%s','%s')",
						cus.getUsername(), cus.getPassword(), cus.getEmail(),
						cus.getPhone());
		executePassiveCommand(sql);

	}

	@Override
	public Customer selectCustomer(String username) {
		String sql = String.format(
				"SELECT * FROM couponsdb.customers WHERE Username='%s' ",
				username);
		List userList = executeActiveCommand(sql);
		if (userList.size() == 0)
			return null;
		HashMap user = (HashMap) userList.get(0);
		Customer result = new Customer((String) user.get("Username"),
				(String) user.get("Password"), (String) user.get("Email"),
				(String) user.get("Phone"));
		return result;
	}
	
	public DefaultTableModel getResultset(String table){
		String sql = String.format(
				"SELECT * FROM couponsdb.%s",
				table);
		return executeResultSet(sql);
	}
	
	public DefaultTableModel getResultSetFromQuery(String query){
		return executeResultSet(query);
	}

	
	public void testAddDeleteCoupon() {
		// insert business owner and business before insert a coupon because
		// coupon has a foreign key to business name. And insert a category.
		BusinessOwner owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		inserBusinessOwner(owner);
		Business business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		insertBusiness(business);
		Category category = new Category(1, "cat1");
		insertCategory(category);

		Coupon coupon = new Coupon("coupon_name", "description", 1, 40, 20, 4,
				"business_name",0);
		insertCoupon(coupon);
		coupon = new Coupon("qwe", "description", 1, 40, 20, 4,
				"business_name",0);
		insertCoupon(coupon);
		coupon = new Coupon("fgh", "description", 1, 40, 20, 4,
				"business_name",0);
		insertCoupon(coupon);
		coupon = new Coupon("hjk", "description", 1, 40, 20, 4,
				"business_name",0);
		insertCoupon(coupon);
		
		Customer customer = new Customer("cust1", "pass", "mail@gmail.com",
				"0129712");
		insertCustomer(customer);
		customer = new Customer("cust2", "pass", "mail2@gmail.com",
				"20129712");
		insertCustomer(customer);
		 owner = new BusinessOwner("owner1", "pass",
				"mail@gmail.com", "0129712");
		inserBusinessOwner(owner);
		 business = new Business("business_name", "pqwfqwass", "asc",
				"wqfqwf", "uu", "owner1");
		insertBusiness(business);
		 category = new Category(1, "cat1");
		insertCategory(category);
		 coupon = new Coupon("coupon1", "description", 1, 40, 20, 4,
				"business_name",0);
		insertCoupon(coupon);

		Purchase purchase = new Purchase("serial_key", 4, "cust1", "coupon1",0);
		insertPurchase(purchase);
		purchase = new Purchase("serial_key1", 4, "cust1", "coupon1",0);
		insertPurchase(purchase);
		purchase = new Purchase("serial_key2", 4, "cust2", "coupon1",0);
		insertPurchase(purchase);
		
	}

	
	
	
	private void executePassiveCommand(String query) {
		Statement stmt = null;
		try {
			connect();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			// Handle errors for Class.forName
			//e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
	}

	private List executeActiveCommand(String query) {
		Statement stmt = null;
		ResultSet result = null;
		List list = null;
		try {
			connect();
			stmt = conn.createStatement();
			result = stmt.executeQuery(query);
			list = resultSetToArrayList(result);
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		return list;
	}

	private List resultSetToArrayList(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		ArrayList list = new ArrayList();
		while (rs.next()) {
			HashMap row = new HashMap(columns);
			for (int i = 1; i <= columns; ++i) {
				row.put(md.getColumnName(i), rs.getObject(i));
			}
			list.add(row);
		}

		return list;
	}

	
	private DefaultTableModel executeResultSet(String query) {
		Statement stmt = null;
		ResultSet result = null;
		List list = null;
		ResultSetMetaData metaData=null;
		try {
			connect();
			stmt = conn.createStatement();
			result = stmt.executeQuery(query);
		    metaData = result.getMetaData();
		    Vector<String> columnNames = new Vector<String>();
		    int columnCount = metaData.getColumnCount();
		    for (int column = 1; column <= columnCount; column++) {
		        columnNames.add(metaData.getColumnName(column));
		    }

		    // data of the table
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    while (result.next()) {
		        Vector<Object> vector = new Vector<Object>();
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		            vector.add(result.getObject(columnIndex));
		        }
		        data.add(vector);
		    }

		    return new DefaultTableModel(data, columnNames);
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		return null;
		
	}
	
	@Override
	public void insertAdmin(Admin admin) {
		String sql = String
				.format("INSERT INTO couponsdb.administrators VALUES ('%s', '%s', '%s','%s')",
						admin.getUsername(), admin.getPassword(),
						admin.getEmail(), admin.getPhone());
		executePassiveCommand(sql);
	}

	@Override
	public void inserBusinessOwner(BusinessOwner owner) {
		String sql = String
				.format("INSERT INTO couponsdb.businessowners VALUES ('%s', '%s', '%s','%s')",
						owner.getUsername(), owner.getPassword(),
						owner.getEmail(), owner.getPhone());
		executePassiveCommand(sql);
	}

	@Override
	public Admin selectAdmin(String username) {
		String sql = String.format(
				"SELECT * FROM couponsdb.administrators WHERE Username='%s' ",
				username);
		List userList = executeActiveCommand(sql);
		if (userList.size() == 0)
			return null;
		HashMap user = (HashMap) userList.get(0);
		Admin result = new Admin((String) user.get("Username"),
				(String) user.get("Password"), (String) user.get("Email"),
				(String) user.get("Phone"));
		return result;
	}

	@Override
	public BusinessOwner selectBusinessOwner(String username) {
		String sql = String.format(
				"SELECT * FROM couponsdb.businessowners WHERE Username='%s' ",
				username);

		List userList = executeActiveCommand(sql);
		if (userList.size() == 0)
			return null;
		HashMap user = (HashMap) userList.get(0);
		BusinessOwner result = new BusinessOwner((String) user.get("Username"),
				(String) user.get("Password"), (String) user.get("Email"),
				(String) user.get("Phone"));

		return result;
	}

	@Override
	public void deleteAdmin(String username) {
		String sql = String.format(
				"DELETE FROM couponsdb.administrators WHERE Username ='%s'",
				username);
		executePassiveCommand(sql);
	}

	@Override
	public void deleteBusinessOwner(String username) {
		String sql = String.format(
				"DELETE FROM couponsdb.businessowners WHERE Username='%s' ",
				username);
		executePassiveCommand(sql);

	}

	@Override
	public void deleteCustomer(String username) {
		String sql = String.format(
				"DELETE FROM couponsdb.customers WHERE Username ='%s'",
				username);
		executePassiveCommand(sql);
	}

	@Override
	public void updateBusinessOwner(BusinessOwner owner) {
		String sql = String
				.format("UPDATE couponsdb.businessowners SET Password='%s', Email='%s',Phone='%s' WHERE Username='%s' ",
						owner.getPassword(), owner.getEmail(),
						owner.getPhone(), owner.getUsername());
		executePassiveCommand(sql);

	}

	@Override
	public void insertBusiness(Business business) {
		String sql = String
				.format("INSERT INTO couponsdb.businesses VALUES ('%s', '%s', '%s','%s','%s','%s')",
						business.getName(), business.getAddress(),
						business.getCity(), business.getCategory(),
						business.getDescription(), business.getOwner());
		executePassiveCommand(sql);

	}

	@Override
	public Business selectBusiness(String name) {
		String sql = String.format(
				"SELECT * FROM couponsdb.businesses WHERE Name='%s' ", name);
		List businessList = executeActiveCommand(sql);
		if (businessList.size() == 0)
			return null;
		HashMap business = (HashMap) businessList.get(0);
		Business result = new Business((String) business.get("Name"),
				(String) business.get("Address"),
				(String) business.get("City"),
				(String) business.get("Category"),
				(String) business.get("Description"),
				(String) business.get("Owner"));
		return result;
	}

	@Override
	public void deleteBusiness(String name) {
		String sql = String.format(
				"DELETE FROM couponsdb.businesses WHERE Name='%s' ", name);
		executePassiveCommand(sql);

	}

	@Override
	public void insertCoupon(Coupon coupon) {
		String sql = String
				.format("INSERT INTO couponsdb.coupons VALUES ('%s', '%s', %d, %d, %d, %d,'%s', %d)",
						coupon.getName(), coupon.getDescription(),
						coupon.getCategory(), coupon.getInitial_price(),
						coupon.getDiscount_price(), coupon.getRating(),
						coupon.getBusiness_name(),coupon.getApproved());
		executePassiveCommand(sql);

	}

	@Override
	public Coupon selectCoupon(String name) {
		String sql = String.format(
				"SELECT * FROM couponsdb.coupons WHERE Name='%s' ", name);
		List userList = executeActiveCommand(sql);
		if (userList.size() == 0)
			return null;
		HashMap coupon = (HashMap) userList.get(0);
		Coupon result = new Coupon((String) coupon.get("Name"),
				(String) coupon.get("Description"),
				(int) coupon.get("Category"), (int) coupon.get("InitialPrice"),
				(int) coupon.get("DiscountPrice"), (int) coupon.get("Rating"),
				(String) coupon.get("Business"),(int) coupon.get("Approved"));
		return result;
	}
	
	public List getTableArrayList(String table) {
		String sql = String.format(
				"SELECT * FROM couponsdb."+table);
		List list = executeActiveCommand(sql);
		return list;
	}

	@Override
	public void deleteCoupon(String name) {
		String sql = String.format(
				"DELETE FROM couponsdb.coupons WHERE Name='%s' ", name);
		executePassiveCommand(sql);

	}

	@Override
	public void updateCoupon(Coupon coupon) {
		String sql = String
				.format("UPDATE couponsdb.coupons SET Description='%s',Category=%d ,InitialPrice=%d ,DiscountPrice=%d ,Rating=%d ,Business='%s', Approved=%d WHERE Name='%s' ",
						coupon.getDescription(), coupon.getCategory(),
						coupon.getInitial_price(), coupon.getDiscount_price(),
						coupon.getRating(), coupon.getBusiness_name(), coupon.getApproved(),
						coupon.getName());
		executePassiveCommand(sql);

	}

	@Override
	public void insertPurchase(Purchase purchase) {
		String sql = String
				.format("INSERT INTO couponsdb.purchases VALUES ('%s', %d, '%s', '%s', %d)",
						purchase.getSerialKey(), purchase.getRating(),
						purchase.getCustomerName(), purchase.getCouponName(), purchase.getUsed());
		executePassiveCommand(sql);

	}

	@Override
	public Purchase selectPurchase(String serialKey) {
		String sql = String.format(
				"SELECT * FROM couponsdb.purchases WHERE SerialKey='%s' ",
				serialKey);
		List userList = executeActiveCommand(sql);
		if (userList.size() == 0)
			return null;
		HashMap purchase = (HashMap) userList.get(0);
		Purchase result = new Purchase((String) purchase.get("SerialKey"),
				(int) purchase.get("Rating"),
				(String) purchase.get("CustomerName"),
				(String) purchase.get("CouponName"),(int) purchase.get("Used"));
		return result;
	}

	@Override
	public void deletePurchase(String serialKey) {
		String sql = String.format(
				"DELETE FROM couponsdb.purchases WHERE SerialKey='%s' ",
				serialKey);
		executePassiveCommand(sql);

	}

	@Override
	public void updatePurchase(Purchase purchase) {
		String sql = String
				.format("UPDATE couponsdb.purchases SET Rating=%d ,CustomerName='%s',CouponName='%s', Used=%d WHERE SerialKey='%s' ",
						purchase.getRating(), purchase.getCustomerName(),
						purchase.getCouponName(), purchase.getUsed(), purchase.getSerialKey());
		executePassiveCommand(sql);

	}

	@Override
	public void insertCategory(Category category) {
		String sql = String.format(
				"INSERT INTO couponsdb.category VALUES (%d, '%s')",
				category.getId(), category.getName());
		executePassiveCommand(sql);

	}

	@Override
	public void deleteCategory(int id) {
		String sql = String.format(
				"DELETE FROM couponsdb.category WHERE Id=%d ", id);
		executePassiveCommand(sql);

	}

	@Override
	public DefaultTableModel selectCouponsNamesRatingsByCustomer(
			String customerName) {
		String query="SELECT SerialKey,CouponName,Rating,Used FROM couponsdb.purchases WHERE CustomerName='"+customerName+"'";
		return getResultSetFromQuery(query);
	}

	@Override
	public DefaultTableModel selectAllCoupons() {
		return getResultset("coupons");
	}

	@Override
	public int getNumOfUnapprovedCoupons() {
		String query="SELECT * FROM couponsdb.coupons WHERE Approved=0";
		List list= executeActiveCommand(query);
		return list.size();
	}

	@Override
	public DefaultTableModel getApprovedCoupons() {
		String query="SELECT * FROM couponsdb.coupons WHERE Approved=1";
		return getResultSetFromQuery(query);
	}

	@Override
	public DefaultTableModel getCouponsByFilter(String filter, String text) {
		String query = String.format("SELECT * FROM couponsdb.coupons WHERE %s='%s' AND Approved=1", filter, text);
		return getResultSetFromQuery(query);
	}

	@Override
	public DefaultTableModel getBusinessByFilter(String filter, String text) {
		String query = String.format("SELECT * FROM couponsdb.businesses WHERE %s='%s'", filter, text);
		return getResultSetFromQuery(query);
	}

	@Override
	public DefaultTableModel getCouponsByPreference(String customerName) {
		String query = String.format("SELECT couponsdb.coupons.Name, couponsdb.coupons.Description, couponsdb.coupons.Category, "+
									"couponsdb.coupons.InitialPrice, couponsdb.coupons.DiscountPrice, couponsdb.coupons.Rating, couponsdb.coupons.Business, couponsdb.coupons.Approved "+
									"FROM  couponsdb.customers_preferences join couponsdb.coupons "+
									"WHERE Customer_Username = '%s'",
									customerName);
		return getResultSetFromQuery(query);
	}

}
