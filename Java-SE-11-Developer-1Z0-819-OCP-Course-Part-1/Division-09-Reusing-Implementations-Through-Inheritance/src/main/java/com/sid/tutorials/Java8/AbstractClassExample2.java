/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class AbstractClassExample2 {
	public static void main(String[] args) {

		// Create an instance of Concrete class with no args constructor
		RealClass c = new RealClass();

		// Execute method on object with the standard text.
		c.printSomething("Hello World");

	}
}

//Abstract Class
abstract class ConceptualClass {

	// protected no args Constructor
	protected ConceptualClass() {

	}

	// abstract method
	public abstract void printSomething(String s1);
}

//Concrete Class
class RealClass extends ConceptualClass {

	// implements abstract method
	public void printSomething(String s1) {
		System.out.println(s1);
	}
}