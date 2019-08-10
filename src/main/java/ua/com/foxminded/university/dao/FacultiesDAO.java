package ua.com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Faculties;

public class FacultiesDAO implements DAO<Faculties> {
    public void add(Faculties faculty) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO FACULTIES (faculty_id, faculty) VALUES (?, ?)";
        String sql_select = "SELECT * FROM FACULTIES WHERE faculty_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, faculty.getFaculty_id());

            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("faculty_id") == faculty.getFaculty_id()) {
                    System.out.println("faculty_id=" + faculty.getFaculty_id() + " is already in the table FACULTIES");
                    return;
                }
            }
            statementInsert.setInt(1, faculty.getFaculty_id());
            statementInsert.setString(2, faculty.getFaculty());

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
    
    public List<Faculties> getAll() throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<Faculties> facultyList = new ArrayList<Faculties>();
        String sql = "SELECT faculty_id, faculty FROM FACULTIES";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Faculties faculty = new Faculties();
                faculty.setFaculty_id(resultSet.getInt("faculty_id"));
                faculty.setFaculty(resultSet.getString("faculty"));

                facultyList.add(faculty);
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
        return facultyList;
    }
    
    public Faculties getById(Integer faculty_id) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT faculty_id, faculty FROM FACULTIES WHERE faculty_id = ?";
        Faculties faculty = new Faculties();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, faculty_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            faculty.setFaculty_id(resultSet.getInt("faculty_id"));
            faculty.setFaculty(resultSet.getString("faculty"));
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
        return faculty;
    }
    
    public void update(Faculties faculty) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql_update = "UPDATE FACULTIES SET faculty=? WHERE faculty_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setString(1, faculty.getFaculty());
            preparedStatement.setInt(2, faculty.getFaculty_id());
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
    
    public void remove(Faculties faculty) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM FACULTIES WHERE faculty_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, faculty.getFaculty_id());
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
