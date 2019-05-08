package cardealer.web.controllers;

import cardealer.domain.dtos.CarImportRootDto;
import cardealer.domain.dtos.CustomerImportRootDto;
import cardealer.domain.dtos.PartImportRootDto;
import cardealer.domain.dtos.SupplierImportRootDto;
import cardealer.service.CarService;
import cardealer.service.CustomerService;
import cardealer.service.PartService;
import cardealer.service.SupplierService;
import cardealer.util.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Controller
public class ImportController {

    private final static String SUPPLIERS_XML_FILE_PATH = "D:\\Programming stuff\\IdeaUltimateProjects\\10_XML_Processing\\src\\main\\resources\\files\\suppliers.xml";
    private final static String PARTS_XML_FILE_PATH = "D:\\Programming stuff\\IdeaUltimateProjects\\10_XML_Processing\\src\\main\\resources\\files\\parts.xml";
    private final static String CARS_XML_FILE_PATH = "D:\\Programming stuff\\IdeaUltimateProjects\\10_XML_Processing\\src\\main\\resources\\files\\cars.xml";
    private final static String CUSTOMERS_XML_FILE_PATH = "D:\\Programming stuff\\IdeaUltimateProjects\\10_XML_Processing\\src\\main\\resources\\files\\customers.xml";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final XmlParser xmlParser;

    @Autowired
    public ImportController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, XmlParser xmlParser) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.xmlParser = xmlParser;
    }

    public String importSuppliers() throws JAXBException, FileNotFoundException {
        SupplierImportRootDto supplierImportRootDto = this.xmlParser
                .parseXml(SupplierImportRootDto.class, SUPPLIERS_XML_FILE_PATH);

        this.supplierService.importSuppliers(supplierImportRootDto);

        return "Imported suppliers";
    }

    public String importParts() throws JAXBException, FileNotFoundException {
        PartImportRootDto partImportRootDto = this.xmlParser
                .parseXml(PartImportRootDto.class, PARTS_XML_FILE_PATH);

        this.partService.importParts(partImportRootDto);

        return "Imported parts";
    }

    public String importCars() throws JAXBException, FileNotFoundException {
        CarImportRootDto carImportRootDto = this.xmlParser
                .parseXml(CarImportRootDto.class, CARS_XML_FILE_PATH);

        this.carService.importCars(carImportRootDto);

        return "Imported cars";
    }

    public String importCustomers() throws JAXBException, FileNotFoundException {
        CustomerImportRootDto customerImportRootDto =
                this.xmlParser.parseXml(CustomerImportRootDto.class, CUSTOMERS_XML_FILE_PATH);

        this.customerService.importCustomers(customerImportRootDto);
        return "Imported customers";
    }
}
