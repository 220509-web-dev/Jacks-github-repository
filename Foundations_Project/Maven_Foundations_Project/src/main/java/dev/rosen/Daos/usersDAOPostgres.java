package dev.rosen.Daos;

import dev.rosen.Utilities.ConnectionUtil;
import dev.rosen.Model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class usersDAOPostgres {

    @Override
    public Users createUser(Users users) {
        return null;
    }

    @Override
    public dev.rosen.Model.Users createUser(dev.rosen.Model.Users users) {
        return null;
    }

    @Override
    public dev.rosen.Model.Users getUsersById(int id) {


        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "select * from users where user_id = ?";
            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ps.setInt(1, id);
            ResultSet rs = null;
            try {
                rs = ps.executeQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            rs.next();

            Users users = new Users();
            usersDAOPostgres.setUsersId(id);
            usersDAOPostgres.setusername(rs.getString("title"));
            usersDAOPostgres.setpassword(rs.getString("author"));
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private static void setUsersId(int id) {
    }

    private static void setpassword(String author) {
    }

    private static void setusername(String title) {
    }


    @Override
    public List<Users> getALLUsers() {
        return null;
    }

    @Override
    public dev.rosen.Model.Users updateUsers(dev.rosen.Model.Users users) {
        return null;
    }

    @Override
    public Users updateUsers(Users users) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "update users set username = ?, password = ? where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, users.getusername());
            ps.setString(2, users.getpassword());
            ps.setInt(4,users.get.usersId());

            ps.execute();

            return users;

        } catch (SQLException exception)  {
            exception.printStackTrace();
        }


        return null;
    }

    @Override
    public void deleteBookByid(int id) {

        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "delete from users where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException exception) {
        }  (SQLException Throwable e;
        e) {
            throw new RuntimeException(e);
        } ;
        System.out.println();
    }




}
