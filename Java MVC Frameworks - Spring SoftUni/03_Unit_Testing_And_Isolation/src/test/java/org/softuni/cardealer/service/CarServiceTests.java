package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Car;
import org.softuni.cardealer.domain.models.service.CarServiceModel;
import org.softuni.cardealer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CarServiceTests {

    @Autowired
    private CarRepository carRepository;
    private ModelMapper modelMapper;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
    }

    @Test
    public void carService_saveCarWithCorrectValues_ReturnsCorrect() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        CarServiceModel toBeSaved = new CarServiceModel();
        toBeSaved.setMake("Mercedes");
        toBeSaved.setModel("Benz");
        toBeSaved.setTravelledDistance(1337L);

        CarServiceModel actual = carService.saveCar(toBeSaved);
        CarServiceModel expected = this.modelMapper.map(this.carRepository.findAll().get(0), CarServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getMake(), actual.getMake());
        Assert.assertEquals(expected.getModel(), actual.getModel());
        Assert.assertEquals(expected.getTravelledDistance(), actual.getTravelledDistance());
    }

    @Test(expected = Exception.class)
    public void carService_saveCarWithNullValues_ThrowException() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        CarServiceModel toBeSaved = new CarServiceModel();
        toBeSaved.setMake(null);
        toBeSaved.setModel("Benz");
        toBeSaved.setTravelledDistance(1337L);

        carService.saveCar(toBeSaved);
    }

    @Test
    public void carService_editCarWithCorrectValues_ReturnsCorrect() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        Car car = new Car();
        car.setMake("Mercedes");
        car.setModel("Benz");
        car.setTravelledDistance(1337L);

        car = this.carRepository.saveAndFlush(car);

        CarServiceModel toBeEdited = new CarServiceModel();
        toBeEdited.setId(car.getId());
        toBeEdited.setMake("Toyota");
        toBeEdited.setModel("Skyline");
        toBeEdited.setTravelledDistance(2674L);

        CarServiceModel actual = carService.editCar(toBeEdited);
        CarServiceModel expected = this.modelMapper.map(this.carRepository.findAll().get(0), CarServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getMake(), actual.getMake());
        Assert.assertEquals(expected.getModel(), actual.getModel());
        Assert.assertEquals(expected.getTravelledDistance(), actual.getTravelledDistance());
    }

    @Test(expected = Exception.class)
    public void carService_editCarWithNullValues_ThrowException() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        Car car = new Car();
        car.setMake("Mercedes");
        car.setModel("Benz");
        car.setTravelledDistance(1337L);

        car = this.carRepository.saveAndFlush(car);

        CarServiceModel toBeEdited = new CarServiceModel();
        toBeEdited.setId(car.getId());
        toBeEdited.setMake(null);
        toBeEdited.setModel("Skyline");
        toBeEdited.setTravelledDistance(2674L);

        carService.editCar(toBeEdited);
    }

    @Test
    public void carService_deleteCarByIdWithValidId_ReturnsCorrect() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        Car car = new Car();
        car.setMake("Mercedes");
        car.setModel("Benz");
        car.setTravelledDistance(1337L);

        car = this.carRepository.saveAndFlush(car);

        carService.deleteCar(car.getId());

        long expectedCount = 0;
        long actualCount = this.carRepository.count();

        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test(expected = Exception.class)
    public void carService_deleteCarByIdWithInvalidId_ThrowsException() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        carService.deleteCar("invalidId");
    }

    @Test
    public void cardService_findCarByIdWithValidId_ReturnsCorrect() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        Car car = new Car();
        car.setMake("Mercedes");
        car.setModel("Benz");
        car.setTravelledDistance(1337L);

        car = this.carRepository.saveAndFlush(car);

        CarServiceModel actual = carService.findCarById(car.getId());
        CarServiceModel expected = this.modelMapper.map(this.carRepository.findAll().get(0), CarServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getMake(), actual.getMake());
        Assert.assertEquals(expected.getModel(), actual.getModel());
        Assert.assertEquals(expected.getTravelledDistance(), actual.getTravelledDistance());
    }

    @Test(expected = Exception.class)
    public void carService_findCarByIdWithInvalidId_ThrowsException() {
        CarService carService = new CarServiceImpl(this.carRepository, this.modelMapper);

        carService.findCarById("invalidId");
    }
}
