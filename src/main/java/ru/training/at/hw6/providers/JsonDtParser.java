package ru.training.at.hw6.providers;


import com.google.gson.Gson;
import org.junit.Test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonDtParser {

    public List<MetalsAndColors> parser() {

        MetalsAndColorsData metalsAndColorsData;
        metalsAndColorsData = new MetalsAndColorsData();
        List<MetalsAndColors> list = new ArrayList<>();

        metalsAndColorsData = null;

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(
                "src/test/resources/JDI_ex8_metalsColorsDataSet.json")) {

            metalsAndColorsData = gson.fromJson(reader, MetalsAndColorsData.class);

            System.out.println(metalsAndColorsData);
            list.add(metalsAndColorsData.getData_1());
            list.add(metalsAndColorsData.getData_2());
            list.add(metalsAndColorsData.getData_3());
            list.add(metalsAndColorsData.getData_4());
            list.add(metalsAndColorsData.getData_5());

        } catch (Exception e) {
            System.out.println("Parser Error: " + e.toString());
        }
        System.out.println(list);
        return list;
    }

}
