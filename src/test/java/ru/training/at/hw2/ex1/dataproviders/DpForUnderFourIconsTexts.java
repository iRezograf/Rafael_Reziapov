package ru.training.at.hw2.ex1.dataproviders;

import org.testng.annotations.DataProvider;

public class DpForUnderFourIconsTexts {
    @DataProvider(name = "DpForUnderFourIconsTexts")
    public Object[][] createData() {
        return new Object[][]{
                {"To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project"},
                {"To be flexible and\n"
                       + "customizable"},
                {"To be multiplatform"},
                {"Already have good base\n"
                       + "(about 20 internal and\n"
                       + "some external projects),\n"
                       + "wish to get more…"}};
    }


}
