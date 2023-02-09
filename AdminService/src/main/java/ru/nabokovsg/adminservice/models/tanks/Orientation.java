package ru.nabokovsg.adminservice.models.tanks;

import java.util.Optional;

public enum Orientation {

    VERTICAL,
    HORIZONTAL;

    public static Optional<Orientation> from(String stringOrientation) {
        for (Orientation orientation : values()) {
            if (orientation.name().equalsIgnoreCase(stringOrientation)) {
                return Optional.of(orientation);
            }
        }
        return Optional.empty();
    }
}
