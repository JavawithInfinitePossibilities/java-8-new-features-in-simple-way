/**
 * 
 */
package com.sid.tutorials.Java8;

import com.sid.tutorials.Java8.packagemodifier.PackageAClass;

/**
 * @author Lenovo
 *
 */


public class SuperClass {
	public int publicInt = 10;
	int packageInt = 20;
	protected int protectedInt = 30;
	private int privateInt = 40;

	public static void main(String[] args) {
		new SuperClass().testAccess();
		/* new PackageAClass().testAccess(); */
	}

	void testAccess() {
		System.out.println(this.getClass().getName() + " has access to all of its own attributes:");
		System.out.println("- this.publicInt = " + this.publicInt);
		System.out.println("- this.packageInt = " + this.packageInt);
		System.out.println("- this.protectedInt = " + this.protectedInt);
		System.out.println("- this.privateInt = " + this.privateInt);
	}
}
