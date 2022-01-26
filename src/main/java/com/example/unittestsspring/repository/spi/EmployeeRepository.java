package com.example.unittestsspring.repository.spi;

import com.example.unittestsspring.model.Employee;
import java.util.Optional;

public interface EmployeeRepository {

  Optional<Employee> findById(Long employeeId);

}
