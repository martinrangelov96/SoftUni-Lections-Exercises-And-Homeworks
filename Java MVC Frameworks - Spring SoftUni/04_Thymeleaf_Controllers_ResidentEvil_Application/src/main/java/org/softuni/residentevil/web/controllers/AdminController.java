package org.softuni.residentevil.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.residentevil.web.domain.models.service.UserServiceModel;
import org.softuni.residentevil.web.domain.models.view.RoleViewModel;
import org.softuni.residentevil.web.domain.models.view.UserViewModel;
import org.softuni.residentevil.web.service.RoleService;
import org.softuni.residentevil.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdminController extends BaseController {

    private final UserService userService;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    @Autowired
    public AdminController(UserService userService, RoleService roleService, ModelMapper modelMapper) {
        this.userService = userService;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView show(Authentication principal, ModelAndView modelAndView) {
        List<UserViewModel> usersViewModel = this.userService.findAllUsers()
                .stream()
                .filter(u -> !u.getUsername().equals(principal.getName()))
                .map(u -> this.modelMapper.map(u, UserViewModel.class)).collect(Collectors.toList());
        modelAndView.addObject("users", usersViewModel);

//        List<RoleViewModel> rolesViewModel = this.roleService.findAllRoles()
//                .stream()
//                .map(r -> this.modelMapper.map(r, RoleViewModel.class))
//                .collect(Collectors.toList());
//        modelAndView.addObject("roles", rolesViewModel);

        return super.view("show-users", modelAndView);
    }

}