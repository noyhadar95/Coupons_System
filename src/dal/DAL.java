package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bl_backend.Customer;

public class DAL implements IDAL {

	Connection conn = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/MySQL";

	// Database credentials
	static final String USER = "CouponDB";
	static final String PASS = "couponpass";
	public DAL() {
		//connect();
	}

	public void connect() {
		

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
		//	System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

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

		String sql =String.format("INSERT INTO couponsdb.customers VALUES ('%s', '%s', '%s','%s')",cus.getUsername(),cus.getPassword(),cus.getEmail(),cus.getPhone()) ;
		executePassiveCommand(sql);

}

	@Override
	public Customer selectCustomer(String username) {
		String sql =String.format("SELECT * FROM couponsdb.customers WHERE Username='%s' ",username) ;
		List userList=executeActiveCommand(sql);
		HashMap user=(HashMap)userList.get(0);
		Customer result=new Customer((String)user.get("Username"), (String)user.get("pass"), (String)user.get("Email"), (String)user.get("Phone"));
		return result;
	}
	
	private void executePassiveCommand(String query){
		Statement stmt = null;
		try{
			connect();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
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
	}
	
	private List executeActiveCommand(String query){
		Statement stmt = null;
		ResultSet result=null;
		List list=null;
		try{
			connect();
			stmt = conn.createStatement();
			result= stmt.executeQuery(query);
			list =resultSetToArrayList(result);
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
	
	private List resultSetToArrayList(ResultSet rs) throws SQLException{
		  ResultSetMetaData md = rs.getMetaData();
		  int columns = md.getColumnCount();
		  ArrayList list = new ArrayList();
		  while (rs.next()){
		     HashMap row = new HashMap(columns);
		     for(int i=1; i<=columns; ++i){           
		      row.put(md.getColumnName(i),rs.getObject(i));
		     }
		      list.add(row);
		  }

		 return list;
		}
		

}
