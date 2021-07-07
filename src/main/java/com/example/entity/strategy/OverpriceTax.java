package com.example.entity.strategy;

public class OverpriceTax implements TaxStrategy {

  @Override
  public Long doCalculate(long price) {
    final double rate = getRate(price);

    return Math.round(price * (1 - rate / 100)) + 10000;
  }

  private double getRate(long price){
    if(price > 50000){
      return 15;
    } else if(price > 40000){
      return 14;
    } else if(price > 30000){
      return 13;
    } else {
      throw new UnsupportedOperationException();
    }
  }
}
