package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<Type> {
// create
    void add(Type type) throws SQLException;

// read
    List<Type> getAll() throws SQLException;

    Type getById(Integer id) throws SQLException;

// update
    void update(Type type) throws SQLException;

// delete
    void remove(Type type) throws SQLException;
}
