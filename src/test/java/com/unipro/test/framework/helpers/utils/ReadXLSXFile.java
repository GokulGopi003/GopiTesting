package com.unipro.test.framework.helpers.utils;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import static  com.unipro.test.framework.helpers.utils.ApplicationLogger.log;
import static  com.unipro.test.framework.helpers.utils.GenericWrappers.properties;;



public class ReadXLSXFile {

	
	public static Map<String, Table<String, String, String>> getExcelAsMapTable(
			final String filePath) {
		log.debug("Begin reading: " + filePath);
		Workbook workbook = null;
		try {
			if (getExtention(filePath).equals("xlsx")) {
				workbook = new XSSFWorkbook(filePath);

			} else {
				workbook = new HSSFWorkbook(new FileInputStream(filePath));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, Table<String, String, String>> excelMap = new HashMap<>();

		for (int i = 0; i <= workbook.getNumberOfSheets() - 1; i++) {
			String sheetName = workbook.getSheetName(i);
			Table<String, String, String> testData = HashBasedTable.create();
			List<String> columNames = new LinkedList<>();
			DataFormatter df = new DataFormatter();

			workbook.getSheet(sheetName)
					.forEach(x -> {

						// if (x.getRowNum() == 0) {
						//
						// x.cellIterator().forEachRemaining(
						//
						// y -> {
						//
						// if (y.getColumnIndex() != 0) {
						//
						// columNames.add(y
						// .getRichStringCellValue()
						// .toString());
						// });
						// System.out.println("COLUMN NAMES >> " +
						// columNames);

							if (x.getRowNum() == 0) {

								x.cellIterator()
										.forEachRemaining(

												y -> {
													if (y.getColumnIndex() != 0)
														columNames
																.add(y.getRichStringCellValue()
																		.toString());
												});

							} else {
								for (int j = 1; j <= columNames.size(); j++) {
									testData.put(
											columNames.contains("Applicant") ? (df
													.formatCellValue(x
															.getCell(0)) + df
													.formatCellValue(x
															.getCell(1)))
													: (columNames
															.contains("Fulfilment-Product") ? (df
															.formatCellValue(x
																	.getCell(0))
															+ (df.formatCellValue(x
																	.getCell(1)) != "" ? "="
																	: "") + df
															.formatCellValue(x
																	.getCell(1)))
															: (df.formatCellValue(x
																	.getCell(0)))),
											columNames.get(j - 1),
											(x.getCell(j,
													Row.RETURN_NULL_AND_BLANK) == null ? ""
													: df.formatCellValue(x
															.getCell(j))));

									// System.out.println("First >" +
									// df.formatCellValue(x.getCell(0)) +
									// "Second > " + columNames.get(j - 1) +
									// " Third > " +
									// (x.getCell(j,Row.RETURN_NULL_AND_BLANK)
									// == null ? "":
									// df.formatCellValue(x.getCell(j))) );
								}

							}
						}

					);
			excelMap.put(sheetName, testData);
		}
		log.debug("End of  reading: " + filePath);
		return excelMap;
	}

	public static Map<String, Table<String, String, String>> getFormRenderingAsMapTable(
			final String filePath) {
		log.debug("Beging of  reading: " + filePath);
		final String COUNTRY_CODE = ReadTestData.loginTD.getCountryCode();
		Workbook workbook = null;
		String sheetNameinPropertyFile = properties(COUNTRY_CODE
				+ ".FormRenderingSheet");

		try {
			if (getExtention(filePath).equals("xlsx")) {
				workbook = new XSSFWorkbook(filePath);

			} else {
				workbook = new HSSFWorkbook(new FileInputStream(filePath));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, Table<String, String, String>> excelMap = new HashMap<>();

		for (int i = 0; i <= workbook.getNumberOfSheets() - 1; i++) {
			String sheetName = workbook.getSheetName(i);
			Table<String, String, String> testData = HashBasedTable.create();
			List<String> columNames = new LinkedList<>();
			DataFormatter df = new DataFormatter();

			workbook.getSheet(sheetName)
					.forEach(
							x -> {

								if (x.getRowNum() == 0) {

									x.cellIterator()
											.forEachRemaining(

													y -> {
														if (y.getColumnIndex() != 0)
															columNames
																	.add(y.getRichStringCellValue()
																			.toString());
													});
									System.out.println("COLUMN NAMES >> "
											+ columNames);
								} else {
									for (int j = 1; j <= columNames.size(); j++) {
										// testData.put(
										// df.formatCellValue(x.getCell(0)),
										// columNames.get(j - 1),
										// (x.getCell(
										// j,
										// Row.RETURN_NULL_AND_BLANK) == null ?
										// ""
										// : df.formatCellValue(x
										// .getCell(j))));

										if (sheetName
										// .equalsIgnoreCase("RTOB Form Rendering - IN NTB")
										// .equalsIgnoreCase(properties(COUNTRY_CODE
										// + ".FormRenderingSheet"))
												.equalsIgnoreCase(sheetNameinPropertyFile)
												|| sheetName
														.equalsIgnoreCase("RTOB Form Rendering - IN ETB"))

										{
											testData.put(

													df.formatCellValue(x.getCell(columNames
															.indexOf("Logical Field Name") - 1)),
													columNames.get(j - 1),
													(x.getCell(
															j,
															Row.RETURN_NULL_AND_BLANK) == null ? ""
															: df.formatCellValue(x
																	.getCell(j))));
											// System.out.println("First >" +
											// df.formatCellValue(x.getCell(0))
											// + " Second > " + columNames.get(j
											// - 1) + " Third > " +
											// (x.getCell(j,Row.RETURN_NULL_AND_BLANK)
											// == null ? "":
											// df.formatCellValue(x.getCell(j)))
											// );

											System.out.println(" Name >> "
													+ df.formatCellValue(x.getCell(columNames
															.indexOf("Logical Field Name") - 1)));
										}

									}

								}
							}

					);
			excelMap.put(sheetName, testData);
		}
		log.debug("End of  reading: " + filePath);
		return excelMap;
	}

	public static Map<String, Table<String, String, String>> getFormRenderingExcelAsMapTable(
			final String filePath) {
		log.debug("Begin of  reading: " + filePath);
		final String COUNTRY_CODE = ReadTestData.loginTD.getCountryCode();
		String sheetNameinPropertyFile = properties(COUNTRY_CODE
				+ ".FormRenderingSheet");
		Workbook workbook = null;
		try {
			if (getExtention(filePath).equals("xlsx")) {
				workbook = new XSSFWorkbook(filePath);

			} else {
				workbook = new HSSFWorkbook(new FileInputStream(filePath));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, Table<String, String, String>> excelMap = new HashMap<>();

		for (int i = 0; i <= workbook.getNumberOfSheets() - 1; i++) {
			String sheetName = workbook.getSheetName(i);
			Table<String, String, String> testData = HashBasedTable.create();
			List<String> columNames = new LinkedList<>();
			DataFormatter df = new DataFormatter();

			workbook.getSheet(sheetName)
					.forEach(
							x -> {

								if (x.getRowNum() == 0) {

									x.cellIterator()
											.forEachRemaining(

													y -> {
														if (y.getColumnIndex() != 0)
															columNames
																	.add(y.getRichStringCellValue()
																			.toString());
													});
								} else {
									for (int j = 1; j <= columNames.size(); j++) {

										if (sheetName
										// .equalsIgnoreCase("RTOB Form Rendering - IN NTB")
										// .equalsIgnoreCase(properties(COUNTRY_CODE
										// + ".FormRenderingSheet"))
												.equalsIgnoreCase(sheetNameinPropertyFile)
												|| sheetName
														.equalsIgnoreCase("RTOB Form Rendering- IN ETB SF")) {
											testData.put(
													df.formatCellValue(x.getCell(columNames
															.indexOf("RWB Stage") + 1))
															+ "="
															+ df.formatCellValue(x
																	.getCell(columNames
																			.indexOf("Logical Field Name") + 1)),
													columNames.get(j - 1),
													(x.getCell(
															j,
															Row.RETURN_NULL_AND_BLANK) == null ? ""
															: df.formatCellValue(x
																	.getCell(j))));

										}

									}
								}
							}

					);
			excelMap.put(sheetName, testData);

			// System.out.println(ReadTestData.getRowFilteredValueFromTable(ReadXLSXFile.getFormRenderingExcelAsMapTable(
			// "/Users/plpatra/git/rwb-bdd-rtob/testdata/IN/NTB/RWB_Form_Rendering_v5.3.xlsx")
			// .get("RTOB Form Rendering - IN NTB"),
			// "full_name_1"));
		}
		// System.out.println(excelMap);
		log.debug("End of  reading: " + filePath);
		return excelMap;

	}

	// ======

	public static HashMap<String, String> getMasterLovDataFromExcelAsMapOFMap(
			String filePath) {
		log.debug("Begin of  reading: " + filePath);
		Workbook workbook = null;
		try {
			if (getExtention(filePath).equals("xlsx")) {
				workbook = new XSSFWorkbook(filePath);

			} else {
				workbook = new HSSFWorkbook(new FileInputStream(filePath));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> columNames = new LinkedList<>();
		DataFormatter df = new DataFormatter();
		HashMap<String, String> testData = new LinkedHashMap<>();
		workbook.getSheet("Master LOV")
				.forEach(
						x -> {

							if (x.getRowNum() == 0) {

								x.cellIterator()
										.forEachRemaining(

												y -> {
													if (y.getColumnIndex() != 0)
														columNames
																.add(y.getRichStringCellValue()
																		.toString());
												});
							} else {
								for (int j = 1; j <= columNames.size(); j++) {

									testData.put(
											df.formatCellValue(x.getCell(columNames
													.indexOf("Code Description") + 1))
													+ "="
													+ x.getCell(columNames
															.indexOf("Field Name") + 1),
											df.formatCellValue(x.getCell(columNames
													.indexOf("Field Name") + 1)));
								}
							}
						}

				);
		log.debug("End of  reading: " + filePath);
		return testData;
	}

	// =====

	private static String getExtention(String filePath) {
		return FilenameUtils.getExtension(filePath);

	}
}
