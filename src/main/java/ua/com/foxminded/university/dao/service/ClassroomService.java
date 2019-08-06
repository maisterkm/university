package ua.com.foxminded.university.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.dao.ClassroomDAO;
import ua.com.foxminded.university.dao.DBConnector;
import ua.com.foxminded.university.domain.entity.Classroom;

public class ClassroomService implements ClassroomDAO {
    public void add(Classroom classroom) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO CLASSROOM (campus_id, roomnumber, capacity) VALUES (?, ?, ?)";
        String sql_select = "SELECT * FROM CLASSROOM WHERE campus_id=? AND roomnumber=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, classroom.getCampus().getCampus_id());
            statementSelect.setString(2, classroom.getRoomNumber());

            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("campus_id") == classroom.getCampus().getCampus_id()
                        && resultSet.getString("roomnumber").equals(classroom.getRoomNumber())) {
                    System.out.println("Classroom=" + classroom.getCampus().getCampus_id() + ", "
                            + classroom.getRoomNumber() + " is already in the table CLASSROOM");
                    return;
                }
            }
            statementInsert.setInt(1, classroom.getCampus().getCampus_id());
            statementInsert.setString(2, classroom.getRoomNumber());
            statementInsert.setInt(3, classroom.getCapacity());

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

    public List<Classroom> getAll() throws SQLException {
        CampusService campusService = new CampusService();
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<Classroom> classroomList = new ArrayList<Classroom>();
        String sql = "SELECT campus_id, roomnumber, capacity FROM CLASSROOM";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Classroom classroom = new Classroom();
                classroom.setCampus(campusService.getById(resultSet.getInt("campus_id")));
                classroom.setRoomNumber(resultSet.getString("roomnumber"));
                classroom.setCapacity(resultSet.getInt("capacity"));

                classroomList.add(classroom);
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
        return classroomList;
    }
}
