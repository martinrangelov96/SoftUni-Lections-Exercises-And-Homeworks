package org.softuni.residentevil.web.service;

import org.softuni.residentevil.web.domain.models.service.CapitalServiceModel;

import java.util.List;

public interface CapitalService {

    List<CapitalServiceModel> findAllCapitals();
}
