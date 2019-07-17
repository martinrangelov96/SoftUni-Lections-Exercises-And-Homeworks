package org.softuni.productshop.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.productshop.domain.models.service.OrderProductServiceModel;
import org.softuni.productshop.domain.models.service.OrderServiceModel;
import org.softuni.productshop.domain.models.service.ProductServiceModel;
import org.softuni.productshop.domain.models.view.OrderProductViewModel;
import org.softuni.productshop.domain.models.view.ProductDetailsViewModel;
import org.softuni.productshop.domain.models.view.ShoppingCartItem;
import org.softuni.productshop.service.OrderService;
import org.softuni.productshop.service.ProductService;
import org.softuni.productshop.service.UserService;
import org.softuni.productshop.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {

    private final ProductService productService;
    private final UserService userService;
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    @Autowired
    public CartController(ProductService productService, UserService userService, OrderService orderService, ModelMapper modelMapper) {
        this.productService = productService;
        this.userService = userService;
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add-product")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView addToCartConfirm(String id, int quantity, HttpSession session) {
        ProductDetailsViewModel product = this.modelMapper.map(this.productService.findProductById(id), ProductDetailsViewModel.class);

        OrderProductViewModel orderProductViewModel = new OrderProductViewModel();
        orderProductViewModel.setProduct(product);
        if (product.getDiscountedPrice() != null) {
            orderProductViewModel.setPrice(product.getDiscountedPrice());
        } else {
            orderProductViewModel.setPrice(product.getPrice());
        }

        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProduct(orderProductViewModel);
        shoppingCartItem.setQuantity(quantity);

        var cart = this.retrieveCart(session);
        this.addItemToCart(shoppingCartItem, cart);

        return super.redirect("/home");
    }

    @GetMapping("/details")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Cart Details")
    public ModelAndView cartDetails(ModelAndView modelAndView, HttpSession session) {
        var cart = this.retrieveCart(session);
        modelAndView.addObject("totalPrice", this.calculateTotalPrice(cart));


        return super.view("/cart/cart-details", modelAndView);
    }

    @DeleteMapping("/remove-product")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView removeFromCartConfirm(String id, HttpSession session) {
        this.removeItemFromCart(id, this.retrieveCart(session));

        return super.redirect("/cart/details");
    }

    @PostMapping("/checkout")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView checkoutConfirm(HttpSession session, Principal principal) {
        var cart = this.retrieveCart(session);

        OrderServiceModel orderServiceModel = this.prepareOrder(cart, principal.getName());
        this.orderService.createOrder(orderServiceModel);
        cart.clear();

        return super.redirect("/home");
    }

    private List<ShoppingCartItem> retrieveCart(HttpSession session) {
        this.initCart(session);

        return (List<ShoppingCartItem>) session.getAttribute("shopping-cart");
    }

    private void initCart(HttpSession session) {
        if (session.getAttribute("shopping-cart") == null) {
            session.setAttribute("shopping-cart", new LinkedList<>());
        }
    }

    private void addItemToCart(ShoppingCartItem item, List<ShoppingCartItem> cart) {
        for (ShoppingCartItem shoppingCartItem : cart) {
            if (shoppingCartItem.getProduct().getProduct().getId().equals(item.getProduct().getProduct().getId())) {
                shoppingCartItem.setQuantity(shoppingCartItem.getQuantity() + item.getQuantity());
                return;
            }
        }

        cart.add(item);
    }

    private void removeItemFromCart(String id, List<ShoppingCartItem> cart) {
        cart.removeIf(ci -> ci.getProduct().getProduct().getId().equals(id));
    }

    private BigDecimal calculateTotalPrice(List<ShoppingCartItem> items) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (ShoppingCartItem item : items) {
            totalPrice = totalPrice.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())));
        }

        return totalPrice;
    }

    private OrderServiceModel prepareOrder(List<ShoppingCartItem> cart, String customer) {
        OrderServiceModel orderServiceModel = new OrderServiceModel();
        orderServiceModel.setCustomer(this.userService.findUserByUsername(customer));

        List<OrderProductServiceModel> products = new ArrayList<>();

        for (ShoppingCartItem item : cart) {
            OrderProductServiceModel productServiceModel =
                    this.modelMapper.map(item.getProduct(), OrderProductServiceModel.class);

            for (int i = 0; i < item.getQuantity(); i++) {
                products.add(productServiceModel);
            }

        }
        orderServiceModel.setProducts(products);
        orderServiceModel.setTotalPrice(this.calculateTotalPrice(cart));

        return orderServiceModel;

    }

}
