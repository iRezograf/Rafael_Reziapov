package ru.training.at.hw1.dataproviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class AllTestProvider {
    @DataProvider(name = "AllTestProvider")
    public Object[][] dpMethod (Method m){
        switch (m.getName()) {
            case "testSumDouble":
                return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
            case "Diff":
                return new Object[][] {{2, 3, -1}, {5, 7, -2}};
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