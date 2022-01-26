package com.example.unittestsspring.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.unittestsspring.model.Employee;
import com.example.unittestsspring.repository.impl.inmemory.InMemoryEmployeeRepository;
import com.example.unittestsspring.util.Calculator;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

class SalaryServiceTest {

  // Given / When / Then
  // Arrange / Act / Assert
  @ParameterizedTest
  @CsvSource({"A", "B", "c"})
  @DisplayName("Cuando el nombre empieza en A, entonces retornara la suma del baseSalary + Bonus")
  void test1(String initialLetter) {
    // Given
    var baseSalary = new BigDecimal("200");
    var bonus = new BigDecimal("500");
    var calculoEsperadoDeCalculator = new BigDecimal("1000");

    // spy vs mock -> Mock nace "sin métodos" / spy nace con el mismo comportamento de la clase
    Calculator calculator = Mockito.mock(Calculator.class);
    Mockito.when(calculator.calculateInternal(baseSalary, bonus))
      .thenReturn(calculoEsperadoDeCalculator);

    InMemoryEmployeeRepository employeeRepository = Mockito.mock(InMemoryEmployeeRepository.class);
    Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(Employee.builder()
      .baseSalary(baseSalary)
      .optionalBonus(bonus)
      .name(initialLetter + "OtraParteDelNombreQueNoNosImporta")
      .build()));

    SalaryService salaryService = new SalaryService(calculator, employeeRepository);

    // When
    BigDecimal salary = salaryService.getSalary(1L);

    // Then
    assertTrue(new BigDecimal("1000").compareTo(salary) == 0);
  }

  @ParameterizedTest
  @CsvSource({"D", "0", "Z"})
  @DisplayName("Cuando el nombre no empieza ni en A, ni B, ni C, entonces retornara la solo el baseSalary")
  void test2(String initialLetter) {
    // Given
    var baseSalary = new BigDecimal("200");
    var bonus = new BigDecimal("500");

    Calculator calculator = Mockito.mock(Calculator.class);

    InMemoryEmployeeRepository employeeRepository = Mockito.mock(InMemoryEmployeeRepository.class);
    Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(Employee.builder()
      .baseSalary(baseSalary)
      .optionalBonus(bonus)
      .name(initialLetter + "OtraParteDelNombreQueNoNosImporta")
      .build()));

    SalaryService salaryService = new SalaryService(calculator, employeeRepository);

    // When
    BigDecimal salary = salaryService.getSalary(1L);

    // Then
    assertTrue(baseSalary.compareTo(salary) == 0);
  }

}
