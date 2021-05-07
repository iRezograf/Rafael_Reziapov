package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class AllTestProvider {

    @DataProvider(name = "AllTestProvider")
    public Object[][] method(Method m) {
        switch (m.getName()) {
            case "testSumLong":
                return new Object[][]{
                        {0, Long.MAX_VALUE, Long.MAX_VALUE},
                        {Long.MAX_VALUE, 0, Long.MAX_VALUE},
                        {9223372036854775807L, -1, 9223372036854775806L},
                        {9223372036854775807L, -9223372036854775808L, -1},
                        {'C', 0, 'C'},
                        {0, 0, 0}};
            case "testSumDouble":
                return new Object[][]{
                        {0.0, Double.MAX_VALUE, Double.MAX_VALUE},
                        {Double.MAX_VALUE, 0.0, Double.MAX_VALUE},
                        {1.7976931348623157E308, -1, 1.7976931348623156E308},
                        {Double.MAX_VALUE, Double.MIN_VALUE, -1},
                        {'C', 0, 'C'},
                        {0.0, 0.0, 0.0}};
            case "testSubLong":
                return new Object[][]{
                        {0, Long.MAX_VALUE, -Long.MAX_VALUE},
                        {Long.MAX_VALUE, 0, Long.MAX_VALUE},
                        {9223372036854775806L, -1, -9223372036854775807L},
                        {'A', 0, 65},
                        {0, 0, 0}};
            case "testSubDouble":
                return new Object[][]{
                        {0.0, Double.MAX_VALUE, -Double.MAX_VALUE},
                        {Double.MAX_VALUE, 0.0, Double.MAX_VALUE},
                        {1.7976931348623156E308, -1, 1.7976931348623157E308},
                        {'A', 0, 65},
                        {0.0, 0.0, 0.0}};
            case "testMultLong":
                return new Object[][]{
                        {0, Long.MAX_VALUE, 0},
                        {Long.MAX_VALUE, 0, 0},
                        {Long.MAX_VALUE, -1, -Long.MAX_VALUE},
                        {9223372036854775807L, -1, 9223372036854775807L},
                        {Long.MAX_VALUE, -1, Long.MIN_VALUE + 1},
                        {'A', 1, 65},
                        {0, 0, 0}};
            case "testMultDouble":
                return new Object[][]{
                        {0, Double.MAX_VALUE, 0},
                        {Double.MAX_VALUE, 0, 0},
                        {Double.MAX_VALUE, -1, -Double.MAX_VALUE},
                        {1.7976931348623157E308, -1, -1.7976931348623157E308},
                        {Double.MAX_VALUE, -1, Double.MIN_VALUE + 1},
                        {'A', 1, 65},
                        {'B', 2, 130},
                        {0, 0, 0}};
            case "testDivLong":
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
            case "testDivDouble":
                return new Object[][]{
                        {0, Double.MAX_VALUE, 0},
                        {Double.MAX_VALUE, 0, 0},
                        {Double.MAX_VALUE, -1, -Double.MAX_VALUE},
                        {1.7976931348623157E308, -1, -1.7976931348623157E308},
                        {Double.MAX_VALUE, -1, Double.MIN_VALUE + 1},
                        {'A', 1, 65},
                        {'B', 2, 33},
                        {0, 0, 0}};
            case "testDivLongByZeroExceptionMessage":
                return new Object[][]{
                        {Long.MAX_VALUE, 0},
                        {9223372036854775807L, 0},
                        {'A', 0},
                        {0, 0}};

            default:
                return null;
        }
    }
}
/*
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DProvider {
 @DataProvider (name = "data-provider")
 public Object[][] dpMethod (Method m){
 switch (m.getName()) {
    case "Sum":
        return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
    case "Diff":
        return new Object[][] {{2, 3, -1}, {5, 7, -2}};
 }
 return null;

 }

   @Test (dataProvider = "data-provider")
     public void Sum (int a, int b, int result) {
         int sum = a + b;
         Assert.assertEquals(result, sum);
     }

   @Test (dataProvider = "data-provider")
     public void Diff (int a, int b, int result) {
         int diff = a - b;
         Assert.assertEquals(result, diff);
     }
}
 */