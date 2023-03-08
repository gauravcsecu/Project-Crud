package com.example.latestapplication.user;

public class UserNotFoundException extends  Throwable {

    public UserNotFoundException(String message) {
         super(message);
    }
}
