package org.softuni.productshop.service;

import org.modelmapper.ModelMapper;
import org.softuni.productshop.domain.entities.Order;
import org.softuni.productshop.domain.models.service.OrderServiceModel;
import org.softuni.productshop.repository.OrderRepository;
import org.softuni.productshop.repository.ProductRepository;
import org.softuni.productshop.validation.ProductValidationService;
import org.softuni.productshop.validation.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductRepository productRepository;
    private final UserValidationService userValidationService;
    private final ProductValidationService productValidationService;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            UserService userService,
                            ProductRepository productRepository,
                            UserValidationService userValidationService,
                            ProductValidationService productValidationService, ModelMapper modelMapper
    ) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productRepository = productRepository;
        this.userValidationService = userValidationService;
        this.productValidationService = productValidationService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createOrder(OrderServiceModel orderServiceModel) {
        orderServiceModel.setFinishedOn(LocalDateTime.now());

        this.orderRepository.saveAndFlush(this.modelMapper.map(orderServiceModel, Order.class));
    }

    @Override
    public List<OrderServiceModel> findAllOrders() {
        List<Order> orders = this.orderRepository.findAllByOrderByFinishedOn();
        List<OrderServiceModel> orderServiceModels = orders
                .stream()
                .map(o -> this.modelMapper.map(o, OrderServiceModel.class))
                .collect(Collectors.toList());

        return orderServiceModels;
    }

    @Override
    public List<OrderServiceModel> findOrdersByCustomer(String name) {
        List<OrderServiceModel> orders = this.orderRepository.findAllOrdersByCustomer_UsernameOrderByFinishedOn(name)
                .stream()
                .map(o -> this.modelMapper.map(o, OrderServiceModel.class))
                .collect(Collectors.toList());

        return orders;
    }

    @Override
    public OrderServiceModel findOrderById(String id) {
        OrderServiceModel orderServiceModel = this.orderRepository.findById(id).map(o -> this.modelMapper.map(o, OrderServiceModel.class))
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        return orderServiceModel;
    }

}
