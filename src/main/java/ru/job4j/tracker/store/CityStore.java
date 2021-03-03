package ru.job4j.tracker.store;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import ru.job4j.tracker.model.City;

public class CityStore {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    public City create(City city) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
        }
        return city;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            cities = session.createQuery("from City").list();
            session.getTransaction().commit();
        }
        return cities;
    }
}
