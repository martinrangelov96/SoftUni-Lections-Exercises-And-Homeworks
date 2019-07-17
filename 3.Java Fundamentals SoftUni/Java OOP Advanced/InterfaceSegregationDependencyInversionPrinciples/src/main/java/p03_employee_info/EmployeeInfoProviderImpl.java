package p03_employee_info;

import p03_employee_info.contracts.Database;
import p03_employee_info.contracts.EmployeeInfoProvider;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProviderImpl implements EmployeeInfoProvider {

    private Database database;

    public EmployeeInfoProviderImpl(Database database) {
        this.database = database;
    }

    @Override
    public List<Employee> getEmployeesByName() {
        return this.database.readEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Employee> getEmployeesBySalary() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }
}
