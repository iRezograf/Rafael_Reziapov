package ru.training.at.hw6.providers;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MetalsAndColorsData {

    private String name;
    private MetalsAndColors metalsAndColors;

    @Override
    public String toString() {
        return "MetalsAndColorsData{"
                + "data='" + name + '\''
                + ", metalsAndColors=" + metalsAndColors
                + '}';
    }
}
