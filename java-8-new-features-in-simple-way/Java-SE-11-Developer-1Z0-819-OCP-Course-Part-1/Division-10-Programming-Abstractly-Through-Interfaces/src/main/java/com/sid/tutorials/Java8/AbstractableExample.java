/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class AbstractableExample extends AbstractClass {
	public static void main(String[] args) {
		AbstractableExample e = new AbstractableExample();
		e.callConcrete();
	}

	// Method is required through extension of AbstractClass -
	// defined on the interface AbstractClass implements.
	public void makeConcrete() {
		System.out.println("method declared on Abstractable interface");
	}

	// Method required through extension of AbstractClass
	void callConcrete() {
		System.out.println("method declared on AbstractClass class");
		makeConcrete();
	}
}

//Interface with single abstract method
//remember all non-concrete methods are public and abstract
//implicitly on an interface.
interface Abstractable {
	void makeConcrete();
}

//An abstract class does NOT have to define concrete methods
//for the abstract methods the interface it implements
abstract class AbstractClass implements Abstractable {

	// Create an additional abstract method -
	// Note that this method is NOT public, but package-private
	// and you must declare it abstract.
	abstract void callConcrete();
}