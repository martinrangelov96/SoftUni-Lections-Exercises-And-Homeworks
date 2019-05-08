package cardealer.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController implements CommandLineRunner {

    private final ImportController importController;
    private final ExportController exportController;

    @Autowired
    protected BaseController(ImportController importController, ExportController exportController) {
        this.importController = importController;
        this.exportController = exportController;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.importController.importSuppliers();
//        this.importController.importParts();
//        this.importController.importCars();
//        this.importController.importCustomers();
        this.exportController.exportCars();

    }
}
