package ua.com.foxminded.university.dao;

import java.sql.SQLException;

import ua.com.foxminded.university.domain.entity.Subject;
import ua.com.foxminded.university.domain.entity.Teacher;

public interface TeacherHasSubjectDAO {
    // create
    void add(Teacher teacher, Subject subjuct) throws SQLException;

    // read
//    List<Lesson> getAll() throws SQLException;

//    Lesson getById(Integer lesson_id) throws SQLException;

    // update
//    void update(Lesson lesson) throws SQLException;

    // delete
//    void remove(Lesson lesson) throws SQLException;
}
