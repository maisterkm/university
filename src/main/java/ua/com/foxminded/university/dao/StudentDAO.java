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

import ua.com.foxminded.university.TypeOfEntity;
import ua.com.foxminded.university.domain.entity.Group;
import ua.com.foxminded.university.domain.entity.Person;
import ua.com.foxminded.university.domain.entity.Student;

public class StudentDAO implements Dao<Student> {
    @Override
    public void create(Student student) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO STUDENT (student_id, matriculationnumber, group_id) VALUES (?, ?, ?)";
        String sql_select = "SELECT * FROM STUDENT WHERE student_id=?";
        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, student.getPersonId());
            if (existParentTable(student)) {
                statementInsert.setInt(1, student.getPersonId());
                statementInsert.setInt(2, student.getMatriculationnumber());
                statementInsert.setInt(3, student.getGroup().getGroupId());
                statementInsert.executeUpdate();
            } else { // Create entry in table PERSON related with entry in table TEACHER
                FactoryDAO factory = new FactoryDAO();
                PersonDAO personDAO = (PersonDAO) factory.create(TypeOfEntity.PERSON);
                Person person = new Person();
                person.setPersonId(student.getPersonId());
                person.setFirstName(student.getFirstName());
                person.setLastName(student.getLastName());
                person.setDateOfBirth(student.getDateOfBirth());
                person.setEnrollmentDate(student.getEnrollmentDate());
                personDAO.create(person);

                statementInsert.setInt(1, student.getPersonId());
                statementInsert.setInt(2, student.getMatriculationnumber());
                statementInsert.setInt(3, student.getGroup().getGroupId());
                statementInsert.executeUpdate();
                System.out.println(
                        "There was no data in table PERSON related to current data student.\nEntry in table PERSON was created.");
            }
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

    @Override
    public List<Student> read() {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<Student> studentList = new ArrayList<Student>();
        Statement statementStudent = null;
        PreparedStatement preStatementPerson = null;

        String sql_select_student = "SELECT student_id, matriculationnumber, group_id, studentschedule_id FROM STUDENT";
        String sql_select_person = "SELECT person_id, firstname, lastname, dateofbirth, enrollmentdate FROM PERSON WHERE person_id=?";
        try {
            statementStudent = connection.createStatement();
            ResultSet resultSetStudent = statementStudent.executeQuery(sql_select_student);

            while (resultSetStudent.next()) {
                preStatementPerson = connection.prepareStatement(sql_select_person);
                preStatementPerson.setInt(1, resultSetStudent.getInt("student_id"));
                ResultSet resultSetPerson = preStatementPerson.executeQuery();

                while (resultSetPerson.next()) {
                    String strDateOfBirth = resultSetPerson.getString("dateofbirth");
                    Timestamp timestampDateOfBirth = Timestamp.valueOf(strDateOfBirth);
                    Calendar calendarDateOfBirth = Calendar.getInstance();
                    calendarDateOfBirth.setTimeInMillis(timestampDateOfBirth.getTime());

                    String strEnrollmentDate = resultSetPerson.getString("enrollmentdate");
                    Timestamp timestampEnrollmentDate = Timestamp.valueOf(strEnrollmentDate);
                    Calendar calendarEnrollmentDate = Calendar.getInstance();
                    calendarEnrollmentDate.setTimeInMillis(timestampEnrollmentDate.getTime());

                    Student student = new Student(resultSetPerson.getInt("person_id"),
                            resultSetPerson.getString("firstname"), resultSetPerson.getString("lastname"),
                            calendarDateOfBirth.get(Calendar.DAY_OF_MONTH), calendarDateOfBirth.get(Calendar.MONTH),
                            calendarDateOfBirth.get(Calendar.YEAR), calendarEnrollmentDate.get(Calendar.DAY_OF_MONTH),
                            calendarEnrollmentDate.get(Calendar.MONTH), calendarEnrollmentDate.get(Calendar.YEAR));
                    FactoryDAO factory = new FactoryDAO();
                    GroupDAO groupDAO = (GroupDAO) factory.create(TypeOfEntity.GROUP);
                    Group group = groupDAO.readById(resultSetStudent.getInt("group_id"));
                    student.setGroup(group);
                    student.setMatriculationnumber(resultSetStudent.getInt("matriculationnumber"));
                    studentList.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statementStudent != null) {
                    statementStudent.close();
                }
                if (preStatementPerson != null) {
                    preStatementPerson.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }

    @Override
    public Student readById(Integer student_id) {
        FactoryDAO factory = new FactoryDAO();
        PersonDAO personDAO = (PersonDAO) factory.create(TypeOfEntity.PERSON);
        GroupDAO groupDAO = (GroupDAO) factory.create(TypeOfEntity.GROUP);
        Person person;
        Student student = null;
        PreparedStatement preStatementStudent = null;
        Connection connection = null;
        try {
            person = personDAO.readById(student_id);

            student = new Student(person.getPersonId(), person.getFirstName(), person.getLastName(),
                    person.getDateOfBirth().get(Calendar.DAY_OF_MONTH), person.getDateOfBirth().get(Calendar.MONTH),
                    person.getDateOfBirth().get(Calendar.YEAR), person.getEnrollmentDate().get(Calendar.DAY_OF_MONTH),
                    person.getEnrollmentDate().get(Calendar.MONTH), person.getEnrollmentDate().get(Calendar.YEAR));

            DBConnector dbConnection = new DBConnector();
            connection = dbConnection.getConnection();

            String sql_select_student = "SELECT student_id, matriculationnumber, group_id, studentschedule_id FROM STUDENT WHERE student_id = ?";

            preStatementStudent = connection.prepareStatement(sql_select_student);
            preStatementStudent.setInt(1, student_id);
            ResultSet resultSetStudent = preStatementStudent.executeQuery();
            while (resultSetStudent.next()) {
                student.setMatriculationnumber(resultSetStudent.getInt("matriculationnumber"));
                student.setGroup(groupDAO.readById(resultSetStudent.getInt("group_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preStatementStudent != null) {
                    preStatementStudent.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public void update(Student student) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_update = "UPDATE STUDENT SET matriculationnumber=?, group_id=?, studentschedule_id=? WHERE student_id=?";
        try {
            preStatement = connection.prepareStatement(sql_update);
            preStatement.setInt(1, student.getMatriculationnumber());
            preStatement.setInt(2, student.getGroup().getGroupId());
            preStatement.setInt(3, 2);
            preStatement.setInt(4, student.getPersonId());
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

    @Override
    public void delete(Student student) {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM STUDENT WHERE student_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, student.getPersonId());
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

    public boolean existParentTable(Student student) {
        boolean flag = false;
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementSelect = null;
        String sql_select = "SELECT person_id FROM PERSON WHERE person_id=?";
        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementSelect.setInt(1, student.getPersonId());
            ResultSet resultSet = statementSelect.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("person_id") == student.getPersonId()) {
                    flag = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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
        return flag;
    }
}
