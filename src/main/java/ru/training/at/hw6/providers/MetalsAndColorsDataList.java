package ru.training.at.hw6.providers;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MetalsAndColorsDataList {
    List<MetalsAndColorsData> metalsAndColorsDataList;

    @Override
    public String toString() {
        return "MetalsAndColorsDataList{" +
                "metalsAndColorsDataList=" + metalsAndColorsDataList +
                '}';
    }
}
