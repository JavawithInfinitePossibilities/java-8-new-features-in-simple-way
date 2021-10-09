package com.sid.tutorials.Java8;

import java.util.Scanner;
import java.util.function.Predicate;

import com.sid.tutorials.Java8.data.User;

public class Section033ProgramForUserAuthenticationByUsingPredicate {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the User name:");
		String userName = scanner.next();
		System.out.println("Enter the password:");
		String password = scanner.next();
		User user = User.builder().password(password).username(userName).build();
		Predicate<User> authentication = userP -> user.getUserName().equals("sid") && user.getPassword().equals("10");
		System.out.println(authentication.test(user));
	}
}
