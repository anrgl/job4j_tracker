package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> addressContainsKey = (person) -> person.getAddress().contains(key);
        Predicate<Person> nameContainsKey = (person) -> person.getName().contains(key);
        Predicate<Person> surnameContainsKey = (person) -> person.getSurname().contains(key);
        Predicate<Person> phoneContainsKey = (person) -> person.getPhone().contains(key);
        Predicate<Person> combine = addressContainsKey
                .or(nameContainsKey)
                .or(surnameContainsKey)
                .or(phoneContainsKey);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
