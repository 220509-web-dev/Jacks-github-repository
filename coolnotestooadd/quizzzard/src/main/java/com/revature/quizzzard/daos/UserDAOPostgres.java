package com.revature.quizzzard.daos;

import com.revature.quizzzard.entities.User;
import com.revature.quizzzard.utils.ConnectionUtil;
import com.revature.quizzzard.utils.MyLogger;
import com.revature.quizzzard.utils.LogLevel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOPostgres implements UserDAO {
    String logString;


    public User createUser(User user) {
        try(Connection connection = ConnectionUtil.getConnection()) {
            logString = "Attempting to create user.";
            MyLogger.log(logString, LogLevel.INFO);
            String sql = "insert into forum_app.app_users (username, password) values(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());

            ps.execute();


            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedID = rs.getInt("id");

            user.setId(generatedID);// the book id changing for 0 to a non-zero values means that it is saved
            logString = "Created user successfully!";
            MyLogger.log(logString, LogLevel.INFO);
            MyLogger.parser();
            return user;

        } catch (SQLException exception) {
            logString = String.format("An error occurred while creating a User. More Information: %s");
            MyLogger.log(logString, LogLevel.ERROR);
            MyLogger.parser();
            exception.printStackTrace();
        }
        return null;
    }


    public User getUserById(int id) {
        try (Connection connection = ConnectionUtil.getConnection()){
            logString = "Attempting to retrieve post by User.";
            MyLogger.log(logString, LogLevel.INFO);
            String sql = "select * from app-users where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            rs.next();

            User user = new User();
            user.setId(id);
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            logString = "Retrieved User successfully!.";
            MyLogger.log(logString, LogLevel.INFO);
            MyLogger.parser();
            return user;

        } catch (SQLException exception){
            logString = String.format("User Null: User ID: %d not found.", id);
            MyLogger.log(logString,LogLevel.ERROR);
            MyLogger.parser();
            System.err.println("Exception: User ID: " + id + " not found.");
        }
        return null;
    }


    public User getUserByUser(String username) {
        try (Connection connection = ConnectionUtil.getConnection()){
            logString = "Attempting to retrieve User by Username.";
            MyLogger.log(logString, LogLevel.INFO);
            String sql = "select * from forum_app.app_users where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();

            //Get First Record
            rs.next();

            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            logString = "found user.";
            MyLogger.log(logString, LogLevel.INFO);
            MyLogger.parser();
            return user;

        } catch (SQLException exception){
            logString = String.format("user not fount: Username: %d not found.", username);
            MyLogger.log(logString,LogLevel.ERROR);
            MyLogger.parser();
            System.err.println("Exception: Username: " + username + " not found.");
        }
        return null;
    }


    public List<User> getAllUsers() {
        try(Connection connection = ConnectionUtil.getConnection()){
            logString = "Getting all users";
            MyLogger.log(logString, LogLevel.INFO);
            String sql = "select * from forum_app.app_users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<User> users = new ArrayList<User>();

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            logString = "got all users";
            MyLogger.log(logString, LogLevel.INFO);
            MyLogger.parser();
            return users;
        } catch (SQLException exception) {
            logString = String.format("Error while getting users More information: %s");
            MyLogger.log(logString, LogLevel.ERROR);
            MyLogger.parser();
            exception.printStackTrace();
        }
        return null;
    }


    public User updateUser(User user) {
        try(Connection connection = ConnectionUtil.getConnection()) {
            logString = "Attempting to update a User.";
            MyLogger.log(logString, LogLevel.INFO);
            String sql = "update forum_app.app_users set first_name = ?, last_name = ?, email = ? , username = ?, password = ?, profile_pic = ?, role_id = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.execute();

            logString = "User updated successfully.";
            MyLogger.log(logString, LogLevel.INFO);
            MyLogger.parser();
            return user;
        } catch (SQLException exception) {
            logString = "User not found.";
            MyLogger.log(logString, LogLevel.ERROR);
            MyLogger.parser();
            System.err.println("Exception: User not found to update.");
            exception.printStackTrace();
        }
        return null;
    }


    public void deleteUserById(int id) {
        try(Connection connection = ConnectionUtil.getConnection()) {
            logString = "Attempting to delete a User.";
            MyLogger.log(logString, LogLevel.INFO);
            String sql = "delete from forum_app.app_users where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            logString = "User deleted successfully.";
            MyLogger.log(logString, LogLevel.INFO);
            MyLogger.parser();
        } catch (SQLException exception) {
            logString = "User not found.";
            MyLogger.log(logString, LogLevel.ERROR);
            MyLogger.parser();
            System.err.println("Exception: User not found to delete.");
            exception.printStackTrace();
        }
    }
}
