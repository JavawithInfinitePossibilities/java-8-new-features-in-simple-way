/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
//Person 'Bean'
public class Person {
	// We declare some private attributes
	private String name;
	private StringBuilder address;
	private int age;

	// We have a constructor for easy creation of Person and
	// population of its attributes
	public Person(String name, StringBuilder address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StringBuilder getAddress() {
		return address;
	}

	public void setAddress(StringBuilder address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// Customize toString method
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", address=" + address + ", age=" + age + '}';
	}
}
