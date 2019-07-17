package exercise08_increase_minion_age;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Engine implements Runnable {

    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            this.increaseMinionAgeAndUpdateName();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void increaseMinionAgeAndUpdateName() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] minionsIds = reader.readLine().split("\\s+");

        this.updateAgeAndName(minionsIds);
        this.printMinionsData();

    }

    private void updateAgeAndName(String[] minionsIds) throws SQLException {
        for (int i = 0; i < minionsIds.length; i++) {
            String queryUpdateAge =
                    String.format("UPDATE minions SET age = age + 1 WHERE id = %d", Integer.parseInt(minionsIds[i]));
            PreparedStatement preparedStatementUpdateAge =
                    this.connection.prepareStatement(queryUpdateAge);

            String queryUpdateName =
                    String.format("UPDATE minions SET name = UPPER(name) WHERE id = %d", Integer.parseInt(minionsIds[i]));
            PreparedStatement preparedStatementUpdateName =
                    this.connection.prepareStatement(queryUpdateName);

            preparedStatementUpdateAge.execute();
            preparedStatementUpdateName.execute();
        }
    }

    private void printMinionsData() throws SQLException {
        String queryPrint = "SELECT name, age FROM minions";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(queryPrint);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(String.format("%s %d", resultSet.getString("name"), resultSet.getInt("age")));
        }
    }


}
