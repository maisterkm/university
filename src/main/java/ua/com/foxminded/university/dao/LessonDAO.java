package ua.com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ua.com.foxminded.university.TypeOfEntity;
import ua.com.foxminded.university.domain.DailySchedule;
import ua.com.foxminded.university.domain.MonthlySchedule;
import ua.com.foxminded.university.domain.Schedule;
import ua.com.foxminded.university.domain.entity.Classroom;
import ua.com.foxminded.university.domain.entity.Lesson;
import ua.com.foxminded.university.domain.entity.Subject;

public class LessonDAO implements DAO<Lesson> {
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

                FactoryDAO factory = new FactoryDAO();
                ClassroomDAO classroomDAO = (ClassroomDAO) factory.create(TypeOfEntity.CLASSROOM);
                Classroom classroom = classroomDAO.getById(resultSet.getInt("campus_id"),
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

                SubjectDAO subjectDAO = (SubjectDAO) factory.create(TypeOfEntity.SUBJECT);
                Subject subject = subjectDAO.getById(resultSet.getInt("subject_id"));
                lesson.setSubject(subject);

                DailyScheduleDAO dailyScheduleDAO = (DailyScheduleDAO) factory.create(TypeOfEntity.DAILYSCHEDULE);
                DailySchedule dailySchedule = dailyScheduleDAO.getById(resultSet.getInt("dailyschedule_id"),
                        resultSet.getInt("monthlyschedule_id"), resultSet.getInt("schedule_id"));
                lesson.setDailySchedule(dailySchedule);

                MonthlyScheduleDAO monthlyScheduleDAO = (MonthlyScheduleDAO) factory
                        .create(TypeOfEntity.MONTHLYSHCEDULE);
                MonthlySchedule monthlySchedule = monthlyScheduleDAO.getById(resultSet.getInt("monthlyschedule_id"),
                        resultSet.getInt("schedule_id"));
                lesson.setMonthlySchedule(monthlySchedule);

                ScheduleDAO scheduleDAO = (ScheduleDAO) factory.create(TypeOfEntity.SCHEDULE);
                Schedule schedule = scheduleDAO.getById(resultSet.getInt("schedule_id"));
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

            FactoryDAO factory = new FactoryDAO();
            ClassroomDAO classroomDAO = (ClassroomDAO) factory.create(TypeOfEntity.CLASSROOM);
            Classroom classroom = classroomDAO.getById(resultSet.getInt("campus_id"),
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

            SubjectDAO subjectDAO = (SubjectDAO) factory.create(TypeOfEntity.SUBJECT);
            Subject subject = subjectDAO.getById(resultSet.getInt("subject_id"));
            lesson.setSubject(subject);

            DailyScheduleDAO dailyScheduleDAO = (DailyScheduleDAO) factory.create(TypeOfEntity.DAILYSCHEDULE);
            DailySchedule dailySchedule = dailyScheduleDAO.getById(resultSet.getInt("dailyschedule_id"),
                    resultSet.getInt("monthlyschedule_id"), resultSet.getInt("schedule_id"));
            lesson.setDailySchedule(dailySchedule);

            MonthlyScheduleDAO monthlyScheduleDAO = (MonthlyScheduleDAO) factory.create(TypeOfEntity.MONTHLYSHCEDULE);
            MonthlySchedule monthlySchedule = monthlyScheduleDAO.getById(resultSet.getInt("monthlyschedule_id"),
                    resultSet.getInt("schedule_id"));
            lesson.setMonthlySchedule(monthlySchedule);

            ScheduleDAO scheduleDAO = (ScheduleDAO) factory.create(TypeOfEntity.SCHEDULE);
            Schedule schedule = scheduleDAO.getById(resultSet.getInt("schedule_id"));
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

    public void update(Lesson lesson) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement predStatement = null;
        String sql_update = "UPDATE LESSON SET campus_id=?, roomnumber=?, begintime=?, endtime=?, subject_id=?, dailyschedule_id=?, monthlyschedule_id=?, schedule_id=? WHERE lesson_id=?";

        try {
            predStatement = connection.prepareStatement(sql_update);
            predStatement.setInt(1, lesson.getCampus_id());
            predStatement.setString(2, lesson.getRoomnumber());
            predStatement.setTimestamp(3, new java.sql.Timestamp(lesson.getBeginTime().getTime().getTime()));
            predStatement.setTimestamp(4, new java.sql.Timestamp(lesson.getEndTime().getTime().getTime()));
            predStatement.setInt(5, lesson.getSubject_id());
            predStatement.setInt(6, lesson.getDailyschedule_id());
            predStatement.setInt(7, lesson.getMonthlyschedule_id());
            predStatement.setInt(8, lesson.getSchedule_id());
            predStatement.setInt(9, lesson.getLesson_id());

            predStatement.executeUpdate();
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
    }

    public void remove(Lesson lesson) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM LESSON WHERE lesson_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, lesson.getLesson_id());
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
