package ru.training.at.hw6.providers;

import org.testng.annotations.DataProvider;

public class MetalsAndColorsDtProvider {

    @DataProvider(name = "MetalsAndColorsDtProvider")
    public static Object[][] createData() {

        JsonDtParser jsonDtParser = new JsonDtParser();
        Object[][] data = new Object[5][1];
        data[0][0] = jsonDtParser.parser().get(0);
        data[1][0] = jsonDtParser.parser().get(1);
        data[2][0] = jsonDtParser.parser().get(2);
        data[3][0] = jsonDtParser.parser().get(3);
        data[4][0] = jsonDtParser.parser().get(4);

        return data;
    }
}
