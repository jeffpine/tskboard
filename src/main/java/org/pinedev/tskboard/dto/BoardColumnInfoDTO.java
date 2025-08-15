package org.pinedev.tskboard.dto;

import org.pinedev.tskboard.persistence.entity.BoardColumnKindEnum;

public record BoardColumnInfoDTO(Long id, int order, BoardColumnKindEnum kind) {
}