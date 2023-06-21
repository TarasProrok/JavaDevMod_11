package services;

import org.flywaydb.core.Flyway;

public class FlywayMigrationService {
    public void flywayMigration() {
        Flyway flyway = Flyway
                .configure()
                .baselineOnMigrate(true)
                .dataSource("jdbc:h2:./spaceTime", null, null)
                .load();
        flyway.migrate();
    }
}
