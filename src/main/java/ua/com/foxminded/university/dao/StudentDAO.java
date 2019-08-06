package ua.com.foxminded.university.dao;

import java.sql.SQLException;

import ua.com.foxminded.university.domain.entity.Student;

public interface StudentDAO {
    // create
    void add(Student student) throws SQLException;

    // read
//    List<Student> getAll() throws SQLException;

//    Student getById(Integer id) throws SQLException;

    // update
//    void update(Student student) throws SQLException;

    // delete
//    void remove(Student student) throws SQLException;
}
