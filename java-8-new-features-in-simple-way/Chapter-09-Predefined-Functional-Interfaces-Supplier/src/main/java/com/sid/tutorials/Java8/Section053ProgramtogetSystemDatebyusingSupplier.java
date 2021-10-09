/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.Date;
import java.util.function.Supplier;

/**
 * @author Lenovo
 *
 */
public class Section053ProgramtogetSystemDatebyusingSupplier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Supplier<Date> supplier = () -> {
			return new Date();
		};
		System.out.println(supplier.get());
		int i = 21;
		System.out.println(Integer.toBinaryString(21));
		int value = i << 2;
		System.out.println(Integer.toBinaryString(value));
		System.out.println(value);
		i = -21;
		value = i >> 2;
		System.out.println(value);

		value = i >>> 2;
		System.out.println(value);

		int l = 23, j = 54;
		System.out.println(Integer.toBinaryString(l));
		System.out.println(Integer.toBinaryString(j));
		System.out.println(l & j);
		System.out.println(l | j);
	}

}
