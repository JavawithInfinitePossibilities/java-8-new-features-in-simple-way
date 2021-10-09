/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.sid.tutorials.Java8.data.DummyDataTable;
import com.sid.tutorials.Java8.data.Employee;

/**
 * @author Lenovo
 *
 */
public class Section039PredefinedFunctionalInterfacesFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Function<String, Integer> fun = (String name) -> {
			return name.length();
		};
		System.out.println(fun.apply("Siddhant"));
		String[] data = DummyDataTable.stringArrayData();
		List<String> woSpace = Arrays.asList(data).stream().map(functionMapper()).collect(Collectors.toList());
		woSpace.stream().forEach(printValue());

		List<Employee> employees = DummyDataTable.getEmployees();
		List<Employee> employeeIncrements = employees.stream().filter((Employee employee) -> {
			return employee.getSalary() <= 15000 && employee.getCity().equals("Bangalore");
		}).map((Employee employee) -> {
			employee.setSalary(20000);
			return employee;
		}).collect(Collectors.toList());
		employeeIncrements.stream().forEach((Employee employee) -> {
			System.out.println(employee);
		});
	}

	private static Consumer<String> printValue() {
		return (String stateNameWOSpace) -> {
			System.out.println(stateNameWOSpace);
		};
	}

	private static Function<String, String> functionMapper() {
		Function<String, String> mapper = (String stateName) -> {
			stateName = stateName.replace(" ", "");
			return stateName;
		};
		return mapper;
	}

}
