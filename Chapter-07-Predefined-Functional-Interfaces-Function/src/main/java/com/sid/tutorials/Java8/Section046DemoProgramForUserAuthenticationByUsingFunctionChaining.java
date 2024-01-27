/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.Scanner;
import java.util.function.Function;

import com.sid.tutorials.Java8.data.User;

/**
 * @author Lenovo
 *
 */
public class Section046DemoProgramForUserAuthenticationByUsingFunctionChaining {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the User name:");
		String userName = scanner.next();
		System.out.println("Enter the password:");
		String password = scanner.next();
		User user = new User(userName, password);
		Function<User, User> authentication = (User userAuthn) -> {
			userAuthn.setUserName(userAuthn.getUserName().toUpperCase());
			return userAuthn;
		};
		Function<User, User> authenticationSubstr = (User userAuthn) -> {
			userAuthn.setUserName(userAuthn.getUserName().substring(0, 5));
			return userAuthn;
		};
		if (authentication.andThen(authenticationSubstr).apply(user).getUserName().equals("SIDDH")) {
			System.out.println("Correct user name");
		}
		/**
		 * In compose the authenticationSubstr function will apply first and <br/>
		 * then authentication will be applied
		 */
		if (authentication.compose(authenticationSubstr).apply(user).getUserName().equals("SIDDH")) {
			System.out.println("Correct user name");
		}

		char myChar = '\u00A9';
		System.out.println(myChar);
	}

}
