/**
 * 
 */
package com.sid.tutorials.Java8;

import com.sid.tutorials.Java8.intf.IDefault2Intf;
import com.sid.tutorials.Java8.intf.IDefaultIntf;

/**
 * @author Lenovo
 *
 */
public class Chapter05DefaultMethodsandStaticMethodsinInterfacesApp implements IDefaultIntf/* , IDefault2Intf */ {

	private static void staticMethod() {
		System.out.println("This is a private static method...");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IDefaultIntf abstractClasses = new Chapter05DefaultMethodsandStaticMethodsinInterfacesApp();
		abstractClasses.method();
		IDefaultIntf.staticMethod();
		IDefault2Intf.staticMethod();
		Chapter05DefaultMethodsandStaticMethodsinInterfacesApp.staticMethod();
	}

	@Override
	public void method() {
		System.out.println("This is my implementation");
		//IDefault2Intf.super.method();
	}

}
