/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class TestInheritance extends OuterMost {
	public static void main(String[] args) {
		new TestInheritance().testInnerClassMembers();
	}

	private void testInnerClassMembers() {
		// non-static method - instance of current class exists so inner
		// classes (with the right access modifiers) are available...
		new ProtectedInner();
		// First Level
		new PublicInner();

	}
}
