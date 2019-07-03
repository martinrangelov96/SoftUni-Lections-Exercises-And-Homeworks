package org.softuni.productshop.service;

import org.softuni.productshop.domain.models.service.ProductServiceModel;

import java.util.List;

public interface ProductService {

    ProductServiceModel addProduct(ProductServiceModel productServiceModel);

    List<ProductServiceModel> findAllProducts();

    ProductServiceModel findProductById(String id);

    ProductServiceModel editProductById(String id, ProductServiceModel productServiceModel);

    ProductServiceModel deleteProductById(String id);

    List<ProductServiceModel> findAllByCategory(String category);

}
