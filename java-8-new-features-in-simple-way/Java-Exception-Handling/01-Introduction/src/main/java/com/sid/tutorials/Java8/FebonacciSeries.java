/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */

public class FebonacciSeries {

	public int febonacciNumber(int num) {
		/*
		 * If I dont put a check in the application
		 */
		if (num <= 1) {
			return num;
		}
		return febonacciNumber(num - 1) + febonacciNumber(num - 2);
	}

}
