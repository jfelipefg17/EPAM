package com.epam.rd.autocode.assessment.basics.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Client extends User implements Serializable {

  protected BigDecimal balance;
  protected String driverLicense;

  public Client(){

  }

  public Client(BigDecimal balance, String driverLicense) {
    this.balance = balance;
    this.driverLicense = driverLicense;
  }

  public Client(Long id, String email, String password, String name, BigDecimal balance, String driverLicense) {
    super(id, email, password, name);
    this.balance = balance;
    this.driverLicense = driverLicense;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public String getDriverLicense() {
    return driverLicense;
  }

  public void setDriverLicense(String driverLicense) {
    this.driverLicense = driverLicense;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Client client)) return false;
    if (!super.equals(o)) return false;
    return Objects.equals(getBalance(), client.getBalance()) && Objects.equals(getDriverLicense(), client.getDriverLicense());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getBalance(), getDriverLicense());
  }

  @Override
  public String toString() {
    return "Client{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", name='" + name + '\'' +
            ", balance=" + balance +
            ", driverLicense='" + driverLicense + '\'' +
            '}';
  }

  // place your code here
}