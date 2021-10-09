/**
 * 
 */
package com.sid.tutorials.Java8;

/**
 * @author Lenovo
 *
 */
public class Chapter12MethodandConstructorReferenceByusingOperatorApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IMethodReference reference = MethodReferClass::methodReference;
		reference.methodReference();
		MethodReferClassInstance methodReferClass = new MethodReferClassInstance();
		IMethodReferenceInstance instReference = methodReferClass::methodRefInstance;
		instReference.methodReference("Siddhant");
		IConstructorRef iConstructorRef = Sample::new;
		System.out.println("***********");
		Sample sample = iConstructorRef.get();
	}
}
