package com.gk.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.*;

public class regex {

	static List<String> list;
	static String apendlist = "";

	public static void main(String[] args) {

		list = new ArrayList<String>();

		String hello = "1	01/05/2020	01/08/2020		0761	33249	Q0		10	$620.00								$620.00\n"
				+ "	\n" + "Adjustment\n" + "Edit: #002299\n"
				+ "APC assigned is 05232 Level 2 ICD and Similar Procedures. Final Status Indicator assigned is J1 Hospital Part B services paid through a comprehensive APC. Final Unit Value assigned is 1.Control: 05232,J1,1\n"
				+ "Mapped message:  COM007 - P602-BL-C--\n" + "Adjustment\n" + "Edit: #002994\n"
				+ "Claim submitted for Maryland facility. Line charges reduced 7.7% per the Maryland All-Payer Model; however, this claim does not include the provider's MPA multiplier of 1.0000.Percentage: 92.3\n"
				+ "Mapped message:  COM002 - P602-BA-C--\n" + "Information\n" + "Edit: #003347\n"
				+ "Allowance available.\n" + "Mapped message:  COM002 - P602-BA-C--\n" + "User Information\n"
				+ "Edit: #002143\n"
				+ "Medicare MUE maximum allowable daily units for 33249 = 1. The total units billed = 10.0. MUE rationale is Anatomic Consideration.\n"
				+ "Mapped message:  COM002 - P602-BA-C--\n" + "Price Info\n"
				+ "Pricer: #0042 Medicare Outpatient Maryland Pricer\n" + "\n" + "\n"
				+ "	2	01/05/2020	01/08/2020		0761	33241			9	$505.00								$505.00\n"
				+ "	\n" + "Adjustment\n" + "Edit: #002299\n"
				+ "APC assigned is 00000. Final Status Indicator assigned is N Items and Services Packaged into APC Rates. Final Unit Value assigned is 9.Control: 00000,N,9\n"
				+ "Mapped message:  COM007 - P602-BL-C--\n" + "Adjustment\n" + "Edit: #002994\n"
				+ "Claim submitted for Maryland facility. Line charges reduced 7.7% per the Maryland All-Payer Model; however, this claim does not include the provider's MPA multiplier of 1.0000.Percentage: 92.3\n"
				+ "Mapped message:  COM002 - P602-BA-C--\n" + "Information\n" + "Edit: #003347\n"
				+ "Allowance available.\n" + "Mapped message:  COM002 - P602-BA-C--\n" + "User Information\n"
				+ "Edit: #002143\n"
				+ "Medicare MUE maximum allowable daily units for 33241 = 1. The total units billed = 9.0. MUE rationale is Anatomic Consideration.\n"
				+ "Mapped message:  COM002 - P602-BA-C--\n" + "Price Info\n"
				+ "Pricer: #0042 Medicare Outpatient Maryland Pricer";

		Pattern pattern = Pattern.compile("Medicare MUE maximum allowable daily units for");
		Matcher matcher = pattern.matcher(hello);

		int count = 0;
		while (matcher.find())
			count++;

		System.out.println(count); // prints 3
		for (int i = 0; i < count; i++) {

		}

		// String[] totlaTable = hello.split("Medicare Outpatient Maryland Pricer");
		// System.out.println("The lentht of total Inner Tables" + totlaTable.length);
		// for (int j = 0; j < totlaTable.length; j++) {
		// System.out.println();
		// String[] dd = totlaTable[j].split("MUE");
		// System.out.println(dd.length);
		// System.out.println(dd[1]);
		// }

		String[] totlaTable1 = hello.split("Medicare Outpatient Maryland Pricer");
		System.out.println("The lentht of total Inner Tables" + totlaTable1.length);
		for (int j = 0; j < totlaTable1.length; j++) {
			System.out.println();
			String[] dd = totlaTable1[j].split("MUE");
			// System.out.println(dd.length);
			// System.out.println(dd[1]);
			String[] Mappedmessge = hello.split("Mapped message:");

			for (int i = 0; i < Mappedmessge.length; i++) {
				// System.out.println(Mappedmessge[i]);

				String[] mappedvalue = Mappedmessge[i].split("Adjustment");
				try {
					// System.out.println(mappedvalue[j]);

					list.add(mappedvalue[j]);

				} catch (Exception e) {
					// TODO Auto-generated catch block

				}
				// String[] mappedvalue2 = Mappedmessge[].split("Adjustment");
				// System.out.println(mappedvalue2[0]);

			}

		}

		// String[] Mappedmessge = hello.split("Mapped message:");
		// for (int i = 0; i < Mappedmessge.length; i++) {
		// // System.out.println(Mappedmessge[i]);
		//
		// }
		//
		// String[] mappedvalue = Mappedmessge[1].split("Adjustment");
		// System.out.println(mappedvalue[0]);
		// String[] mappedvalue2 = Mappedmessge[0].split("Adjustment");
		// System.out.println(mappedvalue2[0]);
		//

		// System.out.println(list.get(0).trim());
		// System.out.println(list.get(4).trim().replaceAll("", ""));
		for (int i = 0; i < list.size(); i++) {

			// System.out.println(i+" "+list.get(i));

			apendlist += list.get(i);

			if (list.get(i).contains("Medicare Outpatient Maryland Pricer")) {

				try {
					// System.out.println(list.get(i+1));
				} catch (Exception e) {
					// TODO Auto-generated catch block

				}

			}
		}

		Pattern p = Pattern.compile("\\d.+");
		Matcher m = p.matcher(apendlist);
		while (m.find()) {
			System.out.println(m.group());
		}

		// System.out.println(apendlist.replaceAll(" ", "-"));
	}

}
