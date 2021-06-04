package ru.training.at.hw6.providers;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MetalsAndColors {
    /* Example from JSon
    {
    "summary": [1,2],
    "elements": ["Water", "Fire"],
    "color": "Red",
    "metals": "Gold",
    "vegetables": ["Cucumber"]
    }
    */

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    @Override
    public String toString() {
        return "MetalsAndColors{"
             +   "summary=" + summary
             +   ", elements=" + elements
             +   ", color='" + color + '\''
             +   ", metals='" + metals + '\''
             +   ", vegetables=" + vegetables
             +   '}';
    }
}
