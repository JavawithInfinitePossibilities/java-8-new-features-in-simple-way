/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.sid.tutorials.Java8.intf.IAdd2number;
import com.sid.tutorials.Java8.intf.IGetStringLength;
import com.sid.tutorials.Java8.intf.ISquare;
import com.sid.tutorials.Java8.intf.Interf;

/**
 * @author Lenovo
 *
 */
public class Chapter02LambdaExpressionsFunctionalInterfacesApp {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Interf interf = () -> {
			System.out.println("This is an functional interface..");
		};
		interf.method1();
		IGetStringLength length = (String S) -> {
			return S.length();
		};
		int stringLength = length.getStringLength("Sidhanth");
		System.out.println("String Length : " + stringLength);
		IAdd2number iAdd2number = (int a, int b) -> {
			System.out.println("Adding 2 number Num1: " + a + " Num2: " + b + " addition : " + (a + b));
		};
		iAdd2number.add2Numbers(50, 100);
		iAdd2number.add2Numbers(45, 58);

		ISquare iSquare = (x) -> {
			return x * x;
		};
		System.out.println("Square of value x :" + iSquare.getSquareOf(5));

		Callable<Integer> myCallableThread = () -> {
			return 10;
		};
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Integer> submit = executor.submit(myCallableThread);
		System.out.println("My callable thread value : " + submit.get());
		executor.shutdown();
	}

}
