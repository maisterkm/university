package ua.com.foxminded.university.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.foxminded.university.dao.DBConnector;
import ua.com.foxminded.university.dao.LessonDAO;
import ua.com.foxminded.university.domain.entity.Lesson;

public class LessonService implements LessonDAO {
    public void add(Lesson lesson) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO LESSON (lesson_id, campus_id, roomnumber, begintime, endtime, subject_id, dailyschedule_id, monthlyschedule_id, schedule_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql_select = "SELECT * FROM LESSON WHERE lesson_id=? ";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, lesson.getLesson_id());

            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("lesson_id") == lesson.getLesson_id()) {
                    System.out.println("lesson_id=" + lesson.getLesson_id() + " is already in the table LESSON");
                    return;
                }
            }
            statementInsert.setInt(1, lesson.getLesson_id());
            statementInsert.setInt(2, lesson.getCampus_id());
            statementInsert.setString(3, lesson.getRoomnumber());
            statementInsert.setTimestamp(4, new java.sql.Timestamp(lesson.getBeginTime().getTime().getTime()));
            statementInsert.setTimestamp(5, new java.sql.Timestamp(lesson.getEndTime().getTime().getTime()));
            statementInsert.setInt(6, lesson.getSubject_id());
            statementInsert.setInt(7, lesson.getDailyschedule_id());
            statementInsert.setInt(8, lesson.getMonthlyschedule_id());
            statementInsert.setInt(9, lesson.getSchedule_id());

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
