package p03_employee_info.contracts;

import p03_employee_info.Employee;

import java.util.List;

public interface EmployeeInfoProvider {

    List<Employee> getEmployeesByName();

    Iterable<Employee> getEmployeesBySalary();
}
