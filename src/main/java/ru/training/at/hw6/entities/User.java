package ru.training.at.hw6.entities;

import com.epam.jdi.tools.DataClass;
import lombok.Data;

@Data
public class User  extends DataClass<User> {
    private String name;
    private String password;
    private String userName;
}