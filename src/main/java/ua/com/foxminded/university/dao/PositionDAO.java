package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Position;

public interface PositionDAO {
 // create
    void add(Position position) throws SQLException;

    // read
    List<Position> getAll() throws SQLException;

    Position getById(Integer id) throws SQLException;

    // update
    void update(Position position) throws SQLException;

    // delete
    void remove(Position position) throws SQLException;
}
