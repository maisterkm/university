package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Teacher;

public interface TeacherDAO {
    // create
    void add(Teacher teacher) throws SQLException;

    // read
    List<Teacher> getAll() throws SQLException;

    //Teacher getById(Integer id) throws SQLException;

    // update
    //void update(Teacher teacher) throws SQLException;

    // delete
    //void remove(Teacher teacher) throws SQLException;
}
