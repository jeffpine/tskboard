package org.pinedev.tskboard;

import org.pinedev.tskboard.persistence.migrations.MigrationStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

import static org.pinedev.tskboard.persistence.config.ConnectionConfig.getConnection;


@SpringBootApplication
public class TskboardApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(TskboardApplication.class, args);
		try (var connection = getConnection()){
			new MigrationStrategy(connection).executeMigration();
		}

	}

}
