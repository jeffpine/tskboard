package org.pinedev.tskboard.service;

import lombok.AllArgsConstructor;
import org.pinedev.tskboard.persistence.dao.BoardColumnDAO;
import org.pinedev.tskboard.persistence.dao.BoardDAO;
import org.pinedev.tskboard.persistence.entity.BoardEntity;

import java.sql.Connection;
import java.sql.SQLException;

@AllArgsConstructor
public class BoardService {

    private final Connection connection;

    public BoardEntity insert(final BoardEntity entity) throws SQLException {
        var dao = new BoardDAO(connection);
        var boardColumnDao = new BoardColumnDAO(connection);
        try{
            dao.insert(entity);
            var columns = entity.getBoardsColumns().stream().map(c -> {
                c.setBoard(entity);
                return c;
            }).toList();
            for (var column : columns) {
                boardColumnDao.insert(column);
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
        return entity;
    }

    public boolean delete(final Long id) throws SQLException {
        var dao = new BoardDAO(connection);
        try {
           if (!dao.exixts(id)) {
               return false;
           }
               dao.delete(id);
               connection.commit();
               return true;
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
}
}
