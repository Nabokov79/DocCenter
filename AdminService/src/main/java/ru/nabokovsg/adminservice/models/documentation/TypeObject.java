package ru.nabokovsg.adminservice.models.documentation;

import java.util.Optional;

public enum TypeObject {

    OIL_FILTER,
    OIL_PIPELINE,
    PIPELINE,
    TANK,
    BOILER;

    public static Optional<TypeObject> from(String stringTypeObject) {
        for (TypeObject typeObject : values()) {
            if (typeObject.name().equalsIgnoreCase(stringTypeObject)) {
                return Optional.of(typeObject);
            }
        }
        return Optional.empty();
    }
}
