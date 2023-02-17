package ru.nabokovsg.adminservice.models.reports;

import java.util.Optional;

public enum Status {

    WAITING,
    WORK,
    COMPLETED,
    PRINT,
    PASSED;

    public static Optional<Status> from(String stringStatus) {
        for (Status status : values()) {
            if (status.name().equalsIgnoreCase(stringStatus)) {
                return Optional.of(status);
            }
        }
        return Optional.empty();
    }
}
