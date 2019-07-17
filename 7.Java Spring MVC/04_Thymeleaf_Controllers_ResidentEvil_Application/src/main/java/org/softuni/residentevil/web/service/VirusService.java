package org.softuni.residentevil.web.service;

import org.softuni.residentevil.web.domain.models.service.VirusServiceModel;

import java.util.List;

public interface VirusService {

    VirusServiceModel createVirus(VirusServiceModel virusServiceModel);

    List<VirusServiceModel> findAllViruses();

    VirusServiceModel editVirus(VirusServiceModel virusServiceModel);

    VirusServiceModel findVirusById(Long id);

    boolean deleteVirusById(Long id);

}
