package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Person;
public interface PersonService {

    Person getByName(String name);
}
