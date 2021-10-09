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
public class SoftwareEngineer {
	private String name;
	private int age;
	private boolean isHavingGf;

	/**
	 * @param name
	 * @param age
	 * @param isHavingGf
	 */
	@Builder
	public SoftwareEngineer(String name, int age, boolean isHavingGf) {
		super();
		this.name = name;
		this.age = age;
		this.isHavingGf = isHavingGf;
	}
}
