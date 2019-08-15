package ua.com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.DailySchedule;

public class DailyScheduleDAO implements Dao<DailySchedule> {
    public void add(DailySchedule dailySchedule) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO DAILYSCHEDULE (dailySchedule_id, monthlyschedule_id, schedule_id, description) VALUES (?, ?, ?, ?)";
        String sql_select = "SELECT * FROM DAILYSCHEDULE WHERE dailySchedule_id=? AND monthlyschedule_id=? AND schedule_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, dailySchedule.getDailyScheduleId());
            statementSelect.setInt(2, dailySchedule.getMonthlyScheduleId());
            statementSelect.setInt(3, dailySchedule.getScheduleId());

            statementInsert.setInt(1, dailySchedule.getDailyScheduleId());
            statementInsert.setInt(2, dailySchedule.getMonthlyScheduleId());
            statementInsert.setInt(3, dailySchedule.getScheduleId());
            statementInsert.setString(4, dailySchedule.getDescription());

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

    public List<DailySchedule> getAll() {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<DailySchedule> dailyScheduleList = new ArrayList<DailySchedule>();
        String sql = "SELECT dailySchedule_id, monthlyschedule_id, schedule_id, description FROM DAILYSCHEDULE";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                DailySchedule dailySchedule = new DailySchedule();
                dailySchedule.setDailyScheduleId(resultSet.getInt("dailyschedule_id"));
                dailySchedule.setMonthlyScheduleId(resultSet.getInt("monthlyschedule_id"));
                dailySchedule.setScheduleId(resultSet.getInt("schedule_id"));
                dailySchedule.setDescription(resultSet.getString("description"));
                dailyScheduleList.add(dailySchedule);
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
        return dailyScheduleList;
    }

    public DailySchedule getById(Integer i) {
        return null;
    }

    public DailySchedule getById(Integer dailySchedule_id, Integer monthlySchedule_id, Integer schedule_id) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement predStatement = null;
        String sql = "SELECT dailySchedule_id, monthlyschedule_id, schedule_id, description FROM DAILYSCHEDULE WHERE dailyschedule_id=? AND monthlyschedule_id=? AND schedule_id=?";
        DailySchedule dailySchedule = new DailySchedule();

        try {
            predStatement = connection.prepareStatement(sql);
            predStatement.setInt(1, dailySchedule_id);
            predStatement.setInt(2, monthlySchedule_id);
            predStatement.setInt(3, schedule_id);

            ResultSet resultSet = predStatement.executeQuery();
            while (resultSet.next()) {
                dailySchedule.setDailyScheduleId(resultSet.getInt("dailyschedule_id"));
                dailySchedule.setMonthlyScheduleId(resultSet.getInt("monthlyschedule_id"));
                dailySchedule.setScheduleId(resultSet.getInt("schedule_id"));
                dailySchedule.setDescription(resultSet.getString("description"));
            }
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
        return dailySchedule;
    }

    public void update(DailySchedule dailySchedule) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement predStatement = null;
        String sql_update = "UPDATE DAILYSCHEDULE SET description=? WHERE dailyschedule_id=? AND monthlyschedule_id=? AND schedule_id=?";

        try {
            predStatement = connection.prepareStatement(sql_update);
            predStatement.setString(1, dailySchedule.getDescription());
            predStatement.setInt(2, dailySchedule.getDailyScheduleId());
            predStatement.setInt(3, dailySchedule.getMonthlyScheduleId());
            predStatement.setInt(4, dailySchedule.getScheduleId());
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

    public void remove(DailySchedule dailySchedule) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM DAILYSCHEDULE WHERE dailyschedule_id=? AND monthlyschedule_id=? AND schedule_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, dailySchedule.getDailyScheduleId());
            preStatement.setInt(2, dailySchedule.getMonthlyScheduleId());
            preStatement.setInt(3, dailySchedule.getScheduleId());
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
