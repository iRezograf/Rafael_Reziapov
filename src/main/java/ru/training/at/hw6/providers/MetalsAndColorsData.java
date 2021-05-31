package ru.training.at.hw6.providers;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MetalsAndColorsData {

    /* Example from JSon
      "data_1": {
    "summary": [1,2],
    "elements": ["Water", "Fire"],
    "color": "Red",
    "metals": "Gold",
    "vegetables": ["Cucumber"]
    },
    */

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
