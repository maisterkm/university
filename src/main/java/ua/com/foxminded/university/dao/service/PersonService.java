package ua.com.foxminded.university.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.com.foxminded.university.dao.DBConnector;
import ua.com.foxminded.university.dao.PersonDAO;
import ua.com.foxminded.university.domain.entity.Person;

public class PersonService implements PersonDAO {
    public void add(Person person) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO PERSON (person_id, firstname, lastname, dateofbirth, enrollmentdate) VALUES (?, ?, ?, ?, ?)";
        String sql_select = "SELECT * FROM PERSON WHERE person_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, person.getPerson_id());
            
            ResultSet resultSet = statementSelect.executeQuery();
            
            while (resultSet.next()) {
                if (resultSet.getInt("person_id") == person.getPerson_id()) {
                    System.out.println("person_id=" + person.getPerson_id() + " is already in the table PERSON");
                    return;
                }
            }
            statementInsert.setInt(1, person.getPerson_id());
            statementInsert.setString(2, person.getFirstName());
            statementInsert.setString(3, person.getLastName());
            statementInsert.setTimestamp(4, new java.sql.Timestamp(person.getDateOfBirth().getTime()));
            statementInsert.setTimestamp(5, new java.sql.Timestamp(person.getEnrollmentDate().getTime()));

            statementInsert.executeUpdate();
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
}
