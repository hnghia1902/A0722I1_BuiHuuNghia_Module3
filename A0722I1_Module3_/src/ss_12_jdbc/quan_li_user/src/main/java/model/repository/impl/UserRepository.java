package model.repository.impl;

import model.User;
import model.repository.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String ALL_USER = "SELECT * FROM demo.users";
    private static final String Create_User = "insert into demo.users(name, email, country) value(?,?,?)";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from demo.users where id =?";
    private static final String UPDATE_USERS_SQL = "update demo.users set name = ?,email= ?, country =? where id = ?;";
    private static final String FIND_USERS_BY_COUNTRY = "select * from demo.users where country like (?);";
    private static final String SORT_USERS_BY_NAME = "select * from demo.users order by name asc;";
    private static final String DELETE_USERS_SQL = "delete from demo.users where id = ?;";
    
    public List<User> showListUser() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        if (connection != null){
            try {
                statement = connection.prepareStatement(ALL_USER);
                resultSet = statement.executeQuery();

                User user = null;
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id,name,email,country);
                    userList.add(user);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                    DBConnection.close();
            }
        }

        return userList;
    }

    @Override
    public void create(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(Create_User);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());

                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public User selectUser(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(SELECT_USER_BY_ID);
                statement.setInt(1,id);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id,name, email, country);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(UPDATE_USERS_SQL);
                statement.setString(1,user.getName());
                statement.setString(2,user.getEmail());
                statement.setString(3,user.getCountry());
                statement.setInt(4,user.getId());
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<User> selectUser_by_country(String country) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        if (connection != null){
            try {
                statement =connection.prepareStatement(FIND_USERS_BY_COUNTRY);
                statement.setString(1,"%"+country);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country1 = resultSet.getString("country");

                    User user = new User(id,name, email, country1);
                    userList.add(user);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return userList;
    }

    @Override
    public List<User> sort() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        if (connection != null) {
            try {
                statement =connection.prepareStatement(SORT_USERS_BY_NAME);
                resultSet = statement.executeQuery();
                User user;
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                    userList.add(user);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return userList;
    }

    @Override
    public void deleteUser(int id) {
        boolean rowDeleted = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_USERS_SQL);
                statement.setInt(1,id);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }
}
