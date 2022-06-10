package com.revature.quizzzard.servlets;

import com.revature.quizzzard.daos.UserDAO;
import com.revature.quizzzard.daos.UserDAOPostgres;
import com.revature.quizzzard.daos.UserPrivDAO;
import com.revature.quizzzard.daos.UserPrivDaoPostgres;
import com.revature.quizzzard.entities.User;
import com.revature.quizzzard.entities.UserPriv;
import com.revature.quizzzard.utils.ConnectionFactory;
import com.revature.quizzzard.utils.ConnectionUtil;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

// registered in web.xml
public class LoginHandler  extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("Servlet is being initialized");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter writer = response.getWriter();
        writer.println("<html>Hello, I am a Java servlet!</html>");
        writer.flush();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String paramUsername = request.getParameter("username");
        String paramPassword = request.getParameter("password");
        //ConnectionFactory connection = ConnectionFactory.getInstance();
        /**/
        UserPass userPass = new UserPass(paramUsername, paramPassword);


        UserDAO userDAO = new UserDaoPostgres();
        User u = userDAO.getUserByUsername(paramUsername);
        String user_info = "";
        if (u == null) user_info = "User not found!";
        else {
            UserPrivDAO pDAO = new UserPrivDaoPostgres();
            UserPriv up = pDAO.getUserInfoById(u.getUser_id());
            UserPriv entered = new UserPriv();
            entered.encryptAndSetPassword(paramPassword);
            if (up.getPassword().equals(entered.getPassword())) {
                user_info = "Logging in as " + paramUsername;
            } else user_info = "Incorrect Password";
        }

        PrintWriter writer = response.getWriter();
        String Return = "<html>Data Entered: <br/>Username : " + paramUsername;
        Return += "<br/>Password : " + paramPassword;
        Return += "<br/>"+user_info+"</html>";
        writer.println(Return);
        writer.flush();



    }


    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
}
