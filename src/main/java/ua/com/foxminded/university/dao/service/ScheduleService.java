package ua.com.foxminded.university.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.foxminded.university.dao.DBConnector;
import ua.com.foxminded.university.dao.ScheduleDAO;
import ua.com.foxminded.university.domain.Schedule;

public class ScheduleService implements ScheduleDAO {
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
}
