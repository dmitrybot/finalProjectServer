package ru.shinepilates.finalprojectserver.exeptions;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
