package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Campus;

public interface CampusDAO {
    // create
    void add(Campus campus) throws SQLException;

    // read
    List<Campus> getAll() throws SQLException;

    Campus getById(Integer id) throws SQLException;

    // update
    void update(Campus campus) throws SQLException;

    // delete
    void remove(Campus campus) throws SQLException;
}
