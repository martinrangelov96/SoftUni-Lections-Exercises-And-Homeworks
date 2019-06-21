package org.softuni.residentevil.web.service;

import org.modelmapper.ModelMapper;
import org.softuni.residentevil.web.domain.entities.Virus;
import org.softuni.residentevil.web.domain.models.service.VirusServiceModel;
import org.softuni.residentevil.web.repository.VirusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VirusServiceImpl implements VirusService {

    private final VirusRepository virusRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public VirusServiceImpl(VirusRepository virusRepository, ModelMapper modelMapper) {
        this.virusRepository = virusRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VirusServiceModel createVirus(VirusServiceModel virusServiceModel) {
        Virus virus = this.modelMapper.map(virusServiceModel, Virus.class);

        if (virus == null) {
            return null;
        }

        return this.modelMapper.map(this.virusRepository.saveAndFlush(virus), VirusServiceModel.class);
    }

    @Override
    public List<VirusServiceModel> findAllViruses() {
        return this.virusRepository.findAll()
                .stream()
                .map(virus -> this.modelMapper.map(virus, VirusServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public VirusServiceModel editVirus(VirusServiceModel virusServiceModel) {
        Virus virus = this.modelMapper.map(virusServiceModel, Virus.class);

        if (virus == null) {
            return null;
        }

        return null;
    }

    @Override
    public VirusServiceModel findVirusById(Long id) {
        Virus virus = this.virusRepository.findById(id).orElse(null);

        if (virus == null) {
            return null;
        }

        return this.modelMapper.map(virus, VirusServiceModel.class);
    }

    @Override
    public boolean deleteVirusById(Long id) {
        try{
            this.virusRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
