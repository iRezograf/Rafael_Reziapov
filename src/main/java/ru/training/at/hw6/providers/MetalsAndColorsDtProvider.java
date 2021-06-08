package ru.training.at.hw6.providers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class MetalsAndColorsDtProvider {

    @DataProvider(name = "MetalsAndColorsDtProvider")
    public static Object[][] createData() {
        Map<String, MetalsAndColors> metalsAndColorsMap;
        Object[][] data = null;

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(
                "src/test/resources/JDI_ex8_metalsColorsDataSet.json")) {

            Type mapType = new TypeToken<Map<String, MetalsAndColors>>() {}.getType();
            metalsAndColorsMap = gson.fromJson(reader, mapType);

            data = new Object[metalsAndColorsMap.size()][1];
            int i = 0;
            for (String key : metalsAndColorsMap.keySet()) {
                data[i][0] = metalsAndColorsMap.get(key);
                i++;
            }
        } catch (Exception e) {
            System.out.println("Parser Error: " + e);
        }
        return data;

    }
}
