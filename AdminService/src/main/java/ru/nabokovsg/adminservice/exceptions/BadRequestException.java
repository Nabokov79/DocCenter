package ru.nabokovsg.adminservice.exceptions;
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
