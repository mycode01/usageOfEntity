package com.example.entity;

import com.example.entity.strategy.Category2Tax;
import com.example.entity.strategy.OverpriceTax;
import com.example.entity.strategy.StandardTax;
import com.example.entity.strategy.TaxStrategy;

public class TaxedProductPrice {
  private final Long price;
  private final Long catId;
  private final TaxStrategy taxStrategy;

  public TaxedProductPrice(Long price, Long catId) {
    this.price = price;
    this.catId = catId;

    this.taxStrategy = considerStrategy();
  }

  private TaxStrategy considerStrategy(){
    if(catId == 2){
      return new Category2Tax();
    } else if(price > 30000) {
      return new OverpriceTax();
    } else {
      return new StandardTax();
    }
  }

  public long deductedPrice(){
    return taxStrategy.doCalculate(price);
  }
}
