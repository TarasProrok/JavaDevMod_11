package services;

import entity.Planet;
import utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanetCrudService {
    public void createPlanet(String id, String name) {
        Planet planet = new Planet();
        planet.setName(name);
        planet.setId(id);

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    public Planet getPlanetById(String id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void updatePlanetById(String id, String name) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            planet.setName(name);
            session.merge(planet);
            transaction.commit();
        }
    }

    public void deleteById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            session.remove(planet);
            transaction.commit();
        }
    }
}