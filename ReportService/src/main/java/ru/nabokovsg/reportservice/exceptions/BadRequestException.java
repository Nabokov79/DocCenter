package ru.nabokovsg.reportservice.exceptions;
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
