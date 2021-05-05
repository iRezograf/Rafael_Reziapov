package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class DivideByZeroDataTestProvider {
    @DataProvider(name = "DivideByZeroDataTestProvider")
    public Object[][] createData() {
        return new Object[][]{
                {Long.MAX_VALUE, 0},
                {9223372036854775807L, 0},
                {'A', 0},
                {0, 0}};
    }
}
