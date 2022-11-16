package ru.otus.spring.dao;

import ru.otus.spring.domain.Person;

public class PersonDaoSimple implements PersonDao {

    private int defaultAge;

    public Person findByName(String name) {
        return new Person(name, defaultAge);
    }

    public void setDefaultAge(String defaultAge) {
        this.defaultAge = Integer.parseInt(defaultAge);
    }
}
