package ua.com.foxminded.university.dao;

import java.sql.SQLException;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Faculties;

public interface FacultyDAO {
    // create
       void add(Faculties faculty) throws SQLException;

       // read
       List<Faculties> getAll() throws SQLException;

       Faculties getById(Integer id) throws SQLException;

       // update
       void update(Faculties faculty) throws SQLException;

       // delete
       void remove(Faculties faculty) throws SQLException;
   }
