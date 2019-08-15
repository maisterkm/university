package ua.com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Position;

public class PositionDAO implements Dao<Position> {
    public void create(Position position) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO POSITIONS (position_id, position) VALUES (?, ?)";
        String sql_select = "SELECT * FROM POSITIONS WHERE position_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, position.getPositionId());

            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("position_id") == position.getPositionId()) {
                    System.out
                            .println("position_id=" + position.getPositionId() + " is already in the table POSITIONS");
                    return;
                }
            }
            statementInsert.setInt(1, position.getPositionId());
            statementInsert.setString(2, position.getPosition());

            statementInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statementInsert != null) {
                    statementInsert.close();
                }
                if (statementSelect != null) {
                    statementSelect.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Position> read() {
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
                position.setPositionId(resultSet.getInt("position_id"));
                position.setPosition(resultSet.getString("position"));

                positionList.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return positionList;
    }

    public Position readById(Integer position_id) {
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
            position.setPositionId(resultSet.getInt("position_id"));
            position.setPosition(resultSet.getString("position"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return position;
    }

    public void update(Position position) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql_update = "UPDATE POSITIONS SET position=? WHERE position_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setString(1, position.getPosition());
            preparedStatement.setInt(2, position.getPositionId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Position position) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM POSITIONS WHERE position_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, position.getPositionId());
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preStatement != null) {
                    preStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
