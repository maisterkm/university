package ua.com.foxminded.university.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.dao.DBConnector;
import ua.com.foxminded.university.dao.MonthlyScheduleDAO;
import ua.com.foxminded.university.domain.MonthlySchedule;

public class MonthlyScheduleService implements MonthlyScheduleDAO {
    public void add(MonthlySchedule monthlySchedule) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO MONTHLYSCHEDULE (monthlyschedule_id, schedule_id, description) VALUES (?, ?, ?)";
        String sql_select = "SELECT * FROM MONTHLYSCHEDULE WHERE monthlyschedule_id=? AND schedule_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, monthlySchedule.getMonthlySchedule_id());
            statementSelect.setInt(2, monthlySchedule.getSchedule_id());

            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("monthlyschedule_id") == monthlySchedule.getMonthlySchedule_id()
                        && resultSet.getInt("schedule_id") == monthlySchedule.getSchedule_id()) {
                    System.out.println(
                            "monthlySchedule_id=" + monthlySchedule.getMonthlySchedule_id() + ", " + "schedule_id="
                                    + monthlySchedule.getSchedule_id() + " is already in the table MONTHLYSCHEDULE");
                    return;
                }
            }
            statementInsert.setInt(1, monthlySchedule.getMonthlySchedule_id());
            statementInsert.setInt(2, monthlySchedule.getSchedule_id());
            statementInsert.setString(3, monthlySchedule.getDescription());

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

    public List<MonthlySchedule> getAll() throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<MonthlySchedule> monthlyScheduleList = new ArrayList<MonthlySchedule>();
        String sql = "SELECT monthlyschedule_id, schedule_id, description FROM MONTHLYSCHEDULE";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                MonthlySchedule monthlySchedule = new MonthlySchedule();
                monthlySchedule.setMonthlySchedule_id(resultSet.getInt("monthlyschedule_id"));
                monthlySchedule.setSchedule_id(resultSet.getInt("schedule_id"));
                monthlySchedule.setDescription(resultSet.getString("description"));
                monthlyScheduleList.add(monthlySchedule);
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
        return monthlyScheduleList;
    }

    public MonthlySchedule getById(Integer monthlySchedule_id, Integer schedule_id) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement predStatement = null;
        String sql = "SELECT monthlyschedule_id, schedule_id, description FROM MONTHLYSCHEDULE WHERE monthlyschedule_id=? AND schedule_id=?";
        MonthlySchedule monthlySchedule = new MonthlySchedule();

        try {
            predStatement = connection.prepareStatement(sql);
            predStatement.setInt(1, monthlySchedule_id);
            predStatement.setInt(2, schedule_id);

            ResultSet resultSet = predStatement.executeQuery();
            resultSet.next();
            monthlySchedule.setMonthlySchedule_id(resultSet.getInt("monthlyschedule_id"));
            monthlySchedule.setSchedule_id(resultSet.getInt("schedule_id"));
            monthlySchedule.setDescription(resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (predStatement != null) {
                predStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return monthlySchedule;
    }

    public void update(MonthlySchedule monthlySchedule) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement predStatement = null;
        String sql_update = "UPDATE MONTHLYSCHEDULE SET description=? WHERE monthlyschedule_id=? AND schedule_id=?";

        try {
            predStatement = connection.prepareStatement(sql_update);
            predStatement.setString(1, monthlySchedule.getDescription());
            predStatement.setInt(2, monthlySchedule.getMonthlySchedule_id());
            predStatement.setInt(3, monthlySchedule.getSchedule_id());
            predStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (predStatement != null) {
                predStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
