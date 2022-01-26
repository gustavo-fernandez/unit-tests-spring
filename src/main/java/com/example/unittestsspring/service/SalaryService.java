package com.example.unittestsspring.service;

import com.example.unittestsspring.model.Employee;
import com.example.unittestsspring.repository.spi.EmployeeRepository;
import com.example.unittestsspring.util.Calculator;
import com.example.unittestsspring.util.LetrasUtil;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalaryService {

  private final Calculator calculator;
  private final EmployeeRepository employeeRepository;

  /*
    Si el nombre del employee empieza en A, B o C retornar salario base + bono, sino retornar solo salario base
   */
  public BigDecimal getSalary(Long employeeId) {
    Employee employee = employeeRepository.findById(employeeId)
      .orElseThrow(() -> new IllegalStateException("Employee not found"));
    if (List.of(LetrasUtil.getLetras()).contains(employee.getName().substring(0, 1).toUpperCase())) {
      return calculator.calculateInternal(employee.getBaseSalary(), employee.getOptionalBonus());
    }
    return employee.getBaseSalary();
  }

}
