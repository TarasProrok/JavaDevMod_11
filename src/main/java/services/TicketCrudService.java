package services;

import entity.Client;
import entity.Planet;
import entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.sql.Timestamp;

public class TicketCrudService {
    public void createTicket(Timestamp createdAt, Client clientId, Planet fromPlanetId, Planet toPlanetId) {
        if (clientId == null) {
            throw new IllegalArgumentException("There is no such client ID!");
        } else if (fromPlanetId == null) {
            throw new IllegalArgumentException("Origin planet ID is wrong!");
        } else if (toPlanetId == null) {
            throw new IllegalArgumentException("Destination planet ID is wrong!");
        }
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(createdAt);
        ticket.setClientId(clientId);
        ticket.setFromPlanetId(fromPlanetId);
        ticket.setToPlanetId(toPlanetId);

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    public Ticket getTicketById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Ticket foundTicket = session.get(Ticket.class, id);
            if (foundTicket == null) {
                throw new IllegalArgumentException("Invalid ID!");
            }
            return foundTicket;
        }
    }

    public void updateTicketById(int id, Timestamp createdAt, Client clientId, Planet fromPlanetId, Planet toPlanetId) {
        if (clientId == null) {
            throw new IllegalArgumentException("There is no such client ID!");
        } else if (fromPlanetId == null) {
            throw new IllegalArgumentException("Origin planet ID is wrong!");
        } else if (toPlanetId == null) {
            throw new IllegalArgumentException("Destination planet ID is wrong!");
        }

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            ticket.setCreatedAt(createdAt);
            ticket.setClientId(clientId);
            ticket.setFromPlanetId(fromPlanetId);
            ticket.setToPlanetId(toPlanetId);

            session.merge(ticket);
            transaction.commit();
        }
    }

    public void deleteTicketById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            session.remove(ticket);
            transaction.commit();
        }
        System.out.println("Ticket with id " + id + "deleted!");
    }
}
