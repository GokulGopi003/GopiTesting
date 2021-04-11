package com.unipro.test.framework.helpers.utils;

import com.google.common.collect.Table;

/**
 * To load login details by country
 * 

 * @since 12-Apr-2017
 */
public class LoginTestData {
	Table<String, String, String> fields;
	String country;

	public LoginTestData(Table<String, String, String> fields, String country) {
		this.fields = fields;
		this.country = country;

	}

	private String username1;

	private String codingUsername;
	private String password;
	private String countryCode;
	private String username2;
	private String countryName;
	private String invalidusrname;
	private String invalidpswd;
	private String lockedusrname;
	private String unregisteredusrname;
	public String getUsername1() {
		return fields.contains("Username1", country) ? fields.get("Username1",
				country) : username1;
	}

	public String getCodingUsername() {
		return fields.contains("Coding Username", country) ? fields.get(
				"Coding Username", country) : codingUsername;
	}

	public String getPassword() {
		return fields.contains("Password", country) ? fields.get("Password",
				country) : password;
	}

	public String getCountryCode() {
		return fields.contains("Country Code", country) ? fields.get(
				"Country Code", country) : countryCode;
	}

	public String getUsername2() {
		return fields.contains("Username2", country) ? fields.get("Username2",
				country) : username2;
	}

	public String getCountryName() {
		return fields.contains("Country Name", country) ? fields.get(
				"Country Name", country) : countryName;
	}
	
	public String getInvalidUsername() {
		return fields.contains("Invalid_Username", country) ? fields.get("Invalid_Username",
				country) : invalidusrname;
	}
	
	public String getInvalidPassword() {
		return fields.contains("Invalid_Password", country) ? fields.get("Invalid_Password",
				country) : invalidpswd;
	}
	
	public String getLockedUsername() {
		return fields.contains("Locked_Username", country) ? fields.get("Locked_Username",
				country) : lockedusrname;
	}
	
	public String getUnregisteredUsername() {
		return fields.contains("Non_registered_Username", country) ? fields.get("Non_registered_Username",
				country) : unregisteredusrname;
	}
	
}
