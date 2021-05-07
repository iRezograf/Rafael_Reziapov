package ru.training.at.hw1.dataproviders.depricated;

import org.testng.annotations.DataProvider;

/* public long sub(long a, long b) { return a - b;} */
public class SubLongDataPositiveTestProvider {
    @DataProvider(name = "SubLongDataPositiveTestProvider")
    public  Object [][] createData() {
        return new Object[][] {
                {0, Long.MAX_VALUE, -Long.MAX_VALUE},
                {Long.MAX_VALUE, 0, Long.MAX_VALUE},
                {9223372036854775806L, -1, -9223372036854775807L},
                {'A', 0, 65},
                {0, 0, 0}};
    }

}
