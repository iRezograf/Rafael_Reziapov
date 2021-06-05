package ru.training.at.hw6.providers;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonDataParser {

    public Object[][] getDataFromFile() {
        JSONParser parser = new JSONParser();

        int countOfRootGets = Integer.parseInt(DataStore
                .getProperty("Data_endNumberInJson"))
                - Integer.parseInt(DataStore
                .getProperty("Data_startNumberInJson")) + 1;
        int dataNumberFieldInForm = Integer.parseInt(DataStore
                .getProperty("Data_NumberFieldInForm"));

        Object[][] data = new Object[countOfRootGets][dataNumberFieldInForm];

        try (FileReader reader = new FileReader(
                "src/test/resources/JDI_ex8_metalsColorsDataSet.json")) {

            JSONObject rootJsonObj = (JSONObject) parser.parse(reader);

            for (int i = 0; i < countOfRootGets; i++) {

                String dataBodyInJson = DataStore.getProperty("Data_bodyInJson") + (i + 1);

                JSONObject field = (JSONObject) rootJsonObj.get(dataBodyInJson);

                data[i][0] = field.get("summary");
                data[i][1] = field.get("elements");
                data[i][2] = field.get("color");
                data[i][3] = field.get("metals");
                data[i][4] = field.get("vegetables");

            }
        } catch (Exception e) {
            System.out.println("Parser Error: " + e);
        }
        return data;
    }


}
