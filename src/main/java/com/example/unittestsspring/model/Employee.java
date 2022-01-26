package com.example.unittestsspring.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private BigDecimal baseSalary;
  private BigDecimal optionalBonus;

}
