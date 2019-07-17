package exercise02_get_villans_names;

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
            this.getVillansNamesAndTheirMinionsCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getVillansNamesAndTheirMinionsCount() throws SQLException {
        String query = "SELECT v.`name`, COUNT(mv.`minion_id`) AS `count_of_minions_for_this_villain` FROM `villains` v JOIN `minions_villains` mv ON mv.`villain_id` = v.`id` GROUP BY mv.`villain_id` HAVING COUNT(mv.`minion_id`) > ? ORDER BY COUNT(mv.`minion_id`) DESC";
        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.setInt(1, 15);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(
                    String.format("%s %d",resultSet.getString("name"), resultSet.getInt("count_of_minions_for_this_villain")));
        }
    }
}
