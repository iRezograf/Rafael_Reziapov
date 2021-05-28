package ru.training.at.hw6.comjdi.data;

import jdisite.entities.User;

public class UsersDataProvider {
    public static User ROMAN = new User().set(c -> {
        c.name = "Roman"; c.password = "Jdi1234";}
    );
}
