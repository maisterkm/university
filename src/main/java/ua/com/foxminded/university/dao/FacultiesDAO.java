package ua.com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Faculties;

public class FacultiesDAO implements Dao<Faculties> {
    public void create(Faculties faculty) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO FACULTIES (faculty_id, faculty) VALUES (?, ?)";
        String sql_select = "SELECT * FROM FACULTIES WHERE faculty_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, faculty.getFacultyId());

            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("faculty_id") == faculty.getFacultyId()) {
                    System.out.println("faculty_id=" + faculty.getFacultyId() + " is already in the table FACULTIES");
                    return;
                }
            }
            statementInsert.setInt(1, faculty.getFacultyId());
            statementInsert.setString(2, faculty.getFaculty());

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

    public List<Faculties> read() {
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
                faculty.setFacultyId(resultSet.getInt("faculty_id"));
                faculty.setFaculty(resultSet.getString("faculty"));

                facultyList.add(faculty);
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
        return facultyList;
    }

    public Faculties readById(Integer faculty_id) {
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
            faculty.setFacultyId(resultSet.getInt("faculty_id"));
            faculty.setFaculty(resultSet.getString("faculty"));
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
        return faculty;
    }

    public void update(Faculties faculty) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql_update = "UPDATE FACULTIES SET faculty=? WHERE faculty_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setString(1, faculty.getFaculty());
            preparedStatement.setInt(2, faculty.getFacultyId());
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

    public void delete(Faculties faculty) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM FACULTIES WHERE faculty_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, faculty.getFacultyId());
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
