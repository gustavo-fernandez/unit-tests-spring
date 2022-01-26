package com.example.unittestsspring.repository.impl.jpa;

import com.example.unittestsspring.model.Employee;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;

@DataJpaTest(properties = "spring.profiles.active=test")
public class EmployeeJpaRepositoryTest {

  @Autowired
  private EmployeeJpaRepository employeeJpaRepository;

  @Test
  public void test() {
    var employee = Employee.builder()
      .name("Arturo")
      .baseSalary(BigDecimal.TEN)
      .optionalBonus(BigDecimal.ONE)
      .build();
    Employee savedEmployee = employeeJpaRepository.save(employee);
    Assertions.assertNotNull(savedEmployee.getId());

    Optional<Employee> retrievedEmployee = ((CrudRepository) employeeJpaRepository).findById(savedEmployee.getId());

    Assertions.assertTrue(retrievedEmployee.isPresent());

    Employee employee1 = retrievedEmployee.get();
    Assertions.assertTrue(employee1.getBaseSalary().compareTo(BigDecimal.TEN) == 0);
    Assertions.assertTrue(employee1.getOptionalBonus().compareTo(BigDecimal.ONE) == 0);
    Assertions.assertEquals("Arturo", employee1.getName());

    List<Employee> allEmployees = employeeJpaRepository.findAll();
    Assertions.assertTrue(allEmployees.size() == 1);

    var employee2 = Employee.builder()
      .name("Gerardo")
      .baseSalary(BigDecimal.TEN)
      .optionalBonus(BigDecimal.ONE)
      .build();
    employeeJpaRepository.save(employee2);

    List<Employee> allEmployees2 = employeeJpaRepository.findAll();
    Assertions.assertTrue(allEmployees2.size() == 2);
  }

}
