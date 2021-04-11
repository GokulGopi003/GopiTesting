package com.unipro.test.framework;

import java.util.Map;

import com.google.common.collect.Table;

public class Globals {

	public static Map<String, Table<String, String, String>> excelSheetData;

	public static class Inventory {
		final public static String SHEETNAME = "Inventory";
		public static Table<String, String, String> inventorySheetData;
		public static Map<String, String> inventoryrowwiseData;
		public static String MRP;
		public static String BasicCost;
		public static String DiscountPer1;
		public static String DiscountPer2;
		public static String DiscountPer3;
		public static String GSTPer;
		public static String DiscountPer;
		public static String AddDiscountPer;
		public static String NetSellingPrice;
		public static String spfixing;
		public static String netcost;

	}
	
	

}
