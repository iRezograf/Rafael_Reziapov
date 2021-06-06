package ru.training.at.hw6.providers;

import org.testng.annotations.Test;

import java.util.List;

public class TestClass {
    @Test(priority = 20,
            dataProvider = "MetalsAndColorsDtProvider",
            dataProviderClass = MetalsAndColorsDtProvider.class)
    public void getFromDP(MetalsAndColors metalsAndColors) {
        System.out.println(metalsAndColors);
    }

}
