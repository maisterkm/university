package ua.com.foxminded.university.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.foxminded.university.dao.DBConnector;
import ua.com.foxminded.university.dao.TeacherHasSubjectDAO;
import ua.com.foxminded.university.domain.entity.Subject;
import ua.com.foxminded.university.domain.entity.Teacher;

public class TeacherHasSubjectService implements TeacherHasSubjectDAO {
    public void add(Teacher teacher, Subject subject) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO TEACHER_SUBJECT (teacher_id, subject_id) VALUES (?, ?)";
        String sql_select = "SELECT * FROM TEACHER_SUBJECT WHERE teacher_id=? AND  subject_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, teacher.getPerson_id());
            statementSelect.setInt(2, subject.getSubject_id());

            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("teacher_id") == teacher.getPerson_id()
                        && resultSet.getInt("subject_id") == subject.getSubject_id()) {
                    System.out.println("teacher_id=" + teacher.getPerson_id() + ", subject_id="
                            + subject.getSubject_id() + " is already in the table LESSON");
                    return;
                }
            }
            statementInsert.setInt(1, teacher.getPerson_id());
            statementInsert.setInt(2, subject.getSubject_id());

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
