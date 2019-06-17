package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Part;
import org.softuni.cardealer.domain.models.service.PartServiceModel;
import org.softuni.cardealer.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PartServiceTests {

    @Autowired
    private PartRepository partRepository;
    private ModelMapper modelMapper;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
    }

    @Test
    public void partService_savePartWithCorrectValues_ReturnsCorrect() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        PartServiceModel toBeSaved = new PartServiceModel();
        toBeSaved.setName("engine");
        toBeSaved.setPrice(BigDecimal.valueOf(1000));

        PartServiceModel actual = partService.savePart(toBeSaved);
        PartServiceModel expected = this.modelMapper.map(this.partRepository.findAll().get(0), PartServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test(expected = Exception.class)
    public void partService_savePartWithNullValues_ThrowsException() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        PartServiceModel toBeSaved = new PartServiceModel();
        toBeSaved.setName(null);
        toBeSaved.setPrice(BigDecimal.valueOf(1000));

        partService.savePart(toBeSaved);
    }

    @Test
    public void partService_editPartWithCorrectValues_ReturnsCorrect() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        Part part = new Part();
        part.setName("engine");
        part.setPrice(BigDecimal.valueOf(1000));

        part = this.partRepository.saveAndFlush(part);

        PartServiceModel toBeEdited = new PartServiceModel();
        toBeEdited.setId(part.getId());
        toBeEdited.setName("tire");
        toBeEdited.setPrice(BigDecimal.valueOf(500));

        PartServiceModel actual = partService.editPart(toBeEdited);
        PartServiceModel expected = this.modelMapper.map(this.partRepository.findAll().get(0), PartServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test(expected = Exception.class)
    public void partService_editPartWithNullValues_ThrowException() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        Part part = new Part();
        part.setName("engine");
        part.setPrice(BigDecimal.valueOf(1000));

        part = this.partRepository.saveAndFlush(part);

        PartServiceModel toBeEdited = new PartServiceModel();
        toBeEdited.setId(part.getId());
        toBeEdited.setName(null);
        toBeEdited.setPrice(BigDecimal.valueOf(500));

        partService.editPart(toBeEdited);
    }

    @Test
    public void partService_deletePartByIdWithValidId_ReturnsCorrect() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        Part part = new Part();
        part.setName("engine");
        part.setPrice(BigDecimal.valueOf(1000));

        part = this.partRepository.saveAndFlush(part);

        partService.deletePart(part.getId());

        long expectedCount = 0;
        long actualCount = this.partRepository.count();

        Assert.assertEquals(actualCount, expectedCount);
    }

    @Test(expected = Exception.class)
    public void partService_deletePartByIdWithInvalidId_ThrowsException() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        partService.deletePart("invalidId");
    }

    @Test
    public void partService_findPartByIdWithValidId_ReturnsCorrect() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        Part part = new Part();
        part.setName("engine");
        part.setPrice(BigDecimal.valueOf(1000));

        part = this.partRepository.saveAndFlush(part);

        PartServiceModel actual = partService.findPartById(part.getId());
        PartServiceModel expected = this.modelMapper.map(this.partRepository.findAll().get(0), PartServiceModel.class);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test(expected = Exception.class)
    public void partService_findPartByIdWithInvalidId_ThrowsException() {
        PartService partService = new PartServiceImpl(this.partRepository, this.modelMapper);

        partService.findPartById("invalidId");
    }
}
