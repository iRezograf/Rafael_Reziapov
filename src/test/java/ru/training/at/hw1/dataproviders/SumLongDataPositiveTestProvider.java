package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

/* data for testing method: public long sum(long a, long b) {return a + b;} */
public class SumLongDataPositiveTestProvider {
    @DataProvider(name = "SumLongDataPositiveTestProvider")
    public  Object [][] createData() {
        return new Object[][] {
                {0, Long.MAX_VALUE, Long.MAX_VALUE},
                {Long.MAX_VALUE, 0, Long.MAX_VALUE},
                {9223372036854775807L, -1, 9223372036854775806L},
                {9223372036854775807L, -9223372036854775808L, -1},
                {'A', 0, 'A'},
                {0, 0, 0}};
    }
}
