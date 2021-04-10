package com.unipro.test.framework.helpers.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.collect.Table;


public class ReadTestData {

	public static final String loginTestDataFilePath = "./testdata/login.csv";
	// public static final String loginTestDataFilePath =
	// "./testdata/login.xlsx";
	public static final String testDataFilePath = "./testdata";
	public static LoginTestData loginTD;
	public static Map<String, Table<String, String, String>> allTestDataTable = new HashMap<>();
	public static Table<String, String, String> loginTestDataTable;

	public static void readTestData() {
		String testDataPath = testDataFilePath.replace("CC",
				loginTD.getCountryCode());
		allTestDataTable = ReadXLSXFile.getExcelAsMapTable(testDataPath);

	}

	public static void readLoginDetails() {
		loginTestDataTable = ReadCSVFile
				.getDataFromCsvFileReturnTable(loginTestDataFilePath);

		// loginTestDataTable =
		// ReadXLSXFile.getExcelAsMapTable(loginTestDataFilePath).get("Sheet 1");

	}

	
	static String getFileNameWithoutExtn(String filePath) {
		File loginfile = new File(filePath);

		String fileName = loginfile.getName();
		fileName = fileName.substring(0, fileName.lastIndexOf("."));
		return fileName;
	}

	
	public static Map<String, String> getColumnFilteredValueFromTable(
			Table<String, String, String> table, String column) {
		return table.column(column).entrySet().stream()
				.filter(m -> !m.getValue().isEmpty())
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

	}


	public static Map<String, String> getColumnFilteredValueFromTable(
			Table<String, String, String> table, String column,
			Predicate<Entry<String, String>> predicate) {
		return table.column(column).entrySet().stream().filter(predicate)
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

	}

	public static Map<String, String> getRowFilteredValueFromTable(
			Table<String, String, String> table, String row) {
		return table.row(row).entrySet().stream()
				.filter(m -> !m.getValue().isEmpty())
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

	}

	public static Map<String, String> getMapFilteredByValue(
			Map<String, String> tobeFiltered, String value) {
		return tobeFiltered.entrySet().stream()
				.filter(x -> value.equals(x.getValue()))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

	}

	public static Map<String, String> getMapFilteredByKey(
			Map<String, String> tobeFiltered, String key) {
		return tobeFiltered.entrySet().stream()
				.filter(x -> key.equals(x.getKey()))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
	}

	public static Map<String, String> getMapFilteredByContainsValue(
			Map<String, String> tobeFiltered, String value) {
		return tobeFiltered.entrySet().stream()
				.filter(x -> value.contains(x.getValue()))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

	}
}
