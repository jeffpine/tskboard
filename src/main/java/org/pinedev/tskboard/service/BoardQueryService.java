package org.pinedev.tskboard.service;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.util.Optional;

@AllArgsConstructor
public class BoardQueryService {

    private final Connection connection;

    public Optional<BoardEntity>
