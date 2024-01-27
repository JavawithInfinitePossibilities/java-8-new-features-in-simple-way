/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.stream.IntStream;

/**
 * @author Lenovo
 *
 */
public class ExceptionAndErrorHandlingApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FebonacciSeries series = new FebonacciSeries();
		IntStream.rangeClosed(1, 5).forEach(i -> {
			System.out.print(series.febonacciNumber(i) + " ");
		});

	}

}
