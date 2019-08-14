package ua.com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Subject;

public class SubjectDAO implements DAO<Subject> {
    public void add(Subject subject) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO SUBJECTS (subject_id, subject) VALUES (?, ?)";
        String sql_select = "SELECT * FROM SUBJECTS WHERE subject_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, subject.getSubjectId());

            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("subject_id") == subject.getSubjectId()) {
                    System.out.println("subject_id=" + subject.getSubjectId() + " is already in the table SUBJECTS");
                    return;
                }
            }
            statementInsert.setInt(1, subject.getSubjectId());
            statementInsert.setString(2, subject.getSubject());

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

    public List<Subject> getAll() {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<Subject> subjectList = new ArrayList<Subject>();
        String sql = "SELECT subject_id, subject FROM SUBJECTS";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setSubjectId(resultSet.getInt("subject_id"));
                subject.setSubject(resultSet.getString("subject"));

                subjectList.add(subject);
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
        return subjectList;
    }

    public Subject getById(Integer subject_id) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT subject_id, subject FROM SUBJECTS WHERE subject_id = ?";
        Subject subject = new Subject();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, subject_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            subject.setSubjectId(resultSet.getInt("subject_id"));
            subject.setSubject(resultSet.getString("subject"));
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
        return subject;
    }

    public void update(Subject subject) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql_update = "UPDATE SUBJECTS SET subject=? WHERE subject_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setString(1, subject.getSubject());
            preparedStatement.setInt(2, subject.getSubjectId());
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

    public void remove(Subject subject) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM SUBJECTS WHERE subject_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, subject.getSubjectId());
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
