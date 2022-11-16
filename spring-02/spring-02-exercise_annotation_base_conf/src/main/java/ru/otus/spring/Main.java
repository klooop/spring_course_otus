package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.domain.Person;
import ru.otus.spring.service.PersonService;
import ru.otus.spring.service.PersonServiceImpl;

@ComponentScan
//@Configuration
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

//        PersonService service = context.getBean(PersonServiceImpl.class);
        PersonService service = (PersonService) context.getBean("service_person");

        Person ivan = service.getByName("Ivan");
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
    }
}
