package ru.otus.spring.dao;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.domain.Person;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dao для работы с персонами должно")
@JdbcTest
@Import(PersonDaoJdbc.class) // не можем внедрить PersonDao т к это интерфейс, поэтому PersonDaoJdbc
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class PersonDaoJdbcTest {
    private static final int EXPECTED_COUNT_OF_PERSONS = 2;
    private static final Long BIG_BOY_ID = 100L;
    private static final String BIG_BOY_NAME = "big_boy";

    @Autowired
    PersonDaoJdbc personDaoJdbc;

    @DisplayName("должен вернуть персона по его id")
    @Test
    void shouldReturnExpectedPersonCount() {
        int count = personDaoJdbc.count();
        List<Person> all = personDaoJdbc.getAll();
        System.out.println(all);
        System.out.println(count);
        assertThat(count).isEqualTo(EXPECTED_COUNT_OF_PERSONS);
    }
    @DisplayName("должен вставать персона")
    @Test
    void shouldInsertPerson() {
        Person expectedPerson = new Person(2314L, "KekPerson");
        personDaoJdbc.insert(expectedPerson);
        Person actualPerson = personDaoJdbc.getById(2314L);
        assertThat(actualPerson).isEqualTo(expectedPerson);
    }

    @DisplayName("должен вернуть ожидаемого персона по его id")
    @Test
    void shouldReturnExpectedPersonById() {
        Person bigBoyPerson = personDaoJdbc.getById(BIG_BOY_ID);
        assertThat(bigBoyPerson)
                .hasFieldOrPropertyWithValue("id",BIG_BOY_ID)
                .hasFieldOrPropertyWithValue("name",BIG_BOY_NAME);
    }
}