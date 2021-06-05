package ru.training.at.hw6.providers;


import com.google.gson.Gson;

import java.io.FileReader;

public class JsonDtParser {

    public  MetalsAndColorsData parser() {

        MetalsAndColorsData metalsAndColorsData;
        metalsAndColorsData = null;

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(
                "src/test/resources/JDI_ex8_metalsColorsDataSet.json")) {

            metalsAndColorsData = gson.fromJson(reader, MetalsAndColorsData.class);

        } catch (Exception e) {
            System.out.println("Parser Error: " + e.toString());
        }
        return metalsAndColorsData;
    }

}
