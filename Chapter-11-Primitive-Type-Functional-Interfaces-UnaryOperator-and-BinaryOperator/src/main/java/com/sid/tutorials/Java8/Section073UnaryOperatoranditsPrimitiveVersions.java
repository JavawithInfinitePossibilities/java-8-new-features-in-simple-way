/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author Lenovo
 *
 */
public class Section073UnaryOperatoranditsPrimitiveVersions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UnaryOperator<Integer> unaryOperator = (Integer i) -> {
			return i * i;
		};
		System.out.println(unaryOperator.apply(5));
		LongUnaryOperator longUnaryOperator = (long l) -> {
			return l;
		};
		System.out.println(longUnaryOperator.applyAsLong(5l));
	}

}
