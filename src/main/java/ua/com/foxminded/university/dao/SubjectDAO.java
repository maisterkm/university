package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Subject;

public interface SubjectDAO extends DAO {
    // create
    void add(Subject subject) throws SQLException;

    // read
    List<Subject> getAll() throws SQLException;

    Subject getById(Integer id) throws SQLException;

    // update
    void update(Subject subject) throws SQLException;

    // delete
    void remove(Subject subject) throws SQLException;
}
