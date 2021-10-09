package com.sid.tutorials.Java8;

import java.util.List;
import java.util.function.Predicate;

import com.sid.tutorials.Java8.data.DummyDataTable;
import com.sid.tutorials.Java8.data.Employee;

public class Section035EmployeeManagementApplicationByUsingPredicatePart_1 {
	public static void main(String[] args) {
		List<Employee> employees = DummyDataTable.getEmployees();
		Predicate<Employee> predicate = emp -> emp.getDesignation().equals("Manager");
		employees.stream().filter(predicate).forEach(employee -> System.out.println(employee));
	}
}
