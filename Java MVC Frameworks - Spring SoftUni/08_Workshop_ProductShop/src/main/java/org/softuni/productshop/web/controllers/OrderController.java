package org.softuni.productshop.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.productshop.domain.models.rest.ProductOrderRequestModel;
import org.softuni.productshop.domain.models.service.OrderServiceModel;
import org.softuni.productshop.domain.models.view.OrderViewModel;
import org.softuni.productshop.service.OrderService;
import org.softuni.productshop.service.ProductService;
import org.softuni.productshop.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/orders")
public class OrderController extends BaseController {

    private final ProductService productService;
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderController(ProductService productService, OrderService orderService, ModelMapper modelMapper) {
        this.productService = productService;
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PageTitle("All Orders")
    public ModelAndView allOrders(ModelAndView modelAndView) {
        List<OrderViewModel> orderViewModels = this.orderService.findAllOrders()
                .stream()
                .map(o -> this.modelMapper.map(o, OrderViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("orders", orderViewModels);

        return super.view("/orders/list-orders", modelAndView);
    }

    @GetMapping("/all/details/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PageTitle("Orders Details")
    public ModelAndView allOrderDetails(@PathVariable String id, ModelAndView modelAndView) {
        OrderViewModel orderViewModel = this.modelMapper.map(this.orderService.findOrderById(id), OrderViewModel.class);
        modelAndView.addObject("order", orderViewModel);

        return super.view("/orders/order-details", modelAndView);
    }

    @GetMapping("/customer-orders")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Customer Orders")
    public ModelAndView customerOrders(Principal principal, ModelAndView modelAndView) {
        String username = principal.getName();
        List<OrderViewModel> orderViewModels = this.orderService.findOrdersByCustomer(username)
                .stream()
                .map(o -> this.modelMapper.map(o, OrderViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("orders", orderViewModels);

        return super.view("/orders/list-orders", modelAndView);
    }

    @GetMapping("/customer-orders/details/{id}")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Customer Orders Details")
    public ModelAndView customerOrdersDetails(@PathVariable String id, ModelAndView modelAndView) {
        OrderViewModel orderViewModel = this.modelMapper.map(this.orderService.findOrderById(id), OrderViewModel.class);
        modelAndView.addObject("order", orderViewModel);

        return super.view("/orders/order-details", modelAndView);
    }


    @PostMapping("/submit")
    public ModelAndView submitOrder(@ModelAttribute ProductOrderRequestModel model, Principal principal) throws Exception {
        String name = principal.getName();
//        this.orderService.createOrder(model.getId(), name);

        return super.redirect("/home");
    }

}
