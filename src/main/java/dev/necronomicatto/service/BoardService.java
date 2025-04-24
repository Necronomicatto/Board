package dev.necronomicatto.service;

import lombok.AllArgsConstructor;
import java.sql.Connection;

@AllArgsConstructor
public class BoardService {
    private final Connection connection;
    public boolean delete(final Long id) throws SQLException {
        var dao = new BoardDAO(connection);
        try{
            if (!dao.exists(id)){
                return false;
            }
            dao.delete(id);
            connection.commit();
            return true;
        } catch (SQLException) {
            connection.rollback();
            throw e;
        }
    }
}
