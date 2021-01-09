package com.gk.test;

import java.util.Scanner;
import java.lang.Math;

public class Percentage {
	public static void main(String args[]) {
		float percentage;
		float total_marks;
		float scored;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Gross Cost ::");
		scored = sc.nextFloat();

		System.out.println("Enter Basic Cost  ::");
		total_marks = sc.nextFloat();

		percentage = (float) ((scored / total_marks) * 100);
		System.out.println("Percentage ::" + percentage);

		float discountOffered = 100 - percentage;
		System.out.println("discountOffered ::" + 	Math.round(discountOffered));
		

		
	}
}
