package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<Type> {
    void create(Type type) throws SQLException;

    List<Type> read() throws SQLException;

    Type readById(Integer id) throws SQLException;

    void update(Type type) throws SQLException;

    void delete(Type type) throws SQLException;
}
