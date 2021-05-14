package ru.training.at.hw3.util;

import org.testng.annotations.Test;
import ru.training.at.hw3.dp.LoginPageDataProvider;

@Test
public class TestUtil {

    @Test(dataProvider = "LoginPageDataProvider",
            dataProviderClass = LoginPageDataProvider.class)
    public void test(String input, String data) {
        System.out.println(input + " " + data);
        //Assert.assertEquals("Roman", input.getUserName());
    }

}
