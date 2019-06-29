package org.softuni.cardealer.web.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.softuni.cardealer.domain.entities.Car;
import org.softuni.cardealer.domain.entities.Part;
import org.softuni.cardealer.domain.entities.Supplier;
import org.softuni.cardealer.repository.CarRepository;
import org.softuni.cardealer.repository.PartRepository;
import org.softuni.cardealer.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CarsControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Before
    public void emptyDataBase() {
        this.carRepository.deleteAll();
        this.partRepository.deleteAll();
        this.supplierRepository.deleteAll();
    }

    @Test
    @WithMockUser
    public void add_addCarSuccessfully() throws Exception {
        List<Part> parts = this.createParts();

        this.mvc
                .perform(
                        post("/cars/add")
                        .param("make", "Mercedes")
                        .param("model", "Benz")
                        .param("travelledDistance", "1337")
                        .param("parts", "parts")
                );

        Assert.assertEquals(1, this.carRepository.count());
    }

    @Test
    @WithMockUser
    public void edit_editCarMakeAndModelSuccessfully() throws Exception {
        List<Part> parts = this.createParts();

        Car car = new Car();
        car.setMake("Mercedes");
        car.setModel("Benz");
        car.setTravelledDistance(1337L);
        car.setParts(parts);
        car = this.carRepository.saveAndFlush(car);

        this.mvc
                .perform(
                        post("/cars/edit/" +car.getId())
                                .param("make", "Trabant")
                                .param("model", "Trabantski")
                                .param("travelledDistance", "5")
                                .param("parts", "parts")
                );

        Car actualCar = this.carRepository.findById(car.getId()).orElse(null);

        Assert.assertEquals("Trabant", actualCar.getMake());
        Assert.assertEquals("Trabantski", actualCar.getModel());
    }

    @Test
    @WithMockUser
    public void edit_editCarMakeAndModelAndRedirectSuccessfully() throws Exception {
        List<Part> parts = this.createParts();

        Car car = new Car();
        car.setMake("Mercedes");
        car.setModel("Benz");
        car.setTravelledDistance(1337L);
        car.setParts(parts);
        car = this.carRepository.saveAndFlush(car);

        this.mvc
                .perform(
                        post("/cars/edit/" +car.getId())
                                .param("make", "Trabant")
                                .param("model", "Trabantski")
                                .param("travelledDistance", "5")
                                .param("parts", "parts")
                ).andExpect(view().name("redirect:/cars/all"));

        Car actualCar = this.carRepository.findById(car.getId()).orElse(null);

        Assert.assertEquals("Trabant", actualCar.getMake());
        Assert.assertEquals("Trabantski", actualCar.getModel());
    }

    @Test
    @WithMockUser
    public void delete_deleteCarByIdSuccessfully() throws Exception {
        List<Part> parts = this.createParts();

        Car car = new Car();
        car.setMake("Mercedes");
        car.setModel("Benz");
        car.setTravelledDistance(1337L);
        car.setParts(parts);
        car = this.carRepository.saveAndFlush(car);

        this.mvc
                .perform(
                        post("/cars/delete/" + car.getId())
                );

        Assert.assertEquals(0, this.carRepository.count());
    }

    @Test(expected = Exception.class)
    @WithMockUser
    public void delete_deleteCarInvalidId_ThrowsException() throws Exception {
        this.mvc
                .perform(
                        post("/cars/delete/invalidId")
                );
    }

    @Test
    @WithMockUser
    public void all_getCorrectView() throws Exception {
        this.mvc
                .perform(get("/cars/all"))
                .andExpect(view().name("all-cars"));
    }

    @Test
    @WithMockUser
    public void all_getCorrectAttribute() throws Exception {
        this.mvc
                .perform(get("/cars/all"))
                .andExpect(model().attributeExists("cars"));
    }

    private List<Part> createParts() {
        Supplier supplier1 = new Supplier();
        supplier1.setName("pesho");
        supplier1.setIsImporter(true);
        supplier1 = this.supplierRepository.saveAndFlush(supplier1);

        Part part1 = new Part();
        part1.setName("tire");
        part1.setPrice(BigDecimal.valueOf(49.99));
        part1.setSupplier(supplier1);
        part1 = this.partRepository.saveAndFlush(part1);

        Supplier supplier2 = new Supplier();
        supplier2.setName("gosho");
        supplier2.setIsImporter(false);
        supplier2 = this.supplierRepository.saveAndFlush(supplier2);

        Part part2 = new Part();
        part2.setName("engine");
        part2.setPrice(BigDecimal.valueOf(999.99));
        part2.setSupplier(supplier2);
        part2 = this.partRepository.saveAndFlush(part2);

        return this.partRepository.findAll();
    }
}
