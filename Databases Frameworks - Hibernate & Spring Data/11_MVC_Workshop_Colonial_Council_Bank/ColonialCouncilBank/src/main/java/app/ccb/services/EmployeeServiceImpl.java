package app.ccb.services;

import app.ccb.domain.dtos.EmployeeImportDto;
import app.ccb.domain.entities.Branch;
import app.ccb.domain.entities.Client;
import app.ccb.domain.entities.Employee;
import app.ccb.repositories.BranchRepository;
import app.ccb.repositories.EmployeeRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final static String EMPLOYEES_JSON_FILE_PATH = "C:\\Users\\martoraneca\\Downloads\\ColonialCouncilBank-skeleton\\ColonialCouncilBank\\src\\main\\resources\\files\\json\\employees.json";

    private final FileUtil fileUtil;
    private final BranchRepository branchRepository;
    private final EmployeeRepository employeeRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(FileUtil fileUtil, BranchRepository branchRepository, EmployeeRepository employeeRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.fileUtil = fileUtil;
        this.branchRepository = branchRepository;
        this.employeeRepository = employeeRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() != 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {
        String employeesFileContent =
                this.fileUtil.readFile(EMPLOYEES_JSON_FILE_PATH);

        return employeesFileContent;
    }

    @Override
    public String importEmployees(String employees) {
        StringBuilder importResult = new StringBuilder();
        EmployeeImportDto[] employeeImportDtos =
                this.gson.fromJson(employees, EmployeeImportDto[].class);

        for (EmployeeImportDto employeeImportDto : employeeImportDtos) {
            if (!this.validationUtil.isValid(employeeImportDto)) {
                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            Branch branchEntity =
                    this.branchRepository.findByName(employeeImportDto.getBranchName()).orElse(null);

            if (branchEntity == null) {
                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            Employee employeeEntity =
                    this.modelMapper.map(employeeImportDto, Employee.class);

            employeeEntity.setFirstName(employeeImportDto.getFullName().split("\\s+")[0]);
            employeeEntity.setLastName(employeeImportDto.getFullName().split("\\s+")[1]);
            employeeEntity.setStartedOn(LocalDate.parse(employeeImportDto.getStartedOn()));
            employeeEntity.setBranch(branchEntity);

            this.employeeRepository.saveAndFlush(employeeEntity);

            importResult.append(String.format("Successfully imported Employee - %s %s",
                    employeeEntity.getFirstName(), employeeEntity.getLastName()))
                    .append(System.lineSeparator());
        }

        return importResult.toString().trim();
    }

    @Override
    public String exportTopEmployees() {
        List<Employee> employeesEntities =
                this.employeeRepository.extractTopEmployees();

        StringBuilder exportResult = new StringBuilder();
        for (Employee employeesEntity : employeesEntities) {
            exportResult.append("Full Name: ").append(String.format("%s %s", employeesEntity.getFirstName(), employeesEntity.getLastName())).append(System.lineSeparator());
            exportResult.append("Salary: ").append(String.format("%.2f", employeesEntity.getSalary())).append(System.lineSeparator());
            exportResult.append("Started On: ").append(employeesEntity.getStartedOn()).append(System.lineSeparator());
            exportResult.append("Clients: ").append(System.lineSeparator());

            for (Client clientEntity : employeesEntity.getClients()) {
                exportResult.append(String.format(" %s",clientEntity.getFullName())).append(System.lineSeparator());
            }

            exportResult.append(System.lineSeparator());
        }

        return exportResult.toString().trim();
    }
}
