package com.epam.rd.autocode.assessment.basics.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Vehicle implements Serializable {

  protected long id;
  protected String make;

  protected String model;
  protected String characteristics;
  protected int yearOfProduction;
  protected long odometer;

  protected String color;
  protected String licensePlate;
  protected int numberOfSeats;
  protected BigDecimal price;
  protected char requiredLicense;
  protected BodyType bodyType;

  public Vehicle(){

  }

  public Vehicle(long id, String make, String model, String characteristics, int yearOfProduction, long odometer, String color, String licensePlate, int numberOfSeats, BigDecimal price, char requiredLicense, BodyType bodyType) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.characteristics = characteristics;
    this.yearOfProduction = yearOfProduction;
    this.odometer = odometer;
    this.color = color;
    this.licensePlate = licensePlate;
    this.numberOfSeats = numberOfSeats;
    this.price = price;
    this.requiredLicense = requiredLicense;
    this.bodyType = bodyType;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(String characteristics) {
    this.characteristics = characteristics;
  }

  public int getYearOfProduction() {
    return yearOfProduction;
  }

  public void setYearOfProduction(int yearOfProduction) {
    this.yearOfProduction = yearOfProduction;
  }

  public long getOdometer() {
    return odometer;
  }

  public void setOdometer(long odometer) {
    this.odometer = odometer;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public char getRequiredLicense() {
    return requiredLicense;
  }

  public void setRequiredLicense(char requiredLicense) {
    this.requiredLicense = requiredLicense;
  }

  public BodyType getBodyType() {
    return bodyType;
  }

  public void setBodyType(BodyType bodyType) {
    this.bodyType = bodyType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Vehicle vehicle)) return false;
    return getId() == vehicle.getId() && getYearOfProduction() == vehicle.getYearOfProduction() && getOdometer() == vehicle.getOdometer() && getNumberOfSeats() == vehicle.getNumberOfSeats() && getRequiredLicense() == vehicle.getRequiredLicense() && Objects.equals(getMake(), vehicle.getMake()) && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getCharacteristics(), vehicle.getCharacteristics()) && Objects.equals(getColor(), vehicle.getColor()) && Objects.equals(getLicensePlate(), vehicle.getLicensePlate()) && Objects.equals(getPrice(), vehicle.getPrice()) && getBodyType() == vehicle.getBodyType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getMake(), getModel(), getCharacteristics(), getYearOfProduction(), getOdometer(), getColor(), getLicensePlate(), getNumberOfSeats(), getPrice(), getRequiredLicense(), getBodyType());
  }

  @Override
  public String toString() {
    return "Vehicle{" +
            "id=" + id +
            ", make='" + make + '\'' +
            ", model='" + model + '\'' +
            ", characteristics='" + characteristics + '\'' +
            ", yearOfProduction=" + yearOfProduction +
            ", odometer=" + odometer +
            ", color='" + color + '\'' +
            ", licensePlate='" + licensePlate + '\'' +
            ", numberOfSeats=" + numberOfSeats +
            ", price=" + price +
            ", requiredLicense=" + requiredLicense +
            ", bodyType=" + bodyType +
            '}';
  }
}
