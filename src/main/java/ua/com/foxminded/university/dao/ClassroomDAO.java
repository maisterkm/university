package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Classroom;

public interface ClassroomDAO {
    // create
    void add(Classroom classroom) throws SQLException;

    // read
    List<Classroom> getAll() throws SQLException;

    Classroom getById(Integer id, String roomnumber) throws SQLException;

    // update
    void update(Classroom classroom) throws SQLException;

    // delete
    void remove(Classroom classroom) throws SQLException;
}
