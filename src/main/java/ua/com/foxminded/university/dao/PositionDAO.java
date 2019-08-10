package ua.com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Position;

public class PositionDAO implements DAO<Position> {
    public void add(Position position) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO POSITIONS (position_id, position) VALUES (?, ?)";
        String sql_select = "SELECT * FROM POSITIONS WHERE position_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, position.getPosition_id());

            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("position_id") == position.getPosition_id()) {
                    System.out
                            .println("position_id=" + position.getPosition_id() + " is already in the table POSITIONS");
                    return;
                }
            }
            statementInsert.setInt(1, position.getPosition_id());
            statementInsert.setString(2, position.getPosition());

            statementInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statementInsert != null) {
                statementInsert.close();
            }
            if (statementSelect != null) {
                statementSelect.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<Position> getAll() throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<Position> positionList = new ArrayList<Position>();
        String sql = "SELECT position_id, position FROM POSITIONS";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Position position = new Position();
                position.setPosition_id(resultSet.getInt("position_id"));
                position.setPosition(resultSet.getString("position"));

                positionList.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return positionList;
    }

    public Position getById(Integer position_id) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT position_id, position FROM POSITIONS WHERE position_id = ?";
        Position position = new Position();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, position_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            position.setPosition_id(resultSet.getInt("position_id"));
            position.setPosition(resultSet.getString("position"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return position;
    }

    public void update(Position position) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql_update = "UPDATE POSITIONS SET position=? WHERE position_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setString(1, position.getPosition());
            preparedStatement.setInt(2, position.getPosition_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void remove(Position position) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM POSITIONS WHERE position_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, position.getPosition_id());
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preStatement != null) {
                preStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
