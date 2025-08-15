package org.pinedev.tskboard.persistence.dao;

import com.mysql.cj.jdbc.StatementImpl;
import lombok.RequiredArgsConstructor;
import org.pinedev.tskboard.persistence.entity.BoardColumnEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class BoardColumnDAO {

    private final Connection connection;

    public BoardColumnEntity insert(final BoardColumnEntity entity) throws SQLException {
        var sql = "INSERT INTO BOARDS_COLUMNS (name, `order`, kind, board_id) VALUES (?, ?, ?, ?);";
    try(var statement = connection.prepareStatement(sql)){
      var i = 1;
      statement.setString(i ++, entity.getName());
      statement.setInt(i ++, entity.getOrder());
      statement.setString(i ++, entity.getKind().name());
      statement.setLong(i, entity.getBoard().getId());
      statement.executeUpdate();
      if (statement instanceof StatementImpl impl){
          entity.setId(impl.getLastInsertID());
      }
      return entity;
    }

}

    public List<BoardColumnEntity> findByBoardId(Long id) throws SQLException {
        return null;
    }
}
