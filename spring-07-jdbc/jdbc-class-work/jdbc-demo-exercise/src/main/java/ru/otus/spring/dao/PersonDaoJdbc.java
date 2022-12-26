package ru.otus.spring.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class PersonDaoJdbc implements PersonDao {

    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations namedJdbc;

    public PersonDaoJdbc(JdbcOperations jdbc,
                         NamedParameterJdbcOperations namedJdbc) {
        this.jdbc = jdbc;
        this.namedJdbc = namedJdbc;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("Select count(*) from Persons", Integer.class);
    }

    @Override
    public void insert(Person person) {
        jdbc.update("insert into persons (id, `name`) values (?, ?)", person.getId(),
                    person.getName());
    }

    @Override
    public Person getById(Long id) {
        return jdbc.queryForObject("Select * from persons where id = ?", new Object[]{id},
                                   new PersonRowMapper());
    }

    @Override
    public List<Person> getAll() {
        return jdbc.query("Select * from persons", new PersonRowMapper());
    }

    public void deleteById(Long id) {
        Map<String, Long> params = new HashMap<>(1);
        params.put("id", id);
        namedJdbc.update("Delete from persons where id = :id", params);
    }


    private static class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet resultSet,
                             int i)
                throws SQLException {
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            return new Person(id, name);
        }
    }



}