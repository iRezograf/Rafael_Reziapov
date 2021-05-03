package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

/* data for testing method: public double sum(double a, double b) {return a + b;} */
public class SumDoubleDataPositiveTestProvider {
    @DataProvider(name = "SumDoubleDataPositiveTestProvider")
    public  Object [][] createData() {
        return new Object[][]{
                {0.0, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MAX_VALUE, 0.0, Double.MAX_VALUE},
                {1.7976931348623157E308, -1, 1.7976931348623156E308},
                {Double.MAX_VALUE, Double.MIN_VALUE, -1},
                {'A', 0, 'A'},
                {0.0, 0.0, 0.0}};
    }
}


