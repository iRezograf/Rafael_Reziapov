package ru.training.at.hw5.dp;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

import static ru.training.at.hw5.util.DriverManager.removeSpaces;

@Getter
@Setter
public class UserTable {

    private int number;
    private List<String>  type;
    private String user;
    private String description;

    public void setType(String type) {
        this.type = Arrays.asList(type.split("\\s*,\\s*"));
    }

    public void setNumber(String number) {
        this.number = Integer.parseInt(number);
    }


    public void setUser(String user) {
        this.user = user.replaceAll(removeSpaces, " ");
    }

    public void setDescription(String description) {
        this.description = description.replaceAll(removeSpaces, " ");
    }

    @Override
    public String toString() {
        return "UserTable{"
               + "number=" + number
               + ", type=" + type
               + ", user='" + user + '\''
               + ", description='" + description + '\''
               + '}';

    }
}
