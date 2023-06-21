package utils;

import entity.Client;
import entity.Planet;
import entity.Ticket;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Data
public class HibernateUtil {
    private static final HibernateUtil INSTANCE;
    static {
        INSTANCE = new HibernateUtil();
    }
    private final SessionFactory sessionFactory;

    public HibernateUtil () {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
