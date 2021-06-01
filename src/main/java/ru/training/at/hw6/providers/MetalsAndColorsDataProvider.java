package ru.training.at.hw6.providers;

import org.testng.annotations.DataProvider;

public class MetalsAndColorsDataProvider {
    @DataProvider(name = "MetalsAndColorsDataProvider")
    public static Object[][] createData() {
        JsonDataParser parser = new JsonDataParser();
        return parser.getDataFromFile();
    }

}
