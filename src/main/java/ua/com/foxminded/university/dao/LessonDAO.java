package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Lesson;

public interface LessonDAO {
    // create
    void add(Lesson lesson) throws SQLException;

    // read
    List<Lesson> getAll() throws SQLException;

    Lesson getById(Integer lesson_id) throws SQLException;

    // update
    void update(Lesson lesson) throws SQLException;

    // delete
    void remove(Lesson lesson) throws SQLException;
}
