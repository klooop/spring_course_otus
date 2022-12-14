package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.PersonDao;
import ru.otus.spring.domain.Person;

@Service("service_person")
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    @Autowired
    public PersonServiceImpl(@Qualifier("dao") PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.findByName(name);
    }
}