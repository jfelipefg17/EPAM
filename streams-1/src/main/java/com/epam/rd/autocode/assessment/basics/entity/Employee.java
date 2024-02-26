package com.epam.rd.autocode.assessment.basics.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Employee extends User implements Serializable {

  protected String phone;
  protected LocalDate dateOfBirth;

  public Employee() {
  }

  public Employee(String phone, LocalDate dateOfBirth) {
    this.phone = phone;
    this.dateOfBirth = dateOfBirth;
  }

  public Employee(Long id, String email, String password, String name, String phone, LocalDate dateOfBirth) {
    super(id, email, password, name);
    this.phone = phone;
    this.dateOfBirth = dateOfBirth;
  }

  public Employee(String name) {
    super(null, null, null, name);
    this.phone = null;
    this.dateOfBirth = null;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Employee employee)) return false;
    if (!super.equals(o)) return false;
    return Objects.equals(getPhone(), employee.getPhone()) && Objects.equals(getDateOfBirth(), employee.getDateOfBirth());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getPhone(), getDateOfBirth());
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            '}';
  }
}
