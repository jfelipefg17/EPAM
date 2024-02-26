package com.epam.rd.autocode.assessment.basics.collections;

import java.util.List;

import com.epam.rd.autocode.assessment.basics.entity.Vehicle;

public interface Sort {

	List<Vehicle> sortByID(List<Vehicle> vehicles);

	List<Vehicle> sortByYearOfProduction(List<Vehicle> vehicles);

	List<Vehicle> sortByOdometer(List<Vehicle> vehicles);
}
