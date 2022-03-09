/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class Division3WorkingWithJavaPrimitiveDataTypesandStringAPIs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 10, y = 12;
		char cha = 's', arh = 's';
		byte b4 = 0b111111;
		short oct = 0123;
		int hd = 0x0078;

		int p;

		boolean value = true;
		if (value) {
			p = 1;
		} else {
			p = 2;
		}
		System.out.println("P :  " + p);

		int q;
		if (true) {
			q = 1;
		}

		System.out.println("Q : " + q);

		int r;
		int testSwitch = 2;
		switch (testSwitch) {
		case 0:
			r = 3;
			break;
		case 1:
		case 2:
		default:
			r = 5;
			break;

		}

		System.out.println("R : " + r);

		byte b = 127;
		char c = 65535;
		short s = 32767;

		int min = Short.MIN_VALUE;
		int max = Short.MAX_VALUE;
		System.out.println("Min value : " + min);
		System.out.println("Max value : " + max);
		min = Short.MIN_VALUE - 1;
		max = Short.MAX_VALUE + 1;
		System.out.println("Min value : " + min);
		System.out.println("Max value : " + max);
	}

}
