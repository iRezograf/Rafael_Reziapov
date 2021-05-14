package ru.training.at.hw3.dp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Test
public class LoginPageDataProvider {
    @DataProvider(name = "LoginPageDataProvider")
    public Object [][] createData() {

        String s1 = DataStore.getProperty("textInLeftSectionMenuButtonList1");
        String s2 = DataStore.getProperty("textInLeftSectionMenuButtonList2");
        String s3 = DataStore.getProperty("textInLeftSectionMenuButtonList3");
        String s4 = DataStore.getProperty("textInLeftSectionMenuButtonList4");
        List<String> list = Arrays.asList(s1, s2, s3, s4);

        return new Object[][]{
                {"textInLeftSectionMenuButtonList1", s1},
                {"textInLeftSectionMenuButtonList2", s2},
                {"textInLeftSectionMenuButtonList3", s3},
                {"textInLeftSectionMenuButtonList1", s4}
        };
    }
}
