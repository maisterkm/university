package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Faculties;

public interface FacultyDAO<T> extends DAO<T> {
    // create
    void add(Faculties faculty) throws SQLException;

    // read
    List<T> getAll() throws SQLException;

    T getById(Integer id) throws SQLException;

    // update
    void update(T faculty) throws SQLException;

    // delete
    void remove(T faculty) throws SQLException;
}
