package com.example.unittestsspring.repository.impl.jpa;

import com.example.unittestsspring.model.Employee;
import com.example.unittestsspring.repository.spi.EmployeeRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long>, EmployeeRepository {
}
