/**
 * 
 */
package com.sid.tutorials.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.sid.tutorials.Java8.data.DummyDataTable;
import com.sid.tutorials.Java8.data.SoftwareEngineer;

/**
 * @author Lenovo
 *
 */
public class Chapter08PredefinedFunctionalInterfacesConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] data = DummyDataTable.stringArrayData();
		Consumer<String> consumer = (String dataValue) -> {
			System.out.println(dataValue);
		};
		consumer.accept("Siddhant");
		Arrays.asList(data).stream().forEach(consumer);
		List<SoftwareEngineer> engineers = DummyDataTable.getSoftwareEngineer();
		engineers.stream().filter((SoftwareEngineer engineer) -> {
			return engineer.getAge() > 25;
		}).map((SoftwareEngineer engineer) -> {
			engineer.setHavingGf(true);
			return engineer;
		}).forEach((SoftwareEngineer engineer) -> {
			System.out.println(engineer);
		});
	}

}
