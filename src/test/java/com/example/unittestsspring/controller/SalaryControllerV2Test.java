package com.example.unittestsspring.controller;

import com.example.unittestsspring.service.SalaryService;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(properties = {"spring.profiles.active=test"})
public class SalaryControllerV2Test {

  @Autowired
  private WebTestClient webTestClient;

  @MockBean
  private SalaryService salaryService;

  @Test
  public void simpleTestController() {
    Mockito.when(salaryService.getSalary(1L)).thenReturn(new BigDecimal("2000.00"));

    webTestClient.method(HttpMethod.GET)
      .uri("http://localhost:8080/api/employee/{employeeId}/salary", 1L)
      .exchange()
      .expectStatus().isOk()
      .expectBody().json("{\"salary\":2000.00}");
  }

}
