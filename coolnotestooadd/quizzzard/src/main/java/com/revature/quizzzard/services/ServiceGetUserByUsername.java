package com.revature.quizzzard.services;

import com.revature.quizzzard.exceptions.AuthExceptions;
import dev.josiah.complaintDepartment.AuthExceptions;
import com.revature.quizzzard.daos.UserDAO;
import com.revature.quizzzard.entities.User;

import java.util.ArrayList;

public class ServiceGetUserByUsername {
    // set anything to null to remove validation for it
    final private static Integer maxLen = 255; // Database constraint for longest possible username
    final private static String userMustEndWith = "@revature.net";
    final private static String userMustStartWith = null;
    final private static ArrayList<String> userCannotContain = null;


    public static User ServiceUsernameRequest(String username_feed, UserDAO userDAO) {
        validateUsername(username_feed);
        return userDAO.getUserByUsername(username_feed);
    }
    private static void validateUsername(String username_feed) {
        if (username_feed == null) {
            throw new AuthExceptions.InputWasNull("Username was null");
            // Shouldn't ever happen. Servlet won't call this if username param is null
        }
        if (username_feed.length() > maxLen) {
            throw new AuthExceptions.ValueOutOfRange("Username length was " + username_feed.length() +
                    ", expected value to be <= " + maxLen);
        }
        if (!username_feed.endsWith(userMustEndWith)) {
            //UsernameFormatException
            throw new AuthExceptions.UsernameFormatException("Username must end with " + userMustEndWith +
                    ", but username entered was " + username_feed);
        }

    }
}
