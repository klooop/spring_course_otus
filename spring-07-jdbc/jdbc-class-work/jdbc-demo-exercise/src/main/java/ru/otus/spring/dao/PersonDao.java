package ru.otus.spring.dao;

import ru.otus.spring.domain.Person;

import java.util.List;

public interface PersonDao {

    int count();

    void insert(Person person);

    Person getById(Long id);

    List<Person> getAll();

    void deleteById(Long id);
}
