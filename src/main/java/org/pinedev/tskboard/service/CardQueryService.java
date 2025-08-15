package org.pinedev.tskboard.service;

import lombok.AllArgsConstructor;
import org.pinedev.tskboard.dto.CardDetailsDTO;
import org.pinedev.tskboard.persistence.dao.CardDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class CardQueryService {

    private final Connection connection;

    public Optional<CardDetailsDTO> findById(final Long id) throws SQLException {
        var dao = new CardDAO(connection);
        return dao.findById(id);
    }

}