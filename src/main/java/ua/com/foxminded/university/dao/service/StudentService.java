package ua.com.foxminded.university.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.foxminded.university.dao.DBConnector;
import ua.com.foxminded.university.dao.StudentDAO;
import ua.com.foxminded.university.domain.entity.Person;
import ua.com.foxminded.university.domain.entity.Student;

public class StudentService implements StudentDAO {
    public void add(Student student) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO STUDENT (student_id, matriculationnumber, group_id) VALUES (?, ?, ?)";
        String sql_select = "SELECT * FROM STUDENT WHERE student_id=?";
        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, student.getPerson_id());
            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("student_id") == student.getPerson_id()) {
                    System.out.println("student_id=" + student.getPerson_id() + " is already in the table STUDENT");
                    return;
                }
            }
            if (existParentTable(student)) {
                statementInsert.setInt(1, student.getPerson_id());
                statementInsert.setInt(2, student.getMatriculationnumber());
                statementInsert.setInt(3, student.getGroup().getGroup_id());
                statementInsert.executeUpdate();
            } else { // Create entry in table PERSON related with entry in table TEACHER
                PersonService personService = new PersonService();
                Person person = new Person();
                person.setPerson_id(student.getPerson_id());
                person.setFirstName(student.getFirstName());
                person.setLastName(student.getLastName());
                person.setDateOfBirth(student.getDateOfBirth());
                person.setEnrollmentDate(student.getEnrollmentDate());
                personService.add(person);

                statementInsert.setInt(1, student.getPerson_id());
                statementInsert.setInt(2, student.getMatriculationnumber());
                statementInsert.setInt(3, student.getGroup().getGroup_id());
                statementInsert.executeUpdate();
                System.out.println(
                        "There was no data in table PERSON related to current data student.\nEntry in table PERSON was created.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statementInsert != null) {
                statementInsert.close();
            }
            if (statementSelect != null) {
                statementSelect.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public boolean existParentTable(Student student) throws SQLException {
        boolean flag = false;
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementSelect = null;
        String sql_select = "SELECT person_id FROM PERSON WHERE person_id=?";
        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementSelect.setInt(1, student.getPerson_id());
            ResultSet resultSet = statementSelect.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("person_id") == student.getPerson_id()) {
                    flag = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statementSelect != null) {
                statementSelect.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return flag;
    }
}
