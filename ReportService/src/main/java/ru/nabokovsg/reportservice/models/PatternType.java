package ru.nabokovsg.reportservice.models;

import java.util.Optional;

public enum PatternType {

    FILTER,
    PIPELINE,
    TANK_VERTICAL,
    TANK_HORIZONTAL,
    BOILER;

    public static Optional<PatternType> from(String stringPatternType) {
        for (PatternType patternType : values()) {
            if (patternType.name().equalsIgnoreCase(stringPatternType)) {
                return Optional.of(patternType);
            }
        }
        return Optional.empty();
    }
}
