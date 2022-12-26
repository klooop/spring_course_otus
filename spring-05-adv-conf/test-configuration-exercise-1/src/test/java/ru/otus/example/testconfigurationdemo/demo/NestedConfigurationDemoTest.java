package ru.otus.example.testconfigurationdemo.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.otus.example.testconfigurationdemo.family.FamilyMember;
import ru.otus.example.testconfigurationdemo.family.pets.Dog;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("В NestedConfigurationDemoTest семья должна ")
@SpringBootTest
public class NestedConfigurationDemoTest {
//    /**
//     * ВАРИАНТ 1
//     * */
//    @Configuration
//    @ComponentScan("ru.otus.example.testconfigurationdemo.family.pets")
//    static class TestConfiguration {}

//    /**
//     * ВАРИАНТ 2
//     * */
//    @Configuration
//    static class TestConfiguration {
//        @Bean
//        public FamilyMember dog() {
//            return new Dog();
//        }
//    }
//    /**
//     * ВАРИАНТ 3
//     * */
    @Import(Dog.class)
    @Configuration
    static class TestConfiguration{

    }


    @Autowired
    private Map<String, FamilyMember> family;

    @DisplayName(" содержать только собаку ")
    @Test
    void shouldContainOnlyDog() {
        assertThat(family).containsOnlyKeys("dog");
    }

}
