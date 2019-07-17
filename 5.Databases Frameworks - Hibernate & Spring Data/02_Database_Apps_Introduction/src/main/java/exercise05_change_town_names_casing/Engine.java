package exercise05_change_town_names_casing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Engine implements Runnable {

    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            changeTownNamesCasing();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void changeTownNamesCasing() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String countryName = reader.readLine();

        if (checkIfItExists(countryName)) {
            System.out.println(String.format("%d town names were affected.", this.numberOfTownsAffected(countryName)));
            this.uppercaseTownsNames(countryName);
            this.printChangedNames(countryName);
        } else {
            System.out.println("No town names were affected.");
        }


    }

    private boolean checkIfItExists(String countryName) throws SQLException {
        String query = "SELECT country FROM towns WHERE country = ?";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.setString(1, countryName);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    private int numberOfTownsAffected(String countryName) throws SQLException {
        String query = "SELECT COUNT(?) FROM towns WHERE country = ? GROUP BY country";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.setString(1, countryName);
        preparedStatement.setString(2, countryName);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        return resultSet.getInt(1);

    }

    private void uppercaseTownsNames(String countryName) throws SQLException {
        String query = "UPDATE towns SET name = UPPER(name) WHERE country = ?";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.setString(1, countryName);

        preparedStatement.execute();

    }

    private void printChangedNames(String countryNames) throws SQLException {
        String query = "SELECT name FROM towns WHERE country = ?";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.setString(1, countryNames);

        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.print("[");
        while (resultSet.next()) {
            System.out.print(String.format("%s, ", resultSet.getString(1)));
        }
        System.out.print("]");

    }
}
