package ua.com.foxminded.university.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.dao.CampusDAO;
import ua.com.foxminded.university.dao.DBConnector;
import ua.com.foxminded.university.domain.entity.Campus;

public abstract class CampusService extends DBConnector implements CampusDAO {

    Connection connection = null;

    public void add(Campus campus) throws SQLException {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO CAMPUS (campus) VALUES (?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, campus.getCampus_id());
            preparedStatement.setString(2, campus.getCampus());

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

    public List<Campus> getAll() throws SQLException {
        List<Campus> campusList = new ArrayList<Campus>();

        String sql = "SELECT campus_is, campus FROM CAMPUS";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Campus campus = new Campus();
                campus.setCampus_id(resultSet.getInt("campus_id"));
                campus.setCampus(resultSet.getString("campus"));

                campusList.add(campus);
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
        return campusList;
    }

    public Campus getById(int campus_id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT campus_id, campus FROM CAMPUS WHERE campus_id = ?";

        Campus campus = new Campus();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, campus_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            campus.setCampus_id(resultSet.getInt("campus_id"));
            campus.setCampus(resultSet.getString("campus"));

            preparedStatement.executeUpdate(); /////// ???????
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

        return campus;
    }

    public void update(Campus campus) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE CAMPUS SET campus=? WHERE campus_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, campus.getCampus());

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

    public void remove(Campus campus) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM CAMPUS WHERE campus_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, campus.getCampus_id());

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

}
