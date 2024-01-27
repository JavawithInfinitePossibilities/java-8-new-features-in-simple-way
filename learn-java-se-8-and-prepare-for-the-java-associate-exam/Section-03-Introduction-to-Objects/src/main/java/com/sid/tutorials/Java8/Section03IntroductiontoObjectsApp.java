/**
 * 
 */
package com.sid.tutorials.Java8;

import com.sid.tutorials.Java8.data.Employee;

/**
 * @author Lenovo
 *
 */
public class Section03IntroductiontoObjectsApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee employee = new Employee("Sid", "SA", 1000, "Bangalore");
		System.out.println(employee);
		String string = new String("Hello world   ");
		String substring = string.substring(4, 10);
		System.out.println(substring);
		String trim = string.trim();
		System.out.println(trim);
		String secondVariable = "Hello world   ";
		System.out.println("String is equal(=) secondVariable : " + (string == secondVariable));
		String intern = string.intern();
		System.out.println("String is equal(=) secondVariable by using intern : " + (intern == secondVariable));
		String thirdVariable = string;
		System.out.println("String is equal(=) thirdVariable : " + (string == thirdVariable));
		System.out.println("String is equal() thirdVariable : " + (string.equals(thirdVariable)));
	}

}
