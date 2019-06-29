package org.softuni.cardealer.web.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.softuni.cardealer.domain.entities.Part;
import org.softuni.cardealer.domain.entities.Supplier;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PartsControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PartRepository partRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    @Before
    public void emptyDataBase() {
        this.partRepository.deleteAll();
        this.supplierRepository.deleteAll();
    }

    @Test
    @WithMockUser
    public void add_addPartSuccessfully() throws Exception {
        Supplier supplier = new Supplier();
        supplier.setName("supplier");

        supplier = this.supplierRepository.saveAndFlush(supplier);

        this.mvc
                .perform(
                        post("/parts/add")
                                .param("name", "tire")
                                .param("price", "49.99")
                                .param("supplier", "supplier")
                );

        Assert.assertEquals(1, this.partRepository.count());
    }

    @Test
    @WithMockUser
    public void edit_editPartPriceSuccessfully() throws Exception {
        Supplier supplier = new Supplier();
        supplier.setName("pesho");
        supplier.setIsImporter(true);
        supplier = this.supplierRepository.saveAndFlush(supplier);

        Part part = new Part();
        part.setName("tire");
        part.setPrice(BigDecimal.valueOf(49.99));
        part.setSupplier(supplier);
        part = this.partRepository.saveAndFlush(part);

        this.mvc
                .perform(
                        post("/parts/edit/" + part.getId())
                                .param("name", "tire")
                                .param("price", "59.99")
                                .param("supplier", "pesho")
                );

        Part actualPart = this.partRepository.findById(part.getId()).orElse(null);

        Assert.assertEquals("tire", actualPart.getName());
        Assert.assertEquals(BigDecimal.valueOf(59.99), actualPart.getPrice());
        Assert.assertEquals("pesho", actualPart.getSupplier().getName());
    }

    @Test
    @WithMockUser
    public void edit_editPartPriceAndRedirectSuccessfully() throws Exception {
        Supplier supplier = new Supplier();
        supplier.setName("pesho");
        supplier.setIsImporter(true);
        supplier = this.supplierRepository.saveAndFlush(supplier);

        Part part = new Part();
        part.setName("tire");
        part.setPrice(BigDecimal.valueOf(49.99));
        part.setSupplier(supplier);
        part = this.partRepository.saveAndFlush(part);

        this.mvc
                .perform(
                        post("/parts/edit/" + part.getId())
                                .param("name", "tire")
                                .param("price", "59.99")
                                .param("supplier", "pesho")
                ).andExpect(redirectedUrl("/parts/all"));

        Part actualPart = this.partRepository.findById(part.getId()).orElse(null);

        Assert.assertEquals("tire", actualPart.getName());
        Assert.assertEquals(BigDecimal.valueOf(59.99), actualPart.getPrice());
        Assert.assertEquals("pesho", actualPart.getSupplier().getName());
    }

    @Test
    @WithMockUser
    public void delete_deletePartByIdSuccessfully() throws Exception {
        Supplier supplier = new Supplier();
        supplier.setName("pesho");
        supplier.setIsImporter(true);
        supplier = this.supplierRepository.saveAndFlush(supplier);

        Part part = new Part();
        part.setName("tire");
        part.setPrice(BigDecimal.valueOf(49.99));
        part.setSupplier(supplier);
        part = this.partRepository.saveAndFlush(part);

        this.mvc
                .perform(
                        post("/parts/delete/" + part.getId())
                );

        Assert.assertEquals(0, this.partRepository.count());
    }

    @Test
    @WithMockUser
    public void delete_deletePartByIdAndRedirectSuccessfully() throws Exception {
        Supplier supplier = new Supplier();
        supplier.setName("pesho");
        supplier.setIsImporter(true);
        supplier = this.supplierRepository.saveAndFlush(supplier);

        Part part = new Part();
        part.setName("tire");
        part.setPrice(BigDecimal.valueOf(49.99));
        part.setSupplier(supplier);
        part = this.partRepository.saveAndFlush(part);

        this.mvc
                .perform(
                        post("/parts/delete/" + part.getId())
                ).andExpect(redirectedUrl("/parts/all"));

        Assert.assertEquals(0, this.partRepository.count());
    }

    @Test(expected = Exception.class)
    @WithMockUser
    public void delete_deleteWithNonExistentId_ThrowsException() throws Exception {
        this.mvc
                .perform(
                        post("/parts/delete/invalidId")
                );
    }

    @Test
    @WithMockUser
    public void all_returnCorrectView() throws Exception {
        this.mvc
                .perform(get("/parts/all"))
                .andExpect(view().name("all-parts"));
    }

    @Test
    @WithMockUser
    public void all_returnsCorrectAttribute() throws Exception {
        this.mvc
                .perform(get("/parts/all"))
                .andExpect(model().attributeExists("parts"));
    }

    @Test
    @WithMockUser
    public void fetch_worksCorrectly() throws Exception {
        Supplier supplier = new Supplier();
        supplier.setName("pesho");
        supplier.setIsImporter(true);
        supplier = this.supplierRepository.saveAndFlush(supplier);

        Part part = new Part();
        part.setName("tire");
        part.setPrice(BigDecimal.valueOf(49.99));
        part.setSupplier(supplier);
        part = this.partRepository.saveAndFlush(part);

        String result = this.mvc
                .perform(get("/parts/fetch"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Assert.assertEquals("[{\"id\":\"" + part.getId() + "\",\"name\":\"tire\",\"price\":49.99,\"supplier\":{\"id\":\"" + supplier.getId() + "\",\"name\":\"pesho\",\"isImporter\":true}}]", result);
    }

}
