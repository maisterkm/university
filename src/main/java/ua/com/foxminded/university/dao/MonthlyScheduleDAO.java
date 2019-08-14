package ua.com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.MonthlySchedule;

public class MonthlyScheduleDAO implements DAO<MonthlySchedule> {
    public void add(MonthlySchedule monthlySchedule) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO MONTHLYSCHEDULE (monthlyschedule_id, schedule_id, description) VALUES (?, ?, ?)";
        String sql_select = "SELECT * FROM MONTHLYSCHEDULE WHERE monthlyschedule_id=? AND schedule_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, monthlySchedule.getMonthlyScheduleId());
            statementSelect.setInt(2, monthlySchedule.getScheduleId());

            statementInsert.setInt(1, monthlySchedule.getMonthlyScheduleId());
            statementInsert.setInt(2, monthlySchedule.getScheduleId());
            statementInsert.setString(3, monthlySchedule.getDescription());

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

    public List<MonthlySchedule> getAll() {
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
                monthlySchedule.setMonthlyScheduleId(resultSet.getInt("monthlyschedule_id"));
                monthlySchedule.setScheduleId(resultSet.getInt("schedule_id"));
                monthlySchedule.setDescription(resultSet.getString("description"));
                monthlyScheduleList.add(monthlySchedule);
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
        return monthlyScheduleList;
    }

    public MonthlySchedule getById(Integer i) {
        return null;
    }

    public MonthlySchedule getById(Integer monthlySchedule_id, Integer schedule_id) {
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
            monthlySchedule.setMonthlyScheduleId(resultSet.getInt("monthlyschedule_id"));
            monthlySchedule.setScheduleId(resultSet.getInt("schedule_id"));
            monthlySchedule.setDescription(resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (predStatement != null) {
                    predStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return monthlySchedule;
    }

    public void update(MonthlySchedule monthlySchedule) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement predStatement = null;
        String sql_update = "UPDATE MONTHLYSCHEDULE SET description=? WHERE monthlyschedule_id=? AND schedule_id=?";

        try {
            predStatement = connection.prepareStatement(sql_update);
            predStatement.setString(1, monthlySchedule.getDescription());
            predStatement.setInt(2, monthlySchedule.getMonthlyScheduleId());
            predStatement.setInt(3, monthlySchedule.getScheduleId());
            predStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (predStatement != null) {
                    predStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void remove(MonthlySchedule monthlySchedule) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM MONTHLYSCHEDULE WHERE monthlyschedule_id=? AND schedule_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, monthlySchedule.getMonthlyScheduleId());
            preStatement.setInt(2, monthlySchedule.getScheduleId());
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
