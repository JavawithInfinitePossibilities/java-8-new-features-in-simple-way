/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;

/**
 * @author Lenovo
 *
 */
public class Section074BinaryOperator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryOperator<String> biFunction = (String name, String lastName) -> {
			return (name + lastName);
		};
		System.out.println(biFunction.apply("Siddhant ", "Sahu"));
		DoubleBinaryOperator doubleBinaryOperator = (double i, double j) -> {
			return i * j;
		};
		System.out.println(doubleBinaryOperator.applyAsDouble(10, 12));
	}

}
