package exercise09_increase_age_stored_procedure;

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
            this.increaseMinionAgeProcedure();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void increaseMinionAgeProcedure() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int minionId = Integer.valueOf(reader.readLine());

        this.updateAge(minionId);
        this.printMinionsData();

    }

    private void updateAge(int minionId) throws SQLException {
        String query = "CREATE PROCEDURE usp_get_older4(id INT) BEGIN UPDATE minions SET age = age + 1 WHERE id = ?; END";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);
        preparedStatement.setInt(1, minionId);

        String callProcedure = "CALL usp_get_older4(?)";
        PreparedStatement preparedStatementCall =
                this.connection.prepareCall(callProcedure);
        preparedStatementCall.setInt(1, minionId);

        preparedStatement.execute();
        preparedStatementCall.execute();
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
