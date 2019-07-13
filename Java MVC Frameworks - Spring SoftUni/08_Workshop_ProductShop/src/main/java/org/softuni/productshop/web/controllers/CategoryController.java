package org.softuni.productshop.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.productshop.domain.models.binding.CategoryAddBindingModel;
import org.softuni.productshop.domain.models.binding.CategoryEditBindingModel;
import org.softuni.productshop.domain.models.service.CategoryServiceModel;
import org.softuni.productshop.domain.models.view.CategoryViewModel;
import org.softuni.productshop.domain.models.view.CategoryDeleteViewModel;
import org.softuni.productshop.domain.models.view.CategoryEditViewModel;
import org.softuni.productshop.service.CategoryService;
import org.softuni.productshop.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/categories")
public class CategoryController extends BaseController {

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @PageTitle("Add Category")
    public ModelAndView add() {
        return super.view("/categories/add-category");
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView addConfirm(@ModelAttribute CategoryAddBindingModel model) {
        this.categoryService.addCategory(this.modelMapper.map(model, CategoryServiceModel.class));

        return redirect("/categories/all");
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @PageTitle("All Categories")
    public ModelAndView allCategories(ModelAndView modelAndView) {
        List<CategoryViewModel> categories =
                this.categoryService.findAllCategories()
                .stream()
                .map(c -> this.modelMapper.map(c, CategoryViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("categories", categories);

        return super.view("/categories/all-categories", modelAndView);
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @PageTitle("Edit Category")
    public ModelAndView editCategory(@PathVariable String id, ModelAndView modelAndView) {
        modelAndView.addObject("category",
                this.modelMapper.map(this.categoryService.findCategoryById(id), CategoryEditViewModel.class));

        return super.view("/categories/edit-category", modelAndView);
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView editCategoryConfirm(@PathVariable String id, @ModelAttribute CategoryEditBindingModel model) {
        CategoryServiceModel categoryServiceModel = this.modelMapper.map(model, CategoryServiceModel.class);
        this.categoryService.editCategory(id, categoryServiceModel);

        return super.redirect("/categories/all");
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @PageTitle("Delete Category")
    public ModelAndView deleteCategory(@PathVariable String id, ModelAndView modelAndView) {
        modelAndView.addObject("category",
                this.modelMapper.map(this.categoryService.findCategoryById(id), CategoryDeleteViewModel.class));

        return super.view("/categories/delete-category", modelAndView);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView deleteCategoryConfirm(@PathVariable String id) {
        this.categoryService.deleteCategoryById(id);

        return super.redirect("/categories/all");
    }

    @GetMapping("/fetch")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    @ResponseBody
    public List<CategoryViewModel> fetchCategories() {
        return this.categoryService.findAllCategories()
                .stream()
                .map(c -> this.modelMapper.map(c, CategoryViewModel.class))
                .collect(Collectors.toList());
    }
}
