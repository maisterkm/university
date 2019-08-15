package ua.com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Person;

public class PersonDAO implements Dao<Person> {
    public void add(Person person) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO PERSON (person_id, firstname, lastname, dateofbirth, enrollmentdate) VALUES (?, ?, ?, ?, ?)";
        String sql_select = "SELECT * FROM PERSON WHERE person_id=?";
        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, person.getPersonId());

            ResultSet resultSet = statementSelect.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("person_id") == person.getPersonId()) {
                    System.out.println("person_id=" + person.getPersonId() + " is already in the table PERSON");
                    return;
                }
            }
            statementInsert.setInt(1, person.getPersonId());
            statementInsert.setString(2, person.getFirstName());
            statementInsert.setString(3, person.getLastName());
            statementInsert.setTimestamp(4, new java.sql.Timestamp(person.getDateOfBirth().getTime().getTime()));
            statementInsert.setTimestamp(5, new java.sql.Timestamp(person.getEnrollmentDate().getTime().getTime()));

            statementInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statementInsert != null) {
                    statementInsert.close();
                }
                if (statementSelect != null) {
                    statementSelect.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Person> getAll() {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<Person> personList = new ArrayList<Person>();
        String sql = "SELECT person_id, firstname, lastname, dateofbirth, enrollmentdate FROM PERSON";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Person person = new Person();
                person.setPersonId(resultSet.getInt("person_id"));
                person.setFirstName(resultSet.getString("firstname"));
                person.setLastName(resultSet.getString("lastname"));

                String strDateOfBirth = resultSet.getString("dateofbirth");
                Timestamp timestampDateOfBirth = Timestamp.valueOf(strDateOfBirth);
                Calendar calendarDateOfBirth = Calendar.getInstance();
                calendarDateOfBirth.setTimeInMillis(timestampDateOfBirth.getTime());
                person.setDateOfBirth(calendarDateOfBirth);

                String strEnrollmentDate = resultSet.getString("enrollmentdate");
                Timestamp timestampEnrollmentDate = Timestamp.valueOf(strEnrollmentDate);
                Calendar calendarEnrollmentDate = Calendar.getInstance();
                calendarEnrollmentDate.setTimeInMillis(timestampEnrollmentDate.getTime());
                person.setDateOfBirth(calendarEnrollmentDate);

                personList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return personList;
    }

    public Person getById(Integer person_id) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT person_id, firstname, lastname, dateofbirth, enrollmentdate FROM PERSON WHERE person_id = ?";
        Person person = new Person();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, person_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            person.setPersonId(resultSet.getInt("person_id"));
            person.setFirstName(resultSet.getString("firstname"));
            person.setLastName(resultSet.getString("lastname"));

            String strDateOfBirth = resultSet.getString("dateofbirth");
            Timestamp timestampDateOfBirth = Timestamp.valueOf(strDateOfBirth);
            Calendar calendarDateOfBirth = Calendar.getInstance();
            calendarDateOfBirth.setTimeInMillis(timestampDateOfBirth.getTime());
            person.setDateOfBirth(calendarDateOfBirth);

            String strEnrollmentDate = resultSet.getString("enrollmentdate");
            Timestamp timestampEnrollmentDate = Timestamp.valueOf(strEnrollmentDate);
            Calendar calendarEnrollmentDate = Calendar.getInstance();
            calendarEnrollmentDate.setTimeInMillis(timestampEnrollmentDate.getTime());
            person.setDateOfBirth(calendarEnrollmentDate);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return person;
    }

    public void update(Person person) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql_update = "UPDATE PERSON SET firstname=?, lastname=?, dateofbirth=?, enrollmentdate=? WHERE person_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setTimestamp(3, new java.sql.Timestamp(person.getDateOfBirth().getTime().getTime()));
            preparedStatement.setTimestamp(4, new java.sql.Timestamp(person.getEnrollmentDate().getTime().getTime()));
            preparedStatement.setInt(5, person.getPersonId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void remove(Person person) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM PERSON WHERE person_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, person.getPersonId());
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preStatement != null) {
                    preStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
