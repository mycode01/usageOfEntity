package com.example.usecase;

import com.example.service.FindProduct;
import com.example.service.dto.ProductInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class InquiryProductPriceUseCaseTest {

  @Mock
  FindProduct somePersistService;
  @InjectMocks
  InquiryProductPriceUseCase inquiryProductPriceUseCase;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testInquiryProductPrice() {
    when(somePersistService.findByProductId(anyLong()))
        .thenReturn(new ProductInfo(null, null, Long.valueOf(1), null));

    Long result = inquiryProductPriceUseCase.inquiryProductPrice(Long.valueOf(1));
    Assertions.assertEquals(Long.valueOf(1), result);
  }

  @Test
  void shouldTaxRated12pWithCategoryId2(){
    when(somePersistService.findByProductId(eq(2L)))
        .thenReturn(new ProductInfo(2l, "카테고리2 - 상품명 뭐뭐", 12000l, 2l));
    Long result = inquiryProductPriceUseCase.inquiryProductPrice(2l);

    long expected = 10560;
    Assertions.assertEquals(expected, result);
  }

  @Test
  void shouldTaxRateDependOnPriceAndPlus10000(){
    when(somePersistService.findByProductId(eq(3L)))
        .thenReturn(new ProductInfo(3l, "비싼 상품 1", 32000l, 99l));
    when(somePersistService.findByProductId(eq(4L)))
        .thenReturn(new ProductInfo(4l, "비싼 상품 2", 45000l, 99l));
    when(somePersistService.findByProductId(eq(5L)))
        .thenReturn(new ProductInfo(5l, "비싼 상품 3", 53000l, 99l));

    Long result = inquiryProductPriceUseCase.inquiryProductPrice(3l);
    Assertions.assertEquals( Math.round(32000 * 0.87) + 10000, result);

    result = inquiryProductPriceUseCase.inquiryProductPrice(4l);
    Assertions.assertEquals(Math.round(45000 * 0.86) + 10000, result);

    result = inquiryProductPriceUseCase.inquiryProductPrice(5l);
    Assertions.assertEquals(Math.round(53000 * 0.85) + 10000, result);
  }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme