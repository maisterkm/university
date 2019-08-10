package ua.com.foxminded.university.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.dao.DAO;
import ua.com.foxminded.university.dao.DBConnector;
import ua.com.foxminded.university.domain.Schedule;

public class ScheduleDAO implements DAO<Schedule> {
    public void add(Schedule schedule) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO SCHEDULE (schedule_id, description) VALUES (?, ?)";
        String sql_select = "SELECT * FROM SCHEDULE WHERE schedule_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, schedule.getSchedule_id());

            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("schedule_id") == schedule.getSchedule_id()) {
                    System.out.println("Classroom=" + schedule.getSchedule_id() + " is already in the table SCHEDULE");
                    return;
                }
            }
            statementInsert.setInt(1, schedule.getSchedule_id());
            statementInsert.setString(2, schedule.getDescription());

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

    public List<Schedule> getAll() throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<Schedule> scheduleList = new ArrayList<Schedule>();
        String sql = "SELECT schedule_id, description FROM SCHEDULE";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setSchedule_id(resultSet.getInt("schedule_id"));
                schedule.setDescription(resultSet.getString("description"));

                scheduleList.add(schedule);
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
        return scheduleList;
    }

    public Schedule getById(Integer schedule_id) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT schedule_id, description FROM SCHEDULE WHERE schedule_id=?";
        Schedule schedule = new Schedule();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, schedule_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            schedule.setSchedule_id(resultSet.getInt("schedule_id"));
            schedule.setDescription(resultSet.getString("description"));
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
        return schedule;
    }

    public void update(Schedule schedule) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql_update = "UPDATE SCHEDULE SET description=? WHERE schedule_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setString(1, schedule.getDescription());
            preparedStatement.setInt(2, schedule.getSchedule_id());
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

    public void remove(Schedule schedule) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM SCHEDULE WHERE schedule_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, schedule.getSchedule_id());
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