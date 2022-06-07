package com.revature.quizzzard.daos;

import com.revature.quizzzard.utils.ConnectionUtil;
import com.revature.quizzzard.utils.CustomLogger;
import com.revature.quizzzard.utils.LogLevel;

import java.sql.*;
import java.util.List;

public class PostDAOPostgres implements PostDAO {
    String logString;


    @Override
    public Post createPost(Post post) {
        return null;
    }

    @Override
    public Post getPostById(int id) {
        return null;
    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post updatePost(Post post) {
        try(Connection connection = ConnectionUtil.getConnection()) {
            logString = "Attempting to update a post.";
            CustomLogger.log(logString, LogLevel.INFO);
            String sql = "update forum_app.app_posts set title = ?, description = ?, thumbnail_url = ?, video_url = ?, owner_id = ?, category_id = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(7, post.getId());

            ps.execute();

            logString = "Post updated successfully.";
            CustomLogger.log(logString, LogLevel.INFO);
            CustomLogger.parser();
            return post;
        } catch (SQLException exception) {
            logString = "Post not found.";
            CustomLogger.log(logString, LogLevel.ERROR);
            CustomLogger.parser();
            System.err.println("Exception: Post not found to update.");
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletePostById(int id) {
        try(Connection connection = ConnectionUtil.getConnection()) {
            logString = "deleted post";
            CustomLogger.log(logString, LogLevel.INFO);
            String sql = "delete from table-creator.app_posts where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            logString = "Post deleted .";
            CustomLogger.log(logString, LogLevel.INFO);
            CustomLogger.parser();
        } catch (SQLException exception) {
            logString = "Post null.";
            CustomLogger.log(logString, LogLevel.ERROR);
            CustomLogger.parser();
            System.err.println("Exception: null");
            exception.printStackTrace();
        }
    }
}
