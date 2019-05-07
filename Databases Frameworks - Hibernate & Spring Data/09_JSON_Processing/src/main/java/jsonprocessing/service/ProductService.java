package jsonprocessing.service;

import jsonprocessing.domain.dtos.ProductInRangeDto;
import jsonprocessing.domain.dtos.ProductSeedDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void seedProducts(ProductSeedDto[] productSeedDtos);

    List<ProductInRangeDto> productsInRange(BigDecimal more, BigDecimal less);
}
