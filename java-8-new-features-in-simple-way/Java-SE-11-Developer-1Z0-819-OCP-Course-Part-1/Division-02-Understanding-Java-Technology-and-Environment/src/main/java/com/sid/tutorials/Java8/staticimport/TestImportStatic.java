/**
 * 
 */
package com.sid.tutorials.Java8.staticimport;

import static java.lang.Math.PI;

/**
 * @author Lenovo
 *
 */
public class TestImportStatic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int radius = 2;

		double result = 2 * PI * radius;
		System.out.println("Circumference is : " + result);

		double value = java.lang.Math.sqrt(81);
		System.out.println("Square root of 81 is : " + value);
	}

}
