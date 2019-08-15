package ua.com.foxminded.university.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Campus;

public class CampusDAO implements Dao<Campus> {

    public void create(Campus campus) {
        Handler handler = new Handler();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO CAMPUS (campus_id, campus) VALUES (?, ?)";
        String sql_select = "SELECT * FROM CAMPUS WHERE campus_id=?";
        try {
            statementSelect = handler.getPreparedStatement(sql_select);
            statementSelect.setInt(1, campus.getCampusId());
            ResultSet resultSetSelect = handler.getPreparedResultSet();
            while (resultSetSelect.next()) {
                if (resultSetSelect.getInt("campus_id") == campus.getCampusId()) {
                    System.out.println("campus_id=" + campus.getCampusId() + " is already in the table CAMPUS");
                    return;
                }
            }
            statementInsert = handler.getPreparedStatement(sql_insert);
            statementInsert.setInt(1, campus.getCampusId());
            statementInsert.setString(2, campus.getCampus());
            statementInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        handler.close();
    }

    public List<Campus> read() {
        Handler handler = new Handler();
        List<Campus> campusList = new ArrayList<Campus>();
        String sql = "SELECT campus_id, campus FROM CAMPUS";
        Statement statement = null;
        try {
            statement = handler.getStatement();
            ResultSet resultSet = handler.getResultSet(sql);

            while (resultSet.next()) {
                Campus campus = new Campus();
                campus.setCampusId(resultSet.getInt("campus_id"));
                campus.setCampus(resultSet.getString("campus"));

                campusList.add(campus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        handler.close();
        return campusList;
    }

    public Campus readById(Integer campus_id) {
        Handler handler = new Handler();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT campus_id, campus FROM CAMPUS WHERE campus_id = ?";
        Campus campus = new Campus();

        try {
            preparedStatement = handler.getPreparedStatement(sql);
            preparedStatement.setInt(1, campus_id);

            ResultSet resultSet = handler.getPreparedResultSet();
            while (resultSet.next()) {
                campus.setCampusId(resultSet.getInt("campus_id"));
                campus.setCampus(resultSet.getString("campus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        handler.close();
        return campus;
    }

    public void update(Campus campus) {
        Handler handler = new Handler();
        PreparedStatement preparedStatement = null;
        String sql_update = "UPDATE CAMPUS SET campus=? WHERE campus_id=?";

        try {
            preparedStatement = handler.getPreparedStatement(sql_update);
            preparedStatement.setString(1, campus.getCampus());
            preparedStatement.setInt(2, campus.getCampusId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        handler.close();
    }

    public void delete(Campus campus) {
        Handler handler = new Handler();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM CAMPUS WHERE campus_id=?";
        try {
            preStatement = handler.getPreparedStatement(sql_delete);
            preStatement.setInt(1, campus.getCampusId());
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        handler.close();
    }
}
