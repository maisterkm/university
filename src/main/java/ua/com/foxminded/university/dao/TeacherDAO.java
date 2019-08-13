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
import ua.com.foxminded.university.domain.entity.Person;
import ua.com.foxminded.university.domain.entity.Position;
import ua.com.foxminded.university.domain.entity.Teacher;

public class TeacherDAO implements DAO<Teacher> {
    public void add(Teacher teacher) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO TEACHER (teacher_id, salary, position_id) VALUES (?, ?, ?)";
        String sql_select = "SELECT * FROM TEACHER WHERE teacher_id=?";
        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, teacher.getPerson_id());
            if (existParentTable(teacher)) {
                statementInsert.setInt(1, teacher.getPerson_id());
                statementInsert.setInt(2, teacher.getSalary());
                statementInsert.setInt(3, teacher.getPosition().getPosition_id());
                statementInsert.executeUpdate();
            } else { // Create entry in table PERSON related with entry in table TEACHER
                FactoryDAO factory = new FactoryDAO();
                PersonDAO personDAO = (PersonDAO) factory.create(TypeOfEntity.PERSON);
                Person person = new Person();
                person.setPerson_id(teacher.getPerson_id());
                person.setFirstName(teacher.getFirstName());
                person.setLastName(teacher.getLastName());
                person.setDateOfBirth(teacher.getDateOfBirth());
                person.setEnrollmentDate(teacher.getEnrollmentDate());
                personDAO.add(person);

                statementInsert.setInt(1, teacher.getPerson_id());
                statementInsert.setInt(2, teacher.getSalary());
                statementInsert.setInt(3, teacher.getPosition().getPosition_id());
                statementInsert.executeUpdate();
                System.out.println(
                        "There was no data in table PERSON related to current data teacher.\nEntry in table PERSON was created.");
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

    public List<Teacher> getAll() throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<Teacher> teacherList = new ArrayList<Teacher>();
        Statement statementTeacher = null;
        PreparedStatement preStatementPerson = null;

        String sql_select_teacher = "SELECT teacher_id, salary, position_id, teacherschedule_id FROM TEACHER";
        String sql_select_person = "SELECT person_id, firstname, lastname, dateofbirth, enrollmentdate FROM PERSON WHERE person_id=?";
        try {
            statementTeacher = connection.createStatement();
            ResultSet resultSetTeacher = statementTeacher.executeQuery(sql_select_teacher);

            while (resultSetTeacher.next()) {
                preStatementPerson = connection.prepareStatement(sql_select_person);
                preStatementPerson.setInt(1, resultSetTeacher.getInt("teacher_id"));
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

                    Teacher teacher = new Teacher(resultSetPerson.getInt("person_id"),
                            resultSetPerson.getString("firstname"), resultSetPerson.getString("lastname"),
                            calendarDateOfBirth.get(Calendar.DAY_OF_MONTH), calendarDateOfBirth.get(Calendar.MONTH),
                            calendarDateOfBirth.get(Calendar.YEAR), calendarEnrollmentDate.get(Calendar.DAY_OF_MONTH),
                            calendarEnrollmentDate.get(Calendar.MONTH), calendarEnrollmentDate.get(Calendar.YEAR),
                            getPositionByIdFromDB(resultSetTeacher.getInt("position_id")),
                            resultSetTeacher.getInt("salary"));

                    teacherList.add(teacher);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statementTeacher != null) {
                statementTeacher.close();
            }
            if (preStatementPerson != null) {
                preStatementPerson.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return teacherList;
    }

    public Teacher getById(Integer teacher_id) throws SQLException {
        Teacher teacher = new Teacher();
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatementTeacher = null;
        PreparedStatement preStatementPerson = null;

        String sql_select_teacher = "SELECT teacher_id, salary, position_id, teacherschedule_id FROM TEACHER WHERE teacher_id = ?";
        String sql_select_person = "SELECT person_id, firstname, lastname, dateofbirth, enrollmentdate FROM PERSON WHERE person_id=?";

        try {
            preStatementTeacher = connection.prepareStatement(sql_select_teacher);
            preStatementTeacher.setInt(1, teacher_id);
            ResultSet resultSetTeacher = preStatementTeacher.executeQuery();
            while (resultSetTeacher.next()) {
                preStatementPerson = connection.prepareStatement(sql_select_person);
                preStatementPerson.setInt(1, teacher_id);
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

                    Teacher tmpTeacher = new Teacher(resultSetPerson.getInt("person_id"),
                            resultSetPerson.getString("firstname"), resultSetPerson.getString("lastname"),
                            calendarDateOfBirth.get(Calendar.DAY_OF_MONTH), calendarDateOfBirth.get(Calendar.MONTH),
                            calendarDateOfBirth.get(Calendar.YEAR), calendarEnrollmentDate.get(Calendar.DAY_OF_MONTH),
                            calendarEnrollmentDate.get(Calendar.MONTH), calendarEnrollmentDate.get(Calendar.YEAR),
                            getPositionByIdFromDB(resultSetTeacher.getInt("position_id")),
                            resultSetTeacher.getInt("salary"));

                    teacher = tmpTeacher;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preStatementTeacher != null) {
                preStatementTeacher.close();
            }
            if (preStatementPerson != null) {
                preStatementPerson.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return teacher;
    }

    public void update(Teacher teacher) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_update = "UPDATE TEACHER SET salary=?, position_id=?, teacherschedule_id=? WHERE teacher_id=?";

        try {
            preStatement = connection.prepareStatement(sql_update);
            preStatement.setInt(1, teacher.getSalary());
            preStatement.setInt(2, teacher.getPosition().getPosition_id());
            preStatement.setInt(3, 1);
            preStatement.setInt(4, teacher.getPerson_id());

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

    public void remove(Teacher teacher) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM TEACHER WHERE teacher_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, teacher.getPerson_id());
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

    public boolean existParentTable(Teacher teacher) throws SQLException {
        boolean flag = false;
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementSelect = null;
        String sql_select = "SELECT person_id FROM PERSON WHERE person_id=?";
        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementSelect.setInt(1, teacher.getPerson_id());
            ResultSet resultSet = statementSelect.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("person_id") == teacher.getPerson_id()) {
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

    Position getPositionByIdFromDB(int position_id) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatementPosition = null;
        String sql_select_position = "SELECT position_id, position FROM POSITIONS WHERE position_id=?";
        preStatementPosition = connection.prepareStatement(sql_select_position);
        preStatementPosition.setInt(1, position_id);
        ResultSet resultSetPosition = preStatementPosition.executeQuery();
        Position position = new Position();

        while (resultSetPosition.next()) {
            position.setPosition_id(resultSetPosition.getInt("position_id"));
            position.setPosition(resultSetPosition.getString("position"));
        }
        return position;
    }
}
