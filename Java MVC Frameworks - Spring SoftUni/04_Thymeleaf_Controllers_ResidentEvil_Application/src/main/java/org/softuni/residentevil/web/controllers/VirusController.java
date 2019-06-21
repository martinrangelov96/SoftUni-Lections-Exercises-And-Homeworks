package org.softuni.residentevil.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.residentevil.web.domain.models.binding.VirusAddBindingModel;
import org.softuni.residentevil.web.domain.models.service.VirusServiceModel;
import org.softuni.residentevil.web.domain.view.CapitalListViewModel;
import org.softuni.residentevil.web.domain.view.VirusListViewModel;
import org.softuni.residentevil.web.service.CapitalService;
import org.softuni.residentevil.web.service.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/viruses")
public class VirusController extends BaseController {

    private final CapitalService capitalService;
    private final VirusService virusService;
    private final ModelMapper modelMapper;

    @Autowired
    public VirusController(CapitalService capitalService, VirusService virusService, ModelMapper modelMapper) {
        this.capitalService = capitalService;
        this.virusService = virusService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView, @ModelAttribute(name = "bindingModel") VirusAddBindingModel bindingModel) {
        modelAndView.addObject("bindingModel", bindingModel);
        modelAndView.addObject("capitals",
                this.capitalService.findAllCapitals().stream().map(c -> this.modelMapper.map(c, CapitalListViewModel.class)).collect(Collectors.toList()));

        return super.view("add-virus", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addConfirm(@Valid @ModelAttribute(name = "bindingModel") VirusAddBindingModel bindingModel, BindingResult bindingResult, ModelAndView modelAndView) {
            if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingModel", bindingModel);
            modelAndView.addObject("capitals",
                    this.capitalService.findAllCapitals().stream().map(c -> this.modelMapper.map(c, CapitalListViewModel.class)).collect(Collectors.toList()));

            return super.view("add-virus", modelAndView);
        }

        VirusServiceModel virusServiceModel = this.virusService.createVirus(this.modelMapper.map(bindingModel, VirusServiceModel.class));

        if (virusServiceModel == null) {
            throw new IllegalArgumentException("Error with creating a virus!");
        }

        return super.redirect("/");
    }

    @GetMapping("/show")
    public ModelAndView show(ModelAndView modelAndView) {
        modelAndView.addObject("viruses",
                this.virusService.findAllViruses().stream().map(v -> this.modelMapper.map(v, VirusListViewModel.class)).collect(Collectors.toList()));

        return super.view("all-viruses", modelAndView);
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editConfirm(@PathVariable("id") Long id, ModelAndView modelAndView) {
        VirusServiceModel virusServiceModel = this.virusService.findVirusById(id);

        if (virusServiceModel == null) {
            throw new IllegalArgumentException("Error while editing a virus");
        }

        modelAndView.setViewName("edit-virus");

        return modelAndView;
    }

}
