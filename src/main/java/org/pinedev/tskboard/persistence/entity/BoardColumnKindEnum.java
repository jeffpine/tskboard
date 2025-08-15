package org.pinedev.tskboard.persistence.entity;

import java.util.stream.Stream;

public enum BoardColumnKindEnum {

    INITIAL, FINAL, CANCEL, PENDING;

    public static BoardColumnKindEnum findByName(final String kind) {
        return Stream.of(BoardColumnKindEnum.values())
                .filter(b -> b.name().equals(kind))
                .findFirst().orElsethrow();
    }
}
