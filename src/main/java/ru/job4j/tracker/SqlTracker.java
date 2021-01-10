package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public SqlTracker() {
        init();
    }

    @Override
    public void init() {
        try (InputStream is = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(is);
            Class.forName(config.getProperty("tracker.driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("tracker.url"),
                    config.getProperty("tracker.login"),
                    config.getProperty("tracker.password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                cn.prepareStatement("insert into items(name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("update items set name = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setInt(2, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item = new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    public static void main(String[] args) {
        SqlTracker tracker = new SqlTracker();

        for (Item i : tracker.findAll()) {
            System.out.println("id: " + i.getId() + ", name: " + i.getName());
        }
        System.out.println("---------------------------------");

        Item item = tracker.findById(5);
        System.out.println("id: " + item.getId() + ", name: " + item.getName());
        System.out.println("---------------------------------");

        for (Item i : tracker.findByName("Item #7")) {
            System.out.println("id: " + i.getId() + ", name: " + i.getName());
        }
        System.out.println("---------------------------------");

        boolean isDeleted = tracker.delete(2);
        System.out.println(isDeleted);
        for (Item i : tracker.findAll()) {
            System.out.println("id: " + i.getId() + ", name: " + i.getName());
        }
        System.out.println("---------------------------------");

        boolean isReplaced = tracker.replace(4, new Item("Item #42"));
        System.out.println(isReplaced);
        for (Item i : tracker.findAll()) {
            System.out.println("id: " + i.getId() + ", name: " + i.getName());
        }
        System.out.println("---------------------------------");

        item = tracker.add(new Item("Item #99"));
        System.out.println("id: " + item.getId() + ", name: " + item.getName());
        System.out.println("---------------------------------");

        System.out.println("Done!");
    }
}
