package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.Schedule;

public interface ScheduleDAO extends DAO {
    // create
    void add(Schedule schedule) throws SQLException;

    // read
    List<Schedule> getAll() throws SQLException;

    Schedule getById(Integer id) throws SQLException;

    // update
    void update(Schedule schedule) throws SQLException;

    // delete
    void remove(Schedule schedule) throws SQLException;
}
