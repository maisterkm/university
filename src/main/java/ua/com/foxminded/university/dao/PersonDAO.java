package ua.com.foxminded.university.dao;

import java.sql.SQLException;

import ua.com.foxminded.university.domain.entity.Person;

public interface PersonDAO {
    // create
    void add(Person person) throws SQLException;

    // read
//    List<Person> getAll() throws SQLException;
//
//    Person getById(Integer id) throws SQLException;

    // update
//    void update(Person person) throws SQLException;

    // delete
//    void remove(Person person) throws SQLException;
}
