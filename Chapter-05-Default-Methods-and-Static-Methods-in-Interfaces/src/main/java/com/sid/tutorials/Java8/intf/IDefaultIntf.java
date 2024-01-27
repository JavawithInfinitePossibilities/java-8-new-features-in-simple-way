/**
 * 
 */
package com.sid.tutorials.Java8.intf;

/**
 * @author Lenovo
 *
 */
public interface IDefaultIntf {
	public default void method() {
		System.out.println("This is left interface default method...");
	}

	public static void staticMethod() {
		System.out.println("This is left interface Static method...");
	}

}
