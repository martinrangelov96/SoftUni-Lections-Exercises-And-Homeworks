package org.softuni.cardealer.web.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.softuni.cardealer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void emptyDataBase() {
        this.customerRepository.deleteAll();
    }

    @Test
    @WithMockUser
    public void add_savesCustomerSuccessfully() throws Exception {
        this.mvc
                .perform(
                        post("/customers/add")
                                .param("name", "peshkin")
                                .param("birthDate", "1996-12-02")
                );

        Assert.assertEquals(1, this.customerRepository.count());
    }

    @Test(expected = Exception.class)
    @WithMockUser
    public void add_wrongDate_ThrowsException() throws Exception {
        this.mvc
                .perform(
                        post("/customers/add")
                                .param("name", "peshkin")
                                .param("birthDate", "01-01-2002")
                );

        Assert.assertEquals(1, this.customerRepository.count());
    }

    @Test
    @WithMockUser
    public void all_returnsCorrectView() throws Exception {
        this.mvc
                .perform(get("/customers/all"))
                .andExpect(view().name("all-customers"));
    }

    @Test
    @WithMockUser
    public void all_returnsCorrectAttribute() throws Exception {
        this.mvc
                .perform(get("/customers/all"))
                .andExpect(model().attributeExists("customers")
                );
    }

}
