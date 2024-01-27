/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class Section07JavaSyntax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDate date1 = new MyDate(11, 11, 1918);
		MyDate date2 = new MyDate();
		date2.day = 11;
		date2.month = 11;
		date2.year = 1918;
		MyDate date3 = new MyDate();
		date3.setDate(4, 21, 1968);
		String str1 = date1.toString();
		String str2 = date2.toString();
		String str3 = date3.toString();
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		MyDate.leapYears();

		outer_lavel: while (true) {
			int x = 1;
			while (true) {
				if (x % 9 == 0) {
					break outer_lavel;
					/* break; */
				}
				System.out.println("The value is : " + x++);
			}
		}
	}

}
