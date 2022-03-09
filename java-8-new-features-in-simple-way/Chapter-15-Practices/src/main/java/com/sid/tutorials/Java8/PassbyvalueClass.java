/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.Arrays;

/**
 * @author Lenovo
 *
 */
public class PassbyvalueClass {

	public void methodPassbyValue(String myValue, int myInteger, int[] myArray) {
		myValue = "welcome back";
		myInteger = 9;
		Arrays.fill(myArray, 5);
	}

	public void methodPassbyValueReplaceByInitialision(String myValue, int[] myArray) {
		myValue = new String("Spring Boot");
		myArray = new int[] { 1, 2, 3, 4, 5, 6 };
	}
}
