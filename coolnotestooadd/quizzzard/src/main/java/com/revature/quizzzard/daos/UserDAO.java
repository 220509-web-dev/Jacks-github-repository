package com.revature.quizzzard.daos;

import com.revature.quizzzard.entities.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    User createUser(User newUser);
}
