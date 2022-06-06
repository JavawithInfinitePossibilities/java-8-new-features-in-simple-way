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
public class PersonEmployee {
	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	double salary;

	@Builder
	public PersonEmployee(int id, String name, int age, String gender, String department, int yearOfJoining,
			double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}
	

}
