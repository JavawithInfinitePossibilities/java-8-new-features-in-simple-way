/**
 * 
 */
package com.sid.tutorials.Java8.data;

import lombok.Builder;
import lombok.Data;

/**
 * @author Lenovo
 *
 */
@Data
public class User {
	private String userName;
	private String password;

	@Builder
	public User(String username, String password) {
		this.userName = username;
		this.password = password;
	}
}
