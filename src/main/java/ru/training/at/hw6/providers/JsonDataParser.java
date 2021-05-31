package ru.training.at.hw6.providers;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonDataParser {

    MetalsAndColorsDataList metalsAndColorsDataList;
    MetalsAndColorsData metalsAndColorsData;
    MetalsAndColors metalsAndColors;

    public MetalsAndColorsDataList parseFromFile() {

        metalsAndColorsDataList = new MetalsAndColorsDataList();

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(
                "src/test/resources/JDI_ex8_metalsColorsDataSet.json")) {

            int countOfRootGets = Integer.parseInt(DataStore
                    .getProperty("Data_endNumberInJson"))
                  - Integer.parseInt(DataStore
                    .getProperty("Data_startNumberInJson")) + 1;
            List<MetalsAndColorsData> list = new ArrayList<>();
            JSONObject rootJsonObj = (JSONObject) parser.parse(reader);
            for (int i = 1; i <= countOfRootGets; i++) {

                metalsAndColors = new MetalsAndColors();

                String Data_bodyInJson = DataStore.getProperty("Data_bodyInJson") + i;
                JSONObject field = (JSONObject) rootJsonObj.get(Data_bodyInJson);

                metalsAndColors.setElements((List<String>) field.get("elements"));
                metalsAndColors.setColor((String) field.get("color"));
                metalsAndColors.setMetals((String) field.get("metals"));
                metalsAndColors.setVegetables((List<String>) field.get("vegetables"));
                metalsAndColors.setSummary((List<Integer>) field.get("summary"));

                metalsAndColorsData = new MetalsAndColorsData();
                metalsAndColorsData.setName(Data_bodyInJson);
                metalsAndColorsData.setMetalsAndColors(metalsAndColors);
                System.out.println(metalsAndColorsData);
                metalsAndColors = null;

                list.add(metalsAndColorsData);
                metalsAndColorsData = null;
            }

            metalsAndColorsDataList.setMetalsAndColorsDataList(list);

        } catch (Exception e) {
            System.out.println("Parser Error: " + e.toString());
        }
    return metalsAndColorsDataList;
    }
}
