package ru.training.at.hw1.dataproviders.depricated;

import org.testng.annotations.DataProvider;

/* public double sub(double a, double b) {return a - b;} */
public class SubDoubleDataPositiveTestProvider {
    @DataProvider(name = "SubDoubleDataPositiveTestProvider")
    public  Object [][] createData() {
        return new Object[][]{
                {0.0, Double.MAX_VALUE, -Double.MAX_VALUE},
                {Double.MAX_VALUE, 0.0, Double.MAX_VALUE},
                {1.7976931348623156E308, -1, 1.7976931348623157E308},
                {'A', 0, 65},
                {0.0, 0.0, 0.0}};
    }
}
