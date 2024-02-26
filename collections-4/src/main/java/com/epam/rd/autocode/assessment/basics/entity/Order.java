package com.epam.rd.autocode.assessment.basics.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order implements Serializable {

  protected long id;
  protected long clientId;
  protected long employeeId;
  protected long vehicleId;
  protected LocalDateTime startTime;
  protected LocalDateTime endTime;
  protected BigDecimal price;

  protected Employee employee; // Aggregation relationship with Employee
  protected Client client; // Aggregation relationship with Client
  protected Vehicle vehicle; // Aggregation relationship with Vehicle

  public Order() {
  }

  public Order(long id, long idClient, long idEmployee, long vehicleId, LocalDateTime startTime, LocalDateTime endTime, BigDecimal price) {
    this.id = id;
    this.clientId = idClient;
    this.employeeId = idEmployee;
    this.vehicleId = vehicleId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.price = price;
  }

  public Order(long id, long idClient, long idEmployee, long vehicleId, LocalDateTime startTime, LocalDateTime endTime, BigDecimal price, Employee employee, Client client, Vehicle vehicle) {
    this.id = id;
    this.clientId = idClient;
    this.employeeId = idEmployee;
    this.vehicleId = vehicleId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.price = price;
    this.employee = employee;
    this.client = client;
    this.vehicle = vehicle;
  }
  // Getters and setters for existing attributes...

  public Employee getEmployee() {
    return employee;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getClientId() {
    return clientId;
  }

  public void setClientId(long clientId) {
    this.clientId = clientId;
  }

  public long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(long employeeId) {
    this.employeeId = employeeId;
  }

  public long getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(long vehicleId) {
    this.vehicleId = vehicleId;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }





  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", clientId=" + clientId +
            ", employeeId=" + employeeId +
            ", vehicleId=" + vehicleId +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", price=" + price +
            '}';
  }
}

