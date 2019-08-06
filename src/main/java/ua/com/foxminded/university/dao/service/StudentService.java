package ua.com.foxminded.university.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ua.com.foxminded.university.dao.DBConnector;
import ua.com.foxminded.university.dao.StudentDAO;
import ua.com.foxminded.university.domain.entity.Group;
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

    public List<Student> getAll() throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<Student> studentList = new ArrayList<Student>();
        Statement statementStudent = null;
        PreparedStatement preStatementPerson = null;
        PreparedStatement preStatementGrup = null;

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
                    GroupService groupService = new GroupService();
                    Group group = groupService.getById(resultSetStudent.getInt("group_id"));
                    student.setGroup(group);
                    student.setMatriculationnumber(resultSetStudent.getInt("matriculationnumber"));
                    studentList.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statementStudent != null) {
                statementStudent.close();
            }
            if (preStatementPerson != null) {
                preStatementPerson.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return studentList;
    }

    public Student getById(Integer student_id) throws SQLException {
        PersonService personService = new PersonService();
        GroupService groupService = new GroupService();
        Person person = personService.getById(student_id);
        Student student = new Student(person.getPerson_id(), person.getFirstName(), person.getLastName(),
                person.getDateOfBirth().get(Calendar.DAY_OF_MONTH), person.getDateOfBirth().get(Calendar.MONTH),
                person.getDateOfBirth().get(Calendar.YEAR), person.getEnrollmentDate().get(Calendar.DAY_OF_MONTH),
                person.getEnrollmentDate().get(Calendar.MONTH), person.getEnrollmentDate().get(Calendar.YEAR));

        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatementStudent = null;

        String sql_select_student = "SELECT student_id, matriculationnumber, group_id, studentschedule_id FROM STUDENT WHERE student_id = ?";

        try {
            preStatementStudent = connection.prepareStatement(sql_select_student);
            preStatementStudent.setInt(1, student_id);
            ResultSet resultSetStudent = preStatementStudent.executeQuery();
            while (resultSetStudent.next()) {
                student.setMatriculationnumber(resultSetStudent.getInt("matriculationnumber"));
                student.setGroup(groupService.getById(resultSetStudent.getInt("group_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preStatementStudent != null) {
                preStatementStudent.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return student;
    }

    public void update(Student student) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_update = "UPDATE STUDENT SET matriculationnumber=?, group_id=?, studentschedule_id=? WHERE student_id=?";
        try {
            preStatement = connection.prepareStatement(sql_update);
            preStatement.setInt(1, student.getMatriculationnumber());
            preStatement.setInt(2, student.getGroup().getGroup_id());
            preStatement.setInt(3, 2);
            preStatement.setInt(4, student.getPerson_id());
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preStatement != null) {
                preStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void remove(Student student) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM STUDENT WHERE student_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, student.getPerson_id());
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preStatement != null) {
                preStatement.close();
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
