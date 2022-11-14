/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.sid.tutorials.Java8.data.DummyDataTable;
import com.sid.tutorials.Java8.data.PersonEmployee;

/**
 * @author Lenovo For more reference :
 *         https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
 *         https://javaconceptoftheday.com/java-8-interview-questions-and-answers/
 *         https://javaconceptoftheday.com/java-interview-questions-and-answers/
 *         https://javaconceptoftheday.com/java-threads-interview-questions-and-answers/
 *         https://javaconceptoftheday.com/java-8-optional-class/
 *         https://javaconceptoftheday.com/java-8-merge-two-maps-with-same-keys/
 *         https://javaconceptoftheday.com/java-8-stream-intermediate-and-terminal-operations/
 *
 */
public class Chapter13StreamsApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<PersonEmployee> employees = DummyDataTable.getPersonEmployee();
		/**
		 * How many male and female employees are there in the organization?
		 */
		Map<Object, Long> noOfMaleAndFemaleEmployees = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));
		System.out.println("noOfMaleAndFemaleEmployees : " + noOfMaleAndFemaleEmployees);

		/**
		 * Print the name of all departments in the organization?
		 */
		List<String> departmentNames = employees.stream().map(e -> e.getDepartment()).distinct()
				.collect(Collectors.toList());
		System.out.println("departmentNames : " + departmentNames);

		/**
		 * What is the average age of male and female employees?
		 */
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employees.stream().collect(
				Collectors.groupingBy(PersonEmployee::getGender, Collectors.averagingInt(PersonEmployee::getAge)));
		Map<String, IntSummaryStatistics> avgAgeOfMaleAndFemaleEmployeesAlt = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getGender(), Collectors.summarizingInt(e -> e.getAge())));
		System.out.println("avgAgeOfMaleAndFemaleEmployees : " + avgAgeOfMaleAndFemaleEmployees);
		System.out.println("======================================================================");
		avgAgeOfMaleAndFemaleEmployeesAlt
				.forEach((k, v) -> System.out.println("Detartment name : " + k + " average : " + v.getAverage()));

		/**
		 * Get the details of highest paid employee in the organization?
		 */
		Optional<PersonEmployee> highestPaidEmployeeWrapper = employees.stream()
				.collect(Collectors.maxBy(Comparator.comparing(e -> e.getSalary())));
		PersonEmployee personEmployee = highestPaidEmployeeWrapper.get();
		DoubleSummaryStatistics highestPaidEmployeeWrapperAlt = employees.stream()
				.collect(Collectors.summarizingDouble(e -> e.getSalary()));
		System.out.println("highestPaidEmployeeWrapper : " + personEmployee.getSalary());
		System.out.println("======================================================================");
		System.out.println("highest Paid Employee : " + highestPaidEmployeeWrapperAlt.getMax());

		/**
		 * Get the details of highest paid employee in the Department?
		 */
		Map<String, Optional<PersonEmployee>> highestPaidEmployeeByDepartment = employees.stream()
				.collect(Collectors.groupingBy(PersonEmployee::getDepartment,
						Collectors.maxBy(Comparator.comparing(PersonEmployee::getSalary))));
		highestPaidEmployeeByDepartment
				.forEach((k, v) -> System.out.println("Department : " + k + " highest value : " + v.get().getSalary()));
		System.out.println("======================================================================");
		Map<String, DoubleSummaryStatistics> highestPaidEmployeeByDepartmentAlt = employees.stream().collect(
				Collectors.groupingBy(e -> e.getDepartment(), Collectors.summarizingDouble(e -> e.getSalary())));
		highestPaidEmployeeByDepartmentAlt
				.forEach((k, v) -> System.out.println("Department : " + k + " highest value : " + v.getMax()));

		System.out.println("---------------------------------------------------------------");

		/**
		 * Get the details of minimum paid employee in the Department?
		 */
		Map<String, Optional<PersonEmployee>> minimumPaidEmployeeByDepartment = employees.stream()
				.collect(Collectors.groupingBy(PersonEmployee::getDepartment,
						Collectors.minBy(Comparator.comparing(PersonEmployee::getSalary))));
		minimumPaidEmployeeByDepartment
				.forEach((k, v) -> System.out.println("Department : " + k + "minimum value : " + v.get().getSalary()));
		System.out.println("======================================================================");
		Map<String, DoubleSummaryStatistics> minimumPaidEmployeeByDepartmentAlt = employees.stream().collect(
				Collectors.groupingBy(e -> e.getDepartment(), Collectors.summarizingDouble(e -> e.getSalary())));
		minimumPaidEmployeeByDepartmentAlt
				.forEach((k, v) -> System.out.println("Department : " + k + " minimum value : " + v.getMin()));
		System.out.println("---------------------------------------------------------------");

		/**
		 * Get the details of 2rd highest paid employee in the Department?
		 */
		Map<String, List<PersonEmployee>> listOfEmployees = employees.stream()
				.collect(Collectors.groupingBy(PersonEmployee::getDepartment, Collectors.toList()));
		listOfEmployees.forEach((k, v) -> {
			PersonEmployee limit = v.stream().sorted(Comparator.comparing(PersonEmployee::getSalary).reversed())
					.limit(2).collect(Collectors.toList()).get(1);
			System.out.println("Department : " + k + " 2nd highest value : " + limit.getSalary());
		});

		/**
		 * Get the names of all employees who have joined after 2015?
		 */
		List<String> employeeName = employees.stream().filter(e -> e.getYearOfJoining() > 2015).map(e -> e.getName())
				.collect(Collectors.toList());
		System.out.println("Employee join after 2015 : " + employeeName);

		/**
		 * Count the number of employees in each department?
		 */
		Map<String, Long> employeeCountByDepartment = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));
		System.out.println("employeeCountByDepartment : " + employeeCountByDepartment);
		System.out.println("======================================================================");
		Map<String, DoubleSummaryStatistics> employeeCountByDepartmentAlt = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.summarizingDouble(e -> e.getAge())));
		employeeCountByDepartmentAlt
				.forEach((k, v) -> System.out.println("Department : " + k + " employee Count : " + v.getCount()));

		/**
		 * What is the average salary of each department?
		 */
		Map<String, Double> avgSalaryOfDepartments = employees.stream().collect(Collectors
				.groupingBy(PersonEmployee::getDepartment, Collectors.averagingDouble(PersonEmployee::getSalary)));
		System.out.println("avgSalaryOfDepartments : " + avgSalaryOfDepartments);
		System.out.println("======================================================================");
		Map<String, DoubleSummaryStatistics> avgSalaryOfDepartmentsAlt = employees.stream().collect(
				Collectors.groupingBy(e -> e.getDepartment(), Collectors.summarizingDouble(e -> e.getSalary())));
		avgSalaryOfDepartmentsAlt
				.forEach((k, v) -> System.out.println("Departments : " + k + " avg Salary : " + v.getAverage()));

		/**
		 * Get the details of youngest male employee in the product development
		 * department?
		 */
		PersonEmployee youngestMaleEmployeeInProductDevelopmentWrapper = employees.stream()
				.filter(e -> e.getGender().equals("Male") && e.getDepartment().equalsIgnoreCase("product development"))
				.min(Comparator.comparing(PersonEmployee::getAge)).get();
		System.out.println(
				"youngestMaleEmployeeInProductDevelopmentWrapper : " + youngestMaleEmployeeInProductDevelopmentWrapper);

		/**
		 * Who has the most working experience in the organization?
		 */
		Optional<PersonEmployee> seniorMostEmployeeWrapper = employees.stream()
				.sorted(Comparator.comparing(PersonEmployee::getYearOfJoining)).findFirst();
		System.out.println("seniorMostEmployeeWrapper : " + seniorMostEmployeeWrapper.get());

		/**
		 * How many male and female employees are there in the sales and marketing team?
		 */
		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employees.stream()
				.filter(e -> e.getDepartment().equalsIgnoreCase("Sales And Marketing"))
				.collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));
		System.out.println("countMaleFemaleEmployeesInSalesMarketing : " + countMaleFemaleEmployeesInSalesMarketing);

		/**
		 * What is the average salary of male and female employees?
		 */
		Map<String, Double> avgSalaryOfMaleAndFemaleEmployees = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getGender(), Collectors.averagingDouble(e -> e.getSalary())));
		System.out.println("avgSalaryOfMaleAndFemaleEmployees : " + avgSalaryOfMaleAndFemaleEmployees);

		/**
		 * List down the names of all employees in each department?
		 */
		Map<String, List<PersonEmployee>> employeeListByDepartment = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.toList()));
		System.out.println("employeeListByDepartment : " + employeeListByDepartment);

		/**
		 * What is the average salary and total salary of the whole organization?
		 */
		DoubleSummaryStatistics employeeSalaryStatistics = employees.stream()
				.collect(Collectors.summarizingDouble(e -> e.getSalary()));
		System.out.println("Average Salary = " + employeeSalaryStatistics.getAverage());
		System.out.println("Total Salary = " + employeeSalaryStatistics.getSum());

		/**
		 * Separate the employees who are younger or equal to 25 years from those
		 * employees who are older than 25 years.
		 */
		Map<Boolean, List<PersonEmployee>> partitionEmployeesByAge = employees.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() >= 25));
		System.out.println("partitionEmployeesByAge : " + partitionEmployeesByAge);

		/**
		 * Who is the oldest employee in the organization? <br/>
		 * What is his age and which department he belongs to?
		 */
		List<PersonEmployee> oldestEmployeeWrapper = employees.stream()
				.sorted(Comparator.comparing(PersonEmployee::getAge).reversed()).limit(1).collect(Collectors.toList());
		System.out.println("oldestEmployeeWrapper : " + oldestEmployeeWrapper);
		PersonEmployee employee = employees.stream().max(Comparator.comparing(PersonEmployee::getAge)).get();
		System.out.println("oldestEmployeeWrapper : " + employee);

		/**
		 * How we can iterate from 100 to 0 using IntStream.
		 * 
		 * <pre>
		 * for (int i = 100; i >= 0; i -= 10) {
		 * 	System.out.println(i);
		 * }
		 * OR
		 * for (int i = 100; i >= 0; i = i- 10) {
		 * 	System.out.println(i);
		 * }
		 * </pre>
		 */

		IntStream.iterate(100, i -> i >= 0, i -> i - 10).forEach(i -> System.out.println(i));

		for (int j = 0; j < args.length; j = j + 10) {

		}
	}

}
