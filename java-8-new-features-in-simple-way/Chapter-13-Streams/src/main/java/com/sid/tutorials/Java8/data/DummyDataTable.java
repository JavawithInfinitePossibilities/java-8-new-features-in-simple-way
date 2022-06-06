/**
 * 
 */
package com.sid.tutorials.Java8.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 *
 */
public class DummyDataTable {

	public static int[] intArrayData() {
		int[] intDataArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		return intDataArray;
	}

	public static String[] stringArrayData() {
		String[] stringDataArray = { "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa",
				"Gujarat", "Haryana", "Himachal", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra",
				"Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu",
				"Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal" };
		return stringDataArray;
	}

	public static Map<String, String> stringMapData() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Andhra Pradesh", "Hyderabad (Proposed Capital Amaravati)");
		map.put("Arunachal Pradesh", "Itanagar");
		map.put("Assam", "Dispur");
		map.put("Bihar", "Patna");
		map.put("Chhattisgarh", "Raipur");
		map.put("Goa", "Panaji");
		map.put("Gujarat", "Gandhinagar");
		map.put("Haryana", "Chandigarh");
		map.put("Himachal Pradesh", "Shimla");
		map.put("Jharkhand", "Ranchi");
		map.put("Karnataka", "Bengaluru (formerly Bangalore)");
		map.put("Kerala", "Thiruvananthapuram");
		map.put("Madhya Pradesh", "Bhopal");
		map.put("Maharashtra", "Mumbai");
		map.put("Manipur", "Imphal");
		map.put("Meghalaya", "Shillong");
		map.put("Mizoram", "Aizawl");
		map.put("Nagaland", "Kohima");
		map.put("Odisha", "Bhubaneswar");
		map.put("Punjab", "Chandigarh");
		map.put("Rajasthan", "Jaipur");
		map.put("Sikkim", "Gangtok");
		map.put("Tamil Nadu", "Chennai");
		map.put("Telangana", "Hyderabad");
		map.put("Tripura", "Agartala");
		map.put("Uttar Pradesh", "Lucknow");
		map.put("Uttarakhand", "Dehradun (Winter)Gairsain (Summer)");
		map.put("West Bengal", "Kolkata");
		return map;
	}

	public static List<SoftwareEngineer> getSoftwareEngineer() {
		SoftwareEngineer[] list = { SoftwareEngineer.builder().name("Durga").age(60).isHavingGf(false).build(),
				SoftwareEngineer.builder().name("Sunil").age(25).isHavingGf(true).build(),
				SoftwareEngineer.builder().name("Sayan").age(26).isHavingGf(true).build(),
				SoftwareEngineer.builder().name("Subbu").age(28).isHavingGf(false).build(),
				SoftwareEngineer.builder().name("Ravi").age(17).isHavingGf(true).build() };
		return Arrays.asList(list);
	}

	public static List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		list.add(Employee.builder().name("Durga").designation("CEO").salary(30000).city("Hyderabad").build());
		list.add(Employee.builder().name("Sunny").designation("Manager").salary(20000).city("Hyderabad").build());
		list.add(Employee.builder().name("Mallika").designation("Manager").salary(20000).city("Bangalore").build());
		list.add(Employee.builder().name("Kareena").designation("Lead").salary(15000).city("Hyderabad").build());
		list.add(Employee.builder().name("Katrina").designation("Lead").salary(15000).city("Bangalore").build());
		list.add(Employee.builder().name("Anushka").designation("Developer").salary(10000).city("Hyderabad").build());
		list.add(Employee.builder().name("Kanushka").designation("Developer").salary(10000).city("Hyderabad").build());
		list.add(Employee.builder().name("Sowmya").designation("Developer").salary(10000).city("Bangalore").build());
		return list;
	}

	public static List<PersonEmployee> getPersonEmployee() {
		List<PersonEmployee> employeeList = new ArrayList<PersonEmployee>();
		employeeList.add(new PersonEmployee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new PersonEmployee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new PersonEmployee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new PersonEmployee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new PersonEmployee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new PersonEmployee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new PersonEmployee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new PersonEmployee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new PersonEmployee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new PersonEmployee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new PersonEmployee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new PersonEmployee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new PersonEmployee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new PersonEmployee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new PersonEmployee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new PersonEmployee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new PersonEmployee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		return employeeList;
	}
}
