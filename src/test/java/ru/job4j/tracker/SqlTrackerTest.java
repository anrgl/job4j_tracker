package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {
    public Connection init() {
        try (InputStream in =
                SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("tracker.driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("tracker.url"),
                    config.getProperty("tracker.login"),
                    config.getProperty("tracker.password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void addItem() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        tracker.add(new Item("name"));
        assertThat(tracker.findByName("name").size(), is(1));
    }

    @Test
    public void replaceItem() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        int id = tracker.add(new Item("name")).getId();
        boolean isReplaced = tracker.replace(id, new Item("surname"));
        assertTrue(isReplaced);
    }

    @Test
    public void deleteItem() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        int id = tracker.add(new Item("name")).getId();
        tracker.delete(id);
        assertThat(tracker.findByName("name").size(), is(0));
    }

    @Test
    public void findAllItems() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        List<Item> items = tracker.findAll();
        assertThat(items.size(), is(22));
    }

    @Test
    public void findByName() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        tracker.add(new Item("new Item"));
        tracker.add(new Item("new Item"));
        tracker.add(new Item("new Item"));
        assertThat(tracker.findByName("new Item").size(), is(3));
    }

    @Test
    public void findById() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        int id = tracker.add(new Item("Item")).getId();
        assertThat(tracker.findById(id).getName(), is("Item"));
    }
}