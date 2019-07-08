package org.softuni.productshop.service;

import org.softuni.productshop.domain.models.service.OrderServiceModel;

import java.util.List;

public interface OrderService {

    void createOrder(String productId, String name);

    List<OrderServiceModel> findAllOrders();

    List<OrderServiceModel> findOrdersByCustomer(String name);
}
