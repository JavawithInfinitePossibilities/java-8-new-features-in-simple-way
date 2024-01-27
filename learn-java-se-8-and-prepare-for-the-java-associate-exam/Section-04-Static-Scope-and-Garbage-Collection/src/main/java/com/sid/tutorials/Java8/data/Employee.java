/**
 * 
 */
package com.sid.tutorials.Java8.data;

/**
 * @author Lenovo
 *
 */

public class Employee {
	private String name;
	private String designation;
	private static double salary;
	private String city;

	{
		System.out.println("This is the instance block");
		this.name = "Janha Doe";
	}

	static {
		System.out.println("This is the static block");
		salary = 10000;
	}

	static void printValue() {
		System.out.println("This is static method...");
	}

	void printMyValue() {
		System.out.println("This is instance method...");
	}

	/**
	 * @param name
	 * @param designation
	 * @param salary
	 * @param city
	 */
	public Employee(String name, String designation, double salary, String city) {
		this();
		System.out.println("This is parameterised constracto...");
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
	}

	public Employee() {
		System.out.println("This is a default constractor...");
	}

}
