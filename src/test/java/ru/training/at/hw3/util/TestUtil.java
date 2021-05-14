package ru.training.at.hw3.util;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.dp.LoginPageDataOfTest;
import ru.training.at.hw3.dp.LoginPageDataProvider;

@Test
public class TestUtil {

    @Test(dataProviderClass = LoginPageDataProvider.class,
            dataProvider = "LoginPageDataProvider")
    public void test(LoginPageDataOfTest input) {
        System.out.println(input.getUserName());
        Assert.assertEquals("Roman", input.getUserName());

    }

}
