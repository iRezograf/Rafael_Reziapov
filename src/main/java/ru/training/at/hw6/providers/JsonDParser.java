package ru.training.at.hw6.providers;


import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import java.io.FileReader;

public class JsonDParser {

    @Test
    public void parser() {

        MetalsAndColorsData metalsAndColorsData;
        MetalsAndColors metalsAndColors;

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(
                "src/test/resources/JDI_ex8_metalsColorsDataSet.json")) {

            metalsAndColorsData = gson.fromJson(reader, MetalsAndColorsData.class);


        } catch (Exception e) {
            System.out.println("Parser Error: " + e.toString());
        }
    }
}
