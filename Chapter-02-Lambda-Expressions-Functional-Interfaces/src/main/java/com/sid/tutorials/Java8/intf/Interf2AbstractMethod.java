/**
 * 
 */
package com.sid.tutorials.Java8.intf;

/**
 * @author Lenovo
 *
 */
@FunctionalInterface
public interface Interf2AbstractMethod {
	public void method1();

	/**
	 * Invalid '@FunctionalInterface' annotation; 
	 * Interf2AbstractMethod is not a functional interface
	 */
	/* public void method2(); */

	public default void method2Default() {
		System.out.println("This is a default method.");
	}

	public static void method3Static() {
		System.out.println("This is a Static method.");
	}
}
