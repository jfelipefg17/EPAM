package com.epam.rd.autocode.assessment.basics.collections;

import java.util.*;
import java.util.stream.Collectors;

import com.epam.rd.autocode.assessment.basics.entity.BodyType;
import com.epam.rd.autocode.assessment.basics.entity.Client;
import com.epam.rd.autocode.assessment.basics.entity.Order;
import com.epam.rd.autocode.assessment.basics.entity.Vehicle;

import java.math.BigDecimal;

public class Agency implements Sort {

	private List<Vehicle> vehicles;
	private List<Order> orders;

	public Agency() {
		this.vehicles = new ArrayList<>();
		this.orders = new ArrayList<>();
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public List<Vehicle> sortByID(List<Vehicle> vehicles) {
		return vehicles.stream()
						.sorted(Comparator.comparingLong(Vehicle::getId))
						.collect(Collectors.toList());
	}

	@Override
	public List<Vehicle> sortByYearOfProduction(List<Vehicle> vehicles) {
		return vehicles.stream()
						.sorted(Comparator.comparingInt(Vehicle::getYearOfProduction))
						.collect(Collectors.toList());
	}

	@Override
	public List<Vehicle> sortByOdometer(List<Vehicle> vehicles) {
		return vehicles.stream()
						.sorted(Comparator.comparingLong(Vehicle::getOdometer))
						.collect(Collectors.toList());
	}

	public Set<String> findMakers() {
		return vehicles.stream()
						.map(Vehicle::getMake)
						.collect(Collectors.toSet());
	}

	public Set<BodyType> findBodytypes() {
		return vehicles.stream()
						.map(Vehicle::getBodyType)
						.collect(Collectors.toSet());
	}

	public Map<String, List<Vehicle>> findVehicleGrouppedByMake() {
		return vehicles.stream()
						.collect(Collectors.groupingBy(Vehicle::getMake));
	}

	public List<Client> findTopClientsByPrices(List<Client> clients, int maxCount) {
		return clients.stream()
						.sorted(Comparator.comparing(client -> orders.stream()
										.filter(order -> order.getClientId() == client.getId())
										.map(Order::getPrice)
										.reduce(BigDecimal.ZERO, BigDecimal::add)))
						.limit(maxCount)
						.collect(Collectors.toList());
	}

	public List<Client> findClientsWithAveragePriceNoLessThan(List<Client> clients, int average) {
		return clients.stream()
						.filter(client -> orders.stream()
										.filter(order -> order.getClientId() == client.getId())
										.mapToDouble(order -> order.getPrice().doubleValue())
										.average()
										.orElse(0.0) >= average)
						.collect(Collectors.toList());
	}

	public List<Vehicle> findMostOrderedVehicles(int maxCount) {
		Map<Long, Long> vehicleOrderCount = orders.stream()
						.collect(Collectors.groupingBy(Order::getVehicleId, Collectors.counting()));

		return vehicleOrderCount.entrySet().stream()
						.sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
						.limit(maxCount)
						.map(entry -> vehicles.stream()
										.filter(vehicle -> vehicle.getId() == entry.getKey())
										.findFirst()
										.orElse(null))
						.filter(Objects::nonNull)
						.collect(Collectors.toList());
	}
}
