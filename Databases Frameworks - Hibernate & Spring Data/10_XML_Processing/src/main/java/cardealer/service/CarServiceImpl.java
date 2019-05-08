package cardealer.service;

import cardealer.domain.dtos.*;
import cardealer.domain.entities.Car;
import cardealer.domain.entities.Part;
import cardealer.repository.CarRepository;
import cardealer.repository.PartRepository;
import cardealer.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importCars(CarImportRootDto carImportRootDto) {
        for (CarImportDto carImportDto : carImportRootDto.getCarImportDtos()) {
            if (!this.validationUtil.isValid(carImportDto)) {
                System.out.println("Something went wrong.");

                continue;
            }

            Car carEntity = this.modelMapper.map(carImportDto, Car.class);
            carEntity.setParts(this.getRandomParts());

            this.carRepository.saveAndFlush(carEntity);
        }
    }

    @Override
    public CarExportRootDto exportCars() {
        List<Car> carEntities = this.carRepository.findAll();

        List<CarExportDto> carExportDtos = new ArrayList<>();

        for (Car carEntity : carEntities) {
            CarExportDto carExportDto = this.modelMapper.map(carEntity, CarExportDto.class);

            List<PartExportDto> partExportDtos = new ArrayList<>();

            for (Part part : carEntity.getParts()) {
                PartExportDto partExportDto =
                        this.modelMapper.map(part, PartExportDto.class);

                partExportDtos.add(partExportDto);
            }

            PartExportRootDto partExportRootDto = new PartExportRootDto();
            partExportRootDto.setPartExportDtos(partExportDtos);
            carExportDto.setPartExportRootDto(partExportRootDto);

            carExportDtos.add(carExportDto);
        }

        CarExportRootDto carExportRootDto = new CarExportRootDto();
        carExportRootDto.setCarExportDtos(carExportDtos);

        return carExportRootDto;
    }

    private List<Part> getRandomParts() {
        List<Part> parts = new ArrayList<>();
        Random random = new Random();

        List<Part> partEntities = this.partRepository.findAll();

        int length = random.nextInt(10) + 10;

        for (int i = 0; i < length; i++) {
            int partIndex = random.nextInt((int) (this.partRepository.count() - 1)) + 1;

            parts.add(partEntities.get(partIndex));
        }

        return parts;
    }
}
