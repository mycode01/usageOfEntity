package com.example.service.dto;

public class ProductInfo {

  private final Long prdId;
  private final String prdName;
  private final Long prdPrice;
  private final Long catId;


  public ProductInfo(Long prdId, String prdName, Long prdPrice, Long catId) {
    this.prdId = prdId;
    this.prdName = prdName;
    this.prdPrice = prdPrice;
    this.catId = catId;
  }

  public Long getPrdId() {
    return prdId;
  }

  public String getPrdName() {
    return prdName;
  }

  public Long getPrdPrice() {
    return prdPrice;
  }

  public Long getCatId() {
    return catId;
  }
}
