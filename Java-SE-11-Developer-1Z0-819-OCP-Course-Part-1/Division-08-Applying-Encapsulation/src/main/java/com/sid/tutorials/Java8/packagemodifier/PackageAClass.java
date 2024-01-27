/**
 * 
 */
package com.sid.tutorials.Java8.packagemodifier;

import com.sid.tutorials.Java8.SuperClass;

/**
 * @author Lenovo
 *
 */
public class PackageAClass {
	void testAccess() {
		SuperClass c = new SuperClass();
		System.out.println(
				"A non-subclass class has access to all but " + "private fields of another class in same package");

		System.out.println("- SuperClass().publicInt = " + c.publicInt);

		/*
		 * System.out.println("- SuperClass().packageInt = " + c.packageInt);
		 * 
		 * System.out.println("- SuperClass().protectedInt = " + c.protectedInt);
		 */

	}
}
