package ru.training.at.hw6.providers;

import org.junit.Test;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MetalsAndColorsDtProvider {

    @DataProvider(name = "MetalsAndColorsDtProvider")
    public static Object[][] createData() {

        JsonDtParser jsonDtParser = new JsonDtParser();
        Object[][] data = new Object[5][5];
        data[0][0] = jsonDtParser.parser().get(0);
        data[0][0] = jsonDtParser.parser().get(1);
        data[0][0] = jsonDtParser.parser().get(2);
        data[0][0] = jsonDtParser.parser().get(3);
        data[0][0] = jsonDtParser.parser().get(4);

        return data;
    }
}
