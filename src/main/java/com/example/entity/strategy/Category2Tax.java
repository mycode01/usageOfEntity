package com.example.entity.strategy;

import java.math.BigDecimal;

public class Category2Tax implements TaxStrategy {
  private final static double RATE = 12;

  @Override
  public Long doCalculate(long price) {

    return Math.round(price * (1 - RATE / 100));
  }
}
