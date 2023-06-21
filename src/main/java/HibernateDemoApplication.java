import services.ClientCrudService;
import services.FlywayMigrationService;
import services.PlanetCrudService;
import services.TicketCrudService;

import java.util.Date;
import java.sql.Timestamp;

public class HibernateDemoApplication {
    public static void main(String[] args) {
        Date date = new Date();
        new FlywayMigrationService().flywayMigration();

        System.out.println("Clients name for id 5 is - " + new ClientCrudService().getClientById(5));
        new ClientCrudService().updateById(5, "Viktor");
        System.out.println("Clients name for id 5 is - " + new ClientCrudService().getClientById(5));

        System.out.println("Planet with EH03 is - " + new PlanetCrudService().getPlanetById("EH03"));
        new PlanetCrudService().updatePlanetById("EH03", "Neptune");
        System.out.println("Planet with EH03 is - " + new PlanetCrudService().getPlanetById("EH03"));

        System.out.println("Ticket info for id 9 is: " + new TicketCrudService().getTicketById(9));
        new TicketCrudService().updateTicketById(
                9,
                new Timestamp(date.getTime()),
                new ClientCrudService().getClientById(1),
                new PlanetCrudService().getPlanetById("PO09"),
                new PlanetCrudService().getPlanetById("PO09"));
        System.out.println("Ticket info for id 9 is: " + new TicketCrudService().getTicketById(9));
    }
}