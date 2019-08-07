package ua.com.foxminded.university.dao;

import java.sql.SQLException;

import ua.com.foxminded.university.domain.entity.Lesson;

public interface LessonDAO {
 // create
    void add(Lesson lesson) throws SQLException;

    // read
//    List<DailySchedule> getAll() throws SQLException;

//    DailySchedule getById(Integer dailySchedule_id, Integer monthlySchedule_id, Integer schedule_id)
//            throws SQLException;

    // update
//    void update(DailySchedule dailySchedule) throws SQLException;

    // delete
//    void remove(DailySchedule dailySchedule) throws SQLException;
}
