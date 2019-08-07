package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.MonthlySchedule;

public interface MonthlyScheduleDAO {
    // create
    void add(MonthlySchedule monthlySchedule) throws SQLException;

    // read
    List<MonthlySchedule> getAll() throws SQLException;

    MonthlySchedule getById(Integer monthlySchedule_id, Integer schedule_id) throws SQLException;

    // update
    void update(MonthlySchedule monthlySchedule) throws SQLException;

    // delete
    void remove(MonthlySchedule monthlySchedule) throws SQLException;
}
