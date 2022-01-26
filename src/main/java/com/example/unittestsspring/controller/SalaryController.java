package com.example.unittestsspring.controller;

import com.example.unittestsspring.controller.model.SalaryResponse;
import com.example.unittestsspring.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class SalaryController {

  private final SalaryService salaryService;

  @GetMapping("api/employee/{employeeId}/salary")
  public Mono<SalaryResponse> getSalary(@PathVariable Long employeeId) {
    return Mono.just(new SalaryResponse(salaryService.getSalary(employeeId)));
  }

}
