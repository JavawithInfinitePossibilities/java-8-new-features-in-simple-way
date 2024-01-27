/**
 * 
 */
package com.sid.tutorials.Java8.data;

import lombok.Builder;
import lombok.Data;

/**
 * @author Lenovo
 *
 */
@Data
public class Employee {
	private String name;
	private String designation;
	private double salary;
	private String city;

	/**
	 * @param name
	 * @param designation
	 * @param salary
	 * @param city
	 */
	@Builder
	public Employee(String name, String designation, double salary, String city) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
	}

}
