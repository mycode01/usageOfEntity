package com.example.entity.strategy;

public class StandardTax implements TaxStrategy{

  private final static double RATE = 10;

  @Override
  public Long doCalculate(long price) {
    return Math.round(price * (1 - RATE / 100));
  }
}
