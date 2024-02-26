package com.epam.rd.autocode.assessment.basics.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.epam.rd.autocode.assessment.basics.entity.BodyType;
import com.epam.rd.autocode.assessment.basics.entity.Client;
import com.epam.rd.autocode.assessment.basics.entity.Order;
import com.epam.rd.autocode.assessment.basics.entity.Vehicle;

public class Agency implements Find, Sort {

	private List<Vehicle> vehicles;
	private List<Order> orders;

	public Agency() {
	}

	public Agency(List<Vehicle> vehicles, List<Order> orders) {
		this.vehicles = vehicles;
		this.orders = orders;
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public List<Vehicle> sortByID() {
		return vehicles.stream()
						.sorted((v1, v2) -> Long.compare(v1.getId(), v2.getId()))
						.collect(Collectors.toList());
	}

	@Override
	public List<Vehicle> sortByYearOfProduction() {
		return vehicles.stream()
						.sorted((v1, v2) -> Integer.compare(v1.getYearOfProduction(), v2.getYearOfProduction()))
						.collect(Collectors.toList());
	}

	@Override
	public List<Vehicle> sortByOdometer() {
		return vehicles.stream()
						.sorted((v1, v2) -> Integer.compare((int) v1.getOdometer(), (int) v2.getOdometer()))
						.collect(Collectors.toList());
	}

	@Override
	public Set<String> findMakers() {
		return vehicles.stream()
						.map(Vehicle::getMake)
						.collect(Collectors.toSet());
	}

	@Override
	public Set<BodyType> findBodytypes() {
		return vehicles.stream()
						.map(Vehicle::getBodyType)
						.collect(Collectors.toSet());
	}

	@Override
	public Map<String, List<Vehicle>> findVehicleGrouppedByMake() {
		return vehicles.stream()
						.collect(Collectors.groupingBy(Vehicle::getMake));
	}

	@Override
	public List<Client> findTopClientsByPrices(List<Client> clients, int maxCount) {
		return clients.stream()
						.sorted((c1, c2) -> Double.compare(calculateTotalOrderAmount(c2), calculateTotalOrderAmount(c1)))
						.limit(maxCount)
						.collect(Collectors.toList());
	}

	private double calculateTotalOrderAmount(Client client) {
		return orders.stream()
						.filter(order -> order.getClient().equals(client))
						.mapToDouble(order -> order.getPrice().doubleValue()) // Cambio aquí
						.sum();
	}


	@Override
	public List<Client> findClientsWithAveragePriceNoLessThan(List<Client> clients, int average) {
		return clients.stream()
						.filter(client -> calculateAverageOrderAmount(client) >= average)
						.collect(Collectors.toList());
	}

	private double calculateAverageOrderAmount(Client client) {
		return orders.stream()
						.filter(order -> order.getClient().equals(client))
						.mapToDouble(order -> order.getPrice().doubleValue()) // Cambio aquí
						.average()
						.orElse(0.0);
	}

	@Override
	public List<Vehicle> findMostOrderedVehicles(int maxCount) {
		return orders.stream()
						.map(Order::getVehicle)
						.collect(Collectors.groupingBy(Vehicle::getId, Collectors.counting()))
						.entrySet().stream()
						.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
						.limit(maxCount)
						.map(Map.Entry::getKey)
						.map(vehicleId -> vehicles.stream().filter(v -> v.getId() == vehicleId).findFirst().orElse(null))
						.filter(vehicle -> vehicle != null)
						.collect(Collectors.toList());
	}
}
