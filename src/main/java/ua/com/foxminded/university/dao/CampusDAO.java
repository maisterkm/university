package ua.com.foxminded.university.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Campus;

public class CampusDAO implements DAO<Campus> {

    public void add(Campus campus) {
        Handler handler = new Handler();
        // Handler handlerInsert = new Handler();
        PreparedStatement statementInsert = null;
        PreparedStatement statementSelect = null;
        String sql_insert = "INSERT INTO CAMPUS (campus_id, campus) VALUES (?, ?)";
        String sql_select = "SELECT * FROM CAMPUS WHERE campus_id=?";
        try {
            statementSelect = handler.getPreparedStatement(sql_select);
            statementSelect.setInt(1, campus.getCampus_id());
            ResultSet resultSetSelect = handler.getPreparedResultSet();
            while (resultSetSelect.next()) {
                if (resultSetSelect.getInt("campus_id") == campus.getCampus_id()) {
                    System.out.println("campus_id=" + campus.getCampus_id() + " is already in the table CAMPUS");
                    return;
                }
            }
            statementInsert = handler.getPreparedStatement(sql_insert);
//            statementInsert = handlerInsert.getPreparedStatement(sql_insert);
            statementInsert.setInt(1, campus.getCampus_id());
            statementInsert.setString(2, campus.getCampus());
            statementInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        handler.close();
//        handlerInsert.close();
    }

//    public void add(Campus campus) {
//        DBConnector dbConnection = new DBConnector();
//        Connection connection = dbConnection.getConnection();
//        PreparedStatement statementInsert = null;
//        PreparedStatement statementSelect = null;
//        String sql_insert = "INSERT INTO CAMPUS (campus_id, campus) VALUES (?, ?)";
//        String sql_select = "SELECT * FROM CAMPUS WHERE campus_id=?";
//
//        try {
//            statementSelect = connection.prepareStatement(sql_select);
//            statementInsert = connection.prepareStatement(sql_insert);
//            statementSelect.setInt(1, campus.getCampus_id());
//
//            ResultSet resultSet = statementSelect.executeQuery();
//            while (resultSet.next()) {
//                if (resultSet.getInt("campus_id") == campus.getCampus_id()) {
//                    System.out.println("campus_id=" + campus.getCampus_id() + " is already in the table CAMPUS");
//                    return;
//                }
//            }
//            statementInsert.setInt(1, campus.getCampus_id());
//            statementInsert.setString(2, campus.getCampus());
//
//            statementInsert.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (statementInsert != null) {
//                    statementInsert.close();
//                }
//                if (statementSelect != null) {
//                    statementSelect.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public List<Campus> getAll() {
        Handler handler = new Handler();
        List<Campus> campusList = new ArrayList<Campus>();
        String sql = "SELECT campus_id, campus FROM CAMPUS";
        Statement statement = null;
        try {
            statement = handler.getStatement();
            ResultSet resultSet = handler.getResultSet(sql);

            while (resultSet.next()) {
                Campus campus = new Campus();
                campus.setCampus_id(resultSet.getInt("campus_id"));
                campus.setCampus(resultSet.getString("campus"));

                campusList.add(campus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        handler.close();
        return campusList;
    }

//    public List<Campus> getAll() {
//        DBConnector dbConnection = new DBConnector();
//        Connection connection = dbConnection.getConnection();
//        List<Campus> campusList = new ArrayList<Campus>();
//        String sql = "SELECT campus_id, campus FROM CAMPUS";
//        Statement statement = null;
//
//        try {
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                Campus campus = new Campus();
//                campus.setCampus_id(resultSet.getInt("campus_id"));
//                campus.setCampus(resultSet.getString("campus"));
//
//                campusList.add(campus);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (statement != null) {
//                    statement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return campusList;
//    }

    public Campus getById(Integer campus_id) {
        Handler handler = new Handler();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT campus_id, campus FROM CAMPUS WHERE campus_id = ?";
        Campus campus = new Campus();

        try {
            preparedStatement = handler.getPreparedStatement(sql);
            preparedStatement.setInt(1, campus_id);

            ResultSet resultSet = handler.getPreparedResultSet();
            while (resultSet.next()) {
                campus.setCampus_id(resultSet.getInt("campus_id"));
                campus.setCampus(resultSet.getString("campus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        handler.close();
        return campus;
    }

//    public Campus getById(Integer campus_id) {
//        DBConnector dbConnection = new DBConnector();
//        Connection connection = dbConnection.getConnection();
//        PreparedStatement preparedStatement = null;
//        String sql = "SELECT campus_id, campus FROM CAMPUS WHERE campus_id = ?";
//        Campus campus = new Campus();
//
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, campus_id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                campus.setCampus_id(resultSet.getInt("campus_id"));
//                campus.setCampus(resultSet.getString("campus"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return campus;
//    }

    public void update(Campus campus) {
        Handler handler = new Handler();
        PreparedStatement preparedStatement = null;
        String sql_update = "UPDATE CAMPUS SET campus=? WHERE campus_id=?";

        try {
            preparedStatement = handler.getPreparedStatement(sql_update);
            preparedStatement.setString(1, campus.getCampus());
            preparedStatement.setInt(2, campus.getCampus_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        handler.close();
    }

//    public void update(Campus campus) {
//        DBConnector dbConnection = new DBConnector();
//        Connection connection = dbConnection.getConnection();
//        PreparedStatement preparedStatement = null;
//        String sql_update = "UPDATE CAMPUS SET campus=? WHERE campus_id=?";
//
//        try {
//            preparedStatement = connection.prepareStatement(sql_update);
//            preparedStatement.setString(1, campus.getCampus());
//            preparedStatement.setInt(2, campus.getCampus_id());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public void remove(Campus campus) {
        Handler handler = new Handler();
        PreparedStatement preStatement = null;
        String sql_delete = "DELETE FROM CAMPUS WHERE campus_id=?";
        try {
            preStatement = handler.getPreparedStatement(sql_delete);
            preStatement.setInt(1, campus.getCampus_id());
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        handler.close();
    }

//    public void remove(Campus campus) {
//        DBConnector dbConnection = new DBConnector();
//        Connection connection = dbConnection.getConnection();
//        PreparedStatement preStatement = null;
//        String sql_delete = "DELETE FROM CAMPUS WHERE campus_id=?";
//        try {
//            preStatement = connection.prepareStatement(sql_delete);
//            preStatement.setInt(1, campus.getCampus_id());
//            preStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preStatement != null) {
//                    preStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
