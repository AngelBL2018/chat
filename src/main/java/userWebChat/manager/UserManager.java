package userWebChat.manager;

import userWebChat.db.DBConnector;
import userWebChat.model.User;

import java.awt.geom.RectangularShape;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class UserManager {
    private Connection connection = DBConnector.getDBConnector().getConnection();

    public List<User> getAllUsers() {
        List<User> allUsers = new LinkedList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user;");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setPicUrl(resultSet.getString("pic_url"));
                allUsers.add(user);
            }

        } catch (SQLException e) {
        }
        return allUsers;
    }

    public User getUserByEmailPassword(String email,String password){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
               preparedStatement.setString(1,email);
               preparedStatement.setString(2,password);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setPicUrl(resultSet.getString("pic_url"));
                    return user;
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(`name`,surname,email,password,pic_url) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
  preparedStatement.setString(1,user.getName());
  preparedStatement.setString(2,user.getSurname());
  preparedStatement.setString(3,user.getEmail());
  preparedStatement.setString(4,user.getPassword());
  preparedStatement.setString(5,user.getPicUrl());
  preparedStatement.executeUpdate();
  ResultSet resultSet = preparedStatement.getGeneratedKeys();
  if (resultSet.next()){
      int id = resultSet.getInt(1);
      user.setId(id);
  }

    }
}
