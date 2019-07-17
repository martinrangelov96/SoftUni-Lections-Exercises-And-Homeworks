package lection_database_apps_introduction.db_introduction;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        String connectionString = "jdbc:mysql://localhost:3306/soft_uni";

        Connection connection =
                DriverManager.getConnection(connectionString, "root", "password");

        PreparedStatement preparedStatement =
                connection.prepareStatement("" +
                        "SELECT CONCAT(first_name, ' ', last_name) AS full_name, salary\n" +
                        "FROM employees\n" +
                        "WHERE salary BETWEEN ? AND ?\n" +
                        "ORDER BY salary");

        preparedStatement.setDouble(1, 30000);
        preparedStatement.setDouble(2, 50000);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("full_name") + " "
                    + resultSet.getDouble("salary"));
        }

        connection.close();
    }
}
