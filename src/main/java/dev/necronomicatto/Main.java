package dev.necronomicatto;


import dev.necronomicatto.persistence.migration.MigrationStrategy;

import java.sql.SQLException;

import static dev.necronomicatto.persistence.config.ConnectionConfig.getConnection;

public class Main {
    public static void main(String[] args){
        try(var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
