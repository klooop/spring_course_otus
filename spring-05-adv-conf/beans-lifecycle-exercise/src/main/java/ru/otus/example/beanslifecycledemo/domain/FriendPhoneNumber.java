package ru.otus.example.beanslifecycledemo.domain;

import org.springframework.stereotype.Component;

//@Component нет компонента
public class FriendPhoneNumber extends PhoneNumber {
    @Override
    public String getOwnerName() {
        return "Друг";
    }
}
