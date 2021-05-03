package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class DivideDoubleDataPositiveTestProvider {
    @DataProvider(name = "DivideDoubleDataPositiveTestProvider")
    public Object[][] createData() {
        return new Object[][]{
            {0, Double.MAX_VALUE, 0},
            {Double.MAX_VALUE, 0, 0},
            {Double.MAX_VALUE, -1, -Double.MAX_VALUE},
            {1.7976931348623157E308, -1, -1.7976931348623157E308},
            {Double.MAX_VALUE, -1, Double.MIN_VALUE + 1},
            {'A', 1, 65},
            {0, 0, 0}};
    }
}
