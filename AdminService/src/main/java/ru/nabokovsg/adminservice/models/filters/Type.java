package ru.nabokovsg.adminservice.models.filters;
import java.util.Optional;

public enum Type {

    OIL,
    WATER,
    GAS;

    public static Optional<Type> from(String stringType) {
        for (Type type : values()) {
            if (type.name().equalsIgnoreCase(stringType)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }
}
