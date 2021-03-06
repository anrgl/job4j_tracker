package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class HibernateRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder().configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Item item = create(new Item("Learn Hibernate"), sf);
            System.out.println(item);
            item.setName("Learn Hibernate 5.");
            update(item, sf);
            System.out.println(item);
            Item rsl = findById(item.getId(), sf);
            System.out.println(rsl);
            delete(rsl.getId(), sf);
            List<Item> list = findAll(sf);
            for (Item it : list) {
                System.out.println(it);
            }

            Item item1 = create(new Item(
                    "Item #1",
                    "Description of Item # 1",
                    new Timestamp(new Date().getTime())), sf);
            Item item2 = create(new Item(
                    "Item #2",
                    "Description of Item # 2",
                    new Timestamp(new Date().getTime())), sf);
            Item item3 = create(new Item(
                    "Item #3",
                    "Description of Item # 3",
                    new Timestamp(new Date().getTime())), sf);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static Item create(Item item, SessionFactory sf) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        }
        return item;
    }

    public static void update(Item item, SessionFactory sf) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        }
    }

    public static void delete(Integer id, SessionFactory sf) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Item item = new Item(null);
            item.setId(id);
            session.delete(item);
            session.getTransaction().commit();
        }
    }

    public static List<Item> findAll(SessionFactory sf) {
        List<Item> result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from ru.job4j.tracker.Item").list();
            session.getTransaction().commit();
        }
        return result;
    }

    public static Item findById(Integer id, SessionFactory sf) {
        Item result;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            result = session.get(Item.class, id);
            session.getTransaction().commit();
        }
        return result;
    }
}
