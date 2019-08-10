package ua.com.foxminded.university.dao;

import java.sql.SQLException;

import ua.com.foxminded.university.domain.entity.Subject;
import ua.com.foxminded.university.domain.entity.Teacher;

public interface TeacherHasSubjectDAO {
    // create
    void add(Teacher teacher, Subject subjuct) throws SQLException;
}
