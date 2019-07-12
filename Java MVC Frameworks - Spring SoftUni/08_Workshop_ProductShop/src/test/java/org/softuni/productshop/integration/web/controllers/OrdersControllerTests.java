package org.softuni.productshop.integration.web.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.softuni.productshop.domain.entities.Order;
import org.softuni.productshop.domain.models.view.OrderViewModel;
import org.softuni.productshop.repository.OrderRepository;
import org.softuni.productshop.web.controllers.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrdersControllerTests {

    @Autowired
    OrderController orderController;

    @Mock
    Principal principal;

    @MockBean
    OrderRepository mockOrderRepository;

    private ArrayList<Order> orders;

    @Before
    public void setupTest() {
        this.orders = new ArrayList<>();

//        when(this.mockOrderRepository.findAllByUser_Username(any()))
//                .thenReturn(orders);
    }

    @Test
    @WithMockUser
    public void customerOrders_whenCustomerHasNoOrders_returnEmpty() {
        this.orders.clear();
        when(principal.getName())
                .thenReturn("");

        ModelAndView modelAndView = new ModelAndView();

        ModelAndView result = this.orderController.customerOrders(principal, modelAndView);

        List<OrderViewModel> viewModels = (List<OrderViewModel>) result.getModel().get("orders");
        assertTrue(viewModels.isEmpty());
    }

    @Test
    @WithMockUser
    public void customerOrders_whenAllOrdersAreForCustomer_returnOrders() {
        this.orders.add(new Order());
        when(principal.getName())
                .thenReturn("");

        ModelAndView modelAndView = new ModelAndView();

        ModelAndView result = this.orderController.customerOrders(principal, modelAndView);

        List<OrderViewModel> viewModels = (List<OrderViewModel>) result.getModel().get("orders");
        assertEquals(this.orders.size(), viewModels.size());
    }

    @Test
    @WithMockUser
    public void customerOrders_whenNotAllOrdersAreForCustomer_returnOrders() {
        this.orders.add(new Order());
        when(principal.getName())
                .thenReturn("");

        ModelAndView modelAndView = new ModelAndView();

        ModelAndView result = this.orderController.customerOrders(principal, modelAndView);

        List<OrderViewModel> viewModels = (List<OrderViewModel>) result.getModel().get("orders");
        assertEquals(this.orders.size(), viewModels.size());
    }

}
