package com.example.unittestsspring.util;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class Calculator {

  public BigDecimal calculateInternal(BigDecimal baseSalary, BigDecimal bonus) {
    return baseSalary.add(bonus.multiply(BigDecimal.TEN));
  }

}
