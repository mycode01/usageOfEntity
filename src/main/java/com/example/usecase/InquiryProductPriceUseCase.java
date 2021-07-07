package com.example.usecase;

import com.example.entity.TaxedProductPrice;
import com.example.service.FindProduct;
import com.example.service.dto.ProductInfo;

public class InquiryProductPriceUseCase {
  private final FindProduct somePersistService;

  public InquiryProductPriceUseCase(FindProduct findProductInfo) {
    this.somePersistService = findProductInfo;
  }

  public Long inquiryProductPrice(Long prodId){
    final ProductInfo info = somePersistService.findByProductId(prodId);

    final TaxedProductPrice entity = new TaxedProductPrice(info.getPrdPrice(), info.getCatId());

    return entity.deductedPrice();
  }
}
