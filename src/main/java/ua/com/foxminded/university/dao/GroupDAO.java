package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Group;

public interface GroupDAO {
 // create
    void add(Group group) throws SQLException;

    // read
    List<Group> getAll() throws SQLException;

    Group getById(Integer id) throws SQLException;

    // update
    void update(Group group) throws SQLException;

    // delete
    void remove(Group group) throws SQLException;
}
