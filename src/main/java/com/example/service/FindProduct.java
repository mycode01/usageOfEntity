package com.example.service;

import com.example.service.dto.ProductInfo;

public interface FindProduct {
  ProductInfo findByProductId(Long prodId);
}
