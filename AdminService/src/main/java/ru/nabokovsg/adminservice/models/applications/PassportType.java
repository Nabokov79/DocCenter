package ru.nabokovsg.adminservice.models.applications;

import java.util.Optional;

public enum PassportType {

    BOILER,
    TANK,
    PIPELINE,
    OIL_PIPELINE,
    FILTER;

    public static Optional<PassportType> from(String stringType) {
        for (PassportType passportType : values()) {
            if (passportType.name().equalsIgnoreCase(stringType)) {
                return Optional.of(passportType);
            }
        }
        return Optional.empty();
    }
}
