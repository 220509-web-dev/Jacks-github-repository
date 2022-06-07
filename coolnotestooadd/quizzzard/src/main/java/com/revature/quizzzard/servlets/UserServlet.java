package com.revature.quizzzard.servlets;

import com.revature.quizzzard.daos.UserDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.quizzzard.entities.User;
import com.revature.quizzzard.utils.CustomLogger;
import com.revature.quizzzard.utils.LogLevel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UserServlet extends HttpServlet {

    private final ObjectMapper mapper;
    private final UserDAO userDAO;
    private String logString;

    public UserServlet(ObjectMapper mapper, UserDAO userdao) {
        this.mapper = mapper;
        this.userDAO = userdao;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - UserServlet start");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logString = "UserServlet received a get request at - " + LocalDateTime.now();
        CustomLogger.log(logString, LogLevel.INFO);
        List<User> userList = userDAO.getAllUsers();
        System.out.println("request= " + req);


        String username = req.getParameter("username");

        try {
            int userId = Integer.parseInt(req.getParameter("id"));
            userList = userList.stream().filter(user -> user.getId() == userId).collect(Collectors.toList());

        } catch (NumberFormatException e) {
            logString = "Null or invalid ID input";
            CustomLogger.log(logString, LogLevel.ERROR);
        }


        if (username != null) {
            userList = userList.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
        }


        String result = mapper.writeValueAsString(userList);
        resp.setContentType("application/json");
        resp.getWriter().write(result);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logString = "UserServlet received a post request at - " + LocalDateTime.now();
        CustomLogger.log(logString, LogLevel.INFO);

        try {
            List<User> users = userDAO.getAllUsers();
            User newUser = mapper.readValue(req.getInputStream(), User.class);
            for (User user : users) {
                if (newUser.getPassword().equals(user.getPassword())) {
                    logString = "Password already exists, please choose again - " + LocalDateTime.now();
                    CustomLogger.log(logString, LogLevel.ERROR);

                    System.err.println("[ERROR] - password taken.");
                } else if (newUser.getUsername().equals(user.getUsername())) {
                    logString = "Username taken, please insert a different username - " + LocalDateTime.now();
                    CustomLogger.log(logString, LogLevel.ERROR);

                    System.err.println("[ERROR] - Username taken, please insert a different username.");
                } else {
                    userDAO.
                            createUser(newUser);
                }
            }


        } catch (Exception e) {
            logString = "error for User. More Information: %s";
            CustomLogger.log(logString, LogLevel.INFO);
            e.printStackTrace();
        }
        resp.setStatus(204);

    }


}
