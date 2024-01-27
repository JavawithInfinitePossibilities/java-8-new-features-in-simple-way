/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.concurrent.TimeUnit;

/**
 * @author Lenovo
 *
 */
public class Section02ParallelAsynchronousprogramming {
	private static String result = "";

	public static void hello() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		result = result.concat("Hello ");
	}

	public static void world() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		result = result.concat("world");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread hello = new Thread(() -> {
			try {
				hello();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread world = new Thread(() -> {
			try {
				world();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		hello.start();
		world.start();

		try {
			hello.join();
			world.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The result is : " + result);
	}
}
