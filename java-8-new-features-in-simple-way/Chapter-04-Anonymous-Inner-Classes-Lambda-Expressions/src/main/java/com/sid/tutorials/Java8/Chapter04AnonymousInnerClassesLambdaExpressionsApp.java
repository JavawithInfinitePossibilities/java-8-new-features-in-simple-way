/**
 * 
 */
package com.sid.tutorials.Java8;

import com.sid.tutorials.Java8.intf.IAnonymousInterface;

/**
 * @author Lenovo
 *
 */
public class Chapter04AnonymousInnerClassesLambdaExpressionsApp {
	public int x = 888;
	public int y = 111;

	public void method2Concrete() {
		IAnonymousInterface iAnonymousInterface = new IAnonymousInterface() {
			int x = 999;

			@Override
			public void method1Abstract() {
				System.out
						.println("Instance variable x : " + Chapter04AnonymousInnerClassesLambdaExpressionsApp.this.x);
				System.out.println("Anonymous Interface local variable x : " + this.x);
			}
		};
		iAnonymousInterface.method1Abstract();
	}

	public void method3ConcreteLambda() {
		int y = 999;
		IAnonymousInterface iAnonymousInterface = () -> {
			int x = 999;
			/**
			 * Lambda expression's local variable y cannot redeclare another local variable defined in an enclosing scope. 
			 */
			/* int y = 222; */
			System.out.println("Lambda local variable x : " + x);
			System.out.println("Instance variable x : " + this.x);
			System.out.println("Method local variable y : " + y);
			System.out.println("Instance local variable y : " + this.y);
			this.x = 1000;
			//y=1100;
			System.out.println("Modified Lambda local variable x : " + this.x);
		};
		iAnonymousInterface.method1Abstract();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Chapter04AnonymousInnerClassesLambdaExpressionsApp par3 = new Chapter04AnonymousInnerClassesLambdaExpressionsApp();
		par3.method2Concrete();
		par3.method3ConcreteLambda();
	}
}
