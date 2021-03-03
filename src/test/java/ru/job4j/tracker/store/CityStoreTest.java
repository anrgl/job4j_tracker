package ru.job4j.tracker.store;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import ru.job4j.tracker.model.City;

public class CityStoreTest {
    @Test
    public void whenCreate() {
        CityStore store = new CityStore();
        City city = new City("Moscow");
        store.create(city);
        List<City> cities = store.findAll();
        assertEquals(city, cities.get(0));
    }

    @Test
    public void whenFindAll() {
        CityStore cityStore = new CityStore();
        City city1 = new City("Moscow");
        City city2 = new City("St. Petersburg");
        cityStore.create(city1);
        cityStore.create(city2);
        assertEquals(List.of(city1, city2), cityStore.findAll());
    }
}
