package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.spring.dao.PersonDao;
import ru.otus.spring.domain.Person;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = SpringApplication.run(Main.class);

        PersonDao dao = context.getBean(PersonDao.class);
        Person artem = new Person(2,"Artem");
        System.out.println("Count of people: "+dao.count());
        dao.insert(artem);
        System.out.println("Count of people after insert: "+dao.count());

        Person person = dao.getById(1L);
        System.out.println(person);

        List<Person> personsList = dao.getAll();
        System.out.println(personsList);
        dao.deleteById(2L);
        System.out.println("Delete person By NamedParameterJdbcOperations");
        System.out.println("Count of people after delete: "+dao.count());

        //        Console.main(args);
    }
}
