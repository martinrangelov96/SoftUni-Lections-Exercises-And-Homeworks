//package org.softuni.productshop.integration.services;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.softuni.productshop.domain.entities.Order;
//import org.softuni.productshop.domain.entities.Product;
//import org.softuni.productshop.domain.entities.User;
//import org.softuni.productshop.domain.models.service.OrderServiceModel;
//import org.softuni.productshop.domain.models.service.ProductServiceModel;
//import org.softuni.productshop.domain.models.service.UserServiceModel;
//import org.softuni.productshop.repository.OrderRepository;
//import org.softuni.productshop.repository.ProductRepository;
//import org.softuni.productshop.service.OrderService;
//import org.softuni.productshop.service.ProductService;
//import org.softuni.productshop.service.UserService;
//import org.softuni.productshop.validation.ProductValidationService;
//import org.softuni.productshop.validation.UserValidationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class OrderServiceTests {
//
//    @Autowired
//    OrderService orderService;
//
//    @MockBean
//    OrderRepository mockOrderRepository;
//
//    @MockBean
//    UserValidationService mockUserValidation;
//
//    @MockBean
//    ProductValidationService mockProductValidation;
//
//    @MockBean
//    UserService mockUserService;
//
//    @MockBean
//    ProductRepository mockProductRepository;
//
//    private List<Order> orders;
//
//    @Before
//    public void setupTest() {
//        orders = new ArrayList<>();
//        when(this.mockOrderRepository.findAll())
//                .thenReturn(orders);
//    }
//
//    @Test
//    public void findAllOrders_when1Orders_return1Orders() {
////        String customer = "Test customer";
////        String productImageUrl = "http.image.url";
////        String productName = "Test 1";
////        BigDecimal productPrice = BigDecimal.valueOf(1.34);
////
////        Order order = new Order();
////        order.setUser(new User() {{
////            setUsername(customer);
////        }});
////        order.setProduct(new Product() {{
////            setImageUrl(productImageUrl);
////            setName(productName);
////            setPrice(productPrice);
////
////        }});
////        this.orders.add(order);
////
////        var result = orderService.findAllOrders();
////        OrderServiceModel orderResult = result.get(0);
////
////        assertEquals(1, result.size());
////        assertEquals(customer, orderResult.getCustomer());
////        assertEquals(productName, orderResult.getName());
////        assertEquals(productImageUrl, orderResult.getImageUrl());
////        assertEquals(productPrice, orderResult.getPrice());
//    }
//
//    @Test
//    public void findAllOrders_whenNoOrders_returnEmptyOrders() {
//        this.orders.clear();
//        var result = orderService.findAllOrders();
//
//        assertTrue(result.isEmpty());
//    }
//
//    @Test
//    public void createOrder_whenUserAndProductAreValid_orderCreated() throws Exception {
//        when(this.mockUserValidation.isValid(any()))
//                .thenReturn(true);
//        when(this.mockProductValidation.isValid(any(Product.class)))
//                .thenReturn(true);
//
//        when(this.mockUserService.findUserByUsername(any()))
//                .thenReturn(new UserServiceModel());
//
//        when(this.mockProductRepository.findById(any()))
//                .thenReturn(java.util.Optional.of(new Product()));
//
//        this.orderService.createOrder("", "");
//
//        verify(this.mockOrderRepository)
//                .save(any());
//    }
//
//    @Test(expected = Exception.class)
//    public void createOrder_whenUserIsValidAndProductIsNotValid_throw() throws Exception {
//        when(this.mockUserValidation.isValid(any()))
//                .thenReturn(true);
//        when(this.mockProductValidation.isValid(any(Product.class)))
//                .thenReturn(false);
//
//        this.orderService.createOrder("", "");
//    }
//
//    @Test(expected = Exception.class)
//    public void createOrder_whenUserIsNotValidAndProductIsValid_throw() throws Exception {
//        when(this.mockUserValidation.isValid(any()))
//                .thenReturn(false);
//        when(this.mockProductValidation.isValid(any(Product.class)))
//                .thenReturn(true);
//
//        this.orderService.createOrder("", "");
//    }
//
//    @Test(expected = Exception.class)
//    public void createOrder_whenUserAndProductAreNotValid_throw() throws Exception {
//        when(this.mockUserValidation.isValid(any()))
//                .thenReturn(false);
//        when(this.mockProductValidation.isValid(any(Product.class)))
//                .thenReturn(false);
//
//        this.orderService.createOrder("", "");
//    }
//
//}
