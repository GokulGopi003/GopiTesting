package com.unipro.test.framework.helpers.utils;

import static java.util.Objects.nonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class ReadCSVFile {

	/**
	 * This method will read the data from given csv file and return 2dArraylist
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<ArrayList<String>> getDataFromCsvFile(
			String filePath) throws IOException {
		ArrayList<ArrayList<String>> testData = new ArrayList<>();
		String line;
		BufferedReader file = null;
		try {
			file = new BufferedReader(new FileReader(new File(filePath)));
			while ((line = file.readLine()) != null) {
				ArrayList<String> data = new ArrayList<>();
				String[] colData = line.split(",", -1);
				for (int i = 0; i < colData.length; i++) {
					data.add(colData[i]);
				}
				testData.add(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (nonNull(file))
				file.close();
		}

		return testData;

	}

	public static Map<String, HashMap<String, ArrayList<String>>> getDataFromAllCsvFile(
			String filePath) {
		Map<String, HashMap<String, ArrayList<String>>> testData = new HashMap<>();
		String line;
		File fil = new File(filePath);
		// log.debug(fil.isFile());
		String[] dst = fil.list();
		// log.debug("yyyy" + dst.length);
		for (String fileName : dst) {
			// log.debug(fileName);
			String fPath = filePath + fileName;
			HashMap<String, ArrayList<String>> td = getDataFromCsvFileReturnMap(fPath);
			testData.put(fileName, td);

		}
		return testData;

	}

	public static HashMap<String, ArrayList<String>> getDataFromCsvFileReturnMap(
			String filePath) {
		String line;
		HashMap<String, ArrayList<String>> testData = new HashMap<>();
		try {
			BufferedReader file = new BufferedReader(new FileReader(new File(
					filePath)));
			while ((line = file.readLine()) != null) {
				ArrayList<String> data = new ArrayList<>();
				String[] colData = line.split(",", -1);
				for (int i = 1; i < colData.length; i++) {
					data.add(colData[i]);

				}
				testData.put(colData[0], data);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
	}

	public static HashMap<String, String> getLovDataFromCsvFileReturnMap(
			String filePath) {
		String line;
		HashMap<String, String> testData = new LinkedHashMap<>();
		try {
			BufferedReader file = new BufferedReader(new FileReader(new File(
					filePath)));
			while ((line = file.readLine()) != null) {
				String[] colData = line.split(",", -1);
				testData.put(colData[0] + "=" + colData[1], colData[1]);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
	}

	public static Table<String, String, String> getDataFromCsvFileReturnTable(
			String filePath) {
		String line;
		Table<String, String, String> testData = HashBasedTable.create();
		ArrayList<String> columNames = new ArrayList<>();
		try {
			BufferedReader file = new BufferedReader(new FileReader(new File(
					filePath)));

			if ((line = file.readLine()) != null) {
				String[] colData = line.split(",", -1);
				for (int i = 1; i < colData.length; i++) {
					columNames.add(colData[i]);
					// System.out.println(colData[i]);
				}
			}

			while ((line = file.readLine()) != null) {
				ArrayList<String> data = new ArrayList<>();
				String[] colData = line.split(",", -1);
				for (int i = 1; i <= columNames.size(); i++) {
					// System.out.println(colData[0] + columNames.get(i - 1)
					// + colData[i]);
					testData.put(colData[0], columNames.get(i - 1), colData[i]);

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
	}

	
	public static Table<String, String, String> getUniqueDataFromCsvFileReturnTable(
			String filePath) {
		String line;
		Table<String, String, String> testData = HashBasedTable.create();
		ArrayList<String> columNames = new ArrayList<>();
		try {
			BufferedReader file = new BufferedReader(new FileReader(new File(
					filePath)));

			if ((line = file.readLine()) != null) {
				String[] colData = line.split(",", -1);
				for (int i = 2; i < colData.length; i++) {
					columNames.add(colData[i]);
					// System.out.println(colData[i]);
				}
			}

			while ((line = file.readLine()) != null) {
				ArrayList<String> data = new ArrayList<>();
				String[] colData = line.split(",", -1);
				for (int i = 2; i <= columNames.size(); i++) {
					// System.out.println(colData[0] + columNames.get(i - 1)
					// + colData[i]);
				//	testData.put(colData[0]+colData[1], columNames.get(i - 2), colData[i]);
				//	 System.out.println(colData[0]+colData[1] + columNames.get(i - 2)  + colData[i]);

//				 System.out.println(colData[0]
//								+ (colData[1].trim().isEmpty() ? "" : "="
//										+ colData[1]) + "  " +  columNames.get(i - 2) + "  " + 
//								colData[i]);
					 testData.put(colData[0]
								+ (colData[1].trim().isEmpty() ? "" : "="
										+ colData[1]), columNames.get(i - 2),
								colData[i]);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
	}
	
	
	
	
	
	
	public static Table<String, String, String> getFromRenderingCsvFileReturnTable(
			String filePath) {
		String line;
		Table<String, String, String> testData = HashBasedTable.create();
		ArrayList<String> columNames = new ArrayList<>();
		try {
			BufferedReader file = new BufferedReader(new FileReader(new File(
					filePath)));

			if ((line = file.readLine()) != null) {
				String[] colData = line.split(";", -1);
				for (int i = 1; i < colData.length; i++) {
					columNames.add(colData[i]);
					// System.out.println(colData[i]);
				}
			}

			while ((line = file.readLine()) != null) {
				ArrayList<String> data = new ArrayList<>();
				String[] colData = line.split(";", -1);
				for (int i = 1; i <= columNames.size(); i++) {
					// System.out.println(colData[0] + columNames.get(i - 1)
					// + colData[i]);
					testData.put(colData[0], columNames.get(i - 1), colData[i]);

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
	}

	public static Map<String, Table<String, String, String>> getDataFromAllCsvFileReturnsMapTable(
			String dirPath) {
		Map<String, Table<String, String, String>> testData = new HashMap<>();
		File fileDir = new File(dirPath);

		List<String> files = Arrays.asList(fileDir.list()).stream()
				.filter(p -> p.endsWith(".csv")).collect(Collectors.toList());
		for (String fileName : files) {
			String filePath = dirPath + fileName;
			fileName = ReadTestData.getFileNameWithoutExtn(filePath);
			testData.put(fileName, getDataFromCsvFileReturnTable(filePath));
		}
		return testData;

	}

	public static Table<String, String, String> getUniqueColumnDataFromCsvFileReturnMap(
			String filePath) {
		String line;
		Table<String, String, String> testData = HashBasedTable.create();
		ArrayList<String> columNames = new ArrayList<>();
		try {
			BufferedReader file = new BufferedReader(new FileReader(new File(
					filePath)));

			if ((line = file.readLine()) != null) {
				String[] colData = line.split(",", -1);
				for (int i = 1; i < colData.length; i++) {
					columNames.add(colData[i]);
					// System.out.println(colData[i]);
				}
			}

			while ((line = file.readLine()) != null) {
				ArrayList<String> data = new ArrayList<>();
				String[] colData = line.split(",", -1);
				for (int i = 1; i <= columNames.size(); i++) {
					 System.out.println(colData[0] + "=" + colData[1].trim()
					 + columNames.get(i - 1) + colData[i]);
					testData.put(colData[0]
							+ (colData[1].trim().isEmpty() ? "" : "="
									+ colData[1]), columNames.get(i - 1),
							colData[i]);

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
	}
}
