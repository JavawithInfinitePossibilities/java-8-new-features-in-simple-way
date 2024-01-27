/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class Division04UsingOperatorsandDecisionConstructsApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int value = 1;
		++value;
		System.out.println("This is a prefix increment : " + value);
		value = 1;
		value++;
		System.out.println("This is a postfix increament : " + value);
		System.out.println("--------------------------------------");
		value = 1;
		System.out.println("This is a postfix increament : " + value++);
		System.out.println("This is the value after the execution : " + value);
		System.out.println("--------------------------------------");
		int binaryValue = 10;
		System.out.println("Binary value : " + Integer.toBinaryString(binaryValue));
		System.out.println("Left shift : " + Integer.toBinaryString(binaryValue << 2));
		System.out.println("Right shift : " + Integer.toBinaryString(binaryValue >> 2));
		binaryValue = -10;
		System.out.println("Binary value : " + Integer.toBinaryString(binaryValue));
		System.out.println("Unsigned right shift : " + Integer.toBinaryString(binaryValue >>> 2));
	}

}
