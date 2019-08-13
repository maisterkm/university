package ua.com.foxminded.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Faculties;
import ua.com.foxminded.university.domain.entity.Group;

public class GroupDAO implements DAO<Group> {
    public void add(Group group) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO GRUP (group_id, groupnumber, faculty_id) VALUES (?, ?, ?)";
        String sql_select = "SELECT * FROM GRUP WHERE group_id=?";

        try {
            statementSelect = connection.prepareStatement(sql_select);
            statementInsert = connection.prepareStatement(sql_insert);
            statementSelect.setInt(1, group.getGroup_id());

            ResultSet resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("group_id") == group.getGroup_id()) {
                    System.out.println("group_id=" + group.getGroup_id() + " is already in the table GROUP");
                    return;
                }
            }
            statementInsert.setInt(1, group.getGroup_id());
            statementInsert.setString(2, group.getGroupNumber());
            statementInsert.setInt(3, group.getFaculty_id());

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

    public List<Group> getAll() throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        List<Group> groupList = new ArrayList<Group>();
        String sql_select_grup = "SELECT group_id, groupnumber, faculty_id FROM GRUP";
        String sql_select_faculty = "SELECT faculty_id, faculty FROM FACULTIES WHERE faculty_id=?";
        Statement statement_grup = null;
        PreparedStatement statement_faculty = null;
        try {
            statement_grup = connection.createStatement();
            ResultSet resultSet_grup = statement_grup.executeQuery(sql_select_grup);
            while (resultSet_grup.next()) {
                Group group = new Group();
                Faculties faculty = new Faculties();
                statement_faculty = connection.prepareStatement(sql_select_faculty);
                group.setGroup_id(resultSet_grup.getInt("group_id"));
                group.setGroupNumber(resultSet_grup.getString("groupnumber"));
                statement_faculty.setInt(1, resultSet_grup.getInt("faculty_id"));
                ResultSet resultSet_faculty = statement_faculty.executeQuery();
                while (resultSet_faculty.next()) {
                    if (resultSet_faculty.getInt("faculty_id") == resultSet_grup.getInt("faculty_id")) {
                        faculty.setFaculty_id(resultSet_faculty.getInt("faculty_id"));
                        faculty.setFaculty(resultSet_faculty.getString("faculty"));
                        break;
                    }
                }
                group.setFaculty(faculty);
                groupList.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement_grup != null) {
                statement_grup.close();
            }
            if (statement_faculty != null) {
                statement_faculty.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return groupList;
    }

    public Group getById(Integer group_id) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT group_id, groupnumber, faculty_id FROM GRUP WHERE group_id = ?";
        Group group = new Group();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, group_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                group.setGroup_id(resultSet.getInt("group_id"));
                group.setGroupNumber(resultSet.getString("groupnumber"));
                FacultiesDAO facultiesDAO = new FacultiesDAO();
                group.setFaculty(facultiesDAO.getById(resultSet.getInt("faculty_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return group;
    }

    public void update(Group group) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        String sql_update = "UPDATE GRUP SET groupnumber=?, faculty_id=? WHERE group_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql_update);
            preparedStatement.setString(1, group.getGroupNumber());
            preparedStatement.setInt(2, group.getFaculty_id());
            preparedStatement.setInt(3, group.getGroup_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void remove(Group group) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM GRUP WHERE group_id=?";
        try {
            preStatement = connection.prepareStatement(sql_delete);
            preStatement.setInt(1, group.getGroup_id());
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
}
