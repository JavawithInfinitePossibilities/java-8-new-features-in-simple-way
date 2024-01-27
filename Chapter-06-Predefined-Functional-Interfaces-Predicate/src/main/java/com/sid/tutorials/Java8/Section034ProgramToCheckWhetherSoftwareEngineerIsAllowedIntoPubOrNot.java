package com.sid.tutorials.Java8;

import java.util.List;
import java.util.function.Predicate;

import com.sid.tutorials.Java8.data.DummyDataTable;
import com.sid.tutorials.Java8.data.SoftwareEngineer;

public class Section034ProgramToCheckWhetherSoftwareEngineerIsAllowedIntoPubOrNot {
	public static void main(String[] args) {
		List<SoftwareEngineer> engineers = DummyDataTable.getSoftwareEngineer();
		Predicate<SoftwareEngineer> predicate = sr -> sr.getAge() >= 18 && sr.isHavingGf();
		engineers.stream().filter(predicate).forEach(softwareEngineer -> System.out.println(softwareEngineer));
	}
}
