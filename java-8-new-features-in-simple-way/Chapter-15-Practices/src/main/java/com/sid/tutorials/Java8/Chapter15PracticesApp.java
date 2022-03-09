/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.Arrays;

/**
 * @author Lenovo
 *
 */
public class Chapter15PracticesApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PassbyvalueClass passbyvalueClass = new PassbyvalueClass();
		String myValue = "Java Training";
		int[] myArray = { 10, 9, 8, 7, 6, 5, 4 };
		int myInteger = 78;
		System.out.println("Before my String Value : " + myValue + " my Array : " + Arrays.toString(myArray)
				+ "  :: My integer : " + myInteger);
		passbyvalueClass.methodPassbyValue(myValue, myInteger, myArray);
		System.out.println("After methodPassbyValue my String Value : " + myValue + " my Array : "
				+ Arrays.toString(myArray) + "  :: My integer : " + myInteger);
		passbyvalueClass.methodPassbyValueReplaceByInitialision(myValue, myArray);
		System.out.println("After methodPassbyValueReplaceByInitialision my String Value : " + myValue + " my Array : "
				+ Arrays.toString(myArray) + "  :: My integer : " + myInteger);
	}

}
