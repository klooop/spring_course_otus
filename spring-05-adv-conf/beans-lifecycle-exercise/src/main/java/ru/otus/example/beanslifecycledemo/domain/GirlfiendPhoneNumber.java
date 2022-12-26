package ru.otus.example.beanslifecycledemo.domain;

import org.springframework.stereotype.Component;

@Component // компонент, поэтому привяжется к контексту
public class GirlfiendPhoneNumber extends PhoneNumber {
    @Override
    public String getOwnerName() {
        return "Подруга";
    }
}
