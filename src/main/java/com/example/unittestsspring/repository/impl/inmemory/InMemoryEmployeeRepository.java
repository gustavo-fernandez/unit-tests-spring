package com.example.unittestsspring.repository.impl.inmemory;

import com.example.unittestsspring.model.Employee;
import com.example.unittestsspring.repository.spi.EmployeeRepository;
import java.math.BigDecimal;
import java.util.Optional;

public class InMemoryEmployeeRepository implements EmployeeRepository {

  public Optional<Employee> findById(Long employeeId) {
    if (employeeId.equals(1L)) {
      return Optional.of(Employee.builder()
        .id(1L)
        .name("Armando")
        .baseSalary(new BigDecimal("2000.0"))
        .optionalBonus(new BigDecimal("120.00"))
        .build());
    }
    if (employeeId.equals(2L)) {
      return Optional.of(Employee.builder()
        .id(2L)
        .name("Benito")
        .baseSalary(new BigDecimal("1000.0"))
        .optionalBonus(new BigDecimal("1000.00"))
        .build());
    }

    if (employeeId.equals(3L)) {
      return Optional.of(Employee.builder()
        .id(3L)
        .name("Juan Diego")
        .baseSalary(new BigDecimal("930.0"))
        .optionalBonus(new BigDecimal("800.00"))
        .build());
    }
    return Optional.empty();
  }
}
