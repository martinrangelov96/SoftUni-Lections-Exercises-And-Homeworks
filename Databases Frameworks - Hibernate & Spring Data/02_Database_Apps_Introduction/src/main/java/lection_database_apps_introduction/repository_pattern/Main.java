package lection_database_apps_introduction.repository_pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        String connectionString = "jdbc:mysql://localhost:3306/soft_uni_simple";

        Connection connection =
                DriverManager.getConnection(connectionString, "root", "password");

        DataRepository<Employee> repository =
                new EmployeesDataRepository(connection);

        repository.getAll()
                .stream()
                .map(emp -> emp.getFirstName())
                .forEach(System.out::println);

        System.out.println("-------------------");
        repository.insert(new Employee("Gosho", "Goshov"));

        repository.getAll()
                .stream()
                .map(emp -> emp.getFirstName())
                .forEach(System.out::println);



        connection.close();
    }
}
