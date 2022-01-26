package com.example.unittestsspring;

import com.example.unittestsspring.model.Employee;
import com.example.unittestsspring.repository.impl.inmemory.InMemoryEmployeeRepository;
import com.example.unittestsspring.repository.impl.jpa.EmployeeJpaRepository;
import com.example.unittestsspring.repository.spi.EmployeeRepository;
import com.example.unittestsspring.service.SalaryService;
import com.example.unittestsspring.util.Calculator;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Slf4j
public class UnitTestsSpringApplication {

  public static void main(String[] args) {
    /*try (var appContext
           = SpringApplication.run(UnitTestsSpringApplication.class, args)) {
      SalaryService salaryService = appContext.getBean(SalaryService.class);
      BigDecimal salaryEmp1 = salaryService.getSalary(1L);
      log.info("salaryEmp1: {}", salaryEmp1);
      BigDecimal salaryEmp2 = salaryService.getSalary(2L);
      log.info("salaryEmp2: {}", salaryEmp2);
      BigDecimal salaryEmp3 = salaryService.getSalary(3L);
      log.info("salaryEmp3: {}", salaryEmp3);
    }*/
    SpringApplication.run(UnitTestsSpringApplication.class, args);
  }

  @Profile("!test")
  @Bean
  ApplicationRunner applicationRunner(EmployeeJpaRepository employeeJpaRepository) {
    return args -> {
      employeeJpaRepository.save(Employee.builder()
        .id(1L)
        .name("Armando")
        .baseSalary(new BigDecimal("2000.0"))
        .optionalBonus(new BigDecimal("120.00"))
        .build());
      employeeJpaRepository.save(Employee.builder()
        .id(2L)
        .name("Julio")
        .baseSalary(new BigDecimal("2000.0"))
        .optionalBonus(new BigDecimal("120.00"))
        .build());
      log.info("Records: {}", employeeJpaRepository.findAll());
    };
  }

  /*@Bean
  Calculator calculator() {
    return new Calculator();
  }

  @Bean
  InMemoryEmployeeRepository employeeRepository() {
    return new InMemoryEmployeeRepository();
  }

  @Bean
  SalaryService salaryService() {
    return new SalaryService(calculator(), employeeRepository());
  }*/

}
