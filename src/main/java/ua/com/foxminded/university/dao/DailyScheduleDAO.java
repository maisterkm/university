package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.DailySchedule;

public interface DailyScheduleDAO extends DAO {
    // create
    void add(DailySchedule dailySchedule) throws SQLException;

    // read
    List<DailySchedule> getAll() throws SQLException;

    DailySchedule getById(Integer dailySchedule_id, Integer monthlySchedule_id, Integer schedule_id)
            throws SQLException;

    // update
    void update(DailySchedule dailySchedule) throws SQLException;

    // delete
    void remove(DailySchedule dailySchedule) throws SQLException;
}
