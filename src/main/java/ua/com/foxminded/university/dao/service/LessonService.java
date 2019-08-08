package ua.com.foxminded.university.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ua.com.foxminded.university.dao.DBConnector;
import ua.com.foxminded.university.dao.LessonDAO;
import ua.com.foxminded.university.domain.DailySchedule;
import ua.com.foxminded.university.domain.MonthlySchedule;
import ua.com.foxminded.university.domain.Schedule;
import ua.com.foxminded.university.domain.entity.Classroom;
import ua.com.foxminded.university.domain.entity.Lesson;
import ua.com.foxminded.university.domain.entity.Subject;

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

    public List<Lesson> getAll() throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<Lesson> lessonList = new ArrayList<Lesson>();
        String sql = "SELECT lesson_id, campus_id, roomnumber, begintime, endtime, subject_id, dailyschedule_id, monthlyschedule_id, schedule_id FROM LESSON";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Lesson lesson = new Lesson();
                lesson.setLesson_id(resultSet.getInt("lesson_id"));

                ClassroomService classroomService = new ClassroomService();
                Classroom classroom = classroomService.getById(resultSet.getInt("campus_id"),
                        resultSet.getString("roomnumber"));
                lesson.setClassroom(classroom);

                String strBeginTime = resultSet.getString("begintime");
                Timestamp timestampBeginTime = Timestamp.valueOf(strBeginTime);
                Calendar calendarBeginTime = Calendar.getInstance();
                calendarBeginTime.setTimeInMillis(timestampBeginTime.getTime());
                lesson.setBeginTime(calendarBeginTime);

                String strEndTime = resultSet.getString("endtime");
                Timestamp timestampEndTime = Timestamp.valueOf(strEndTime);
                Calendar calendarEndTime = Calendar.getInstance();
                calendarEndTime.setTimeInMillis(timestampEndTime.getTime());
                lesson.setEndTime(calendarEndTime);

                SubjectService subjectService = new SubjectService();
                Subject subject = subjectService.getById(resultSet.getInt("subject_id"));
                lesson.setSubject(subject);

                DailyScheduleService dailyScheduleService = new DailyScheduleService();
                DailySchedule dailySchedule = dailyScheduleService.getById(resultSet.getInt("dailyschedule_id"),
                        resultSet.getInt("monthlyschedule_id"), resultSet.getInt("schedule_id"));
                lesson.setDailySchedule(dailySchedule);

                MonthlyScheduleService monthlyService = new MonthlyScheduleService();
                MonthlySchedule monthlySchedule = monthlyService.getById(resultSet.getInt("monthlyschedule_id"),
                        resultSet.getInt("schedule_id"));
                lesson.setMonthlySchedule(monthlySchedule);

                ScheduleService scheduleService = new ScheduleService();
                Schedule schedule = scheduleService.getById(resultSet.getInt("schedule_id"));
                lesson.setSchedule(schedule);

                lessonList.add(lesson);
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
        return lessonList;
    }

    public Lesson getById(Integer lesson_id) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement predStatement = null;
        String sql = "SELECT lesson_id, campus_id, roomnumber, begintime, endtime, subject_id, dailyschedule_id, monthlyschedule_id, schedule_id FROM LESSON WHERE lesson_id=?";
        Lesson lesson = new Lesson();

        try {
            predStatement = connection.prepareStatement(sql);
            predStatement.setInt(1, lesson_id);

            ResultSet resultSet = predStatement.executeQuery();
            resultSet.next();
            lesson.setLesson_id(resultSet.getInt("lesson_id"));

            ClassroomService classroomService = new ClassroomService();
            Classroom classroom = classroomService.getById(resultSet.getInt("campus_id"),
                    resultSet.getString("roomnumber"));
            lesson.setClassroom(classroom);

            String strBeginTime = resultSet.getString("begintime");
            Timestamp timestampBeginTime = Timestamp.valueOf(strBeginTime);
            Calendar calendarBeginTime = Calendar.getInstance();
            calendarBeginTime.setTimeInMillis(timestampBeginTime.getTime());
            lesson.setBeginTime(calendarBeginTime);

            String strEndTime = resultSet.getString("endtime");
            Timestamp timestampEndTime = Timestamp.valueOf(strEndTime);
            Calendar calendarEndTime = Calendar.getInstance();
            calendarEndTime.setTimeInMillis(timestampEndTime.getTime());
            lesson.setEndTime(calendarEndTime);

            SubjectService subjectService = new SubjectService();
            Subject subject = subjectService.getById(resultSet.getInt("subject_id"));
            lesson.setSubject(subject);

            DailyScheduleService dailyScheduleService = new DailyScheduleService();
            DailySchedule dailySchedule = dailyScheduleService.getById(resultSet.getInt("dailyschedule_id"),
                    resultSet.getInt("monthlyschedule_id"), resultSet.getInt("schedule_id"));
            lesson.setDailySchedule(dailySchedule);

            MonthlyScheduleService monthlyService = new MonthlyScheduleService();
            MonthlySchedule monthlySchedule = monthlyService.getById(resultSet.getInt("monthlyschedule_id"),
                    resultSet.getInt("schedule_id"));
            lesson.setMonthlySchedule(monthlySchedule);

            ScheduleService scheduleService = new ScheduleService();
            Schedule schedule = scheduleService.getById(resultSet.getInt("schedule_id"));
            lesson.setSchedule(schedule);

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
        return lesson;
    }
}
