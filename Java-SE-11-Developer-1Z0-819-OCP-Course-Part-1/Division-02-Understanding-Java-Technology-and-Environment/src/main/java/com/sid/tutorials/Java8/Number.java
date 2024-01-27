/**
 * 
 */
package com.sid.tutorials.Java8;

/*import java.lang.Number;*/

/**
 * @author Lenovo
 *
 */
public class Number {
	Number num;
	java.lang.Number number;

	public Number(Number num) {
		this.num = num;
		System.out.println("This is a customised class....");
	}

	public Number(java.lang.Number number) {
		this.number = number;
		System.out.println("This is a java class....");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Number number = new Number(10);
		Number number2 = new Number(number);
	}
}
