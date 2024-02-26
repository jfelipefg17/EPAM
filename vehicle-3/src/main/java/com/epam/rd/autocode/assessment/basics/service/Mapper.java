package com.epam.rd.autocode.assessment.basics.service;

import com.epam.rd.autocode.assessment.basics.entity.Client;
import com.epam.rd.autocode.assessment.basics.entity.Employee;
import com.epam.rd.autocode.assessment.basics.entity.Order;
import com.epam.rd.autocode.assessment.basics.entity.Vehicle;
import java.math.BigDecimal;
import com.epam.rd.autocode.assessment.basics.entity.BodyType;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Mapper {
    public static Client csvToClient(String[] values) {
        Long id = Long.parseLong(values[0]);
        String email = values[1];
        String password = values[2];
        String name = values[3];
        BigDecimal balance = parseBigDecimal(values[4]);
        String driverLicense = values[5];
        return new Client(id, email, password, name, balance, driverLicense);
    }

    public static Employee csvToEmployee(String[] values) {
        Long id = Long.parseLong(values[0]);
        String email = values[1];
        String password = values[2];
        String name = values[3];
        String phone = values[4];
        LocalDate dateOfBirth = LocalDate.parse(values[5]);
        return new Employee(id, email, password, name, phone, dateOfBirth);
    }

    public String vehicleToCsv(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }

        String[] values = new String[12];
        values[0] = vehicle.getManufacturer();
        values[1] = vehicle.getModel();
        values[2] = String.valueOf(vehicle.getPower());
        values[3] = String.valueOf(vehicle.getManufactureYear());
        values[4] = vehicle.getRegistrationNumber();
        values[5] = String.valueOf(vehicle.getPassengerCapacity());
        values[6] = vehicle.getColor();
        values[7] = vehicle.getVin();
        values[8] = String.valueOf(vehicle.getEngineCapacity());
        values[9] = String.valueOf(vehicle.getWeight());
        values[10] = vehicle.getEngineType().toString();

        // Verificar si getBodyType() retorna un valor nulo
        if (vehicle.getBodyType() != null) {
            values[11] = vehicle.getBodyType().toString();
        } else {
            values[11] = ""; // o algún otro valor predeterminado si lo prefieres
        }

        StringBuilder csvBuilder = new StringBuilder();
        for (String value : values) {
            csvBuilder.append(value).append(",");
        }
        // Eliminar la última coma
        csvBuilder.deleteCharAt(csvBuilder.length() - 1);
        return csvBuilder.toString();
    }

    public static Order csvToOrder(String[] values) {
        Long id = Long.parseLong(values[0]);
        long clientId = Long.parseLong(values[1]);
        long employeeId = Long.parseLong(values[2]);
        long vehicleId = Long.parseLong(values[3]);
        LocalDateTime startTime = LocalDateTime.parse(values[4]);
        LocalDateTime endTime = LocalDateTime.parse(values[5]);
        BigDecimal price = parseBigDecimal(values[6]);
        return new Order(id, clientId, employeeId, vehicleId, startTime, endTime, price);
    }

    public static String[] orderToCsv(Order order) {
        String[] values = new String[7];
        values[0] = String.valueOf(order.getId());
        values[1] = String.valueOf(order.getClientId());
        values[2] = String.valueOf(order.getEmployeeId());
        values[3] = String.valueOf(order.getVehicleId());
        values[4] = order.getStartTime().toString();
        values[5] = order.getEndTime().toString();
        values[6] = order.getPrice().toString();
        return values;
    }

    public static String[] vehicleToCsv(Vehicle vehicle) {
        String[] values = new String[12];
        values[0] = String.valueOf(vehicle.getId());
        values[1] = vehicle.getMake();
        values[2] = vehicle.getModel();
        values[3] = vehicle.getCharacteristics();
        values[4] = String.valueOf(vehicle.getYearOfProduction());
        values[5] = String.valueOf(vehicle.getOdometer());
        values[6] = vehicle.getColor();
        values[7] = vehicle.getLicensePlate();
        values[8] = String.valueOf(vehicle.getNumberOfSeats());
        values[9] = vehicle.getPrice() != null ? vehicle.getPrice().toString() : "";
        values[10] = String.valueOf(vehicle.getRequiredLicense());
        values[11] = vehicle.getBodyType().toString();
        return values;
    }

    public static String[] clientToCsv(Client client) {
        String[] values = new String[5];
        values[0] = String.valueOf(client.getId());
        values[1] = client.getEmail();
        values[2] = client.getPassword();
        values[3] = client.getName();
        values[4] = client.getBalance().toString();
        return values;
    }

    public static String[] employeeToCsv(Employee employee) {
        String[] values = new String[5];
        values[0] = String.valueOf(employee.getId());
        values[1] = employee.getEmail();
        values[2] = employee.getPassword();
        values[3] = employee.getName();
        values[4] = employee.getPhone();
        return values;
    }

    private static BigDecimal parseBigDecimal(String value) {
        return value != null ? new BigDecimal(value) : null;
    }
}
