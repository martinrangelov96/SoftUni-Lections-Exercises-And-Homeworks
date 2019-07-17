package cardealer.service;

import cardealer.domain.dtos.CarExportRootDto;
import cardealer.domain.dtos.CarImportRootDto;

public interface CarService {

    void importCars(CarImportRootDto carImportRootDto);

    CarExportRootDto exportCars();
}
