package ru.training.at.hw1.dataproviders.depricated;

import org.testng.annotations.DataProvider;

public class MultiplyLongDataPositiveTestProvider {
    @DataProvider(name = "MultiplyLongDataPositiveTestProvider")
    public Object[][] createData() {
        return new Object[][]{
            {0, Long.MAX_VALUE, 0},
            {Long.MAX_VALUE, 0, 0},
            {Long.MAX_VALUE, -1, -Long.MAX_VALUE},
            {9223372036854775807L, -1, 9223372036854775807L},
            {Long.MAX_VALUE, -1, Long.MIN_VALUE + 1},
            {'A', 1, 65},
            {0, 0, 0}};
    }
}