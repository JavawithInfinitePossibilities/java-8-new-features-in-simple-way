/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class TestDaysOfTheWeek {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Retrieve the list of enum constants from
		// DaysOfTheWeek.values() static method
		for (DaysOfTheWeek day : DaysOfTheWeek.values()) {
			System.out.println(day.ordinal() + " is " + day);
		}

		// Example of using the valueOf() static method
		System.out.println(DaysOfTheWeek.valueOf("WEDNESDAY"));
		
		// We can loop through the list of values..
		for (DaysOfTheWeek day : DaysOfTheWeek.values()) {
		    System.out.println(day.ordinal() + " is " + day);
		    switch (day) {
		        case MONDAY:
		        case TUESDAY:
		            System.out.println("Long road ahead");
		            break;
		        case WEDNESDAY:
		            System.out.println("Hump day");
		            break;
		        case THURSDAY:
		            System.out.println("TGIF - 1");
		            break;
		        case FRIDAY:
		            System.out.println("TGIF");
		            break;
		        case SATURDAY:
		        case sunday:
		            System.out.println("Wonderful Weekend");
		    }
		}
	}

}
