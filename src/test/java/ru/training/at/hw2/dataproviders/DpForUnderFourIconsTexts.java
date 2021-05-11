package ru.training.at.hw2.dataproviders;

import org.testng.annotations.DataProvider;

public class DpForUnderFourIconsTexts {
    @DataProvider(name = "DpForUnderFourIconsTexts")
    public Object[][] createData() {
        /*
        //    1,2,3,4 - is child's element index
        //    element = driver.findElement(By.cssSelector(
        //        ".row.clerafix.benefits>.col-sm-3:nth-child(" + index + ")"));
         */
        return new Object[][]{
                {1, "To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project"},

                {2, "To be flexible and\n"
                       + "customizable"},

                {3, "To be multiplatform"},

                {4, "Already have good base\n"
                       + "(about 20 internal and\n"
                       + "some external projects),\n"
                       + "wish to get more…"}};
    }


}
