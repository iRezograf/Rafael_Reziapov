package ru.training.at.hw2.ex1.dataproviders;

import org.testng.annotations.DataProvider;

public class DpForLeftSectionTexts {
    @DataProvider(name = "DpForLeftSectionTexts")
    public Object[][] createData() {
        /*
            1,2,3,4,5  - is child's element index
            element = driver.findElement(By.cssSelector(
                ".sidebar-menu.left>li:nth-child(" + index + ")"));
         */
        return new Object[][]{
                {1, "Home"},
                {2, "Contact form"},
                {3, "Service"},
                {4, "Metals & Colors"},
                {5, "Elements packs"},
        };
    }


}
