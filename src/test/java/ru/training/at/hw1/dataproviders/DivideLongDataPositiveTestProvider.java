package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class DivideLongDataPositiveTestProvider {
    @DataProvider(name = "DivideLongDataPositiveTestProvider")
    public Object[][] createData() {
        return new Object[][]{
                {0, Long.MAX_VALUE, 0},
                {Long.MAX_VALUE, 1, Long.MAX_VALUE},
                {Long.MAX_VALUE, -1, -Long.MIN_VALUE},
                {Long.MAX_VALUE, Long.MAX_VALUE, 1},
                {Long.MAX_VALUE, -Long.MAX_VALUE, -1},
                {9223372036854775807L, 2, 9223372036854775807L / 2},
                {'A', 1, 65},
                {'A', 65, 1},
                {0, 1, 0}};
    }
}
