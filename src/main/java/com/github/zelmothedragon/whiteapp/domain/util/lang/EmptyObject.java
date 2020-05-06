package com.github.zelmothedragon.whiteapp.domain.util.lang;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Fourni des représentations vide d'objet immuable.
 *
 * @author MOSELLE Maxime
 */
public final class EmptyObject {

    /**
     * Identifiant unique vide.
     */
    public static final UUID EMPTY_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    /**
     * Date vide.
     */
    public static final LocalDateTime EMPTY_DATE_TIME = LocalDateTime.parse("0000-01-01T00:00:00");

    /**
     * Constructeur interne. Pas d'instanciation.
     */
    private EmptyObject() {
        throw new IllegalStateException("No instances for you!");
    }

}
