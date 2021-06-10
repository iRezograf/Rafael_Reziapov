package ru.training.at.hw6.providers;

import lombok.Data;

import java.util.List;

@Data
public class MetalsAndColors {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

}
