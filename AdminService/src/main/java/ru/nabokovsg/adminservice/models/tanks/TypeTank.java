package ru.nabokovsg.adminservice.models.tanks;

import java.util.Optional;

public enum TypeTank {

    BATTERY_TANK,
    OIL_TANK,
    DEAERATOR;

    public static Optional<TypeTank> from(String stringTypeTank) {
        for (TypeTank typeTank : values()) {
            if (typeTank.name().equalsIgnoreCase(stringTypeTank)) {
                return Optional.of(typeTank);
            }
        }
        return Optional.empty();
    }
}
