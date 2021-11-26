package com.gk.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {


	public static void main(String[] args) throws SQLException {

		MssqlConnect mysqlConnect = new MssqlConnect();
		
		Statement st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	
		ResultSet rs = 
				st.executeQuery("select * from tblinventorypricing where inventorycode='859539'");
		
		//ResultSet rs = st.executeQuery("");

		while (rs.next()) {

			//String s = rs.getString("CategoryCode");
			String netcost = rs.getString("NetCost");
	      // System.out.println(s);
	       System.out.println(netcost);
		}

		


	}

}