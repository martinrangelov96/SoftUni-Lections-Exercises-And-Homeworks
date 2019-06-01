package regapp.web.mbeans;

import org.modelmapper.ModelMapper;
import regapp.domain.models.service.EmployeeServiceModel;
import regapp.domain.models.view.EmployeeListViewModel;
import regapp.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class EmployeeListBean {

    private List<EmployeeListViewModel> employees;

    private EmployeeService employeeService;
    private BigDecimal totalMoneyNeeded = BigDecimal.ZERO;
    private BigDecimal averageSalary = BigDecimal.ZERO;
    private ModelMapper modelMapper;

    public EmployeeListBean() {
    }

    @Inject
    public EmployeeListBean(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;

        this.employees = this.employeeService
                .findAllEmployees()
                .stream()
                .map(e -> this.modelMapper.map(e, EmployeeListViewModel.class))
                .collect(Collectors.toList());

        this.totalMoneyNeeded = this.employeeService
            .findAllEmployees()
                .stream()
                .map(EmployeeServiceModel::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        this.averageSalary = this.employeeService
                .findAllEmployees()
                .stream()
                .map(EmployeeServiceModel::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divideToIntegralValue(BigDecimal.valueOf(this.employeeService.findAllEmployees().size()));
    }

    public List<EmployeeListViewModel> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeListViewModel> employees) {
        this.employees = employees;
    }

    public BigDecimal getTotalMoneyNeeded() {
        return totalMoneyNeeded;
    }

    public void setTotalMoneyNeeded(BigDecimal totalMoneyNeeded) {
        this.totalMoneyNeeded = totalMoneyNeeded;
    }

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(BigDecimal averageSalary) {
        this.averageSalary = averageSalary;
    }
}
