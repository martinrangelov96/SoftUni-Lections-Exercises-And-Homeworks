package exercise03_get_minnions_names;

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
            this.getVillainAndHisMinions();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void getVillainAndHisMinions() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int id = Integer.parseInt(reader.readLine());

        String query = "SELECT v.`name`, m.`name`, m.`age` FROM `minions` m JOIN `minions_villains` mv ON mv.`minion_id` = m.`id` JOIN `villains` v ON v.`id` = mv.`villain_id` WHERE mv.`villain_id` = ?";
        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println(String.format("Villain: %s", resultSet.getString("v.name")));
        } else {
            System.out.println(String.format("No villain with ID %d exists in the database.", id));
        }

        resultSet.beforeFirst();
        for (int i = 1; i < query.length() + 1; i++) {
            if (resultSet.next()) {
                System.out.println(i + ". " + resultSet.getString("m.name") + " " + resultSet.getInt("m.age"));
            }
        }
    }
}
