package com.example.unittestsspring.controller;

import com.example.unittestsspring.controller.model.SalaryResponse;
import com.example.unittestsspring.service.SalaryService;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class SalaryControllerTest {

  @Test
  public void simpleTestController() {
    // Given
    SalaryService salaryService = Mockito.mock(SalaryService.class);
    Mockito.when(salaryService.getSalary(1L)).thenReturn(new BigDecimal("100.0"));

    SalaryController controller = new SalaryController(salaryService);

    // When
    Mono<SalaryResponse> salary = controller.getSalary(1L);

    // Then
    // 1)
    /*salary.subscribe(salaryResponse -> {
      Assertions.assertTrue(salaryResponse.getSalary().compareTo(new BigDecimal("100")) == 0);
    });*/

    // 2)
    /*SalaryResponse salaryResponse = salary.block();
    Assertions.assertTrue(salaryResponse.getSalary().compareTo(new BigDecimal("100")) == 0);*/

    // 3)
    StepVerifier
      .create(salary)
      .expectNextMatches(salaryResponse -> salaryResponse.getSalary().compareTo(new BigDecimal("100")) == 0)
      .expectComplete();
  }

}
