package app;

import app.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {

    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run() {
//        this.containsEmployee();

//        this.employeesWithSalaryOver50000();

//        this.employeesFromDepartment();

//        this.addingNewAddressAndUpdatingEmployee();

//        this.addressesWithEmployeeCount();

//        this.getEmployeeWithProject();

//        this.findLatest10Projects();

//        this.increaseSalaries();

//        this.findEmployeesMaximumSalaries();

//        this.findEmployeesByFirstName();

        this.removeTowns();
    }

    /**
     * 3.Contains Employee
     */
    private void containsEmployee() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        try {
            Employee employee = this.entityManager
                    .createQuery("FROM Employee WHERE concat(first_name, ' ', last_name) = :name", Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();

            System.out.println("Yes");
        } catch (NoResultException nre) {
            System.out.println("No");
        }

        this.entityManager.getTransaction().commit();
    }

    /**
     * 4.	Employees with Salary Over 50 000
     */
    private void employeesWithSalaryOver50000() {
        this.entityManager.getTransaction().begin();

        List<Employee> employees =
                this.entityManager.
                        createQuery("FROM Employee e WHERE e.salary > 50000", Employee.class)
                        .getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }

        this.entityManager.getTransaction().commit();
    }

    /**
     * 5.	Employees from Department
     */

    private void employeesFromDepartment() {
        this.entityManager.getTransaction().begin();

        Query query = this.entityManager
                .createQuery("SELECT e FROM Employee e JOIN e.department d WHERE d.name = 'Research and Development' ORDER BY e.salary ASC, e.id ASC");
        //AND d.name = 'Research and Development'

        List<Employee> employees = query.getResultList();

        for (Employee employee : employees) {
            System.out.println(String.format("%s %s from %s - $%.2f",
                    employee.getFirstName(), employee.getLastName(), employee.getDepartment().getName(), employee.getSalary()));
        }

        this.entityManager.getTransaction().commit();
    }

    /**
     * 6.	Adding a New Address and Updating Employee
     */

    private void addingNewAddressAndUpdatingEmployee() {
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");

        Town town = this.entityManager
                .createQuery("FROM Town WHERE name = 'Sofia'", Town.class)
                .getSingleResult();
        address.setTown(town);

        this.entityManager.persist(address);

        Employee employee = this.entityManager
                .createQuery("FROM Employee WHERE last_name = :name", Employee.class)
                .setParameter("name", lastName)
                .getSingleResult();

        this.entityManager.detach(employee.getAddress());
        employee.setAddress(address);
        this.entityManager.merge(employee);

        this.entityManager.getTransaction().commit();
    }

    /**
     * 7.	Addresses with Employee Count
     */

    private void addressesWithEmployeeCount() {
        this.entityManager.getTransaction().begin();

        Query query =
                this.entityManager.createQuery("SELECT a FROM Address a JOIN a.employees e GROUP BY a.text ORDER BY COUNT(e.id) DESC, a.town.id ASC")
                        .setMaxResults(10);

        List<Address> addresses = query.getResultList();

        for (Address address : addresses) {
            System.out.println(address.getText() + ", " + address.getTown().getName() + " - " + address.getEmployees().size() + " employees");
        }

        this.entityManager.getTransaction().commit();
    }

    /**
     * 8.	Get Employee with Project
     */

//    private void getEmployeeWithProject() {
//        Scanner scanner = new Scanner(System.in);
//        int employeeId = Integer.parseInt(scanner.nextLine());
//
//        this.entityManager.getTransaction().begin();
//
//        Employee employee = this.entityManager.find(Employee.class, employeeId);
//
//        System.out.println(String.format("%s %s - %s", employee.getFirstName(), employee.getLastName(), employee.getJobTitle()));
//
//        Query query =
//                this.entityManager
//                .createQuery("SELECT p FROM Project p WHERE p.id = :id")
//                .setParameter("id", employee.getId());
//
//        List<Project> projects = query.getResultList();
//
//        for (Project project : projects) {
//            System.out.println(project.getName());
//        }
//
//        this.entityManager.getTransaction().commit();
//    }

    /**
     * 9.	Find Latest 10 Projects
     */

    private void findLatest10Projects() {
        this.entityManager.getTransaction().begin();

        List<Project> projects =
                this.entityManager
                        .createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC, p.name ASC", Project.class)
                        .setMaxResults(10)
                        .getResultList();

        for (Project project : projects) {
            System.out.println(String.format("Project name: %s%n" +
                    "   Project Description: %s%n" +
                    "   Project Start Date: %s%n" +
                    "   Project End Date: %s", project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate()));
        }

        this.entityManager.getTransaction().commit();
    }

    /**
     * 10.	Increase Salaries
     */

    //    private void increaseSalaries() {
//        this.entityManager.getTransaction().begin();
//
//        Query query = this.entityManager
//                .createQuery("UPDATE Employee e SET e.salary = e.salary * 1.12 WHERE e.department.name = 'Engineering'");
//
//        query.executeUpdate();
//
//        this.entityManager.getTransaction().commit();
//
//    }

    /**
     * 11.	Remove Towns
     */

    private void removeTowns() {
        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        Town town = this.entityManager
                .createQuery("SELECT t FROM Town t WHERE t.name = :townName", Town.class)
                .setParameter("townName", townName)
                .getSingleResult();

//        town = this.entityManager.find(Town.class, town.getId());

        this.entityManager.remove(town);

        System.out.println(String.format("town %s deleted", town.getName()));

        this.entityManager.getTransaction().commit();

    }

    /**
     * 12.	Find Employees by First Name
     */

    private void findEmployeesByFirstName() {
        Scanner scanner = new Scanner(System.in);
        String nameStartsWith = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        Query query = this.entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE CONCAT(:fN, '%')")
                .setParameter("fN", nameStartsWith);

        List<Employee> employees = query.getResultList();

        for (Employee employee : employees) {
            System.out.println(String.format("%s %s - %s - ($%.2f)",
                    employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary()));
        }

        this.entityManager.getTransaction().commit();
    }

    /**
     * 13.	Employees Maximum Salaries
     */

//    private void findEmployeesMaximumSalaries() {
//        this.entityManager.getTransaction().begin();
//
//        Query query = this.entityManager
//                .createQuery("SELECT MAX(e.salary) FROM Employee e JOIN e.department d GROUP BY d.name");
//
//        List<Employee> employees = query.getResultList();
//
//        for (Employee employee : employees) {
//            System.out.println(String.format("%s - %s", employee.getDepartment().getName(), String.valueOf(employee.getSalary()))
//
//            );
//        }
//
//        this.entityManager.getTransaction().commit();
//
//    }


}
