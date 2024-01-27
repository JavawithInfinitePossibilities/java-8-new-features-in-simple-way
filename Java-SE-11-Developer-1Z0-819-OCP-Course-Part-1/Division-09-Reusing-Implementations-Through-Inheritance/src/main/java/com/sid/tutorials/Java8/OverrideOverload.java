/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.Arrays;

/**
 * @author Lenovo
 *
 */
public class OverrideOverload {
	// This method overrides one of MostBasicClass's overloaded methods
	public void baseMethod() {
		//super.baseMethod();
		System.out.println("- CHILD OVERRODE 'void baseMethod()'");
	}

	// Overload baseMethod in the child class..
	public Object baseMethod(String[] s) {
		System.out.println("- CHILD OVERLOADED " + " 'Object baseMethod(String[] s)'");
		return Arrays.toString(s);
	}

	// Override baseMethod in the child class..
	// Note that it is ok to define a return type which can be said to
	// be an Object.
	public Integer baseMethod(String s) {
		System.out.println(
				"- CHILD OVERRODE " + " 'Object baseMethod(String s)' with " + "'Integer baseMethod(String s)'");
		return Integer.valueOf(s);
	}

	public int baseMethod(int[] intArray) {
		System.out.println("- CHILD OVERRODE 'int baseMethod(int[] intArray)'");
		return intArray[intArray.length - 1];

	}

	// Main method will call our overloaded, overridden methods
	public static void main(String[] args) {
		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		OverrideOverload oo = new OverrideOverload();
		int i = 0;
		oo.baseMethod();
		oo.baseMethod("10");
		oo.baseMethod(new String[] { "10" });

		try {
			// We'll make the call with var args
			i = oo.baseMethod(intArray);

		} catch (Exception e) {
			System.out.println("Uh oh, error occurred in call to" + " oo.baseMethod(intArray)");
		}
		System.out.println("local variable i = " + i);
	}

}

//MostBasicClass has 3 overloaded methods, all named baseMethod
class MostBasicClass {

	public void baseMethod() {
		System.out.println("- PARENT OVERLOAD 'void baseMethod()'");
		return;
	}

	public Object baseMethod(String s) {
		System.out.println("- PARENT OVERLOAD " + "'Object baseMethod(String s)'");
		return s;
	}

	public int baseMethod(int... intArray) throws ArrayIndexOutOfBoundsException {

		System.out.println("- PARENT OVERLOAD " + "'int baseMethod(int... intArray)'");

		return intArray[intArray.length + 1];
	}
}