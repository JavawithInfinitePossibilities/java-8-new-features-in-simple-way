/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class MyDate {
	public int day;
	public int month;
	public int year;

	// Constructors:
	// 1. Same name as the class
	// 2. No return type
	// The no args constructor
	public MyDate() {
	}

	// Constructor that takes 3 arguments
	public MyDate(int m, int d, int y) {
		setDate(m, d, y);
	}

	// Methods
	public String toString() {
		return month + "/" + day + "/" + year;
	}

	public void setDate(int m, int d, int y) {
		day = d;
		year = y;
		month = m;
	}

	public static void leapYears() {
		for (int i = 1752; i <= 2020; i = i + 4) {
			if ((i % 100 != 0) || (i % 400 == 0))
				System.out.println("The year " + i + " is a leap year");
		}
	}
}
