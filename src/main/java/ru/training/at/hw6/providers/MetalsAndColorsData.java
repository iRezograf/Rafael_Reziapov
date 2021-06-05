package ru.training.at.hw6.providers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetalsAndColorsData {

    private MetalsAndColors data_1;
    private MetalsAndColors data_2;
    private MetalsAndColors data_3;
    private MetalsAndColors data_4;
    private MetalsAndColors data_5;

    @Override
    public String toString() {
        return "MetalsAndColorsData{" +
                "data_1=" + data_1 +
                ", data_2=" + data_2 +
                ", data_3=" + data_3 +
                ", data_4=" + data_4 +
                ", data_5=" + data_5 +
                '}';
    }
}
