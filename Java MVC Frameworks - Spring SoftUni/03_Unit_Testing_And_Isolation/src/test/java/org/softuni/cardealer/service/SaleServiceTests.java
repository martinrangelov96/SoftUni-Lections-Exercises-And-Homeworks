package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.models.service.CarSaleServiceModel;
import org.softuni.cardealer.domain.models.service.PartSaleServiceModel;
import org.softuni.cardealer.repository.CarSaleRepository;
import org.softuni.cardealer.repository.PartSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SaleServiceTests {

    @Autowired
    private CarSaleRepository carSaleRepository;
    @Autowired
    private PartSaleRepository partSaleRepository;
    private ModelMapper modelMapper;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
    }

    @Test
    public void saleService_saleCarWithCorrectValues_ReturnsCorrect() {
        SaleService saleService = new SaleServiceImpl(this.carSaleRepository, this.partSaleRepository, this.modelMapper);

        CarSaleServiceModel toBeSaved = new CarSaleServiceModel();
        toBeSaved.setDiscount(13.37);

        CarSaleServiceModel actual = saleService.saleCar(toBeSaved);
        CarSaleServiceModel expected = this.modelMapper.map(this.carSaleRepository.findAll().get(0), CarSaleServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getDiscount(), actual.getDiscount());
    }

    @Test(expected = Exception.class)
    public void saleService_saleCarWithNullValues_ThrowsException() {
        SaleService saleService = new SaleServiceImpl(this.carSaleRepository, this.partSaleRepository, this.modelMapper);

        CarSaleServiceModel toBeSaved = new CarSaleServiceModel();
        toBeSaved.setDiscount(null);

        saleService.saleCar(toBeSaved);
    }

    @Test
    public void saleService_salePartWithCorrectValues_ReturnsCorrect() {
        SaleService saleService = new SaleServiceImpl(this.carSaleRepository, this.partSaleRepository, this.modelMapper);

        PartSaleServiceModel toBeSaved = new PartSaleServiceModel();
        toBeSaved.setQuantity(10);
        toBeSaved.setDiscount(13.37);

        PartSaleServiceModel actual = saleService.salePart(toBeSaved);
        PartSaleServiceModel expected = this.modelMapper.map(this.partSaleRepository.findAll().get(0), PartSaleServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getQuantity(), actual.getQuantity());
        Assert.assertEquals(expected.getDiscount(), actual.getDiscount());
    }

    @Test(expected = Exception.class)
    public void saleService_salePartWithNullValues_ThrowsException() {
        SaleService saleService = new SaleServiceImpl(this.carSaleRepository, this.partSaleRepository, this.modelMapper);

        PartSaleServiceModel toBeSaved = new PartSaleServiceModel();
        toBeSaved.setQuantity(null);
        toBeSaved.setDiscount(13.37);

        saleService.salePart(toBeSaved);
    }

}
