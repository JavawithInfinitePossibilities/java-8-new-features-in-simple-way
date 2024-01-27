/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class AmbiguousExamples extends Confused implements Confusable {
	public static void main(String[] args) {
		AmbiguousExamples a = new AmbiguousExamples();
		System.out.println("The method confuse returns: " + a.confuse());
	}

	public String confuse() {
		return Confused.name;
	}
}

//interface Confusable has a constant name and abstract method
interface Confusable {
	String name = "Confusable";

	String confuse();
}

//Abstract class Confused has a constant name and abstract method
abstract class Confused {
	public static String name = "Confused";

	abstract Object confuse();
}