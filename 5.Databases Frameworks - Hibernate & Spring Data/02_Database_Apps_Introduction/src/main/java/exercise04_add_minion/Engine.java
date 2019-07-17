package exercise04_add_minion;

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
            addMinion();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void addMinion() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] minionParams = reader.readLine().split("\\s+");
        String[] villainParams = reader.readLine().split("\\s+");

        String minionName = minionParams[1];
        int minionAge = Integer.parseInt(minionParams[2]);
        String townName = minionParams[3];

        String villainName = villainParams[1];

        if (!checkIfEntityExists(townName, "towns")) {
            insertTown(townName);
        }

        if (!checkIfEntityExists(villainName, "villains")) {
            insertVillain(villainName);
        }

        int townId = getEntityId(townName, "towns");

        this.insertMinion(minionName, minionAge, townId);

        System.out.println(String.format("Successfully added %s to be minion of %s", minionName, villainName));

        int minionId = getEntityId(minionName, "minions");
        int villainId = getEntityId(villainName, "villains");

        this.hireMinion(minionId, villainId);
    }

    private boolean checkIfEntityExists(String name, String tableName) throws SQLException {
        String query = "SELECT name FROM " + tableName + " WHERE name = ?";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return true;
        }

        return false;
    }

    private void insertTown(String townName) throws SQLException {
        String query = "INSERT INTO towns(name, country) VALUES (?, NULL)";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.setString(1, townName);
        preparedStatement.execute();

        System.out.println(String.format("Town %s was added to the database.", townName));
    }

    private void insertVillain(String villainName) throws SQLException {
        String query = "INSERT INTO villains(name, evilness_factor) VALUES(?, 'evil')";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.setString(1, villainName);
        preparedStatement.execute();

        System.out.println(String.format("Villain %s was added to the database.", villainName));

    }

    private int getEntityId(String name, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = '%s'", tableName, name);

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        return resultSet.getInt(1);

    }

    private void insertMinion(String minionName, int age, int townId) throws SQLException {
        String query = "INSERT INTO minions(name, age, town_id) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.setString(1, minionName);
        preparedStatement.setInt(2, age);
        preparedStatement.setInt(3, townId);

        preparedStatement.execute();
    }

    private void hireMinion(int minionId, int villainId) throws SQLException {
        String query = String.format("INSERT INTO minions_villains VALUES(%d, %d)", minionId, villainId);

        PreparedStatement preparedStatement =
                this.connection.prepareStatement(query);

        preparedStatement.execute();
    }
}
