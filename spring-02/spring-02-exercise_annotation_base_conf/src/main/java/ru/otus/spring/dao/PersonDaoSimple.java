package ru.otus.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Person;
@Service("dao")
public class PersonDaoSimple implements PersonDao {

    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
